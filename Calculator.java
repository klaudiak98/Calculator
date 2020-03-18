import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;
//import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calculator {

	 public static void createAndShowGUI() {
	        JFrame jf = new JFrame("Calculator");
	        jf.setLayout(new BorderLayout());
	        
	        TextField tx = new TextField();
	        tx.setEditable(false);
	        jf.getContentPane().add(tx, BorderLayout.NORTH); 
	        
	        JPanel jp = new JPanel();
	        jf.getContentPane().add(jp);
	        jp.setLayout(new GridLayout(4,4));
	        
	        MyActionListener myActionListener = new MyActionListener(tx);
	        
	        JButton jb1 = new JButton("1");
	        jb1.addActionListener(myActionListener);
	        jp.add(jb1);
	        
	        JButton jb2 = new JButton("2");
	        jb2.addActionListener(myActionListener);
	        jp.add(jb2);
	        
	        JButton jb3 = new JButton("3");
	        jb3.addActionListener(myActionListener);
	        jp.add(jb3);
	        
	        JButton jbp = new JButton("+");
	        jbp.addActionListener(myActionListener);
	        jp.add(jbp);
	        
	        JButton jb4 = new JButton("4");
	        jb4.addActionListener(myActionListener);
	        jp.add(jb4);
	        
	        JButton jb5 = new JButton("5");
	        jb5.addActionListener(myActionListener);
	        jp.add(jb5);
	        
	        JButton jb6 = new JButton("6");
	        jb6.addActionListener(myActionListener);
	        jp.add(jb6);
	        
	        JButton jbmi = new JButton("-");
	        jbmi.addActionListener(myActionListener);
	        jp.add(jbmi);
	        
	        JButton jb7 = new JButton("7");
	        jb7.addActionListener(myActionListener);
	        jp.add(jb7);
	        
	        JButton jb8 = new JButton("8");
	        jb8.addActionListener(myActionListener);
	        jp.add(jb8);
	        
	        JButton jb9 = new JButton("9");
	        jb9.addActionListener(myActionListener);
	        jp.add(jb9);
	        
	        JButton jbm = new JButton("*");
	        jbm.addActionListener(myActionListener);
	        jp.add(jbm);
	        
	        JButton jb0 = new JButton("0");
	        jb0.addActionListener(myActionListener);
	        jp.add(jb0);
	       
	        JButton jbe = new JButton("=");
	        jbe.addActionListener(myActionListener);
	        jp.add(jbe);
	        
	        JButton jbc = new JButton("C");
	        jbc.addActionListener(myActionListener);
	        jp.add(jbc);
	        
	        JButton jbd = new JButton("/");
	        jbd.addActionListener(myActionListener);
	        jp.add(jbd);
	            
	        jf.pack();
	        jf.setVisible(true);
	        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }

	    public static void main(String[] args) {
	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() { createAndShowGUI(); }
	        });        
	    }

}