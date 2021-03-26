package maven.demo;

import java.sql.*;

public class DAO {
	private Connection conexao;
	
	public DAO() {
		conexao = null;
	}
	
	public boolean conectar() {
		String driverName = "org.postgresql.Driver";
		String serverName = "localhost";
		String mydatabase = "ti2cc";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta + "/" + mydatabase;
		String username = "ti2cc";
		String password = "ti@cc";
		boolean status = false;
		
		try {
			Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conexão efetuada com o postgres!");
		} catch (ClassNotFoundException e) {
			System.err.println("Conexão NÃO efetuada com o postgres -- Driver não encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexão NÃO efetuada com o postgres -- " + e.getMessage());
		}
		
		return status;	
	}
	
	public boolean close() {
		boolean status = false;
		try {
			conexao.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return status;
	}
	
	public boolean inserirCientista(Cientista cientista) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO cientista (codigo, nome, area, contribuicao, nacionalidade)"
					+ " VALUES (" + cientista.getCodigo() + ", " + "'" + cientista.getNome()+ "'"  + ", " 
					+ "'" + cientista.getArea()+ "'"  + ", " + "'"  + cientista.getContribuicao()+ "'" 
					+ ", "+ "'"  + cientista.getNacionalidade() + "'" + ");";
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return status;
	}
	
	public boolean excluirCientista(int codigo) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM cientista WHERE codigo = " + codigo);
			st.close();
			status = true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return status;
	}
	
	public Cientista[] getCientistas() {
		Cientista[] cientistas = null;
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);;
			ResultSet rs = st.executeQuery("SELECT * FROM cientista");
			if (rs.next()) {
				rs.last(); 
				cientistas = new Cientista[rs.getRow()];
				rs.beforeFirst();
				
				for (int i = 0; rs.next(); i++) {
					cientistas[i] = new Cientista(
						rs.getInt("codigo"),
						rs.getString("nome"),
						rs.getString("area"),
						rs.getString("contribuicao"),
						rs.getString("nacionalidade")
					);			
				}
			}
			st.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return cientistas;
	}
	
	
	public boolean atualizarCientista(int codigo, String coluna, String valor) {
		boolean status = false;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);;
			st.executeUpdate("UPDATE cientista SET " + coluna + " = '" + valor + "' WHERE codigo = " + codigo);
			status = true;
			st.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return status;
	}
	
}












