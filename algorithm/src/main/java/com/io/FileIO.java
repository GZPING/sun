package com.io;

/**
 * Created by GD on 2019/5/23.
 *
 * @Description TODO
 * @Author GD
 * @Date 2019/5/23 23:25
 * @Version 1.0V
 */

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2019/5/23 23:25
 * @Version 1.0V
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 1. 读取文件File
 2. 将文件写入流中
 3. 从流中读取数据


 */

public class FileIO {

    public static void main(String[] args) {
        InputStream is = null;
        try {
            is = new FileInputStream(new File("E://data/test.txt"));
            byte[] b = new byte[2048];
            int line;
            while ((line=is.read(b))!= -1){
                for (int i = 0; i < line; i++) {
                    System.out.print((char)b[i]);
                }
                System.out.println();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
