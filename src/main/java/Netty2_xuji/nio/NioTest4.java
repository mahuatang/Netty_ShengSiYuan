package Netty2_xuji.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest4 {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream("input.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");

        FileChannel fileChannel = fileInputStream.getChannel();
        FileChannel fileChannel2 = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (true) {
            byteBuffer.clear();
            int length = fileChannel.read(byteBuffer);
            if (length < 0) {
                break;
            }
            byteBuffer.flip();
            fileChannel2.write(byteBuffer);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
