package com.tranational;

import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;

/**
 * @Author : GD
 * @Create :2019/8/27 : 15:26
 */
public class RestTemplateUtils {

    /**
     * restTemplate 传递文件
     * @throws Exception
     */
    @Test
    public void pic_upload2() throws Exception{

        File file = new File("C:\\Users\\Doctor\\Pictures\\1000x400.png");
        FileSystemResource multipartFile = new FileSystemResource(file);
//        ByteArrayResource contentsAsResource = new ByteArrayResource(in2b) {
//            @Override
//            public String getFilename() {
//                return "image";
//            }
//        };
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("weiboUid","5882229087");
        body.add("weiboType","SINA_DR");
        body.add("image",multipartFile);
        //body.add("image",contentsAsResource);
        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange("http://192.168.255.120:51002/api/weiboProxyService/upload_pic"
                , HttpMethod.POST,entity,String.class);
        System.out.println(response);
    }
}
