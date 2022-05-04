package model;

import java.time.LocalDateTime;

public class Acessa 
{
	private String usuario;
	private int produto;
	private int quantidade;
	private LocalDateTime data;
	
	public Acessa() 
	{
		usuario = "";
		produto = 0;
		quantidade = 0;
		data = LocalDateTime.now();
	}

	public Acessa(String usuario, int produto, int quantidade, LocalDateTime data) 
	{
		setUsuario(usuario);
		setProduto(produto);
		setQuantidade(quantidade);
		setData(data);
	}		

	public Acessa(String usuario, int produto, int quantidade) 
	{
		setUsuario(usuario);
		setProduto(produto);
		setQuantidade(quantidade);
		setData();
	}		
	
	public String getUsuario() 
	{
		return usuario;
	}

	public void setUsuario(String usuario) 
	{
		this.usuario = usuario;
	}

	public int getProduto() 
	{
		return produto;
	}

	public void setProduto(int produto) 
	{
		this.produto = produto;
	}

	public int getQuantidade() 
	{
		return quantidade;
	}

	public void setQuantidade(int quantidade) 
	{
		this.quantidade = quantidade;
	}

	public LocalDateTime getData() 
	{
		return data;
	}

	public void setData(LocalDateTime data) 
	{
		this.data = data;
	}

	public void setData() 
	{
		this.data = LocalDateTime.now();
	}
}