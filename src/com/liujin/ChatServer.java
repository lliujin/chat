package com.liujin;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9999);
            while(true) {
                Socket s = ss.accept();
System.out.println("connected!");
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String str = dis.readUTF();
                System.out.println(str);
                dis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
