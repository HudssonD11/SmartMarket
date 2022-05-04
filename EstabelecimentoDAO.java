package dao;

import model.Produto;

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
                String sql = "INSERT INTO estabelecimento (id, nome, estado, cidade, bairro, rua, numero) "
                           + "VALUES ('" + estab.getId() + "', '"
                           + estab.getNome() + "', '" + estab.getEstado() + "', '"+estab.getCidade()+"', '"
                           + estab.getBairro() + "', '" + esbat.getRua() + "', ?);";
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
    
        
        public Estabelecimento get(String id) {
            Estabelecimento estab = null;
            
            try {
                Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                String sql = "SELECT * FROM estabelecimento WHERE id="+id;
                ResultSet rs = st.executeQuery(sql);	
                if(rs.next()){            
                    estab = new Estabelecimento(rs.getString("id"), rs.getString("nome"), rs.getString("estado"), rs.getString("cidade"), rs.getString("bairro"), rs.getString("rua"), rs.getShort("numero"));
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

        public List<Produto> getOrderByID() {
            return get("id");
        }

        public List<Produto> getOrderByNome() {
            return get("nome");		
        }

        private List<Estabelecimento> get(String orderBy) {
            List<Estabelecimento> estabs = new ArrayList<Estabelecimento>();
            
            try {
                Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                String sql = "SELECT * FROM estabelecimento" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
                ResultSet rs = st.executeQuery(sql);	           
                while(rs.next()) {	            	
                    Estabelecimento p = new Estabelecimento(rs.getString("id"), rs.getString("nome"), rs.getString("estado"), rs.getString("cidade"), rs.getString("bairro"), rs.getString("rua"), rs.getShort("numero"));
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
                String sql = "UPDATE estabelecimento SET nome = '" + estab.getNome() + "', "
                           + "estado = '" + estab.getEstado() + "', " 
                           + "cidade = '" + estab.getCidade() + "', "
                           + "bairro = '" + estab.getBairro() + "', " 
                           + "rua = '"+ estab.getRua() + "', " + "numero = " + estab.getNumero() + " WHERE id = " + estab.getID();
                PreparedStatement st = conexao.prepareStatement(sql);
                st.executeUpdate();
                st.close();
                status = true;
            } catch (SQLException u) {  
                throw new RuntimeException(u);
            }
            return status;
        }
        
        
        public boolean delete(String id) {
            boolean status = false;
            try {  
                Statement st = conexao.createStatement();
                st.executeUpdate("DELETE FROM estabelecimento WHERE id = " + id);
                st.close();
                status = true;
            } catch (SQLException u) {  
                throw new RuntimeException(u);
            }
            return status;
        }
    }
}