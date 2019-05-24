package com.netty;

/**
 * Created by GD on 2019/5/12.
 */

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2019/5/12 19:34
 * @Version 1.0V
 */

public class TimeServer {

    public void lisense() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(InetAddress.getByName("IP"),1000));
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();

        


    }
}
