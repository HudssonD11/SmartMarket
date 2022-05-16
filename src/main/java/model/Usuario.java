package model;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class Usuario 
    {
        private String CPF;
        private String nome;
        private String login;
        private String senha;
        private String email;
        private int creditos;
        private char tipo;

        public Usuario() 
        {
            email = "";
            CPF = "";
            nome = "";
            login = "";
            senha = "";
            creditos = 0;
            tipo = '-';

        }
        
        public Usuario(String CPF, String nome, String login, String senha, String email, char tipo) 
        {
            setEmail(email);
            setLogin(login);
            setSenha(encryptPassword(senha));
            setNome(nome);
            setTipo(tipo);
            setCreditos(0);
            setCPF(CPF);
        }

        public Usuario(String CPF, String nome, String login, String senha, String email, int creditos, char tipo) 
        {
            setEmail(email);
            setLogin(login);
            setSenha(senha);
            setNome(nome);
            setTipo(tipo);
            setCreditos(creditos);
            setCPF(CPF);
        }

        
    
    public static String encryptPassword(final String base) {
    try{
        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
        final byte[] hash = digest.digest(base.getBytes("UTF-8"));
        final StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            final String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) 
              hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    } catch(Exception ex){
       throw new RuntimeException(ex);
    }
}

        public void setEmail(String email) 
        {
            this.email = email;
        }

        public void setNome(String nome) 
        {
            this.nome = nome;
        }

        public void setLogin(String login) 
        {
            this.login = login;
        }

        public void setSenha(String senha) 
        {
            this.senha = senha;
        }

        public void setSenhaEncrypt(String senha) 
        {
            this.senha = encryptPassword(senha);
        }

        public void setCreditos(int creditos) 
        {
            this.creditos = creditos;
        }

        public void setTipo(char tipo) 
        {
            this.tipo = tipo;
        }

        public void setCPF(String cpf) 
        {
            this.CPF = cpf;
        }

        public String getEmail()
        {
            return this.email;
        }

        public String getNome() 
        {
            return this.nome;
        }

        public String getLogin() 
        {
            return this.login;
        }

        public String getSenha() 
        {
            return this.senha;
        }

        public String getCPF() 
        {
            return this.CPF;
        }

        public int getCreditos() 
        {
            return this.creditos;
        }

        public char getTipo() 
        {
            return this.tipo;
        }

    }
