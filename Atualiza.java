public class Atualiza {
    class usuario {
        private String usuario;
        private String produto;
        private String estabelecimento;
        private Date data;

        public usuario() {
            usuario = "";
            produto = "";
            estabelecimento = "";
            data = "";

        }

        public usuario(String usuario, String produto, String estabelecimento, Date data) {
            this.usuario = usuario;
            this.produto = produto;
            this.estabelecimento = estabelecimento;
            this.data = data;
        }

        public void setUsuario(String usuario) {
            this.usuario = usuario;
        }

        public void setProduto(String produto) {
            this.produto = produto;
        }

        public void setEstabelecimento(String estabelecimento) {
            this.estabelecimento = estabelecimento;
        }

        public void setData(Date data) {
            this.data = data;
        }

        public String getUsuario() {
            return this.usuario;
        }

        public String getProduto() {
            return this.produto;
        }

        public String getEstabelecimento() {
            return this.estabelecimento;
        }

        public int getData() {
            return this.data;
        }

    }

}
