package br.com.viagem.gerenciador.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.viagem.gerenciador.entidades.Local;

public class ViagemDto implements Serializable{
	
	private int id;
	
	private Local localDe;
	
	private Local localPara;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")	
	private Date dt_saida;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dt_volta;
	
	
	public ViagemDto() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Local getLocalDe() {
		return localDe;
	}


	public void setLocalDe(Local localDe) {
		this.localDe = localDe;
	}


	public Local getLocalPara() {
		return localPara;
	}


	public void setLocalPara(Local localPara) {
		this.localPara = localPara;
	}


	@NotNull(message = "Data da Saida é uma informação obrigatória")
	public Date getDt_saida() {
		return dt_saida;
	}


	public void setDt_saida(Date dt_saida) {
		this.dt_saida = dt_saida;
	}


	public Date getDt_volta() {
		return dt_volta;
	}


	public void setDt_volta(Date dt_volta) {
		this.dt_volta = dt_volta;
	}
	
	
	@Override
	public String toString() {
		return "Viagem[id: "+id+", localDe:"+localDe+", localPara:"+ localPara+", dataSaida:"+dt_saida+""
				+", dataRetorno: " +dt_volta+"]";
	}
}
