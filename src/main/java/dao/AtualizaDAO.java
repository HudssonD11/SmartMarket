package dao;

import model.Atualiza;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class AtualizaDAO extends DAO
{
    
    public AtualizaDAO() 
    {
        super();
        conectar();
    }
        
        
    public void finalize() {
        close();
    }
    
    
    public boolean insert(Atualiza atualiza) {
        boolean status = false;
        try {
            String sql = "INSERT INTO atualiza (usuario, produto, estabelecimento, data) "
                        + "VALUES ('" + atualiza.getUsuario() + "', "
                        + atualiza.getProduto() + ", " + atualiza.getEstabelecimento() + ", ?);";
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setTimestamp(1, Timestamp.valueOf(atualiza.getData()));
            st.executeUpdate();
            st.close();
            status = true;
        } catch (SQLException u) {  
            throw new RuntimeException(u);
        }
        return status;
    }

    
    public Atualiza get(String usuario, int produto, int estab) {
        Atualiza atualiza = null;
        
        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM atualiza WHERE usuario = '"+ usuario +"' AND produto = "+ produto +" AND estabelecimento = "+ estab;
            ResultSet rs = st.executeQuery(sql);	
            if(rs.next()){            
                atualiza = new Atualiza(rs.getString("usuario"), rs.getInt("produto"), rs.getInt("estabelecimento"), rs.getTimestamp("data").toLocalDateTime());
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return atualiza;
    }

    public List<Atualiza> get() {
        return get("");
    }

    public List<Atualiza> getOrderByUsuario() {
        return get("usuario");
    }

    public List<Atualiza> getOrderByProduto() {
        return get("produto");		
    }

    public List<Atualiza> getOrderByEstabelecimento() {
        return get("estabelecimento");		
    }

    public List<Atualiza> getOrderByData() {
        return get("data");		
    }

    private List<Atualiza> get(String orderBy) {
        List<Atualiza> atualiza = new ArrayList<Atualiza>();
        
        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM atualiza" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
            ResultSet rs = st.executeQuery(sql);	           
            while(rs.next()) {
                Atualiza p = new Atualiza(rs.getString("usuario"), rs.getInt("produto"), rs.getInt("estabelecimento"), rs.getTimestamp("data").toLocalDateTime());
                atualiza.add(p);
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return atualiza;
    }
    
    
    public boolean update(Atualiza ac) {
        boolean status = false;
        try {  
            String sql = "UPDATE atualiza SET data = ? WHERE usuario = '" + ac.getUsuario()
            + "' AND produto = "+ac.getProduto() +" AND estabelecimento = "+ac.getEstabelecimento();
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setTimestamp(1, Timestamp.valueOf(ac.getData()));
            st.executeUpdate();
            st.close();
            status = true;
        } catch (SQLException u) {  
            throw new RuntimeException(u);
        }
        return status;
    }
    
    
    public boolean delete(String usuario, int produto, int estab) {
        boolean status = false;
        try {  
            Statement st = conexao.createStatement();
            st.executeUpdate("DELETE FROM atualiza WHERE usuario = '" + usuario 
            + "' AND produto = "+ produto + " AND estabelecimento = " + estab);
            st.close();
            status = true;
        } catch (SQLException u) {  
            throw new RuntimeException(u);
        }
        return status;
    }
}
