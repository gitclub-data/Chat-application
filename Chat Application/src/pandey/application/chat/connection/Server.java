package pandey.application.chat.connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	//defining port number
	private static final int port=9090;
	public static void main(String args[]) throws IOException {
		//start the server
		ServerSocket listener=new ServerSocket(port);

		System.out.println("Waiting for connection");
		Socket client=listener.accept(); 
		System.out.println("Connected");
		
		//make a output stream
		PrintWriter out=new PrintWriter(client.getOutputStream(),true);
		out.println("hello");
		
		System.out.print("Closing Connection");
		client.close();
		listener.close();
	}
}
