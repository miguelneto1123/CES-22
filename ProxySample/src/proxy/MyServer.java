package proxy;

import java.net.*;
import java.io.*;

public class MyServer implements Runnable{
	private String messages[] = {"Hello!", "Olá!", "Hola!", "Hallo!", "Konnichiwa!"};
	ServerSocket ssoc = null;
	private int port;
	
	public MyServer(int port) {
		this.port = port;
	}
	
	public void go() {
		try {
			ssoc = new ServerSocket(port);
			
			while (true) {
				Socket soc = ssoc.accept();
				
				PrintWriter pw = new PrintWriter(soc.getOutputStream());
				String message = getMessage();
				pw.println(message);
				pw.close();
				System.out.println(message);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public String getMessage() {
		int random = (int) (Math.random() * messages.length);
		return messages[random];
	}

	@Override
	public void run() {
		this.go();	
	}
	
	
}
