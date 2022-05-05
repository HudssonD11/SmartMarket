package model;

public class Estabelecimento 
{
    private int id;
    private String nome;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private short numero;
    private String preco;

    public Estabelecimento()
    {
        id = 0;
        nome = "";
        estado = "";
        cidade = "";
        bairro = "";
        rua = "";
        numero = 0;
        preco = "";
    }

    public Estabelecimento(int id, String nome, String estado, String cidade, String bairro, String rua, short numero)
    {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        preco = "";
    }

    public void setId(int newId)
    {
        this.id = newId;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
    }
    public void setCidade(String cidade)
    {
        this.cidade = cidade;
    }
    public void setBairro(String bairro)
    {
        this.bairro = bairro;
    }
    public void setRua(String rua)
    {
        this.rua = rua;
    }
    public void setNumero(short numero)
    {
        this.numero = numero;
    }

    public void setPreco(String preco)
    {
        this.preco = preco;
    }

    public String getPreco()
    {
        return this.preco;
    }

    public int getId()
    {
        return this.id;
    }

    public String getNome()
    {
        return this.nome;
    }

    public String getEstado()
    {
        return this.estado;
    }
    public String getCidade()
    {
        return this.cidade;
    }
    public String getBairro()
    {
        return this.bairro;
    }
    public String getRua()
    {
        return this.rua;
    }
    public short getNumero()
    {
        return this.numero;
    }

}