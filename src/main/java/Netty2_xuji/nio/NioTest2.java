package Netty2_xuji.nio;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest2 {
    public static void main(String[] args) throws Exception{
        FileInputStream filInputStream = new FileInputStream("input.txt");
        FileChannel fileChannel = filInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        fileChannel.read(byteBuffer);

        byteBuffer.flip();

        while (byteBuffer.hasRemaining()) {
            byte by = byteBuffer.get();

            System.out.println((char)by + " ");
        }

        filInputStream.close();
    }
}
