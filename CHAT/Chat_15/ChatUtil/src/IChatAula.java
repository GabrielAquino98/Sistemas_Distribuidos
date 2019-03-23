import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IChatAula extends Remote {

	
	
	void sendMessage(Message msg) throws RemoteException;
	List<Message> retrieveMessage() throws RemoteException;
		
	

}
