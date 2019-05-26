package com.io;

/**
 * Created by GD on 2019/5/12.
 */

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

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
}
