import java.sql.Date;

public class Pedido {
	private int num_pedido;
	private String descricao;
	private String dt_compra;
	private String estado;
	private int id_produto;
	
	public Pedido(int num_pedido, String descricao, String dt_compra, String estado, int id_produto) {
		super();
		this.num_pedido = num_pedido;
		this.descricao = descricao;
		this.dt_compra = dt_compra;
		this.estado = estado;
		this.id_produto = id_produto;
	}

	public Pedido() {
		super();
	}

	public int getNum_pedido() {
		return num_pedido;
	}

	public void setNum_pedido(int num_pedido) {
		this.num_pedido = num_pedido;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDt_compra() {
		return dt_compra;
	}

	public void setDt_compra(String dt_compra) {
		this.dt_compra = dt_compra;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}
	
	

}
