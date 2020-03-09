package com.algorithm.io;

/**
 * Created by GD on 2019/5/12.
 */

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2019/5/12 19:34
 * @Version 1.0V
 */

public class TimeServer implements Runnable{

    private ServerSocketChannel serverSocketChannel;

    private Selector selector;

    private volatile Boolean stop;

    public TimeServer(int port){
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(port));

            selector =Selector.open();

            serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void lisense() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(1000));
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        SelectionKey key = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        int num = selector.select();

        Set selectkeys = selector.selectedKeys();

        Iterator it = selectkeys.iterator();
        while (it.hasNext()){
            SelectionKey key2 = (SelectionKey) it.next();
        }

    }

    @Override
    public void run() {
        try {
            // 设置超时时间
            selector.select(1024);
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> it = selectionKeys.iterator();
            SelectionKey key = null;
            while (it.hasNext()){
                key = it.next();
                it.remove();
                handleInput(key);
            }
            int[] a = new int[2];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleInput(SelectionKey key) throws IOException{
        if(key.isValid()){
            if(key.isAcceptable()){
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                sc.register(selector,SelectionKey.OP_READ);
            }
            if(key.isReadable()){
                // read data
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer bb = ByteBuffer.allocate(1024);
                int readBytes = sc.read(bb);
                if(readBytes > 0){
                    bb.flip();
                    byte[] bytes = new byte[bb.remaining()];
                    bb.get(bytes);
                    String info = new String(bytes,"UTF-8");
                    System.out.println("server receive info : " + bytes);
                    String response = "OK";
                    dowrite(sc,response);
                }else if(readBytes < 0){
                    key.cancel();
                    sc.close();
                }
            }

        }

    }

    private void dowrite(SocketChannel sc, String response) throws IOException {

        if(response != null && "".equals(response)){
            byte[] bytes = response.getBytes();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put(bytes);
            byteBuffer.flip();
            sc.write(byteBuffer);
        }
    }
}
