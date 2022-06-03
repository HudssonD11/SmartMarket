package service;

import java.io.*;
import java.text.ParseException;
import java.util.List;
import dao.ProdutoDAO;
import dao.EstabelecimentoDAO;
import model.Produto;
import model.Comercializa;
import dao.ComercializaDAO;
import model.Estabelecimento;
import spark.Request;
import spark.Response;

class produtoUser {
	int id;
	String nome;
	float valor;

	public produtoUser(int id, String nome, float valor) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}

	public produtoUser() {
		this.id = -1;
		this.nome = "";
		this.valor = -1;
	}

	public produtoUser clone() {
		produtoUser produto = new produtoUser();
		produto.nome = this.nome;
		produto.id = this.id;
		produto.valor = this.valor;
		return produto;
	}
}

public class ProdutoService {

	private ProdutoDAO produtoDAO = new ProdutoDAO();
	private ComercializaDAO comercializaDAO = new ComercializaDAO();
	private int nextId = produtoDAO.getLastId();
	private String form;

	public ProdutoService() {
	}

	public String makeForm() {

		form = "";

		form += "<!doctype html>";

		form += "<html lang=\"pt-br\">";
		form += "<head>";
		form += "<!-- Required meta tags -->";
		form += "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">";
		form += "<meta charset=\"utf-8\">";
		form += "<title>SmartMarket</title>";
		form += "<!-- Bootstrap CSS -->";
		form += "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css\">";
		form += "<script src=\"https://kit.fontawesome.com/c81b80495f.js\" crossorigin=\"anonymous\"></script>";
		form += "<script src=\"app.js\"></script>";
		form += "<!-- Meu css -->";
		form += "<link rel=\"stylesheet\" href=\"..\\style.css\">";
		form += "<script src = \"..\\app.js\"> </script>";
		form += "<script> VARIAVEL  </script>";
		form += "</head>";
		form += "<!--Menu Superior-->";
		form += "<body onLoad=\"isAdmin(true,'../produtos'),mostrarProdutos(produtos), setProdLS(produtos)\">";
		form += "<div id=\"menu\">";
		form += "<header class=\"container header\">";
		form += "<nav class=\"navbar navbar-expand-lg navbar-light bg-light menu\">";
		form += "<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSite\">";
		form += "<span class=\"navbar-toggler-icon\"></span>";
		form += "</button>";
		form += "<div class=\"collapse navbar-collapse\" id=\"navbarSite\">";
		form += "<ul class=\"navbar-nav mr-auto\">";
		form += "<li class=\"nav-item name\">";
		form += "<a class=\"nav-link\" href=\"..\\index.html\">SmartMarket</a>";
		form += "</li>";
		form += "<li class=\"nav-item menu_item\">";
		form += "<a class=\"nav-link\" >|</a>";
		form += "</li>";
		form += "<li class=\"nav-item menu_item\">";
		form += "<a class=\"nav-link\" href=\"..\\produtos\" method=\"get\">Produtos</a>";
		form += "</li>";
		form += "<li class=\"nav-item menu_item\">";
		form += "<a class=\"nav-link\">|</a>";
		form += "</li>";
		form += "<li class=\"nav-item menu_item\">";
		form += "<a class=\"nav-link\" href=\"..\\mercados\" method=\"get\">Supermercados</a>";
		form += "<li class=\"nav-item menu_item\">";
		form += "<a class=\"nav-link\">|</a>";
		form += "</li>";
		form += "<li class=\"nav-item menu_item\">";
		form += "<a class=\"nav-link\" href=\"..\\login\" method=\"get\">Login</a>";
		form += "</li>";
		form += "</ul>";
		form += "</div>";
		form += "</nav>";
		form += "</header>";
		form += "</div>";
		form += "<!--1 Bloco com Propagandas-->";
		form += "<section class=\"row publicidade\">";
		form += "<div class=\"col-12 col-sm-12 col-md-12 col-lg-12 publicidade_produtos\">";
		form += "<h1>Propaganda</h1>";
		form += "</div>";
		form += "</section>";
		// parte de pesquisa de produtos
		form += "<section class=\"row search\">";
		form += "<hr>";
		form += "<div class=\"text-center\"><input placeholder=\"Pesquisar produto ou categoria\" id=\"pesquisaMercado\" type=\"text\" oninput=\"filtraProdutos()\" ></div>";
		// form += "<input placeholder=\"Pesquisar produto ou categoria\"
		// id=\"pesquisaMercado\" type=\"text\" oninput=\"filtraProdutos()\" >";
		form += "<hr>";
		form += "</section>";
		// parte de exibição do produto
		form += "<section class=\"row card_produto\" id=\"tela\">";

		form += "</section>";
		// rodapé
		form += "<footer class=\"container footer\">";
		form += "<div class=\"row\">";
		form += "<div class=\"col-12 footer_area\">";
		form += "SmartMarket - Todos os direitos reservados - 2021";
		form += "</div>";
		form += "</div>";
		form += "</footer>";
		form += "</main>";
		form += "</body>";
		form += "</html>";

		List<Produto> produtos = produtoDAO.getOrderByID();

		String js = "";
		js += "let produtos = [";
		for (Produto p : produtos) {
			js += "{id: \"" + p.getId() + "\", nome: \"" + p.getNome() + "\", descricao: \"" + p.getDescricao()
					+ "\", categoria: \"" + p.getCategoria() + "\", marca: \"" + p.getMarca() + "\", unidade: \""
					+ p.getUnidade() + "\", imagem: \"" + p.getImagem() + "\"},";
		}
		js += "{}]";
		form = form.replaceFirst("VARIAVEL", js);
		return form;
	}

