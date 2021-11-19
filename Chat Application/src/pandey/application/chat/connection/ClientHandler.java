package pandey.application.chat.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

public class ClientHandler implements Runnable{
	private Socket client;
	private BufferedReader in;
	private PrintWriter out;
	private String[] id_and_cmd;
	private Map<String, ClientHandler> id_obj;
	private Map<ClientHandler, String> obj_id;
	public ClientHandler(Socket clientsocket,Map<String, ClientHandler> id_and_object, Map<ClientHandler, String> object_and_id) throws IOException {
		client=clientsocket;
		this.id_obj=id_and_object;
		this.obj_id=object_and_id;
		in=new BufferedReader(new InputStreamReader(client.getInputStream()));
		out=new PrintWriter(client.getOutputStream(),true);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {// null pointer exception should solve in graphical mode
				String clientsays=in.readLine();
				id_and_cmd = clientsays.split("c@d!",2);
				id_obj.get(id_and_cmd[0]).out.println(obj_id.get(this)+" : "+id_and_cmd[1]);
				System.out.print(">>");
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			out.close();
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
