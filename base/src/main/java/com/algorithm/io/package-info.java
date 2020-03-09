/**
 * Created by GD on 2019/5/23.
 */
package com.algorithm.io;

/*
NIO :

1. Channel

用于数据传输，是双向的
既可以用来进行读操作，又可以用来进行写操作

主要有实现类 ：
        FileChannel   文件IO
        DataGramChannel   UDP
        SocketChannel   TCP
        ServerSocketChannel  TCP server

2 Buffer

ByteBuffer, CharBuffer, DoubleBuffer, FloatBuffer, IntBuffer, LongBuffer, ShortBuffer
MappedByteBuffer, HeapByteBuffer, DirectByteBuffer



3. Selector

Selector运行单线程处理多个Channel，如果你的应用打开了多个通道，但每个连接的流量都很低，使用Selector就会很方便。
例如在一个聊天服务器中。要使用Selector, 得向Selector注册Channel，
然后调用它的select()方法。这个方法会一直阻塞到某个注册的通道有事件就绪。
一旦这个方法返回，线程就可以处理这些事件，事件的例子有如新的连接进来、数据接收等。




 */
