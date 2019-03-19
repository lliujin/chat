package com.liujin;

import java.io.IOException;
import java.net.ServerSocket;

public class ChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket();
            System.out.println("a client connected!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
