package digitalscroll;
import java.io.Serializable;
public class CommunicationBean implements Serializable {

	private String command;
	private Object data;
	
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
	
}
