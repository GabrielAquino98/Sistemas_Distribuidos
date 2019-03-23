import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDB {
	private Connection connection;	
	private PreparedStatement ps;
	private ResultSet rs;

	public MessageDB() {
		connection = Conexao.getConnection();
	}

	public boolean inserir(Message message) throws SQLException {

		try {

			PreparedStatement stmt = this.connection
					.prepareStatement("INSERT INTO TB_CONVERSA(MENSAGEM, DT_HR, USUARIO) VALUES(?, now(), ?)");

			stmt.setString(1, message.getMessage());
			stmt.setString(2, message.getUsuario());
			

			stmt.execute();
			return true;

		} catch (SQLException e) {
			System.err.println(e.toString());
		} finally {

			connection.close();

		}
		return false;
	}
	
	
	public Message getMessage(int id) {
		
		
		try {
			ps = this.connection.prepareStatement("SELECT Mensagem FROM TB_CONVERSA WHERE id = ?");
			ps.setInt(1, id);
			
			rs= ps.executeQuery();
			
			
			Message message = new Message(rs.getInt("id"), rs.getString("mensagem"), rs.getString("dt_hr"),
			rs.getString("usuario"));
			
			return message;
			
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Message Não Encontrado!");
			return null;
		}
		
	}

	public List<Message> getAll() {

		List<Message> lstMessage = new ArrayList<>();
		try {
			ps = this.connection.prepareStatement("SELECT ID, MENSAGEM, date_format(DT_HR,'%d/%m/%y %Hh%i') AS DT_HR, USUARIO FROM TB_CONVERSA ORDER BY DT_HR;");
			rs = ps.executeQuery();
			

			while (rs.next()) {
				lstMessage.add(new Message(rs.getInt("id"), 
						rs.getString("mensagem"),
						rs.getString("dt_hr"), 
						rs.getString("usuario")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lstMessage;
	}
	
	

}

