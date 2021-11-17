package pandey.application.chat.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	//defining port number and ip address
	private static final int port=9090;
	private static final String ip_address="127.0.0.1";
	public static void main(String args[]) throws UnknownHostException, IOException {
		
		// set connection to server
		Socket socket= new Socket(ip_address,port);
		
		// make a input streamreader to get input from skocket
		BufferedReader inp=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		BufferedReader keyinp=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
		
		while(true) {
			System.out.print(">>");
			String cmd=keyinp.readLine();
			if(cmd=="quit") break;
			
			out.println(cmd);
			
			String serverResponse=inp.readLine();
			System.out.println("Server says:"+serverResponse);
		}	
		System.out.print("Closing Connection");
		//closing the connection
		inp.close();
		socket.close();		
	}
}
