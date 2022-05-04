package service;

import java.util.Scanner;
import java.time.LocalDate;
import java.io.File;
import java.io.ObjectStreamClass;
import java.time.LocalDateTime;
import java.util.List;
import dao.UsuarioDAO;
import model.Usuario;
import spark.Request;
import spark.Response;


public class UsuarioService 
{
    private UsuarioDAO userDAO = new UsuarioDAO();
    private String form;

    public UsuarioService()
    {

    }

    public void makeForm(String login, String senha)
    {
        String form = "";
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
        form += "<script src=\"app.js\"></script>";
        form += "<script>SUBSTITUIR</script>";
        form += "<link rel=\"stylesheet\" href=\"style.css\">";
        form += "</head>";
        form += "<!--Menu Superior-->";
        form += "</body onload=\"logouAgora()\">";
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
        form += "<section class=\"row log_cad\">";
        form += "<div class=\"col-12 col-sm-12 col-md-12 col-lg-6 login\">";
        form += "<h1>Faça seu login</h1>";
        form += "<div class=\"bloco\">";
        form += "<form action=\"/login/entrar\" method=\"get\">";
        form += "<label for=\"username\">Usuário</label><br>";
        form += "<input type=\"text\" name=\"username\" id=\"box\" class=\"form-control\"placeholder=\"Usuário\">";
        form += "<label for=\"password\">Senha</label><br>";
        form += "<input type=\"password\" name=\"password\" id=\"box\" class=\"form-control\"placeholder=\"Senha\">";
        form += "<input type=\"submit\" value=\"Login\" class=\"btn btn-primary\" id=\"btn-log\">";
        form += "</form>";
        form += "</div>";
        form += "</div>";
        form += "<div class=\"col-12 col-sm-12 col-md-12 col-lg-6 cadastro\">";
        form += "<h1>Cadastre-se</h1>";
        form += "<div class=\"bloco2\">";
        form += "<label for=\"username\">Nome completo</label><br>";
        form += "<input type=\"text\" name=\"username\" id=\"user\" class=\"form-control\"placeholder=\"Nome Completo\">";
        form += "<label for=\"username\">Email</label><br>";
        form += "<input type=\"text\" name=\"username\" id=\"user\" class=\"form-control\"placeholder=\"Email\">";
        form += "<label for=\"username\">CPF</label><br>";
        form += "<input type=\"text\" name=\"username\" id=\"user\" class=\"form-control\"placeholder=\"CPF\">";
        form += "<label for=\"username\">Usuário</label><br>";
        form += "<input type=\"text\" name=\"username\" id=\"user\" class=\"form-control\"placeholder=\"Usuário\">";
        form += "<label for=\"password\">Senha</label><br>";
        form += "<input type=\"password\" name=\"password\" id=\"senha\" class=\"form-control\"placeholder=\"Senha\">";
        form += "<button type=\"button\" class=\"btn btn-primary\" id=\"btn-cad\">Cadastrar</button>";
        form += "</div>";
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

        Usuario user = userDAO.getByLogin(login, senha);
        String subs = "let user = ''; ";
        if(user!=null)
        {
            subs += "user = {login: \""+user.getLogin()+"\", nome: \""+user.getNome()+"\", creditos: \""+user.getCreditos()+"\", tipo: \""+user.getTipo()+"\", CPF: \""+user.getCPF()+"\"};";
        }
        form = form.replaceFirst("SUBSTITUIR", subs);
    }
    
    public Object get(Request request, Response response)
    {
        String login = request.queryParams("username");
        System.out.println(login);
        String senha = request.queryParams("password");
        makeForm(login, senha);
        return form;
    }
}
