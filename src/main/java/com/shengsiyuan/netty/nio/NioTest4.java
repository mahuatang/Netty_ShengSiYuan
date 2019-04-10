package com.shengsiyuan.netty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by YuRui on 2017/8/2.
 */
public class NioTest4 {
    public static void main(String[] args) throws Exception{
        FileInputStream inputStream = new FileInputStream("input.txt");
        FileOutputStream outputStream = new FileOutputStream("output.txt");

        FileChannel inputChannel = inputStream.getChannel();
        FileChannel outputChannel = outputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while(true) {//此处不能设置成buff.hasRemaining()
            buffer.clear();//如果这行代码注释掉
            int read = inputChannel.read(buffer);//实现每次读一部分
            System.out.println("read: " + read);
            if(-1 == read) {
                break;
            }
            buffer.flip();
            outputChannel.write(buffer);
        }
        inputChannel.close();
        outputChannel.close();
    }
}