	public String makeFormByEstab(int idEstab) {

		form = "";

		form += "<!doctype html>";

		form += "<html lang=\"pt-br\">";
		form += "<head>";
		form += "<!-- Required meta tags -->";
		form += "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">";
		form += "<meta charset=\"utf-8\">";
		form += "<title>SmartMarket</title>";
		form += "<!-- Bootstrap CSS -->";
		form += "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css\">";
		form += "<script src=\"https://kit.fontawesome.com/c81b80495f.js\" crossorigin=\"anonymous\"></script>";
		form += "<script src=\"app.js\"></script>";
		form += "<!-- Meu css -->";
		form += "<link rel=\"stylesheet\" href=\"..\\style.css\">";
		form += "<script src = \"..\\app.js\"> </script>";
		form += "<script> VARIAVEL  </script>";
		form += "</head>";
		form += "<!--Menu Superior-->";
		form += "<body onLoad=\"isAdmin(true,'../mercados/IDMERCADO'),mostrarMercado(mercado, produtos)\">";
		form += "<div id=\"menu\">";
		form += "<header class=\"container header\">";
		form += "<nav class=\"navbar navbar-expand-lg navbar-light bg-light menu\">";
		form += "<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSite\">";
		form += "<span class=\"navbar-toggler-icon\"></span>";
		form += "</button>";
		form += "<div class=\"collapse navbar-collapse\" id=\"navbarSite\">";
		form += "<ul class=\"navbar-nav mr-auto\">";
		form += "<li class=\"nav-item name\">";
		form += "<a class=\"nav-link\" href=\"..\\index.html\">SmartMarket</a>";
		form += "</li>";
		form += "<li class=\"nav-item menu_item\">";
		form += "<a class=\"nav-link\" >|</a>";
		form += "</li>";
		form += "<li class=\"nav-item menu_item\">";
		form += "<a class=\"nav-link\" href=\"produtos\" method=\"get\">Produtos</a>";
		form += "</li>";
		form += "<li class=\"nav-item menu_item\">";
		form += "<a class=\"nav-link\">|</a>";
		form += "</li>";
		form += "<li class=\"nav-item menu_item\">";
		form += "<a class=\"nav-link\" href=\"mercados\" method=\"get\">Supermercados</a>";
		form += "<li class=\"nav-item menu_item\">";
		form += "<a class=\"nav-link\">|</a>";
		form += "</li>";
		form += "<li class=\"nav-item menu_item\">";
		form += "<a class=\"nav-link\" href=\"login\" method=\"get\">Login</a>";
		form += "</li>";
		form += "</ul>";
		form += "</div>";
		form += "</nav>";
		form += "</header>";
		form += "</div>";
		form += "<!--1 Bloco com Propagandas-->";
		form += "<section class=\"row publicidade\"  id=\"mercado\">";

		form += "</section>";
		// parte de pesquisa de produtos
		form += "<section class=\"row search\">";
		form += "<hr>";
		form += "<div class=\"text-center\"><input oninput=\"\" id=\"pesquisaMercado\" placeholder=\"Pesquisar Produtos\" type=\"text\"></div>";
		form += "<hr>";
		form += "</section>";
		// parte de exibição do produto
		form += "<section class=\"row card_produto\" id=\"tela\">";

		form += "</section>";
		// rodapé
		form += "<footer class=\"container footer\">";
		form += "<div class=\"row\">";
		form += "<div class=\"col-12 footer_area\">";
		form += "SmartMarket - Todos os direitos reservados - 2021";
		form += "</div>";
		form += "</div>";
		form += "</footer>";
		form += "</main>";
		form += "</body>";
		form += "</html>";

		List<Produto> produtos = produtoDAO.getByEstab(idEstab);
		System.out.println(produtos);
		EstabelecimentoDAO estabDAO = new EstabelecimentoDAO();
		Estabelecimento estab = estabDAO.get(idEstab);

		String js = "";
		js += "let produtos = [";
		for (Produto p : produtos) {
			js += "{id: \"" + p.getId() + "\", nome: \"" + p.getNome() + "\", descricao: \"" + p.getDescricao()
					+ "\", categoria: \"" + p.getCategoria() + "\", marca: \"" + p.getMarca() + "\", unidade: \""
					+ p.getUnidade() + "\", preco: \"" + p.getPreco() + "\", imagem: \"" + p.getImagem() + "\"},";
		}
		js += "{}]; ";
		js += "let mercado = {id: \"" + idEstab + "\", nome: \"" + estab.getNome() + "\", estado: \""
				+ estab.getEstado() + "\", cidade: \"" + estab.getCidade() + "\", bairro: \"" + estab.getBairro()
				+ "\", rua: \"" + estab.getRua() + "\", numero: \"" + estab.getNumero() + "\", imagem: \""
				+ estab.getLogo() + "\"};";
		form = form.replaceFirst("VARIAVEL", js);
		js = "" + estab.getId();
		form = form.replaceFirst("IDMERCADO", js);
		return form;

	}

