package com.shengsiyuan.zerocopy;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by YURUIThink on 2017/10/1.
 */
public class NewIOServer {
    public static void main(String[] args) throws Exception{
        InetSocketAddress address = new InetSocketAddress(8899);

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.setReuseAddress(true);//如果想绑定到某一个端口号上，但是那个端口号正处于超时状态，
                                          // 则不能绑定成功，此设置可以绑定成功
        serverSocket.bind(address);

        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);

        while(true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(true);//返回来的socketchannel默认就是阻塞的，
                                                  // 如果要注册到selector上，必须设置成非阻塞的

            int readCount = 0;

            while(-1 != readCount) {
                try {
                    readCount = socketChannel.read(byteBuffer);
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
                byteBuffer.rewind();//重新读
            }

        }
    }
}
