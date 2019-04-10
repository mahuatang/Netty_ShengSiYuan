package Netty2_xuji.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest3 {
    public static void main(String[] args) throws Exception{
        FileOutputStream fileInputStream = new FileOutputStream("NioTest2.txt");
        FileChannel fileChannel = fileInputStream.getChannel();

        byte[] bytes = "MMMMMMMMMMMMMMhello shengsiyuan zhanglong WWWWWWWWWWWWWWWWWW".getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);


        for (int i = 0; i < bytes.length; i++) {
            byteBuffer.put(bytes[i]);
        }

        byteBuffer.flip();

        fileChannel.write(byteBuffer);

        fileInputStream.close();

    }
}