	public Object getAll(Request request, Response response) {
		// int orderBy = Integer.parseInt(request.params(":orderby"));
		String html = makeForm();
		response.header("Content-Type", "text/html");
		response.header("Content-Encoding", "UTF-8");
		return html;
	}

	public Object getByEstab(Request request, Response response) {
		int idEstab = Integer.parseInt(request.params(":idEstab"));
		String html = makeFormByEstab(idEstab);
		response.header("Content-Type", "text/html");
		response.header("Content-Encoding", "UTF-8");
		return html;
	}

	public String makeFormProduto() {
		form = "<!doctype html>";

		form += "<!doctype html>";
		form += "<html lang=\"pt-br\">";
		form += "<head>";
		form += "<!-- Required meta tags -->";
		form += "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">";
		form += "<meta charset=\"utf-8\">";
		form += "<title>SmartMarket</title>";
		form += "<!-- Bootstrap CSS -->";
		form += "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css\">";
		form += "<script src=\"https://kit.fontawesome.com/c81b80495f.js\" crossorigin=\"anonymous\"></script>";
		form += "<script src=\"app.js\"></script>";
		form += "<!-- Meu css -->";
		form += "<link rel=\"stylesheet\" href=\"..\\style.css\">";
		form += "</head>";
		form += "<!--Menu Superior-->";
		form += "<body onload=\"isAdmin(true,null)\">";
		form += "<div id=\"menu\">";
		form += "<header class=\"container header\">";
		form += "<nav class=\"navbar navbar-expand-lg navbar-light bg-light menu\">";
		form += "<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSite\">";
		form += "<span class=\"navbar-toggler-icon\"></span>";
		form += "</button>";
		form += "<div class=\"collapse navbar-collapse\" id=\"navbarSite\">";
		form += "<ul class=\"navbar-nav mr-auto\">";
		form += "<li class=\"nav-item name\">";
		form += "<a class=\"nav-link\" href=\"..\\index.html\">SmartMarket</a>";
		form += "</li>";
		form += "<li class=\"nav-item menu_item\">";
		form += "<a class=\"nav-link\" >|</a>";
		form += "</li>";
		form += "<li class=\"nav-item menu_item\">";
		form += "<a class=\"nav-link\" href=\"produtos\" method=\"get\">Produtos</a>";
		form += "</li>";
		form += "<li class=\"nav-item menu_item\">";
		form += "<a class=\"nav-link\">|</a>";
		form += "</li>";
		form += "<li class=\"nav-item menu_item\">";
		form += "<a class=\"nav-link\" href=\"mercados\" method=\"get\">Supermercados</a>";
		form += "<li class=\"nav-item menu_item\">";
		form += "<a class=\"nav-link\">|</a>";
		form += "</li>";
		form += "<li class=\"nav-item menu_item\">";
		form += "<a class=\"nav-link\" href=\"login\" method=\"get\">Login</a>";
		form += "</li>";
		form += "</ul>";
		form += "</div>";
		form += "</nav>";
		form += "</header>";
		form += "</div>";
		form += "<h1 id=\"insert\">Adicionar Produto</h1>";
		form += "<section class=\"row card_insert\" id=\"tela\">";
		form += "<div class=\"col-12 col-sm-12 col-md-6 col-lg-12\">";
		form += "<form action=\"produto/adicionar\" method=\"post\">";
		form += "<label for=\"username\">Produto</label><br>";
		form += "<input type=\"text\" name=\"nome\" id=\"produto\" class=\"form-control\" placeholder=\"Nome do Produto\" required>";
		form += "<label for=\"username\">Categoria</label><br>";
		form += "<input type=\"text\" name=\"categoria\" id=\"categoria\" class=\"form-control\" placeholder=\"Categoria do Produto\" required>";
		form += "<label for=\"username\">Descrição</label><br>";
		form += "<input type=\"text\" name=\"descricao\" id=\"categoria\" class=\"form-control\" placeholder=\"Descrição do Produto\">";
		form += "<label for=\"username\">Marca</label><br>";
		form += "<input type=\"text\" name=\"marca\" id=\"marca\" class=\"form-control\" placeholder=\"Marca do Produto\" required>";
		form += "<label for=\"username\">Unidade</label><br>";
		form += "<input type=\"text\" name=\"unidade\" id=\"unidade\" class=\"form-control\" placeholder=\"Unidade de medida\">";
		form += "<label for=\"username\">Imagem</label><br>";
		form += "<input type=\"text\" name=\"imagem\" id=\"imagem\" class=\"form-control\" placeholder=\"Foto do produto\">";
		form += "<input type=\"submit\" value=\"Cadastrar\" class=\"btn btn-primary\" id=\"btn-cad\"></form>";
		form += "</div>";
		form += "</section>";
		form += "<footer class=\"container footer\">";
		form += "<div class=\"row\">";
		form += "<div class=\"col-12 footer_area\">";
		form += "SmartMarket - Todos os direitos reservados - 2021";
		form += "</div>";
		form += "</div>";
		form += "</footer>";
		form += "</main>";
		form += "</body>";
		form += "</html>";

		return form;
	}

