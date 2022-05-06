package dao;

import model.Produto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDAO extends DAO {	
	public ProdutoDAO() {
		super();
		conectar();
	}
	
	
	public void finalize() {
		close();
	}
	
	
	public boolean insert(Produto produto) {
		boolean status = false;
		try {
			String sql = "INSERT INTO sm.produto (id, nome, descricao, categoria, marca, unidade, imagem) "
		               + "VALUES ("+produto.getId()+", '" + produto.getNome() +"', '"+produto.getDescricao() + "', '"
		               + produto.getCategoria() + "', '" + produto.getMarca() + ", '"+produto.getUnidade()+", '"+produto.getImagem()+"');";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	
	public Produto get(int id) {
		Produto produto = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM sm.produto WHERE id="+id;
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	 produto = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"), rs.getString("categoria"), rs.getString("marca"), rs.getString("unidade"), rs.getString("imagem"));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return produto;
	}
	
	public List<Produto> get() {
		return get("");
	}
	
	public List<Produto> getOrderByID() {
		return get("id");		
	}
	
	public List<Produto> getOrderByDescricao() {
		return get("descricao");		
	}
	
	public List<Produto> getOrderByNome() {
		return get("nome");		
	}
	
	public List<Produto> getOrderByCategoria() {
		return get("categoria");		
	}
	
	public List<Produto> getOrderByMarca() {
		return get("marca");		
	}
	
	
	private List<Produto> get(String orderBy) {
		List<Produto> produtos = new ArrayList<Produto>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM sm.produto" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Produto p = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"), rs.getString("categoria"), rs.getString("marca"), rs.getString("unidade"), rs.getString("imagem"));
	            produtos.add(p);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return produtos;
	}
	
	public List<Produto> getByEstab(int idEstab) {
		return getByEstab(idEstab, "");
	}
	
	public List<Produto> getByEstabOrderByID(int idEstab) {
		return getByEstab(idEstab, "id");		
	}
	
	public List<Produto> getByEstabOrderByDescricao(int idEstab) {
		return getByEstab(idEstab, "descricao");		
	}
	
	public List<Produto> getByEstabOrderByNome(int idEstab) {
		return getByEstab(idEstab, "nome");		
	}
	
	public List<Produto> getByEstabOrderByCategoria(int idEstab) {
		return getByEstab(idEstab, "categoria");		
	}
	
	public List<Produto> getByEstabOrderByMarca(int idEstab) {
		return getByEstab(idEstab, "marca");		
	}
	
	
	private List<Produto> getByEstab(int idEstab, String orderBy) {
		List<Produto> produtos = new ArrayList<Produto>();
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
//			String sql = SELECT * FROM produto" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
            String sql = "SELECT sm.produto.id, sm.produto.nome, sm.produto.descricao, sm.produto.categoria, sm.produto.marca, sm.produto.unidade, sm.produto.imagem, sm.comercializa.preco, sm.estabelecimento.nome as supermercado FROM (SELECT * FROM sm.comercializa WHERE sm.comercializa.estabelecimento = "+idEstab+") AS A JOIN sm.produto ON A.produto = sm.produto.id" /*+  ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));*/;
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Produto p = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"), rs.getString("categoria"), rs.getString("marca"), rs.getString("unidade"), rs.getString("imagem"));
	        	p.setPreco(rs.getString("preco"));
				p.setSupermercado(rs.getString("supermercado"));
	            produtos.add(p);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return produtos;
	}

	
	public boolean update(Produto produto) {
		boolean status = false;
		try {  
			String sql = "UPDATE sm.produto SET nome = '"+produto.getNome()+"', descricao = '" + produto.getDescricao() + "', "
					   + "categoria = '" + produto.getCategoria() + "'', " 
					   + "marca = '" + produto.getMarca() + "', "
					   + "unidade = '" + produto.getUnidade() + "', "
					   + "imagem = '" + produto.getImagem() + "'";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public boolean delete(int id) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM sm.produto WHERE id = " + id);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	public int getLastId() {
		int lastId = -1;
		 try {
			 Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			 String sql = "SELECT MAX(id) FROM sm.produto;";
			 ResultSet rs = st.executeQuery(sql);
			 if(rs.next()){   
				 lastId = rs.getInt("MAX");
			 }
			 st.close();
		 } catch (Exception e) {
			 System.err.println(e.getMessage());
		 }
		 return lastId;
	 }
}