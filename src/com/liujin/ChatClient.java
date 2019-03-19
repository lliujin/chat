package com.liujin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        textField.addActionListener(new TextFieldListener());
        setVisible(true);
    }

    private class TextFieldListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String s = textField.getText();
            textArea.setText(s);
            textField.setText("");
        }
    }
}