	public Object getAdd(Request request, Response response) {
		String html = makeFormProduto();

		return html;
	}

	public String makeFormIndeferidos() throws ParseException {
		String[] arquivos = new String[10];
		produtoUser[] produtos = new produtoUser[30];
		arquivos = leitura();
		produtos = read(arquivos);
		form = "<!doctype html>";
		form += "<!doctype html>";
		form += "<html lang=\"pt-br\">";
		form += "<head>";
		form += "<!-- Required meta tags -->";
		form += "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">";
		form += "<meta charset=\"utf-8\">";
		form += "<title>SmartMarket</title>";
		form += "<!-- Bootstrap CSS -->";
		form += "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css\">";
		form += "<script src=\"https://kit.fontawesome.com/c81b80495f.js\" crossorigin=\"anonymous\"></script>";
		form += "<script src = \"..\\app.js\"> </script>";
		form += "<script> VARIAVEL  </script>";
		form += "<!-- Meu css -->";
		form += "<link rel=\"stylesheet\" href=\"..\\style.css\">";
		form += "</head>";
		form += "<!--Menu Superior-->";
		form += "<body onload=\"isAdmin(true,null), mostrarBugados2(produtos)\">";
		form += "<div id=\"menu\">";
		form += "<header class=\"container header\">";
		form += "<nav class=\"navbar navbar-expand-lg navbar-light bg-light menu\">";
		form += "<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSite\">";
		form += "<span class=\"navbar-toggler-icon\"></span>";
		form += "</button>";
		form += "<div class=\"collapse navbar-collapse\" id=\"navbarSite\">";
		form += "<ul class=\"navbar-nav mr-auto\">";
		form += "<li class=\"nav-item name\">";
		form += "<a class=\"nav-link\" href=\"..\\index.html\">SmartMarket</a>";
		form += "</li>";
		form += "<li class=\"nav-item menu_item\">";
		form += "<a class=\"nav-link\" >|</a>";
		form += "</li>";
		form += "<li class=\"nav-item menu_item\">";
		form += "<a class=\"nav-link\" href=\"produtos\" method=\"get\">Produtos</a>";
		form += "</li>";
		form += "<li class=\"nav-item menu_item\">";
		form += "<a class=\"nav-link\">|</a>";
		form += "</li>";
		form += "<li class=\"nav-item menu_item\">";
		form += "<a class=\"nav-link\" href=\"mercados\" method=\"get\">Supermercados</a>";
		form += "<li class=\"nav-item menu_item\">";
		form += "<a class=\"nav-link\">|</a>";
		form += "</li>";
		form += "<li class=\"nav-item menu_item\">";
		form += "<a class=\"nav-link\" href=\"login\" method=\"get\">Login</a>";
		form += "</li>";
		form += "</ul>";
		form += "</div>";
		form += "</nav>";
		form += "</header>";
		form += "</div>";
		form += "<h1 id=\"valid\">Validação de Produtos</h1>";
		form += "<section class=\"row card_mercado\"  id=\"tela\">";
		// parte da string
		form += "</section>";
		form += "<footer class=\"container footer\">";
		form += "<div class=\"row\">";
		form += "<div class=\"col-12 footer_area\">";
		form += "SmartMarket - Todos os direitos reservados - 2021";
		form += "</div>";
		form += "</div>";
		form += "</footer>";
		form += "</main>";
		form += "</body>";
		form += "</html>";

		String js = "";
		js += "let produtos = [";
		for (int i = 0; i < produtos.length; i++) {
			if (produtos[i] != null) {
				js += "{id: \"" + produtos[i].id + "\", nome: \"" + produtos[i].nome + "\", valor: \""
						+ produtos[i].valor
						+ "\"},";
			} else {
				i = produtos.length;
			}
		}
		js += "{}]; ";
		form = form.replaceFirst("VARIAVEL", js);

		return form;
	}

