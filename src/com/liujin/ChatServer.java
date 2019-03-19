package com.liujin;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) {
        try {
            System.out.println("connected!");
            ServerSocket ss = new ServerSocket(9999);
            while(true) {
                Socket s = ss.accept();
System.out.println("connected!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
