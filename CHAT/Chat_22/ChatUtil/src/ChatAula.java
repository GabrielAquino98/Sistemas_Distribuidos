import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ChatAula extends UnicastRemoteObject implements IChatAula {

	public ChatAula() throws RemoteException{
		super();
	}
	
	private static final long serialVersionUID = 7004671466388954207L;

	public void pesquisaPedido(int num_pedido) throws RemoteException {
		PedidoDB pdb = new PedidoDB();
		
		Pedido p = new  Pedido();
		p = pdb.getPedido(num_pedido);

		Message msg = new Message();
		
		msg.setMessage("O Status do Pedido é: "+ p.getEstado());
		
		sendMessage(msg);
		
	}

	
	@Override
	public void sendMessage(Message msg) throws RemoteException {
		Message.setLstMessage(msg);
		
	}
	
	

	@Override
	public List<Message> retrieveMessage() throws RemoteException {
		
		return Message.getLstMessage();
	}
	
	

}