	public String[] leitura() throws ParseException {
		String[] arquivos = new String[10];
		try (BufferedReader br = new BufferedReader(
				new FileReader("src/main/resources/public/notasFiscais/arquivo.txt"))) {
			int i = 0;
			while ((arquivos[i] = br.readLine()) != null) {
				i++;
			}

		} catch (IOException ex) {
			System.out.println("erro - leitura 1");
		}
		return arquivos;
	}

	public produtoUser[] read(String[] arquivos) throws ParseException {
		String form = "";
		int tamanho = 0;
		int i = 0;
		int pos = 0;

		boolean check = false;
		float valor = 0;
		String line = "";
		String aux = "";
		String local = "src/main/resources/public/notasFiscais/";
		String endereco = "";
		produtoUser[] produtos = new produtoUser[30];
		int id = 0;
		for (i = 0; i < arquivos.length; i++, tamanho++) {
			if (arquivos[i] == null) {
				i = arquivos.length;
				tamanho--;
			}
		}
		i = 0;
		while (i < tamanho) {
			endereco += local + arquivos[i];
			try (BufferedReader br = new BufferedReader(new FileReader(endereco))) {
				line = br.readLine().trim();

				for (int j = 0; j < line.length(); j++) {
					if (line.charAt(j) >= 48 && line.charAt(j) <= 57) {
						aux += line.charAt(j);
					}
				}
				id = Integer.parseInt(aux);

				line = br.readLine().trim();

				line = br.readLine().trim();

				while (!line.equals("<FIM>")) {

					aux = "";
					aux = line;

					line = br.readLine().trim();
					check = false;
					for (int j = 0; j < line.length(); j++) {
						if ((line.charAt(j) >= 48 && line.charAt(j) <= 57) || line.charAt(j) == 46) {
							check = true;
						} else {
							check = false;
							j = line.length();
						}
					}
					if (check == true) {
						valor = Float.parseFloat(line);
						produtoUser product = new produtoUser(id, aux, valor);
						produtos[pos] = product.clone();
						pos++;
					}
					if (line.equals("<FIM>")) {

					} else {
						line = br.readLine();
						line = br.readLine();
					}

				}

			} catch (IOException ex) {
				System.out.println("erro - leitura 2");
			}
			i++;
			endereco = "";
		}

		return produtos;
	}

	public Object getStrings(Request request, Response response) throws ParseException {
		String html = makeFormIndeferidos();

		return html;
	}

