package interno;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import externo.professor;

public class crud extends conexao{
	
public void cadastrar(professor x) {
		
		String sql = "insert into professor " +
					 " (valorhora, nome, telefone, materia) values "
					 + "(?, ?, ?, ?)";
		try{
			PreparedStatement ps = getconexao().prepareStatement(sql);
			ps.setDouble(1,x.getvalorhora());
			ps.setString(2,x.getnome());
			ps.setString(3,x.gettelefone());
			ps.setString(4,x.getmateria());
			ps.execute();
		} 
		catch(SQLException e){
			System.out.println("erro");
			e.printStackTrace();
		} 
		finally{
			fecharconexao();
		}
	}
public void alterar(professor x) {
	String sql = "update professor set" +
			     " valorhora = ?" +
				 " nome = ?," +
				 " telefone = ?" +
				 " materia = ?" +
				 " where idprofessor = ?";
		try {
		PreparedStatement ps = getconexao().prepareStatement(sql);
		ps.setDouble(1,x.getvalorhora());
		ps.setString(2,x.getnome());
		ps.setString(3,x.gettelefone());
		ps.setString(4,x.getmateria());
		ps.setLong(5,x.getid());
		ps.execute();
	} 
		catch(SQLException e) {
		System.out.println("erro");
		e.printStackTrace();
	} 
		finally {
		fecharconexao();
	}
}
public ArrayList<professor> listar(String busca){
	ArrayList<professor> lista = new ArrayList<professor>();
	
	String sql = "select * from professor " +
				 "where nome like ?";
					
	try {
		PreparedStatement ps = getconexao().prepareStatement(sql);
		ps.setString(1,"%" + busca + "%");
		
		ResultSet rs = ps.executeQuery();
		professor x;
		while (rs.next()) {
			x = new professor();
			x.setvalorhora(rs.getDouble("valorhora"));
			x.setnome(rs.getString("nome"));
			x.settelefone(rs.getString("telefone"));
			x.setmateria(rs.getString("materia"));
			x.setid(rs.getLong("idcurso"));
			lista.add(x);
		}
		
	} 
	catch(SQLException e) { 
		System.out.println("Erro no Listar");
		e.printStackTrace();
	} 
	finally {
		fecharconexao();
	}
	return lista;
}
public professor buscar(long id) {
	professor professor = null;
	
	String sql = "select * from professor " +
			 "where idprofessor = ?";
	
	try {
		PreparedStatement ps = getconexao().prepareStatement(sql);
		ps.setLong(1,id);

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			professor = new professor();
			professor.setvalorhora(rs.getDouble("valorhora"));
			professor.setnome(rs.getString("nome"));
			professor.settelefone(rs.getString("telefone"));
			professor.setmateria(rs.getString("materia"));
			professor.setid(rs.getLong("idprofessor"));
		}
		
	} 
	catch(SQLException e) { 
		System.out.println("Erro no Listar");
		e.printStackTrace();
	} 
	finally {
		fecharconexao();
	}
	return professor;
}	
}
