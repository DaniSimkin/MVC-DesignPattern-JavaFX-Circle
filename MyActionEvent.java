
import javafx.event.Event;

public class MyActionEvent extends Event {
	private static final long serialVersionUID = 1L;
	private String msg;

	/** Constructor */
	public MyActionEvent(Object source, String msg) {
		super(source, null, null);
		this.msg = msg;
	}

	/** Gets the message */
	public String getMsg() {
		return msg;
	}

}
