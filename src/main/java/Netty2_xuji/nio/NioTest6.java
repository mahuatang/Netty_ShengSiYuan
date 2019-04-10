package Netty2_xuji.nio;

import java.nio.ByteBuffer;

public class NioTest6 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        for (int i = 0; i < 10; i++) {
            byteBuffer.put((byte)(i+1));
        }

        byteBuffer.position(2);
        byteBuffer.limit(6);

        ByteBuffer sliceBuffer = byteBuffer.slice();

        for (int j = 0; j < 4; j++) {
            Byte b = sliceBuffer.get(j);
            sliceBuffer.put(j, (byte)(b * 2));
        }

        byteBuffer.clear();

        while (byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.get());
        }
    }
}
