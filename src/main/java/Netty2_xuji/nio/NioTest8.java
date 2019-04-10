package Netty2_xuji.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest8 {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream("input.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("output3.txt");

        FileChannel fielChannel1 = fileInputStream.getChannel();
        FileChannel fileChannel2 = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        while(true) {
            byteBuffer.clear();
            int read = fielChannel1.read(byteBuffer);
            System.out.println(read);
            if (read == -1) {
                break;
            }

            byteBuffer.flip();
            fileChannel2.write(byteBuffer);
        }

        fielChannel1.close();
        fileChannel2.close();
    }
}
