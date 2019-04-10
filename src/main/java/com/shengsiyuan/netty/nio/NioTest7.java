package com.shengsiyuan.netty.nio;

import java.nio.ByteBuffer;
/*
* 只读buffer，我们可以随时将一个普通buffer调用asReadonlyBuffer方法返回一个只读Buffer
* 但不能将一个只读Buffer转换为读写Buffer
* */
public class NioTest7 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        System.out.println(buffer.getClass());

        for(int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte)i);
        }

        ByteBuffer readonlyBuffer = buffer.asReadOnlyBuffer();

        System.out.println(readonlyBuffer.getClass());

        readonlyBuffer.position(0);
        readonlyBuffer.put((byte)2);//只读buffer加了会报错
    }
}
