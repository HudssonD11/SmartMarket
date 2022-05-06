package service;
import java.util.List;
import dao.EstabelecimentoDAO;
import model.Estabelecimento;
import spark.Request;
import spark.Response;


public class EstabelecimentoService 
{
    private EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAO();
    private int nextId = estabelecimentoDAO.getLastId();
    private String form;


    public EstabelecimentoService()
    {
    }

    public void makeForm()
    {
        form = "<!doctype html>";
        form += "<html lang=\"pt-br\">        ";
        form += "<head>";
        form += "<!-- Required meta tags -->";
        form += "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">";
        form += "<meta charset=\"utf-8\">";
        form += "<title>SmartMarket</title>";
        form += "<!-- Bootstrap CSS -->";
        form += "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css\">";
        form += "<script src=\"https://kit.fontawesome.com/c81b80495f.js\" crossorigin=\"anonymous\"></script>";
        form += "<!-- Meu css -->";
		form += "<link rel=\"stylesheet\" href=\"..\\style.css\">";
		form += "<script src = \"..\\app.js\"> </script>";
        form += "<script> VARIAVEL ";
        form += "</script>";
        form += "</head>";
        form += "<!--Menu Superior-->";
        form += "<body onLoad=\"mostrarMercados(mercados)\">";
        form += "<header class=\"container header\">";
        form += "<nav class=\"navbar navbar-expand-lg navbar-light bg-light menu\">";
        form += "<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSite\">";
        form += "<span class=\"navbar-toggler-icon\"></span>";
        form += "</button>";
        form += "<div class=\"collapse navbar-collapse\" id=\"navbarSite\">";
        form += "<ul class=\"navbar-nav mr-auto\">";
        form += "<li class=\"nav-item name\">";
        form += "<a class=\"nav-link\" href=\"Index.html\">SmartMarket</a>";
        form += "</li>";
        form += "<li class=\"nav-item menu_item\">";
        form += "<a class=\"nav-link\" >|</a>";
        form += "</li>";
        form += "<li class=\"nav-item menu_item\">";
        form += "<a class=\"nav-link\" href=\"Index.html\">Home</a>";
        form += "</li>";
        form += "<li class=\"nav-item menu_item\">";
        form += "<a class=\"nav-link\" >|</a>";
        form += "</li>";
        form += "<li class=\"nav-item menu_item\">";
        form += "<a class=\"nav-link\" href=\"ListProducts.html\">Produtos</a>";
        form += "</li>";
        form += "<li class=\"nav-item menu_item\">";
        form += "<a class=\"nav-link\">|</a>";
        form += "</li>";
        form += "<li class=\"nav-item menu_item\">";
        form += "<a class=\"nav-link\" href=\"ListMarkets.html\">Supermercados</a>";
        form += "<li class=\"nav-item menu_item\">";
        form += "<a class=\"nav-link\">|</a>";
        form += "</li>";
        form += "<li class=\"nav-item menu_item\">";
        form += "<a class=\"nav-link\" href=\"Login.html\">Login</a>";
        form += "</li>";
        form += "</ul>";
        form += "</div>";
        form += "</nav>";
        form += "</header>";
        form += "<!--1 Bloco com Propagandas-->";
        form += "<section class=\"row publicidade\">";
        form += "<div class=\"col-12 col-sm-12 col-md-12 col-lg-12 publicidade_produtos\">";
        form += "<h1>Propaganda</h1>";
        form += "</div>";
        form += "</section>";
        form += "<section class=\"row search\">";
        form += "<hr>";
        form += "<div class=\"text-center\"><input oninput=\"\" id=\"pesquisaMercado\" placeholder=\"Pesquisar Mercado\" type=\"text\"></div>";
        form += "<hr>";
        form += "</section>";
        form += "<div class=\"row card_mercado\" id=\"tela\">";
        // aqui ficam os mercados
        form += "</div>";
        form += "<div id=\"tela2\">";
        // aqui ficam os mercados
        form += "</div>";
        form += "<footer class=\"container footer\">";
        form += "";
        form += "<div class=\"row\">";
        form += "<div class=\"col-12 footer_area\">";
        form += "SmartMarket - Todos os direitos reservados - 2021";
        form += "</div>";
        form += "</div>";
        form += "</footer>";
        form += "</main>";
        form += "</body>";
        form += "</html>";

        List<Estabelecimento> mercados = estabelecimentoDAO.getOrderByID();

        String js = "";
        js += "let mercados = [";
        for (Estabelecimento e : mercados) 
        {
            js += "{ id: \""+e.getId()+"\", nome: \""+e.getNome()+"\", estado: \""+e.getEstado()+"\", cidade: \""+e.getCidade()
            +"\", bairro: \""+e.getBairro()+"\", rua: \""+e.getRua()+"\", numero: \""+e.getNumero()+"\"},";
        }
        js += "{}];";

		form = form.replaceFirst("VARIAVEL", js);				
    
    }

