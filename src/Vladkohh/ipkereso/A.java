package Vladkohh.ipkereso;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class A extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	JLabel l;
	JTextField tf;
	JButton b;
	A(){
		super("Minecraft ip scraper");
		l = new JLabel("MC szerver ip");
		l.setBounds(50,70,150,20);
		tf = new JTextField();
		tf.setBounds(50, 100, 200, 20);
		
		setLocationRelativeTo(null);
		b = new JButton("IP!");
		b.setBounds(70,150,100,30);
		b.addActionListener(this);
		setLayout(null);
		add(l);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(tf);
		add(b);
		setSize(300,300);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		String url = tf.getText();
		String message = "A szerver szamos ip-je: ";
		try {
			InetAddress ia = InetAddress.getByName(url);
			String ip = ia.getHostAddress();
			JOptionPane.showMessageDialog(this, ip,message, getDefaultCloseOperation());
		}catch (UnknownHostException e1){
			JOptionPane.showMessageDialog( null, "Ismeretlen IP cim! hadd mondjak egy példát: play.mineside.hu XD");
			
		}
		
	}
	public static void open() throws IOException {
		Desktop.getDesktop().open(new File("quboscanner/quboscanner.jar"));
	}
	public static void main(String[]args) throws IOException {
		System.out.println("Welcome to my Minecraft IP finder! To open the finder, type 'IPFind' then press enter. To open QuboScanner: 'quboscan'. To quit the program type 'Exit'.");
		while(true) {
			@SuppressWarnings("resource")
		Scanner f = new Scanner(System.in);
		String storage = f.nextLine();
		if(storage.equals("IPFind")) {
		new A();
		}
		if(storage.equals("quboscan")) {
			open();
		}
		if(storage.equals("Exit")) {
			
			System.exit(1);
		}
		}
	}
}