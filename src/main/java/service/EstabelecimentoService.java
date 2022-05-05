package service;

import java.util.Scanner;
import java.time.LocalDate;
import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import dao.EstabelecimentoDAO;
import model.Estabelecimento;
import spark.Request;
import spark.Response;


public class EstabelecimentoService 
{
    private EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAO();
    private String form;

    public EstabelecimentoService()
    {
        makeForm();
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
        form += "<link rel=\"stylesheet\" href=\"style.css\">";
        form += "<script src=\"app.js\"></script>";
        form += "<script> VARIAVEL ";
/*        "function mostrarMercados(mercados)"+
        "{"+
        "let tela = document.getElementById('tela2');"+
        "let strHtml = '';"+
    "for(i = 0; i<mercados.length-1; i++)"+
    "{"+
    "strHtml += `<div class=\"col-12 col-sm-12 col-md-6 col-lg-4\">"+
        "<div class=\"mercado\">"+
        "<a href=\"ShowMarket2.html\">"+
            "<h1>${mercados[i].nome}</h1>"+
                "</a>"+
            "<img src=\"img/ApoioMineiro.png\">"+
            "</div>"+
        "</div> `;"+
    "} tela.innerHTML = strHtml; console.log(strHtml);"+
    "}"+"</script>"; */
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

    public Object getAll(Request request, Response response) {
		makeForm();
	    response.header("Content-Type", "text/html");
	    response.header("Content-Encoding", "UTF-8");
		return form;
	}			

}
