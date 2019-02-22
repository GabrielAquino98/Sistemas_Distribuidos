import java.rmi.RemoteException;

public class PessoaJuridica extends Pessoa {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1807032074389254158L;
	private int cnpj;
	
	public PessoaJuridica() throws RemoteException{
		super();
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
