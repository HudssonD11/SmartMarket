public class Comercializa 
{
    private String estabelecimento;
    private String produto;
    private String preco;

    Comercializa()
    {
        estabelecimento = "";
        produto = "";
        preco = "";
    }

    Comercializa(String estab, String prod, String prec)
    {
        estabelecimento = estab;
        produto = prod;
        preco = prec;
    }

    public void setEstabelecimento(String estabelecimento) 
    {
        this.estabelecimento = estabelecimento;
    }

    public void setPreco(String preco) 
    {
        this.preco = preco;
    }

    public void setProduto(String produto) 
    {
        this.produto = produto;
    }

    public String getEstabelecimento() 
    {
        return estabelecimento;
    }

    public String getPreco() 
    {
        return preco;
    }

    public String getProduto() 
    {
        return produto;
    }
}
