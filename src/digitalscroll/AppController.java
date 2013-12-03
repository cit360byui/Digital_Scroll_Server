package digitalscroll;
import java.util.HashMap;

public class AppController {
	private HashMap<String, IAction> ActionMap;
	
	public AppController() {
		
	}
	
	public void mapAction(String command, IAction action) {
		ActionMap.put(command, action);
	}
	
	public void handleRequest(String command, Object params) {
		ActionMap.get(command).execute(params);
	}
	
	public int getSize() {
		return ActionMap.size();
	}
}
