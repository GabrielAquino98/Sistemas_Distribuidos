import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServicoRemotoImpl  extends UnicastRemoteObject implements IServicoRemoto{

	private static final long serialVersionUID = -4400683503221962602L;
	
	private static List<Pessoa> lstPessoa = new ArrayList<>();
	private static List<PessoaFisica> lstPessoaF = new ArrayList<>();
	private static List<PessoaJuridica> lstPessoaJ = new ArrayList<>();
	
	public ServicoRemotoImpl() throws RemoteException{
		
	}
	
	public void inserir(Pessoa p) throws RemoteException{
		lstPessoa.add(p);
	}
	
	public List<Pessoa> listarPessoa() throws RemoteException{
		return lstPessoa;
	}
	
	public void inserirF(PessoaFisica p) throws RemoteException{
		lstPessoaF.add(p);
	}
	
	public List<PessoaFisica> listarPessoaF() throws RemoteException{
		return lstPessoaF;
	}
	
	public void inserirJ(PessoaJuridica p) throws RemoteException{
		lstPessoaJ.add(p);
	}
	
	public List<PessoaJuridica> listarPessoaJ() throws RemoteException{
		return lstPessoaJ;
	}
	
	public double gerarAumentoF(PessoaFisica p)throws RemoteException{

		double salario = p.getSalario();
		int idade = p.getIdade();
		
			if(idade <=20) {
				salario = p.getSalario() * 1.1;
			}else if((idade > 20) & (idade <=30)) {
				salario = p.getSalario() * 1.15;
			}else {
				salario = p.getSalario() * 1.2;
			}
			
		return salario;
	}
	
	public double gerarAumentoJ(PessoaJuridica p)throws RemoteException{
		
		double salario = p.getSalario();
		
		if(p.getIdade() <=20) {
			salario = p.getSalario() * 1.1;
		}else if((p.getIdade() > 20) & (p.getIdade() <=30)) {
			salario = p.getSalario() * 1.15;
		}else {
			salario = p.getSalario() * 1.2;
		}
		
		
		return salario;
		

		
	}
	
	public String imprimirF(PessoaFisica p) throws RemoteException{
		String texto = ("ID: " + p.getId()
		+ " NOME: " + p.getNome()
		+" CPF: " + p.getCpf()
		+" TELEFONE: " + p.getTelefone()
		+" IDADE: " + p.getIdade()
		+" ENDERECO: " + p.getEndereco()
		+" CIDADE: " + p.getCidade()
		+" ESTADO: " + p.getEstado()
		+" SALARIO: " + p.getSalario()
		+" PAI: " + p.getPai()
		+" MAE: " + p.getMae());
		
		return texto;
		
	}
	
	public String imprimirJ(PessoaJuridica p) throws RemoteException{
		String texto = ("ID: " + p.getId()
		+ " NOME: " + p.getNome()
		+" CNPJ: " + p.getCnpj()
		+" TELEFONE: " + p.getTelefone()
		+" IDADE: " + p.getIdade()
		+" ENDERECO: " + p.getEndereco()
		+" CIDADE: " + p.getCidade()
		+" ESTADO: " + p.getEstado()
		+" SALARIO: " + p.getSalario()
		+" PAI: " + p.getPai()
		+" MAE: " + p.getMae());
		
		return texto;
	}

	

		
}
