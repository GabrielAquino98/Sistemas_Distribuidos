import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class Principal {

	public static void main(String[] args) {

		try {
			IServicoRemoto objPessoa = (IServicoRemoto) Naming.lookup("rmi://localhost:8282/pessoa");
			
			PessoaFisica p1 =new PessoaFisica();
			
			p1.setId(1);
			p1.setNome("Chico");
			p1.setCpf(466);
			p1.setEstado("SP");
			p1.setEndereco("Rua chiquinho");
			p1.setSalario(2400.0);
			p1.setTelefone("(16)9999-8888");
			p1.setIdade(18);
			p1.setMae("Francisca");
			p1.setPai("Francisco");
			p1.setCidade("Franciscolandia");
			
			
			
			PessoaJuridica p2 = new  PessoaJuridica();
			
			p2.setId(2);
			p2.setNome("Chicao");
			p2.setCnpj(664);
			p2.setEstado("SP");
			p2.setEndereco("Rua palmirinha");
			p2.setSalario(5700.0);
			p2.setTelefone("(16)1234-9865");
			p2.setIdade(31);
			p2.setMae("Clara");
			p2.setPai("Romeu");
			p2.setCidade("Panlapolandia");
			
			PessoaFisica p3 = new  PessoaFisica();
			
			p3.setId(2);
			p3.setNome("Florisvaldo");
			p3.setCpf(664);
			p3.setEstado("RO");
			p3.setEndereco("Rua largatixa");
			p3.setSalario(1900.0);
			p3.setTelefone("(87)4398-0876");
			p3.setIdade(21);
			p3.setMae("Lima");
			p3.setPai("Limao");
			p3.setCidade("Qualquer");
			
			objPessoa.inserirF(p1);
			objPessoa.inserirJ(p2);
			objPessoa.inserirF(p3);
			
			
			
			
			for(PessoaFisica pessoa : objPessoa.listarPessoaF()) {
				System.out.println("Pessoa antes do aumento: ");
				System.out.println(objPessoa.imprimirF(pessoa));
				pessoa.setSalario(objPessoa.gerarAumentoF(pessoa));
				System.out.println("Pessoa depois do aumento: ");
				System.out.println(objPessoa.imprimirF(pessoa));
			}
			

			for(PessoaJuridica pessoa : objPessoa.listarPessoaJ()) {
				System.out.println("Pessoa antes do aumento: ");
				System.out.println(objPessoa.imprimirJ(pessoa));
				pessoa.setSalario(objPessoa.gerarAumentoJ(pessoa));
				System.out.println("Pessoa depois do aumento: ");
				System.out.println(objPessoa.imprimirJ(pessoa));
			}
			
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}catch(RemoteException e) {
			e.printStackTrace();
		}catch(NotBoundException e) {
			e.printStackTrace();
		}

	}
	
	public PessoaFisica inserirPessoaFisica(PessoaFisica p) {
		
		return p; 
	}

}
