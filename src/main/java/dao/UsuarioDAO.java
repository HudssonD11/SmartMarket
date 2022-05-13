package dao;

import model.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAO extends DAO {	
	public UsuarioDAO() {
		super();
		conectar();
	}
	
	
	public void finalize() {
		close();
	}
	
	
	public boolean insert(Usuario usuario) {
		boolean status = false;
		try {
			String sql = "INSERT INTO sm.usuario (CPF, nome, login, senha, email, creditos, tipo) "
		               + "VALUES ('"+usuario.getCPF()+"', '" + usuario.getNome() + "', '"
		               + usuario.getLogin() + "', '" + usuario.getSenha() +"', '"+usuario.getEmail()+"', ?, '"+ usuario.getTipo() +"');";
			PreparedStatement st = conexao.prepareStatement(sql);
		    st.setInt(1, usuario.getCreditos());
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	
	public Usuario get(String CPF, int auxiliar) {
		Usuario user = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM sm.usuario WHERE CPF='"+CPF+"'";
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	user = new Usuario(rs.getString("CPF"), rs.getString("nome"), rs.getString("login"), rs.getString("senha"), rs.getString("email"), rs.getInt("creditos"), rs.getString("tipo").charAt(0));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return user;
	}

	public Usuario getByLogin(String username, String senha) {
		Usuario user = null;
		senha = user.encryptPassword(senha);
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM sm.usuario WHERE login='"+username+"' AND senha='"+senha+"'";

			ResultSet rs = st.executeQuery(sql);
	        if(rs.next()){            
	        	user = new Usuario(rs.getString("CPF"), rs.getString("nome"), rs.getString("login"), rs.getString("senha"), rs.getString("email"), rs.getInt("creditos"), rs.getString("tipo").charAt(0));
	        }
			else{

			}
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return user;
	}

	
	public List<Usuario> get() {
		return get("");
	}

	
	public List<Usuario> getOrderByCPF() {
		return get("CPF");		
	}
	
	
	public List<Usuario> getOrderByNome() {
		return get("nome");		
	}

    public List<Usuario> getOrderByLogin() {
		return get("login");		
	}
	
	
	public List<Usuario> getOrderByCreditos() {
		return get("creditos");		
	}
	
	
	private List<Usuario> get(String orderBy) {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM sm.usuario" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Usuario p = new Usuario(rs.getString("CPF"), rs.getString("nome"), rs.getString("login"), rs.getString("senha"), rs.getString("email"), rs.getInt("creditos"), rs.getString("tipo").charAt(0));
	            usuarios.add(p);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return usuarios;
	}
	
	
	public boolean update(Usuario usuario) {
		boolean status = false;
		try {  
			String sql = "UPDATE sm.usuario SET nome = '"+usuario.getNome() + "', email = '"+usuario.getEmail()
            +"', login = '"+usuario.getLogin()+"', senha = '"+usuario.getSenha()
            +"', creditos = "+usuario.getCreditos()+" tipo = '"+usuario.getTipo()+"',  WHERE CPF = '" + usuario.getCPF()+"'";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	public boolean updateUser(Usuario usuario, String login) {
		boolean status = false;
		System.out.println(usuario.getSenha());
		try {  
			String sql = "UPDATE sm.usuario SET nome = '"+ usuario.getNome() + "', email = '"+usuario.getEmail()
            +"', login = '"+ login +"', senha = '"+usuario.getSenha()
            +"', creditos = "+usuario.getCreditos()+", tipo = '"+usuario.getTipo()+"' WHERE CPF = '" + usuario.getCPF()+"'";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		System.out.println(status);
		return status;
	}

	public boolean updateSenha(Usuario usuario, String senha) {
		senha = usuario.encryptPassword(senha);
		boolean status = false;
		try {  
			String sql = "UPDATE sm.usuario SET nome = '"+ usuario.getNome() + "', email = '"+usuario.getEmail()
            +"', login = '"+ usuario.getLogin() +"', senha = '"+ senha
            +"', creditos = "+usuario.getCreditos()+", tipo = '"+usuario.getTipo()+"' WHERE CPF = '" + usuario.getCPF()+"'";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		System.out.println(status);
		return status;
	}
	
	
	public boolean delete(String id) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM sm.usuario WHERE CPF = '" + id+"'");
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
}