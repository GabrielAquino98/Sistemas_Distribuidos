import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDB {
	private Connection connection;	
	private PreparedStatement ps;
	private ResultSet rs;

	public ProdutoDB() {
		connection = Conexao.getConnection();
	}

	public boolean inserir(Produto produto) throws SQLException {

		try {

			PreparedStatement stmt = this.connection
					.prepareStatement("INSERT INTO TB_PRODUTO VALUES(?,?,?,?)");

			stmt.setInt(1, produto.getId());
			stmt.setString(2, produto.getDescricao());
			stmt.setDouble(3, produto.getValor());
			stmt.setString(4, produto.getTipo());

			stmt.execute();
			return true;

		} catch (SQLException e) {
			System.err.println(e.toString());
		} finally {

			connection.close();

		}
		return false;
	}
	
	public boolean alterar(Produto produto) throws SQLException {

		try {

			PreparedStatement stmt = this.connection
					.prepareStatement("UPDATE TB_PRODUTO SET descricao = ?, valor = ?, tipo = ? WHERE id = ?");
			
			stmt.setString(1, produto.getDescricao());
			stmt.setDouble(2, produto.getValor());
            stmt.setString(3, produto.getTipo());
            stmt.setInt(4, produto.getId());
            
			stmt.execute();
			return true;

		} catch (SQLException e) {
			System.err.println(e.toString());
		} finally {

			connection.close();

		}
		return false;
	}

	public List<Produto> getAll() {

		List<Produto> lstProduto = new ArrayList<>();
		try {
			ps = this.connection.prepareStatement("SELECT * FROM TB_PRODUTO");
			rs = ps.executeQuery();

			while (rs.next()) {
				lstProduto.add(new Produto(rs.getInt("id"), rs.getString("descricao"), rs.getDouble("valor"), rs.getString("tipo")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lstProduto;
	}
	
	public boolean excluir(int codigo) throws SQLException {

		try {

			PreparedStatement stmt = this.connection
					.prepareStatement("DELETE FROM TB_PRODUTO WHERE ID_PRODUTO =?");

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
