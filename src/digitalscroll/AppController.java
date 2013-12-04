package digitalscroll;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppController {
	private HashMap<String, IAction> actions;
	private ExecutorService executor;
	public AppController() {
		actions = new HashMap<String, IAction>();
		executor = Executors.newCachedThreadPool();
	}
	
	public void mapAction(String command, Class<?> actionClass) {
		try {
			actions.put(command, (IAction)actionClass.newInstance());
		}
		catch (Exception ex) {
			System.out.println("Could not create new object of type: " + actionClass.getCanonicalName() + "\n" + ex.toString());
		}
		
	}
	
	public void handleRequest(final String command, final Object params, boolean async) {
		if (async) {
			executor.execute(new Runnable() {

				@Override
				public void run() {
					actions.get(command).execute(params);
				}
				
			});
		}
		else {
			actions.get(command).execute(params);
		}
		actions.get(command).execute(params);
	}
	
	public int getSize() {
		return actions.size();
	}
}
