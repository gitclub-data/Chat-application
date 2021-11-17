package pandey.application.chat.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		BufferedReader inp=new BufferedReader(new InputStreamReader(client.getInputStream()));
		BufferedReader keyinp=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(client.getOutputStream(),true);
		
		while(true) {
			String clientsays=inp.readLine();
			System.out.println("Client Says: "+clientsays);
			System.out.print(">>");
			String cmd=keyinp.readLine();
			if(cmd=="quit") break;
			out.println(cmd);
		}
		
		System.out.print("Closing Connection");
		client.close();
		listener.close();
	}
}
