package com.liujin;

import java.awt.*;

public class ChatClient extends Frame {
    public static void main(String[] args) {
        new ChatClient().launchFrame();
    }

    public void launchFrame() {
        setBounds(400,300,300,300);
        setVisible(true);
    }
}
