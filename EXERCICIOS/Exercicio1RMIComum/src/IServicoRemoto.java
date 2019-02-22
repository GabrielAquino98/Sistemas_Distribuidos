import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IServicoRemoto extends Remote{
	
	void inserirF(PessoaFisica p) throws RemoteException;
	void inserirJ(PessoaJuridica p) throws RemoteException;
	List<PessoaFisica> listarPessoaF() throws  RemoteException;
	List<PessoaJuridica> listarPessoaJ() throws  RemoteException;
	String imprimirF(PessoaFisica p) throws RemoteException;
	String imprimirJ(PessoaJuridica p) throws RemoteException;
	double gerarAumentoF(PessoaFisica p) throws RemoteException;
	double gerarAumentoJ(PessoaJuridica p) throws RemoteException;
}