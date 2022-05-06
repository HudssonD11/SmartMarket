package model;

public class Produto 
{

	private int id;
    private String nome;
    private String descricao;
    private String categoria;
    private String marca;
    private String unidade;
	private String imagem;
	private String preco;
	private String supermercado;
	
	public Produto() 
	{
        id = 0;
        nome = "";
        categoria = "";
        marca = "";
        unidade = "";
        descricao = "";
		imagem = "";
		preco = "";
		supermercado = "";
	}

	public Produto(int id, String nome, String descricao, String categoria, String marca, String unidade, String imagem) 
	{
		setId(id);
        setNome(nome);
        setCategoria(categoria);
        setMarca(marca);
        setUnidade(unidade);
        setDescricao(descricao);
		setImagem(imagem);
		preco = "";
		supermercado = "";
	}		

    public String getDescricao() 
	{
        return descricao;
    }
    
    public String getPreco()
    {
    	return preco;
    }
    
    public void setPreco(String preco)
    {
    	this.preco = preco;
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
	public String getImagem() 
	{
        return imagem;
    }

    public void setImagem(String imagem) 
	{
        this.imagem = imagem;
    }

	public String getSupermercado() 
	{
        return supermercado;
    }

    public void setSupermercado(String supermercado) 
	{
        this.supermercado = supermercado;
    }
}