package br.com.viagem.gerenciador.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Entity
@Component
@Table(name="viagem")
public class Viagem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4620206769521662330L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "local_de", nullable = false)
	private Local localDe;

	@Column(name = "local_para", nullable = false)
	private Local localPara;
	
	@JsonSerialize(using = DateSerializer.class)
	@Column(name = "data_saida", nullable = false)
	private Date dt_saida;
	
	@JsonSerialize(using = DateSerializer.class)
	@Column(name = "data_volta", nullable = false)
	private Date dt_volta;

	
	public Viagem() {
		
	}


	public Viagem(int id, Local localDe, Local localPara, Date dt_saida, Date dt_volta) {
		super();
		this.id = id;
		this.localDe = localDe;
		this.localPara = localPara;
		this.dt_saida = dt_saida;
		this.dt_volta = dt_volta;
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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public Date getDt_saida() {
		return dt_saida;
	}
	
	public void setDt_saida(Date dt_saida) {
		this.dt_saida = dt_saida;
	}


	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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
