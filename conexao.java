package interno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
	private String caminho = "jdbc:mysql://localhost:3306/cursoja"; 
	private String usuario = "root"; 
	private String senha = "11111111"; 
	private Connection c = null;

	public Connection getconexao(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			c = DriverManager.getConnection(caminho, usuario, senha);
			System.out.println("conectado");
		} 
		catch(ClassNotFoundException e){
			System.out.println("erro no drive");
			e.printStackTrace();
		} 
		catch(SQLException e){
			System.out.println("erro no banco de dados");
			e.printStackTrace();
		}
		return c;
	}

	public void fecharconexao(){
		try{
			c.close();
			System.out.println("encerrado");
		} 
		catch(SQLException e){
			System.out.println("erro");
			e.printStackTrace();
			
		}
	}
}
