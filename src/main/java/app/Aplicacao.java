package app;

import static spark.Spark.*;
import service.EstabelecimentoService;
import service.ProdutoService;
import service.UsuarioService;
import dao.DAO;


public class Aplicacao {
	
	private static EstabelecimentoService EstabService = new EstabelecimentoService();
    private static UsuarioService UserService = new UsuarioService();
    private static ProdutoService ProdService = new ProdutoService();
	
    public static void main(String[] args) {
        port(6789);
        
        staticFiles.location("/public");
        
        //post("/produto/insert", (request, response) -> EstabService.insert(request, response));

        //get("/produto/:id", (request, response) -> EstabService.get(request, response));
        
        //get("/produto/list/:orderby", (request, response) -> EstabService.getAll(request, response));
        
        get("/mercados", (request, response) -> EstabService.getAll(request, response));
        get("/mercados/:idProduct", (request, response) -> EstabService.getByProduct(request, response));
        //post("/mercados/adicionar", (request, response) -> EstabService.insert(request, response));
        //get("/produto", (request, response) -> EstabService.getAll(request, response));
        get("/produtos", (request, response) -> ProdService.getAll(request, response));
        get("/produtos/:idEstab", (request, response) -> ProdService.getByEstab(request, response));
        //post("/produtos/adicionar", (request, response) -> ProdService.insert(request, response));
        
        get("/login/entrar", (request, response) -> UserService.get(request, response));
        get("/login", (request, response) -> UserService.getLogin(request, response));
        post("/login/cadastrar", (request, response) -> UserService.insert(request, response));
        //get("/produto/update/:id", (request, response) -> EstabService.getToUpdate(request, response));
        
        //post("/produto/update/:id", (request, response) -> EstabService.update(request, response));
           
        //get("/produto/delete/:id", (request, response) -> EstabService.delete(request, response));

             
    }
}