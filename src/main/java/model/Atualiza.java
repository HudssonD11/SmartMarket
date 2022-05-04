package model;

import java.time.LocalDateTime;

public class Atualiza 
{
    private String usuario;
    private int produto;
    private int estabelecimento;
    private LocalDateTime data;

    public Atualiza() 
    {
        usuario = "";
        produto = 0;
        estabelecimento = 0;
        data = LocalDateTime.now();

    }

    public Atualiza(String usuario, int produto, int estabelecimento, LocalDateTime data) 
    {
        this.usuario = usuario;
        this.produto = produto;
        this.estabelecimento = estabelecimento;
        this.data = data;
    }

    public void setUsuario(String usuario) 
    {
        this.usuario = usuario;
    }

    public void setProduto(int produto) 
    {
        this.produto = produto;
    }

    public void setEstabelecimento(int estabelecimento) 
    {
        this.estabelecimento = estabelecimento;
    }

    public void setData(LocalDateTime data) 
    {
        this.data = data;
    }

    public void setData() 
    {
        this.data = LocalDateTime.now();
    }

    public String getUsuario() 
    {
        return this.usuario;
    }

    public int getProduto() 
    {
        return this.produto;
    }

    public int getEstabelecimento() 
    {
        return this.estabelecimento;
    }

    public LocalDateTime getData() 
    {
        return this.data;
    }

}
