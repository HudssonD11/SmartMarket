package dao;

import model.Comercializa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ComercializaDAO extends DAO
{
    
    public ComercializaDAO() 
    {
        super();
        conectar();
    }
        
        
    public void finalize() {
        close();
    }
    
    
    public boolean insert(Comercializa com) {
        boolean status = false;
        try {
            String sql = "INSERT INTO comercializa (estabelecimento, produto, preco) "
                        + "VALUES (" + com.getEstabelecimento() + ", "
                        + com.getProduto() + ", '" + com.getPreco() + "');";
            PreparedStatement st = conexao.prepareStatement(sql);
            st.executeUpdate();
            st.close();
            status = true;
        } catch (SQLException u) {  
            throw new RuntimeException(u);
        }
        return status;
    }

    
    public Comercializa get(int estab, int produto) {
        Comercializa com = null;
        
        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM comercializa WHERE estabelecimento = "+ estab +" AND produto = "+ produto;
            System.out.println(st.executeQuery(sql));
            ResultSet rs = st.executeQuery(sql);	
            
            if(rs.next()){    
                System.out.println("peguei certo");        
                com = new Comercializa(rs.getInt("estabelecimento"), rs.getInt("produto"), rs.getString("preco"));
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return com;
    }

    public List<Comercializa> get() {
        return get("");
    }

    public List<Comercializa> getOrderByProduto() {
        return get("produto");		
    }

    public List<Comercializa> getOrderByEstabelecimento() {
        return get("estabelecimento");		
    }

    public List<Comercializa> getOrderByPreco() {
        return get("preco");		
    }

    private List<Comercializa> get(String orderBy) {
        List<Comercializa> com = new ArrayList<Comercializa>();
        
        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM sm.comercializa" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
            ResultSet rs = st.executeQuery(sql);	           
            while(rs.next()) {
                Comercializa p = new Comercializa(rs.getInt("estabelecimento"), rs.getInt("produto"), rs.getString("preco"));
                com.add(p);
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return com;
    }
    
    
    public boolean update(Comercializa ac, String valor) {
        boolean status = false;
        try {  
            String sql = "UPDATE sm.comercializa SET preco = '"+valor+"' WHERE estabelecimento = " + ac.getEstabelecimento()
            + " AND produto = "+ac.getProduto();
            PreparedStatement st = conexao.prepareStatement(sql);
            st.executeUpdate();
            st.close();
            status = true;
        } catch (SQLException u) {  
            throw new RuntimeException(u);
        }
        return status;
    }
    
    
    public boolean delete(int estab, int produto) {
        boolean status = false;
        try {  
            Statement st = conexao.createStatement();
            st.executeUpdate("DELETE FROM sm.comercializa WHERE produto = "+ produto + " AND estabelecimento = " + estab);
            st.close();
            status = true;
        } catch (SQLException u) {  
            throw new RuntimeException(u);
        }
        return status;
    }
}
