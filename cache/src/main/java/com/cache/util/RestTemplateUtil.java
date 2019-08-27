package com.cache.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Slf4j
public class RestTemplateUtil {

    private static RestTemplate restTemplate;

    private RestTemplateUtil() {
    }

    public static RestTemplate instance() {
        if (restTemplate == null) {
            int poolSize = 1000;
            int connectTimeout = 30;
            int readTimeout = 30;
            int requestConnectionRequestTimeout = 60;
            PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
            cm.setMaxTotal(poolSize);
            cm.setDefaultMaxPerRoute(poolSize);
            CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
            HttpComponentsClientHttpRequestFactory httpFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
            httpFactory.setConnectTimeout(connectTimeout * 1000);
            httpFactory.setReadTimeout(readTimeout * 1000);
            httpFactory.setConnectionRequestTimeout(requestConnectionRequestTimeout * 1000);
            restTemplate = new RestTemplate(httpFactory);
            List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
            messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
            messageConverters.add(new MappingJackson2HttpMessageConverter());
            restTemplate.setMessageConverters(messageConverters);
        }
        return restTemplate;
    }

    public static Object get(Map<String, Object> param, String url, String returnDataKey) {
        return execute(param, url, returnDataKey, RequestMethod.GET);
    }

    public static Object post(Map<String, Object> param, String url, String returnDataKey) {
        return execute(param, url, returnDataKey, RequestMethod.POST);
    }

    private static Object execute(Map<String, Object> param, String url,
                                        String returnDataKey, RequestMethod method) {
        RestTemplate restClient = RestTemplateUtil.instance();
        Object resp = null;
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.setAll(param);
        try {
            String response;
            if (method == RequestMethod.POST) {
                response = restClient.postForObject(url, map, String.class);
            } else {
                String getParams = "?" + map.keySet().stream().map(k -> String.format("%s={%s}", k, k))
                        .collect(Collectors.joining("&"));
                response = restClient.getForObject(url + getParams, String.class, param);
            }
           /* JSONObject obj = JSON.parseObject(response);
            if (BlueVDict.Code.success.equals(obj.getString(BlueVDict.CODE))) {
                Optional.ofNullable(obj.getJSONObject(BlueVDict.DATA)).ifPresent(data -> {
                    Optional.ofNullable(data.getJSONArray(returnDataKey))
                            .ifPresent(result -> resp.setData(result.toJSONString()));
                    Optional.ofNullable(data.getInteger(BlueVDict.PAGE)).ifPresent(resp::setPageNum);
                    Optional.ofNullable(data.getInteger(BlueVDict.COUNT)).ifPresent(resp::setPageSize);
                    Optional.ofNullable(data.getLong(BlueVDict.TOTAL)).ifPresent(resp::setTotal);
                });
            } else {
                return Object.error(obj.getString(BlueVDict.MSG));
            }*/
        } catch (RestClientException e) {
            log.warn("an exception occurred when call weibo api. url: " + url, e);
            return e.getMessage();
        }
        return resp;
    }
    
    public static String postJson(String url, Map<String, Object> param, String token) {
        return postJson(url, param, String.class, token);
    }
    
    public static String postJson(String url, Map<String, Object> param) {
        return postJson(url, param, String.class, null);
    }
    
    public static <T> T postJson(String url, Map<String, Object> param, Class<T> responseType, String token) {
        RestTemplate restClient = instance();
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.setContentType(type);
        if (token != null) {
            headers.add("token", token);
        }
        String requestJson = null;//JSON.toJSONString(param);
        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
        return restClient.postForObject(url, entity, responseType);
    }

    public static String fetchString(Map<String, Object> param, String url) {
        RestTemplate restClient = instance();
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.setAll(param);
        String getParams = "?" + map.keySet().stream().map(k -> String.format("%s={%s}", k, k))
                .collect(Collectors.joining("&"));
        String res = restClient.getForObject(url + getParams, String.class, param);
        log.info("fetchString resp: " + res);
        return res;
    }
}
