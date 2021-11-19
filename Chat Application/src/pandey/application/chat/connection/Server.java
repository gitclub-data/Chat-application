package pandey.application.chat.connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	//defining port number
	private static final int port=9090;
	
	private static Map<ClientHandler,String> object_and_id = new HashMap<ClientHandler,String>();
	private static Map<String, ClientHandler> id_and_object = new HashMap<String, ClientHandler>();
	//make a pool of max 10 people to execute at one time in a thread
	private static ExecutorService pool = Executors.newFixedThreadPool(10);
	
	public static void main(String args[]) throws IOException {
		try (//start the server
		ServerSocket listener = new ServerSocket(port)) {
			while(true) {
				System.out.println("Waiting for connection");
				Socket client=listener.accept(); 
				System.out.println("Connected");
				PrintWriter out=new PrintWriter(client.getOutputStream(),true);
				//generate id
				String rnd;
				while(true) {
					rnd = Integer.toString(10000 + new Random().nextInt(90000));
					if(!id_and_object.containsKey(rnd)) break;
				}
				ClientHandler clientthread=new ClientHandler(client,(HashMap<String, ClientHandler>) id_and_object,(HashMap<ClientHandler,String>) object_and_id);
				out.println("Your Identity is:"+rnd);                        
				//id_and_object.put(clientthread.id_and_cmd[0],clientthread);store genrated id and object here
				id_and_object.put(rnd,clientthread);
				object_and_id.put(clientthread, rnd);
				System.out.println(id_and_object);
				//exceute the clienthandler
				pool.execute(clientthread);
				//set the id of the person
				
			}
		}
	}
}
