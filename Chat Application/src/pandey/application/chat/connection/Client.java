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
		ServerHandler serverhndle=new ServerHandler(socket);
		
		BufferedReader keyinp=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader keyid=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
		
		new Thread(serverhndle).start();
		
		while(true) {
			System.out.println("Input the id");
			String identity=keyid.readLine();
			System.out.print(">>");
			String cmd=keyinp.readLine();
			if(cmd=="quit") break;
			out.println(identity+"c@d!"+cmd);
		}	
		System.out.print("Closing Connection");
		//closing the connection
		socket.close();		
	}
}
