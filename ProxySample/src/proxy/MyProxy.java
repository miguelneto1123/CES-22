package proxy;

import java.net.*;
import java.io.*;

public class MyProxy {
	private ServerSocket client;
	private Socket server;
	
	public void go(int serverPort, int clientPort) {
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
	
	public static void main(String args[]) {
		MyServer server = new MyServer();
		MyProxy proxy = new MyProxy();
		
		server.go(4242);
		proxy.go(4242, 5050);
	}
}
