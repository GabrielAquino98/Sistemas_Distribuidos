import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Message implements Serializable{
	

	private static final long serialVersionUID = -4342333769266357134L;
	
	private int id;
	private String dt_hr;
	private String user;
	private String message;
	private static List<Message> lstMessage = new ArrayList<Message>();
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDt_hr() {
		return dt_hr;
	}

	public void setDt_hr(String dt_hr) {
		this.dt_hr = dt_hr;
	}

	
	
	

	public Message() {
		super();
	}

	public Message(int id, String dt_hr, String user, String message) {
		super();
		this.id = id;
		this.dt_hr = dt_hr;
		this.user = user;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsuario() {
		return user;
	}

	public void setUsuario(String user) {
		this.user = user;
	}

	public static List<Message> getLstMessage() {
		return lstMessage;
	}

	public static void setLstMessage(Message msg) {
		lstMessage.add(msg);
	}
	
	

}