    public void makeFormByProduct(int idProduct)
    {
        form = "<!doctype html>";
        form += "<html lang=\"pt-br\">        ";
        form += "<head>";
        form += "<!-- Required meta tags -->";
        form += "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">";
        form += "<meta charset=\"utf-8\">";
        form += "<title>SmartMarket</title>";
        form += "<!-- Bootstrap CSS -->";
        form += "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css\">";
        form += "<script src=\"https://kit.fontawesome.com/c81b80495f.js\" crossorigin=\"anonymous\"></script>";
        form += "<!-- Meu css -->";
		form += "<link rel=\"stylesheet\" href=\"..\\style.css\">";
		form += "<script src = \"..\\app.js\"> </script>";
        form += "<script> VARIAVEL ";
        form += "</script>";
        form += "</head>";
        form += "<!--Menu Superior-->";
        form += "<body onLoad=\"mostrarProdutosMercado(mercados)\">";
        form += "<header class=\"container header\">";
        form += "<nav class=\"navbar navbar-expand-lg navbar-light bg-light menu\">";
        form += "<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSite\">";
        form += "<span class=\"navbar-toggler-icon\"></span>";
        form += "</button>";
        form += "<div class=\"collapse navbar-collapse\" id=\"navbarSite\">";
        form += "<ul class=\"navbar-nav mr-auto\">";
        form += "<li class=\"nav-item name\">";
        form += "<a class=\"nav-link\" href=\"Index.html\">SmartMarket</a>";
        form += "</li>";
        form += "<li class=\"nav-item menu_item\">";
        form += "<a class=\"nav-link\" >|</a>";
        form += "</li>";
        form += "<li class=\"nav-item menu_item\">";
        form += "<a class=\"nav-link\" href=\"Index.html\">Home</a>";
        form += "</li>";
        form += "<li class=\"nav-item menu_item\">";
        form += "<a class=\"nav-link\" >|</a>";
        form += "</li>";
        form += "<li class=\"nav-item menu_item\">";
        form += "<a class=\"nav-link\" href=\"ListProducts.html\">Produtos</a>";
        form += "</li>";
        form += "<li class=\"nav-item menu_item\">";
        form += "<a class=\"nav-link\">|</a>";
        form += "</li>";
        form += "<li class=\"nav-item menu_item\">";
        form += "<a class=\"nav-link\" href=\"ListMarkets.html\">Supermercados</a>";
        form += "<li class=\"nav-item menu_item\">";
        form += "<a class=\"nav-link\">|</a>";
        form += "</li>";
        form += "<li class=\"nav-item menu_item\">";
        form += "<a class=\"nav-link\" href=\"Login.html\">Login</a>";
        form += "</li>";
        form += "</ul>";
        form += "</div>";
        form += "</nav>";
        form += "</header>";
        form += "<!--1 Bloco com Propagandas-->";
        form += "<section class=\"row publicidade\">";
        form += "<div id=\"descricao\">";
        //aqui fica a descricao
        form += "</div>";
        form += "</section>";
        form += "<div class=\"row card_mercado\" id=\"tela\">";
        // aqui ficam os mercados
        form += "</div>";
        form += "<div id=\"tela\">";
        // aqui ficam os mercados
        form += "</div>";
        form += "<footer class=\"container footer\">";
        form += "";
        form += "<div class=\"row\">";
        form += "<div class=\"col-12 footer_area\">";
        form += "SmartMarket - Todos os direitos reservados - 2021";
        form += "</div>";
        form += "</div>";
        form += "</footer>";
        form += "</main>";
        form += "</body>";
        form += "</html>";

        List<Estabelecimento> mercados = estabelecimentoDAO.getByProduct(idProduct);

        String js = "";
        js += "let mercados = [";
        for (Estabelecimento e : mercados) 
        {
            js += "{ id: \""+e.getId()+"\", nome: \""+e.getNome()+"\", estado: \""+e.getEstado()+"\", cidade: \""+e.getCidade()
            +"\", bairro: \""+e.getBairro()+"\", rua: \""+e.getRua()+"\", numero: \""+e.getNumero()+"\", preco: \""+e.getPreco()+"\"},";
        }
        js += "{}];";

		form = form.replaceFirst("VARIAVEL", js);				
    
    }

    public Object getAll(Request request, Response response) {
		makeForm();
	    response.header("Content-Type", "text/html");
	    response.header("Content-Encoding", "UTF-8");
		return form;
	}

    public Object getByProduct(Request request, Response response) {
		int idProduct = Integer.parseInt(request.params(":idProduct"));		
		makeFormByProduct(idProduct);
	    response.header("Content-Type", "text/html");
	    response.header("Content-Encoding", "UTF-8");
		return form;
	}

