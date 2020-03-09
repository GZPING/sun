package com.algorithm.io;

/**
 * Created by GD on 2019/5/23.
 */

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2019/5/23 23:05
 * @Version 1.0V
 */
/*
1. 读取文件

2. 创建Channel

3. 绑定buffer

4. 读取buffer
 */
public class FileNio {

    public static void main(String[] args) {


        RandomAccessFile accessFile = null;

        try {

            accessFile = new RandomAccessFile("E://data/test.txt","rw");

            FileChannel fileChannel = accessFile.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            int line;

            while ((line = fileChannel.read(byteBuffer))!= -1){
                // 转换
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()){
                    System.out.print((char) byteBuffer.get());
                }
                System.out.println();
                // buffer.compact()将没有发出的数据复制到 buffer的开始位置
                byteBuffer.compact();

            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(accessFile != null){
                try {
                    accessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
