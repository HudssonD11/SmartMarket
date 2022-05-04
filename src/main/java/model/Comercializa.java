package model;

public class Comercializa 
{
    private int estabelecimento;
    private int produto;
    private String preco;

    public Comercializa()
    {
        estabelecimento = 0;
        produto = 0;
        preco = "";
    }

    public Comercializa(int estab, int prod, String prec)
    {
        estabelecimento = estab;
        produto = prod;
        preco = prec;
    }

    public void setEstabelecimento(int estabelecimento) 
    {
        this.estabelecimento = estabelecimento;
    }

    public void setPreco(String preco) 
    {
        this.preco = preco;
    }

    public void setProduto(int produto) 
    {
        this.produto = produto;
    }

    public int getEstabelecimento() 
    {
        return estabelecimento;
    }

    public String getPreco() 
    {
        return preco;
    }

    public int getProduto() 
    {
        return produto;
    }
}