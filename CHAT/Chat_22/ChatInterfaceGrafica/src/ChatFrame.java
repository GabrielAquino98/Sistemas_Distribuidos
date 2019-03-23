import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream.GetField;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ChatFrame {

	private JFrame frame;
	private JTextField txtMensagem;
	private static JTextArea txtConversa;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatFrame window = new ChatFrame();
					window.frame.setVisible(true);
					preencheConversa();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChatFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtMensagem = new JTextField();
		txtMensagem.setBounds(10, 190, 301, 60);
		frame.getContentPane().add(txtMensagem);
		txtMensagem.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MessageDB mdb = new MessageDB();
				
				Message msg = new Message();
				
				msg.setUsuario("Usuario");
				msg.setMessage(txtMensagem.getText());
				
				try {
					mdb.inserir(msg);
					txtMensagem.setText("");
					limparConversa();
					preencheConversa();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					e.printStackTrace();
				}
				
			}
		});
		btnEnviar.setBounds(321, 190, 103, 60);
		frame.getContentPane().add(btnEnviar);
		
		
		
		JTextArea txtConversa = new JTextArea();
		txtConversa.setBounds(10, 11, 414, 168);
		frame.getContentPane().add(txtConversa);
	}
	
	
	public static void preencheConversa() {
		
		String text = "";
		
		List<Message> lstMsg = new ArrayList<Message>();
		
		MessageDB mdb = new MessageDB();
		
		lstMsg = mdb.getAll();
		
		for (Message msg : lstMsg) {
			text +=  msg.getUsuario() + " " + msg.getDt_hr() + ": "+ msg.getMessage()+"\n";
			
		}
		System.out.print(text);
		txtConversa.setText(text);
		
		
	}
	
	public static void limparConversa() {
		txtConversa.setText("");
	}
}
