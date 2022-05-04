package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Acessa {

	private String usuario;
	private String produto;
	private int quantidade;
	private Date data;
	
	public Produto() {
		usuario = "";
		produto = "";
		quantidade = 0;
		data = "";
	}

	public Produto(int id, String descricao, float preco, int quantidade, LocalDateTime fabricacao, LocalDate v) {
		setUsuario(usuario);
		setProduto(produto);
		setQuantidade(quantidade);
		setData(data);
	}		
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}