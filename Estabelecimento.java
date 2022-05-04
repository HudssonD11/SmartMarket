public class Estabelecimento 
{
    private String id;
    private String nome;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private short numero;

    Estabelecimento()
    {
        id = "";
        nome = "";
        estado = "";
        cidade = "";
        bairro = "";
        rua = "";
        numero = -1;
    }

    Estabelecimento(String id, String nome, String estado, String cidade, String bairro, String rua, short numero)
    {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
    }

    public void setId(String newId)
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

    public String getId()
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