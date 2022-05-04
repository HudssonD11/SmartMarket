public class Usuario {
    class usuario {
        private String nome;
        private String login;
        private String senha;
        private int creditos;
        private char tipo;

        public usuario() {
            name = "";
            login = "";
            senha = "";
            creditos = 0;
            tipo = "";

        }

        public usuario(String nome, String login, String senha, int creditos, char tipo) {
            this.nome = nome;
            this.login = login;
            this.senha = senha;
            this.creditos = creditos;
            this.tipo = tipo;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }

        public void setNome(int creditos) {
            this.creditos = creditos;
        }

        public void setTipo(char tipo) {
            this.tipo = tipo;
        }

        public String getNome() {
            return this.nome;
        }

        public String getLogin() {
            return this.login;
        }

        public String getSenha() {
            return this.senha;
        }

        public int getCredito() {
            return this.creditos;
        }

        public char getTipo() {
            return this.tipo;
        }

    }
}