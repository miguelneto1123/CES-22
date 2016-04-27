package proxySample;
import java.io.*;
import java.net.*;

class WebRetriever {
	private Socket soc;
	private OutputStream os;
	private InputStream is;
	
	WebRetriever(String server, int port)
			throws IOException, UnknownHostException {
			soc = new Socket(server, port);
			os = soc.getOutputStream();
			is = soc.getInputStream();
	}

	public void request(String path, String host, int hostPort) {
		PrintWriter pw = new PrintWriter(os);
		pw.println("GET "+path+" HTTP/1.1\r");
		pw.println("Host: "+host+":"+hostPort+"\r");
		pw.println("Accept: */*\r\n Accept-Encoding: gzip, deflate\r\n "
				+ "User-Agent: runscope/0.1\r\n\r");
		pw.flush();
	}
	
	public String getResponse() {
		int c;
		String response = "";
		System.out.println("HTTP RESPONSE:");
		try {
			while ((c = is.read()) != -1) {
				System.out.print((char) c) ;
				response += (char) c;
			}
		} catch (IOException e) {
			System.err.println("IOException in reading from " +
					"Web server");
		}
		return response;
	}
	
	public void close() {
		try {
			is.close(); os.close(); soc.close();
		} catch (IOException e) {
			System.err.println("IOException in closing connection");
		}
	}
	
	/*public static void main(String[] args) {
		try {
			WebRetriever w = new WebRetriever("www.ita.br", 80);
			w.request("/grad/");
			w.getResponse();
			w.close();
		} catch (UnknownHostException h) {
			System.err.println("Hostname Unknown");
		} catch (IOException i) {
			System.err.println("IOException in connecting to Host");
		}
	}*/
}