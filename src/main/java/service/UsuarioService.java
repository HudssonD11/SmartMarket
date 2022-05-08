package service;

import dao.UsuarioDAO;
import model.Usuario;
import spark.Request;
import spark.Response;

public class UsuarioService {
    private UsuarioDAO userDAO = new UsuarioDAO();
    private String form;

    public UsuarioService() {

    }

    public String makeForm(String login, String senha) {
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
        form += "<script src=\"..\\app.js\"></script>";
        form += "<script> SUBSTITUIR </script>";
        form += "<link rel=\"stylesheet\" href=\"..\\style.css\">";
        form += "</head>";
        form += "<!--Menu Superior-->";
        form += "<body onload=\"isAdmin(true, '../login')\">";
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
        form += "<input type=\"text\" name=\"nome\" id=\"user\" class=\"form-control\"placeholder=\"Nome Completo\">";
        form += "<label for=\"username\">Email</label><br>";
        form += "<input type=\"text\" name=\"email\" id=\"user\" class=\"form-control\"placeholder=\"Email\">";
        form += "<label for=\"username\">CPF</label><br>";
        form += "<input type=\"text\" name=\"cpf\" id=\"user\" class=\"form-control\"placeholder=\"CPF\">";
        form += "<label for=\"username\">Usuário</label><br>";
        form += "<input type=\"text\" name=\"login\" id=\"user\" class=\"form-control\"placeholder=\"Usuário\">";
        form += "<label for=\"password\">Senha</label><br>";
        form += "<input type=\"password\" name=\"senha\" id=\"senha\" class=\"form-control\"placeholder=\"Senha\">";
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
        if (user != null) {

            subs = "let user = {login: \"" + user.getLogin() + "\", nome: \"" + user.getNome() + "\", creditos: \""
                    + user.getCreditos() + "\", tipo: \"" + user.getTipo() + "\", CPF: \"" + user.getCPF() + "\"};";
            subs += "\nsetUserLS(user);";
            subs += "\nwindow.location.href = \"../index.html\";";

        } else {
            subs = "alert(\"Login ou senha incorretos tente novamente\")";
            subs += "\nwindow.location.href = \"../login\";";
        }
        form = form.replaceFirst("SUBSTITUIR", subs);
        return form;
    }

    public String makeForm() {
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
        form += "<script src=\"..\\app.js\"></script>";
        form += "<script> setUserLS(null); \nSUBSTITUIR </script>";
        form += "<link rel=\"stylesheet\" href=\"..\\style.css\">";
        form += "</head>";
        form += "<!--Menu Superior-->";
        form += "<body onload=\"isAdmin(true, '../login')\">";
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
        form += "<form action=\"login/cadastrar\" method=\"post\"><label for=\"username\">Nome completo</label><br>";
        form += "<input type=\"text\" name=\"nome\" id=\"user\" class=\"form-control\"placeholder=\"Nome Completo\">";
        form += "<label for=\"username\">Email</label><br>";
        form += "<input type=\"text\" name=\"email\" id=\"user\" class=\"form-control\"placeholder=\"Email\">";
        form += "<label for=\"username\">CPF</label><br>";
        form += "<input type=\"text\" name=\"cpf\" id=\"user\" class=\"form-control\"placeholder=\"CPF\">";
        form += "<label for=\"username\">Usuário</label><br>";
        form += "<input type=\"text\" name=\"login\" id=\"user\" class=\"form-control\"placeholder=\"Usuário\">";
        form += "<label for=\"password\">Senha</label><br>";
        form += "<input type=\"password\" name=\"senha\" id=\"senha\" class=\"form-control\"placeholder=\"Senha\">";
        form += "<input type=\"submit\" value=\"Cadastrar\" class=\"btn btn-primary\" id=\"btn-cad\"> </form>";
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
        return form;
    }

    public String makeFormUser(boolean status) {
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
            form += "<script> SUBSTITUIR </script>";
            form += "<link rel=\"stylesheet\" href=\"..\\style.css\">";
            form += "</head>";
            form += "<!--Menu Superior-->";
            form += "<body onLoad=\"showTelaEditUser()\">";
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
            form += "<!--1 Bloco com Propagandas-->";
            form += "<section class=\"row editUser\">";
            form += "<div class=\"col-12 col-sm-12 col-md-12 col-lg-6\">";
            form += "<h1>Editar Usuário</h1>";
            form += "<div id=\"tela4\">";
            form += "</div>";
            form += "</div>";
            form += "<div class=\"col-12 col-sm-12 col-md-12 col-lg-6\">";
            form += "<div id=\"tela2\">";
            form += "</div>";
            form += "</div>";
            form += "<div class=\"col-12 col-sm-12 col-md-12 col-lg-12\">";
            form += "<br><h1>Produtos Acessados Recentemente</h1>";
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
        }
        return form;
    }

    public Object get(Request request, Response response) {
        String login = request.queryParams("username");
        String senha = request.queryParams("password");
        String html = makeForm(login, senha);

        return html;
    }

    public Object getLogin(Request request, Response response) {
        String html = makeForm();

        return html;
    }

    public Object getEdit(Request request, Response response) {
        String html = makeFormUser(false);

        return html;
    }

    public Object insert(Request request, Response response) {
        String nome = request.queryParams("nome");
        String email = request.queryParams("email");
        String login = request.queryParams("login");
        String senha = request.queryParams("senha");
        String cpf = request.queryParams("cpf");

        String resp = "";

        Usuario user = new Usuario(cpf, nome, login, senha, email, 0, 'n');

        if (userDAO.insert(user) == true) {
            resp = "usuario (" + nome + ") inserido!";
            response.status(201); // 201 Created
        } else {
            resp = "usuario (" + nome + ") não inserido!";
            response.status(404); // 404 Not found
        }

        String html = makeForm();
        return html;
    }

    public Object getEditUser(Request request, Response response) {
        String oldLogin = request.queryParams("username");
        String login = request.queryParams("newusername");
        String senha = request.queryParams("password");
        String resp = "";

        Usuario user = userDAO.getByLogin(oldLogin, senha);
        boolean status = userDAO.updateUser(user, login);
        if ( status == true) {

            resp = "usuario (" + login + ") editado!";
            status = true;
            response.status(201); // 201 Created
        } else {
            resp = "usuario (" + login + ") não editado!";

            response.status(404); // 404 Not found
        }

        String html = makeFormUser(status);
        return html;
    }

    public Object getEditSenha(Request request, Response response) {
        String login = request.queryParams("username");
        String oldSenha = request.queryParams("oldpassword");
        String senha = request.queryParams("password");
        String resp = "";

        Usuario user = userDAO.getByLogin(login, oldSenha);
        boolean status = userDAO.updateSenha(user, senha);
        System.out.println(status);
        if ( status == true) {

            resp = "usuario (" + login + ") editado!";
            status = true;
            response.status(201); // 201 Created
        } else {
            resp = "usuario (" + login + ") não editado!";

            response.status(404); // 404 Not found
        }

        String html = makeFormUser(status);
        return html;
    }

}
