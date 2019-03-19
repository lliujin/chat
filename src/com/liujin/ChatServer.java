package com.liujin;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    boolean started = false;
    ServerSocket ss = null;

    public static void main(String[] args) {
        new ChatServer().start();
    }

    public void start() {
        try {
            ss = new ServerSocket(9999);
            started = true;
        } catch (BindException e) {
            System.out.println("端口使用中……");
            System.out.println("请关掉相关程序并重新启动服务器");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {

            while(started) {
                Socket s = ss.accept();
                Client c = new Client(s);

                new Thread(c).start();
                System.out.println("connected!");

            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class Client implements Runnable {

        private Socket s;
        private DataInputStream dis = null;
        private boolean bConnected = false;

        public Client(Socket s) {
            this.s = s;
            try {
                dis = new DataInputStream(s.getInputStream());
                bConnected = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                while (bConnected) {
                    String str = dis.readUTF();
                    System.out.println(str);
                }
            } catch(EOFException e){
                    System.out.println("Client closed!");
            } catch(IOException e){
                    e.printStackTrace();
            } finally{
                try {
                    if (dis != null) dis.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
