package pandey.application.chat.connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	//defining port number
	private static final int port=9090;
	//declare an arraylist
	private static ArrayList<ClientHandler> clients=new ArrayList<>();
	//make a pool of max 10 people to execute at one time in a thread
	private static ExecutorService pool = Executors.newFixedThreadPool(10);
	
	public static void main(String args[]) throws IOException {
		try (//start the server
		ServerSocket listener = new ServerSocket(port)) {
			while(true) {
				System.out.println("Waiting for connection");
				Socket client=listener.accept(); 
				System.out.println("Connected");
				ClientHandler clientthread=new ClientHandler(client);
				clients.add(clientthread);
				//exceute the clienthandler
				pool.execute(clientthread);
			}
		}
	}
}
