package tests;
import java.net.*;
import java.util.*;
import java.io.*;

public class WebServe {
	private Socket soc;
	private OutputStream os;
	private BufferedReader is;
	private String resource;
	
	public void getRequest() {
		try {
			String message;
			
			while ((message = is.readLine()) != null) {
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
	
	public void returnResponse() {
		int c;
		try {
			FileInputStream f = new FileInputStream("." + resource);
			while ((c = f.read()) != -1) {
				os.write(c);
			}
			f.close();
		} catch (IOException ioe) {
			System.err.println("IOException in reading in Web "
					+ resource + " server");
		}
	}
	
	public void close() {
		try {
			is.close();
			os.close();
			soc.close();
		} catch (IOException ioe) {
			System.err.println("IOException in closing connection");
		}
	}
	
	public WebServe(Socket s) throws IOException {
		soc = s;
		os = s.getOutputStream();
		is = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}
}
