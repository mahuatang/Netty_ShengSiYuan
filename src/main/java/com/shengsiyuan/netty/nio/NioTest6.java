package com.shengsiyuan.netty.nio;

import java.nio.ByteBuffer;
/*
* Slice Buffer与原有buffer共享相同的底层数组
* */
public class NioTest6 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);//同样可以使用IntBuffer实现

        for(int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte)i);//此处int可以转换为byte
        }

        buffer.position(2);
        buffer.limit(6);

        ByteBuffer sliceBuffer = buffer.slice();

        for (int i = 0; i < sliceBuffer.capacity(); i++) {
            byte b = sliceBuffer.get(i);//不加i也可以
            b *= 2;
            sliceBuffer.put(i, b);
        }

        buffer.position(0);
        buffer.limit(buffer.capacity());//可以直接clear

        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }
}
