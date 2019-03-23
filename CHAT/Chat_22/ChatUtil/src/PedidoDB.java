import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDB {
	private Connection connection;	
	private PreparedStatement ps;
	private ResultSet rs;

	public PedidoDB() {
		connection = Conexao.getConnection();
	}

	public boolean inserir(Pedido pedido) throws SQLException {

		try {

			PreparedStatement stmt = this.connection
					.prepareStatement("INSERT INTO TB_PEDIDO VALUES(?,?,?,?,?)");

			stmt.setInt(1, pedido.getNum_pedido());
			stmt.setString(2, pedido.getDescricao());
			stmt.setString(3, pedido.getDt_compra());
			stmt.setString(4, pedido.getEstado());
			stmt.setInt(5, pedido.getId_produto());

			stmt.execute();
			return true;

		} catch (SQLException e) {
			System.err.println(e.toString());
		} finally {

			connection.close();

		}
		return false;
	}
	
	public boolean alterar(Pedido pedido) throws SQLException {

		try {

			PreparedStatement stmt = this.connection
					.prepareStatement("UPDATE TB_pedido SET descricao = ?, dt_compra = ?, estado = ?, id_produto = ? WHERE num_pedido = ?");
			
			
			stmt.setString(1, pedido.getDescricao());
			stmt.setString(2, pedido.getDt_compra());
			stmt.setString(3, pedido.getEstado());
			stmt.setInt(4, pedido.getId_produto());
			stmt.setInt(5, pedido.getNum_pedido());
			
			stmt.execute();
			return true;

		} catch (SQLException e) {
			System.err.println(e.toString());
		} finally {

			connection.close();

		}
		return false;
	}
	
	public Pedido getPedido(int num_pedido) {
		
		
		try {
			ps = this.connection.prepareStatement("SELECT * FROM TB_PEDIDO WHERE NUM_PEDIDO = ?");
			ps.setInt(1, num_pedido);
			
			rs= ps.executeQuery();
			
			
			Pedido pedido = new Pedido(rs.getInt("num_pedido"), rs.getString("descricao"), rs.getString("dt_compra"),
			rs.getString("estado"), rs.getInt("id_produto"));
			
			return pedido;
			
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Pedido Não Encontrado!");
			return null;
		}
		
	}

	public List<Pedido> getAll() {

		List<Pedido> lstpedido = new ArrayList<>();
		try {
			ps = this.connection.prepareStatement("SELECT * FROM TB_pedido WHERE");
			rs = ps.executeQuery();
			

			while (rs.next()) {
				lstpedido.add(new Pedido(rs.getInt("num_pedido"), 
						rs.getString("descricao"),
						rs.getString("dt_compra"), 
						rs.getString("estado"), 
						rs.getInt("id_produto")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lstpedido;
	}
	
	public boolean excluir(int codigo) throws SQLException {

		try {

			PreparedStatement stmt = this.connection
					.prepareStatement("DELETE FROM TB_PEDIDO WHERE NUM_PEDIDO =?");

			stmt.setInt(1, codigo);

			stmt.execute();
			return true;

		} catch (SQLException e) {
			System.err.println(e.toString());
		} finally {

			connection.close();

		}
		return false;
	}

}

