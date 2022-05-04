package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Produto {

	private String id;
    private String nome;
    private String categoria;
    private String marca;
    private String unidade;
    private String descricao;
	
	public Produto() {
        id = "";
        nome = "";
        categoria = "";
        marca = "";
        unidade = "";
        descricao = "";
	}

	public Produto(String id, String nome, String categoria, String marca, String unidade, String descricao) {
		setId(id);
        setNome(nome);
        setCategoria(categoria);
        setMarca(marca);
        setUnidade(unidade);
        setDescricao(descricao);
	}		

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
}