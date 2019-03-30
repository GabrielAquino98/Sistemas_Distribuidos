package br.com.rest.teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

//http://localhost:8082/RestExemplo1/rest/helloworld/show=teste

@Path("/helloworld")
public class HelloWorldResource {

	@GET
	@Path("show={param}")
	public String show(@PathParam("param") String msg) throws IOException {
		String out = "Resultado = " + msg;
		escritor(out);
		return out;
	}
	
	@GET
	@Path("soma/{param1}/{param2}")
	public String somar(@PathParam("param1") int a, @PathParam("param2") int b) throws IOException {
		String out = String.valueOf(a+b);
		escritor(out);
		return out;
	}
	
	@GET
	@Path("informacoes/{nome}/{idade}/{linguagem}")
	public String informacoes(@PathParam("nome") String nome
					        , @PathParam("idade") String idade
					        , @PathParam("linguagem") String linguagem) throws IOException {
		String out = "Eu "+ nome+ ", trabalho e estudo, tenho "+idade+" anos, e adoro programar em "+ linguagem;
		escritor(out);
		return out;
	}
	
	@GET
	@Path("imc/{altura}/{peso}")
	public String informacoes(@PathParam("altura") double altura
					        , @PathParam("peso") double peso) throws IOException {
		double imc = peso/(altura*altura);
		String situacao = "";
		
		/*Abaixo de 17	Muito abaixo do peso
		Entre 17 e 18,49	Abaixo do peso
		Entre 18,5 e 24,99	Peso normal
		Entre 25 e 29,99	Acima do peso
		Entre 30 e 34,99	Obesidade I
		Entre 35 e 39,99	Obesidade II (severa)
		Acima de 40	Obesidade III (mórbida)*/
		
		if(imc <= 17)
			situacao = "Muito abaixo do peso";
		else if(imc > 17 && imc <= 18.49) 
			situacao = "Abaixo do peso";
		else if(imc > 18.49 && imc <=24.99)
			situacao = "Peso normal";
		else if(imc >25 && imc < 29.99)
			situacao = "Acima do peso";
		else
			situacao = "Obeso";
		
		String out = "Eu tenho "+ altura + " de altura e tenho "+peso+ " Eu estou "+situacao;
		
		escritor(out);
		return out;
	}
	
	public static void escritor(String log) throws IOException {
		 BufferedReader buffRead = new BufferedReader(new FileReader("C:/Users/user-10/Documents/log_rest.txt"));
	        String linha = "";
	        String texto = "";
	        while (buffRead.readLine() != null) {
	            if (linha != null) {
	                System.out.println(linha);
	                linha = buffRead.readLine();
	                texto = texto + buffRead.readLine();
	            } else
	                break;
	            
	        }
	        buffRead.close();
		
		
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter("C:/Users/user-10/Documents/log_rest.txt"));
        texto = texto + log;
        buffWrite.append(linha + "\n");
        buffWrite.close();
    }
	
}



