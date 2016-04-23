import java.net.*;
import java.util.*;
import java.io.*;

public class WebProxy {
	
	/*
	 * Prefixes 1 and 2 refer, respectively, to connection
	 * with the client and to connection with the server
	 * */
	private Socket soc1, soc2;
	private OutputStream os1, os2;
	private BufferedReader is1, is2;
	private String resource;
	private ArrayList<String> forbiddenServers;
	
	public void requestToServer(String path) {
		try {
			String message = "GET " + path + "\n\n";
			os2.write(message.getBytes());
			os2.flush();
		} catch (IOException e) {
			System.err.println("Error in HTTP request");
		}
	}
	public void getResponseFromServer() {
		int c;
		try {
			while ((c = is2.read()) != -1)
				System.out.print((char) c) ;
		} catch (IOException e) {
			System.err.println("IOException in reading from Web server");
		}
	}
	
	public void getRequestFromClient() {
		try {
			String message;
			
			while ((message = is1.readLine()) != null) {
				if (message.equals(""))
					break;
				System.err.println(message);
				StringTokenizer t = new StringTokenizer(message);
				String token = t.nextToken();
				if (token.equals("GET"))
					resource = t.nextToken();
			}
		} catch (IOException ioe) {
			System.err.println("Error receiving web request");
		}
	}
	
	public void returnResponseToClient() {
		StringTokenizer t = new StringTokenizer(resource, ":");
		String server = t.nextToken();
		if (forbiddenServers.contains(server)){
			System.err.println("You can't access this web domain!");
		}
		else {
			int c;
			try {
				FileInputStream f = new FileInputStream("." + resource);
				while ((c = f.read()) != -1) {
					os1.write(c);
				}
				f.close();
			} catch (IOException ioe) {
				System.err.println("IOException in reading in Web "
						+ resource + " server");
			}
		}
	}
	
	public void close() {
		try {
			is1.close(); os1.close(); soc1.close();
			is2.close(); os2.close(); soc2.close();
		} catch (IOException e) {
			System.err.println("IOException in closing connections");
		}
	}
	
	public Socket getClientSocket() {
		return soc1;
	}
	
	public WebProxy (Socket s1, String server, int port)
			throws IOException, UnknownHostException{
		soc1 = s1;
		os1 = soc1.getOutputStream();
		is1 = new BufferedReader(new InputStreamReader(soc1.getInputStream()));
		soc2 = new Socket(server, port);
		os2 = soc2.getOutputStream();
		is2 = new BufferedReader(new InputStreamReader(soc2.getInputStream()));
		forbiddenServers = new ArrayList<String>();
		forbiddenServers.add("www.facebook.com");
		forbiddenServers.add("www.youtube.com");
		forbiddenServers.add("www.twitter.com");
	}
}
