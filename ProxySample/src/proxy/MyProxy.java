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
				
				pw.println("From proxy: " + buffer.readLine());
				
				pw.close();
				buffer.close();
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
