package Netty2_xuji.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

public class NioTest1 {
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(10);

        for(int i = 0; i < 5; i++) {
            buffer.put(new SecureRandom().nextInt(20));
        }

        System.out.println("before flip:");
        System.out.println(buffer.limit());;
        buffer.flip();
        System.out.println("after flip:");
        System.out.println(buffer.limit());

        while (buffer.hasRemaining()) {
            System.out.println("limit: " + buffer.limit());
            System.out.println("position: " + buffer.position());
            System.out.println("capacity: " + buffer.capacity());

            System.out.println(buffer.get());
            System.out.println("-------------------");
        }

        System.out.println("------*************---");
        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        System.out.println(buffer.capacity());

        buffer.flip();

        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        System.out.println(buffer.capacity());


        buffer.put(1);
        buffer.put(2);

        System.out.println("---------");

        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        System.out.println(buffer.capacity());

        buffer.flip();

        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        System.out.println(buffer.capacity());
    }
}
