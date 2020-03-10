package com.instantiate;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Date;
import java.util.Random;

/**
 * 自动生成实例
 * @author : GD
 * @date :2020/3/10 : 21:23
 */
public class InstanceUtil {

    /**
     * 通过class 初始化一个对象
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T initClassInfo(Class<T> clazz) {
        T bean=null;
        try{
            bean = clazz.getDeclaredConstructor().newInstance();
            Method[] methods = clazz.getDeclaredMethods();
            Field[] fields = clazz.getDeclaredFields();

            for(Field field:fields){
                String fieldSetName = parSetName(field.getName());
                if (!checkSetMet(methods, fieldSetName)) {
                    continue;
                }
                Method fieldSetMet = clazz.getMethod(fieldSetName,
                        field.getType());

                fieldSet(bean,fieldSetMet,field);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("initClassInfo调用异常");
        }
        return bean;
    }

    /**
     * 通过type 随机生成一个对象
     * @param type
     * @return
     */
    private static Object getRandomInfo(String type) {
        try{
            if(type.equals("String")){
                int length = (int) (Math.random()*10);
                String str = "猪猪侠哈哈测试数据拉拉拉老王小王abcdefg1234567890猪大美丽小花冬冬强豆豆新";
                char[] chr = str.toCharArray();
                Random random = new Random();
                StringBuffer buffer = new StringBuffer();
                for (int i = 0; i < length; i++) {
                    buffer.append(chr[random.nextInt(46)]);
                }
                return buffer.toString();
            }else if(type.equals("Date")){
                return new Date();
            }else if(type.equals("Long")){
                return (long)(Math.random()*100000);
            }else if(type.equals("Integer")){
                return (int)(Math.random()*1000);
            }else if(type.equals("int")){
                return (int)(Math.random()*1000);
            }else if(type.equals("Double")){
                return Math.random()*100;
            }else if(type.equals("Boolean")){
                double a = Math.random();
                return a>0.5 ;
            }else if(type.equals("BigDecimal")){
                return new BigDecimal(Math.random() * 100, MathContext.DECIMAL32);
            }
        }catch (Exception e){
            System.out.println("未找到匹配类型,初始化数据失败"+type);
        }
        return "haha";
    }


    /**
     * 拼接在某属性的 set方法
     *
     * @param fieldName
     * @return String
     */
    private static String parSetName(String fieldName) {
        if (null == fieldName || "".equals(fieldName)) {
            return null;
        }
        int startIndex = 0;
        if (fieldName.charAt(0) == '_'){
            startIndex = 1;
        }
        return "set"
                + fieldName.substring(startIndex, startIndex + 1).toUpperCase()
                + fieldName.substring(startIndex + 1);
    }

    /**
     * 判断是否存在某属性的 set方法
     *
     * @param methods
     * @param fieldSetMet
     * @return boolean
     */
    private static boolean checkSetMet(Method[] methods, String fieldSetMet) {
        for (Method met : methods) {
            if (fieldSetMet.equals(met.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 调用某个set方法set数据
     * @param bean
     * @param fieldSetMet
     * @param field
     * @throws Exception
     */
    private static void fieldSet(Object bean, Method fieldSetMet, Field field) throws Exception{
        String fieldType = field.getType().getSimpleName();
        Object value = getRandomInfo(fieldType);
        if ("String".equals(fieldType)) {
            fieldSetMet.invoke(bean, (String)value);
        } else if ("Date".equals(fieldType)) {
            Date temp = (Date)value;
            fieldSetMet.invoke(bean, temp);
        } else if ("Integer".equals(fieldType)
                || "int".equals(fieldType)) {
            Integer intval = (Integer)value;
            fieldSetMet.invoke(bean, intval);
        } else if ("Long".equalsIgnoreCase(fieldType)) {
            Long temp = (Long)value;
            fieldSetMet.invoke(bean, temp);
        } else if ("Double".equalsIgnoreCase(fieldType)) {
            Double temp = (Double)value;
            fieldSetMet.invoke(bean, temp);
        } else if ("Boolean".equalsIgnoreCase(fieldType)) {
            Boolean temp =(Boolean)value;
            fieldSetMet.invoke(bean, temp);
        }else if ("BigDecimal".equalsIgnoreCase(fieldType)) {
            BigDecimal temp =(BigDecimal)value;
            fieldSetMet.invoke(bean, temp);
        } else {
            System.out.println("未找到匹配类型" + fieldType);
        }
    }

    public static void main(String[] args) {
        Order o = InstanceUtil.initClassInfo(Order.class);
        System.out.println(o);
    }
}
