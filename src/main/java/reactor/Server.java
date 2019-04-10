package reactor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    public static int MAX_INPUT = 10;
    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket();
            while(!Thread.interrupted()) {
                new Thread(new Handler(ss.accept())).start();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static class Handler implements Runnable {
        final Socket socket;
        Handler(Socket s) {
            socket = s;
        }
        public void run() {
            try {
                byte[] input = new byte[MAX_INPUT];
                socket.getInputStream().read(input);
                byte[] output = process(input);
                socket.getOutputStream().write(output);
            } catch (IOException ex) {
                /*******/
            }
        }

        private static byte[] process(byte[] c) {
            System.out.println("do dosomething");
            return c;
        }
    }
}
