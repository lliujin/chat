package com.liujin;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) {

        Socket s = null;
        DataInputStream dis = null;

        boolean started = false;
        try {
            ServerSocket ss = new ServerSocket(9999);
            started = true;
            while(started) {
                boolean bConnected = false;
                s = ss.accept();
System.out.println("connected!");
                bConnected = true;
                dis = new DataInputStream(s.getInputStream());
                while(bConnected) {
                    String str = dis.readUTF();
                    System.out.println(str);
                }
            }
        } catch (IOException e) {
            System.out.println("Client closed!");
        } finally {
            try {
                if(dis != null) dis.close();
                if(s != null) s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
