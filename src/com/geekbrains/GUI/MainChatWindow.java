package com.geekbrains.GUI;

import javax.swing.*;
import java.awt.*;


public class MainChatWindow extends JFrame{

    private JTextField jtx;
    private JTextArea jta;

    public MainChatWindow(){
        setTitle("Chat window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(600,600,400,400);


        JPanel bottomPanel = new JPanel();
        JPanel centralPanel = new JPanel();

        centralPanel.setBackground(Color.WHITE);
        bottomPanel.setBackground(Color.GRAY);

        bottomPanel.setPreferredSize(new Dimension(1,40));

        add(bottomPanel,BorderLayout.SOUTH);
        add(centralPanel,BorderLayout.CENTER);

        centralPanel.setLayout(new BorderLayout());
        bottomPanel.setLayout(new FlowLayout());

        JButton jb = new JButton("Send message");
        bottomPanel.add(jb);

        JButton jb1 = new JButton("Clear");
        bottomPanel.add(jb1);

        jb.addActionListener(e -> sendText()); // лямбда, выражения выше
        jb1.addActionListener(e -> jta.setText(""));

        jta = new JTextArea();
        jta.setEditable(false);
        JScrollPane jsp = new JScrollPane(jta);
        centralPanel.add(jsp,BorderLayout.CENTER);

        jtx = new JTextField();
        jtx.addActionListener(e -> sendText());
        centralPanel.add(jtx,BorderLayout.SOUTH);

        setVisible(true);
    }

    private void sendText() {

        if (jtx.getText()!=null && !jtx.getText().isEmpty()){
            jta.append(jtx.getText() + "\n");
        }
        jtx.setText("");
        jtx.grabFocus(); // возвращаем фокус на поле ввода текста
    }

}
