package proxySample;
import java.net.*;
import java.util.*;
import java.io.*;

public class WebServe implements Runnable{
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
				if (token.equals("GET")) {
					resource = t.nextToken();
				}
			}
		} catch (IOException ioe) {
			System.err.println("Error receiving web request");
		}
	}
	
	public void returnResponse() {
		String address;
		String request = "/";
		
		StringTokenizer st = new StringTokenizer(resource, "/");
		address = st.nextToken();
		if (st.hasMoreTokens()){
			request += st.nextToken();
		}
		
		try {
			WebRetriever wr = new WebRetriever(address, 80);
			wr.request(request, address, soc.getPort());
			
			byte[] byteMessage = wr.getResponse().getBytes();
			os.write(byteMessage);
			wr.close();
		} catch (UnknownHostException uhe){
			System.err.println(uhe.getMessage());
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
	
	@Override
	public void run() {
		getRequest();
		returnResponse();
		close();
	}
	
	public WebServe(Socket s) throws IOException {
		soc = s;
		os = s.getOutputStream();
		is = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}
	
	public static void main(String args[]) {
		 try {
			 ServerSocket s = new ServerSocket(4242);
			 for (;;) {
				 WebServe w = new WebServe(s.accept());
				 Thread thr = new Thread(w);
				 thr.start();

			 }
		 } catch (IOException i) {
			 System.err.println("IOException in Server");
			 i.printStackTrace();
		 }
	 }
}
