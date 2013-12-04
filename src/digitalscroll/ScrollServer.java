package digitalscroll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ScrollServer {

	public static AppController app;
	public static ServerSocket serverSocket;
	static {
		app = new AppController();
		try {
			serverSocket = new ServerSocket();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		JButton btnStart = new JButton("Start");
		JButton btnStop = new JButton("Stop");
		app.mapAction("start", StartServerAction.class);
		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String response = (String)JOptionPane.showInputDialog("Enter port number...");
				int port = Integer.parseInt(response);
				app.handleRequest("start", port, true);
			}
			
		});
		frame.add(btnStart);
		
		app.mapAction("stop", StopServerAction.class);
		btnStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					serverSocket.close();
				}
				catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			
		});
	}
}
