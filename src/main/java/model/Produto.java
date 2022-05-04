package model;

public class Produto 
{

	private int id;
    private String nome;
    private String descricao;
    private String categoria;
    private String marca;
    private String unidade;
	
	public Produto() 
	{
        id = 0;
        nome = "";
        categoria = "";
        marca = "";
        unidade = "";
        descricao = "";
	}

	public Produto(int id, String nome, String descricao, String categoria, String marca, String unidade) 
	{
		setId(id);
        setNome(nome);
        setCategoria(categoria);
        setMarca(marca);
        setUnidade(unidade);
        setDescricao(descricao);
	}		

    public String getDescricao() 
	{
        return descricao;
    }

    public void setDescricao(String descricao) 
	{
        this.descricao = descricao;
    }

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public String getCategoria() 
	{
		return categoria;
	}

	public void setCategoria(String categoria) 
	{
		this.categoria = categoria;
	}

	public String getMarca() 
	{
		return marca;
	}

	public void setMarca(String marca) 
	{
		this.marca = marca;
	}

    public String getUnidade() 
	{
        return unidade;
    }

    public void setUnidade(String unidade) 
	{
        this.unidade = unidade;
    }
}