package digitalscroll;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import org.quickconnect.json.JSONException;
import org.quickconnect.json.JSONInputStream;
import org.quickconnect.json.JSONOutputStream;

public class StartServerAction implements IAction {

	@Override
	public void execute(final Object data) {
		//HashMap<String, Object> params = (HashMap)data;
		//final int port = (int)params.get("port");
		//final ServerSocket server = (ServerSocket)params.get("server");
		while (true) {
			try {
				Socket fromClient = ScrollServer.serverSocket.accept();
				JSONInputStream jin = new JSONInputStream(fromClient.getInputStream());
				JSONOutputStream jout = new JSONOutputStream(fromClient.getOutputStream());
				CommunicationBean com = (CommunicationBean) jin.readObject();
				jin.close();
				
				HashMap<String, Object> params = new HashMap<String, Object>();
				params.put("out", jout);
				params.put("data", com.getData());
				ScrollServer.app.handleRequest(com.getCommand(), params, true);
			}
			catch (IOException e) {
				//e.printStackTrace();
				break;
			} 
			catch (JSONException e) {
				//e.printStackTrace();
				break;
			}
		}
	}
}
