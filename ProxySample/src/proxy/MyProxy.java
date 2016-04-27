package proxy;

import java.net.*;
import java.io.*;

public class MyProxy implements Runnable{
	private ServerSocket client;
	private Socket server;
	
	private int serverPort;
	private int clientPort;
	
	public MyProxy(int serverPort, int clientPort) {
		this.serverPort = serverPort;
		this.clientPort = clientPort;
	}
	
	public void go() {
		try {
			client = new ServerSocket(clientPort);
			
			while (true) {	
				server = new Socket("localhost", serverPort);
				
				Socket socClient = client.accept();
				
				InputStreamReader inputServer =
						new InputStreamReader(server.getInputStream());
				BufferedReader buffer = new BufferedReader(inputServer);
				PrintWriter pw = new PrintWriter(socClient.getOutputStream());
				
				String proxyMessage = "From proxy: " + buffer.readLine();
				
				pw.println(proxyMessage);
				System.out.println(proxyMessage);
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		this.go();
	}
	
	public static void main(String args[]) {
		MyServer server = new MyServer(4242);
		MyProxy proxy = new MyProxy(4242, 5050);
		
		server.go();
		proxy.go();
	}
}