    // Adicionar Estabelecimento
    public String makeFormEstabelecimento()
    {
        form = "<!doctype html>";
        form +="<html lang=\"pt-br\">";
        form +="<head>";
        form +="<!-- Required meta tags -->";
        form +="<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">";
        form +="<meta charset=\"utf-8\">";
        form +="<title>SmartMarket</title>";
        form +="<!-- Bootstrap CSS -->";
        form +="<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css\">";
        form +="<script src=\"https://kit.fontawesome.com/c81b80495f.js\" crossorigin=\"anonymous\"></script>";
        form +="<!-- Meu css -->";
		form += "<link rel=\"stylesheet\" href=\"..\\style.css\">";
		form += "<script src = \"..\\app.js\"> </script>";
        form +="</head>";
        form +="<!--Menu Superior-->";
        form +="<body onload=\"\">";
        form +="<header class=\"container header\">";
        form +="<nav class=\"navbar navbar-expand-lg navbar-light bg-light menu\">";
        form +="<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSite\">";
        form +="<span class=\"navbar-toggler-icon\"></span>";
        form +="</button>";
        form +="<div class=\"collapse navbar-collapse\" id=\"navbarSite\">";
        form +="<ul class=\"navbar-nav mr-auto\">";
        form +="<li class=\"nav-item name\">";
        form +="<a class=\"nav-link\" href=\"Index.html\">SmartMarket</a>";
        form +="</li>";
        form +="<li class=\"nav-item menu_item\">";
        form +="<a class=\"nav-link\" >|</a>";
        form +="</li>";
        form +="<li class=\"nav-item menu_item\">";
        form +="<a class=\"nav-link\" href=\"Index.html\">Home</a>";
        form +="</li>";
        form +="<li class=\"nav-item menu_item\">";
        form +="<a class=\"nav-link\" >|</a>";
        form +="</li>";
        form +="<li class=\"nav-item menu_item\">";
        form +="<a class=\"nav-link\" href=\"ListProducts.html\">Produtos</a>";
        form +="</li>";
        form +="<li class=\"nav-item menu_item\">";
        form +="<a class=\"nav-link\">|</a>";
        form +="</li>";
        form +="<li class=\"nav-item menu_item\">";
        form +="<a class=\"nav-link\" href=\"ListMarkets.html\">Supermercados</a>";
        form +="<li class=\"nav-item menu_item\">";
        form +="<a class=\"nav-link\">|</a>";
        form +="</li>";
        form +="<li class=\"nav-item menu_item\">";
        form +="<a class=\"nav-link\" href=\"Login.html\">Login</a>";
        form +="</li>";
        form +="</ul>";
        form +="</div>";
        form +="</nav>";
        form +="</header>";
        form +="<h1 id=\"valid\">Adicionar Mercado</h1>";
        form +="<section class=\"row card_mercado\" id=\"tela\">";
        form +="<div class=\"col-12 col-sm-12 col-md-6 col-lg-12\">"; 
        form += "<form action=\"mercado/adicionar\" method=\"post\">";  
        form +="<label for=\"username\">Nome</label><br>";
        form +="<input type=\"text\" name=\"nome\" id=\"user\" class=\"form-control\" placeholder=\"Nome do mercado\">";
        form +="<label for=\"username\">Estado</label><br>";
        form +="<input type=\"text\" name=\"estado\" id=\"user\" class=\"form-control\" placeholder=\"Estado do mercado\">";
        form +="<label for=\"username\">Cidade</label><br>";
        form +="<input type=\"text\" name=\"cidade\" id=\"user\" class=\"form-control\" placeholder=\"Cidade do mercado\">";
        form +="<label for=\"username\">Bairro</label><br>";
        form +="<input type=\"text\" name=\"bairro\" id=\"user\" class=\"form-control\" placeholder=\"Bairro do mercado\">";
        form +="<label for=\"username\">Rua</label><br>";
        form +="<input type=\"text\" name=\"rua\" id=\"user\" class=\"form-control\" placeholder=\"Rua do mercado\">";
        form +="<label for=\"username\">Número</label><br>";
        form +="<input type=\"text\" name=\"numero\" id=\"user\" class=\"form-control\" placeholder=\"Número do mercado\">";
        form +="<input type=\"submit\" value=\"Cadastrar\" class=\"btn btn-primary\" id=\"btn-cad\"> </form>";
        form +="</div>";
        form +="</section>";
        form +="<footer class=\"container footer\">";
        form +="<div class=\"row\">";
        form +="<div class=\"col-12 footer_area\">";
        form +="SmartMarket - Todos os direitos reservados - 2021";
        form +="</div>";
        form +="</div>";
        form +="</footer>";
        form +="</body>";
        form +="</html>";
        return form;
    }

    public Object getAdd(Request request, Response response)
    {
        String html = makeFormEstabelecimento();

        return html;
    }

    public Object insert(Request request, Response response) {
		String nome = request.queryParams("nome");
		String estado = request.queryParams("estado");
		String cidade = request.queryParams("cidade");
		String bairro = request.queryParams("bairro");
		String rua = request.queryParams("rua");
        short numero = Short.valueOf(request.queryParams("numero"));
		
		String resp = "";
		Estabelecimento estab = new Estabelecimento(nextId++, nome, estado, cidade, bairro, rua, numero);
		
		if(estabelecimentoDAO.insert(estab) == true) {
            resp = "estabelecimento (" + nome + ") inserido!";
            response.status(201); // 201 Created
		} else {
			resp = "estabelecimento (" + nome + ") não inserido!";
			response.status(404); // 404 Not found
		}
			
		String html = makeFormEstabelecimento();
		return html;
	}
}