	public Object insert(Request request, Response response) {
		String nome = request.queryParams("nome");
		String descricao = request.queryParams("descricao");
		String categoria = request.queryParams("categoria");
		String marca = request.queryParams("marca");
		String unidade = request.queryParams("unidade");
		String imagem = request.queryParams("imagem");

		String resp = "";
		Produto prod = new Produto(++nextId, nome, descricao, categoria, marca, unidade, imagem);

		if (produtoDAO.insert(prod) == true) {
			resp = "produto (" + nome + ") inserido!";
			response.status(201); // 201 Created
		} else {
			resp = "produto (" + nome + ") não inserido!";
			response.status(404); // 404 Not found
		}

		String html = makeFormProduto();
		return html;
	}

	public String makeFormUpdates(boolean status) {
        String form = "";
        if (status == true) {
            form = makeForm();
        } else {

            form += "<!doctype html>";
            form += "<html lang=\"pt-br\">";
            form += "<head>";
            form += "<!-- Required meta tags -->";
            form += "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">";
            form += "<meta charset=\"utf-8\">";
            form += "<title>SmartMarket</title>";
            form += "<!-- Bootstrap CSS -->";
            form += "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css\">";
            form += "<script src=\"https://kit.fontawesome.com/c81b80495f.js\" crossorigin=\"anonymous\"></script>";
            form += "<!-- Meu css -->";
            form += "<script src=\"..\\app.js\"></script>";
            //form += "<script> SUBSTITUIR </script>";
            form += "<link rel=\"stylesheet\" href=\"..\\style.css\">";
            form += "</head>";
            form += "<!--Menu Superior-->";
            form += "<body onLoad=\"isAdmin(),showTelaEditUser(), mostrarBugados()\">";
            form += "<div id=\"menu\">";
            form += "<header class=\"container header\">";
            form += "<nav class=\"navbar navbar-expand-lg navbar-light bg-light menu\">";
            form += "<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSite\">";
            form += "<span class=\"navbar-toggler-icon\"></span>";
            form += "</button>";
            form += "<div class=\"collapse navbar-collapse\" id=\"navbarSite\">";
            form += "<ul class=\"navbar-nav mr-auto\">";
            form += "<li class=\"nav-item name\">";
            form += "<a class=\"nav-link\" href=\"..\\index.html\">SmartMarket</a>";
            form += "</li>";
            form += "<li class=\"nav-item menu_item\">";
            form += "<a class=\"nav-link\" >|</a>";
            form += "</li>";
            form += "<li class=\"nav-item menu_item\">";
            form += "<a class=\"nav-link\" href=\"..\\produtos\" method=\"get\">Produtos</a>";
            form += "</li>";
            form += "<li class=\"nav-item menu_item\">";
            form += "<a class=\"nav-link\">|</a>";
            form += "</li>";
            form += "<li class=\"nav-item menu_item\">";
            form += "<a class=\"nav-link\" href=\"..\\mercados\" method=\"get\">Supermercados</a>";
            form += "<li class=\"nav-item menu_item\">";
            form += "<a class=\"nav-link\">|</a>";
            form += "</li>";
            form += "<li class=\"nav-item menu_item\">";
            form += "<a class=\"nav-link\" href=\"..\\login\" method=\"get\">Login</a>";
            form += "</li>";
            form += "</ul>";
            form += "</div>";
            form += "</nav>";
            form += "</header>";
            form += "</div>";
            form += "<h1 id=\"valid\">Validação de Produtos</h1>";
			form += "<section class=\"row card_mercado\"  id=\"tela\">";
			// parte da string
			form += "</section>";
			form += "<footer class=\"container footer\">";
			form += "<div class=\"row\">";
			form += "<div class=\"col-12 footer_area\">";
			form += "SmartMarket - Todos os direitos reservados - 2021";
			form += "</div>";
			form += "</div>";
			form += "</footer>";
			form += "</main>";
			form += "</body>";
			form += "</html>";
        }
        return form;
    }

	public Object update(Request request, Response response) {
        int id = Integer.parseInt(request.queryParams("id"));
        int idP = Integer.parseInt(request.queryParams("produtos"));
        String valor = request.queryParams("valor");
		System.out.println("Mercado: "+id+" prod: "+idP+" valor: "+valor);
        String resp = "";

        Comercializa prod = comercializaDAO.get(id, idP);
		
        boolean status = comercializaDAO.update(prod, valor);
        if ( status == true) {

            resp = "produto (" + idP + ") editado!";
            status = true;
            response.status(201); // 201 Created
        } else {
            resp = "produto (" + idP + ") não editado!";

            response.status(404); // 404 Not found
        }

        String html = makeFormUpdates(status);
        return html;
    }

}
