package com.liujin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class ChatClient extends Frame {

    Socket s = null;
    DataOutputStream dos = null;
    DataInputStream dis = null;
    private  boolean bConnected = false;

    TextField textField = new TextField();
    TextArea textArea = new TextArea();
    Thread tRecv = new Thread(new RecvThread());

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
                disconnect();
                System.exit(0);
            }
        });
        textField.addActionListener(new TextFieldListener());
        setVisible(true);
        connect();

        tRecv.start();
    }

    public void connect() {
        try {
            s = new Socket("127.0.0.1", 9999);
            dos = new DataOutputStream(s.getOutputStream());
            dis = new DataInputStream(s.getInputStream());
System.out.print("a client connected!");
            bConnected = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            dos.close();
            dis.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class TextFieldListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String str = textField.getText().trim();
            textField.setText("");
            try {
                dos.writeUTF(str);
                dos.flush();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    private class RecvThread implements Runnable {

        @Override
        public void run() {
            try {
                while (bConnected) {
                    String str = dis.readUTF();
System.out.println(str);
                    textArea.setText(textArea.getText() + str + '\n');
                }
            } catch (SocketException e) {
                System.out.println("exit,bye!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
