package dao;

import model.Estabelecimento;
import model.Usuario;
import spark.Request;
import spark.Response;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class EstabelecimentoDAO extends DAO
{
    
    public EstabelecimentoDAO() 
    {
        super();
        conectar();
    }
        
        
    public void finalize() {
        close();
    }
    
    
    public boolean insert(Estabelecimento estab) {
        boolean status = false;
        try {
            String sql = "INSERT INTO \"sm\".\"estabelecimento\" (id, nome, estado, cidade, bairro, rua, logo, numero) "
                        + "VALUES (" + estab.getId() + ", '"
                        + estab.getNome() + "', '" + estab.getEstado() + "', '"+estab.getCidade()+"', '"
                        + estab.getBairro() + "', '" + estab.getRua() +"', '" + estab.getLogo() + "', ?);";
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setShort(1, estab.getNumero());
            st.executeUpdate();
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
            String sql = "SELECT MAX(id) FROM sm.estabelecimento;";
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


    
    public Estabelecimento get(int id) {
        Estabelecimento estab = null;
        
        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM \"sm\".\"estabelecimento\" WHERE id="+id;
            ResultSet rs = st.executeQuery(sql);	
            if(rs.next()){            
                estab = new Estabelecimento(rs.getInt("id"), rs.getString("nome"), rs.getString("estado"), rs.getString("cidade"), rs.getString("bairro"), rs.getString("rua"), rs.getShort("numero"),  rs.getString("logo"));
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return estab;
    }

    public List<Estabelecimento> get() {
        return get("");
    }

    public List<Estabelecimento> getOrderByID() {
        return get("id");
    }

    public List<Estabelecimento> getOrderByNome() {
        return get("nome");		
    }

    public List<Estabelecimento> getOrderByEndereco() {
        return get("estado, cidade, bairro");		
    }

    private List<Estabelecimento> get(String orderBy) {
        List<Estabelecimento> estabs = new ArrayList<Estabelecimento>();
        
        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM \"sm\".\"estabelecimento\"" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
            ResultSet rs = st.executeQuery(sql);	           
            while(rs.next()) {	            	
                Estabelecimento p = new Estabelecimento(rs.getInt("id"), rs.getString("nome"), rs.getString("estado"), rs.getString("cidade"), rs.getString("bairro"), rs.getString("rua"), rs.getShort("numero"), rs.getString("logo"));
                estabs.add(p);
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return estabs;
    }
    
    public List<Estabelecimento> getByProduct(int idProduct) {
        return getByProduct(idProduct, "");
    }

    public List<Estabelecimento> getByProductOrderByID(int idProduct) {
        return getByProduct(idProduct, "id");
    }

    public List<Estabelecimento> getByProductOrderByNome(int idProduct) {
        return getByProduct(idProduct, "nome");		
    }

    public List<Estabelecimento> getByProductOrderByEndereco(int idProduct) {
        return getByProduct(idProduct, "estado, cidade, bairro");		
    }

    private List<Estabelecimento> getByProduct(int idProduct, String orderBy) {
        List<Estabelecimento> estabs = new ArrayList<Estabelecimento>();
        
        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM (SELECT * FROM sm.comercializa WHERE sm.comercializa.produto = "+idProduct
            		+") AS A JOIN sm.estabelecimento ON A.estabelecimento = sm.estabelecimento.id" /*+  ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));*/;
//            String sql = "SELECT * FROM \"sm\".\"estabelecimento\"" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
            ResultSet rs = st.executeQuery(sql);	           
            while(rs.next()) {	            	
                Estabelecimento p = new Estabelecimento(rs.getInt("id"), rs.getString("nome"), rs.getString("estado"), rs.getString("cidade"), rs.getString("bairro"), rs.getString("rua"), rs.getShort("numero"), rs.getString("logo"));
                p.setPreco(rs.getString("preco"));
                estabs.add(p);
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return estabs;
    }

    
    public boolean update(Estabelecimento estab) {
        boolean status = false;
        try {  
            String sql = "UPDATE \"sm\".\"estabelecimento\" SET nome = '" + estab.getNome() + "', "
                        + "estado = '" + estab.getEstado() + "', " 
                        + "cidade = '" + estab.getCidade() + "', "
                        + "bairro = '" + estab.getBairro() + "', " 
                        + "rua = '"+ estab.getRua() + "', " + "numero = " + estab.getNumero() + " WHERE id = " + estab.getId();
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
            st.executeUpdate("DELETE FROM \"sm\".\"estabelecimento\" WHERE id = " + id);
            st.close();
            status = true;
        } catch (SQLException u) {  
            throw new RuntimeException(u);
        }
        return status;
    }
}
