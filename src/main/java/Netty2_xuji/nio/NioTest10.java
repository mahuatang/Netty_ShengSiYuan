package Netty2_xuji.nio;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class NioTest10 {
    public static void main(String[] args) throws Exception{
        RandomAccessFile randomAccessFile = new RandomAccessFile("NioTest10", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();

        FileLock lock = fileChannel.lock(3, 6, true);

        System.out.println(lock.isShared());
        System.out.println(lock.isValid());

        lock.release();

        System.out.println(lock.isShared());
        System.out.println(lock.isValid());

        randomAccessFile.close();
    }
}
