package com.liujin;

import java.awt.*;

public class ChatClient extends Frame {

    TextField textField = new TextField();
    TextArea textArea = new TextArea();

    public static void main(String[] args) {
        new ChatClient().launchFrame();
    }

    public void launchFrame() {
        setBounds(400,300,300,300);
        add(textField, BorderLayout.SOUTH);
        add(textArea, BorderLayout.NORTH);
        pack();
        setVisible(true);
    }
}
