package utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HABJOptionPane extends JFrame implements ActionListener{

	  HABJOptionPane(){
	    JButton button = new JButton("dialog");
	    button.addActionListener(this);

	    JPanel p = new JPanel();
	    p.add(button);

	    getContentPane().add(p, BorderLayout.CENTER);
	  }

  public static void main(String[] args){
    HABJOptionPane frame = new HABJOptionPane();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(10, 10, 300, 200);
    frame.setTitle("タイトル");
    frame.setVisible(true);
    frame.setAlwaysOnTop(true);
  }

  public void actionPerformed(ActionEvent e){
    JLabel label = new JLabel("Message");
    label.setForeground(Color.RED);
    JOptionPane.showMessageDialog(this, label);
  }
}