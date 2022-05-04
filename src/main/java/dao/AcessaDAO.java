package dao;

import model.Acessa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class AcessaDAO extends DAO
{
    
    public AcessaDAO() 
    {
        super();
        conectar();
    }
        
        
    public void finalize() {
        close();
    }
    
    
    public boolean insert(Acessa acessa) {
        boolean status = false;
        try {
            String sql = "INSERT INTO acessa (usuario, produto, quantidade, data) "
                        + "VALUES ('" + acessa.getUsuario() + "', "
                        + acessa.getProduto() + ", " + acessa.getQuantidade() + ", ?);";
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setTimestamp(1, Timestamp.valueOf(acessa.getData()));
            st.executeUpdate();
            st.close();
            status = true;
        } catch (SQLException u) {  
            throw new RuntimeException(u);
        }
        return status;
    }

    
    public Acessa get(String usuario, int produto) {
        Acessa acessa = null;
        
        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM acessa WHERE usuario = '"+ usuario +"' AND produto = "+ produto;
            ResultSet rs = st.executeQuery(sql);	
            if(rs.next()){            
                acessa = new Acessa(rs.getString("usuario"), rs.getInt("produto"), rs.getInt("quantidade"), rs.getTimestamp("data").toLocalDateTime());
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return acessa;
    }

    public List<Acessa> get() {
        return get("");
    }

    public List<Acessa> getOrderByUsuario() {
        return get("usuario");
    }

    public List<Acessa> getOrderByProduto() {
        return get("produto");		
    }

    private List<Acessa> get(String orderBy) {
        List<Acessa> acessa = new ArrayList<Acessa>();
        
        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM acessa" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
            ResultSet rs = st.executeQuery(sql);	           
            while(rs.next()) {
                Acessa p = new Acessa(rs.getString("usuario"), rs.getInt("produto"), rs.getInt("quantidade"), rs.getTimestamp("data").toLocalDateTime());
                acessa.add(p);
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return acessa;
    }
    
    
    public boolean update(Acessa ac) {
        boolean status = false;
        try {  
            String sql = "UPDATE Acessa SET quantidade = " + ac.getQuantidade() + ", "
                        + "data = ? WHERE usuario = " + ac.getUsuario()+" AND produto = "+ac.getProduto();
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
    
    
    public boolean delete(int usuario, int produto) {
        boolean status = false;
        try {  
            Statement st = conexao.createStatement();
            st.executeUpdate("DELETE FROM Acessa WHERE usuario = " + usuario + " AND produto = "+ produto);
            st.close();
            status = true;
        } catch (SQLException u) {  
            throw new RuntimeException(u);
        }
        return status;
    }
}
