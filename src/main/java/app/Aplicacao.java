package app;

import static spark.Spark.*;
import service.EstabelecimentoService;
import service.UsuarioService;


public class Aplicacao {
	
	private static EstabelecimentoService EstabService = new EstabelecimentoService();
    private static UsuarioService UserService = new UsuarioService();
	
    public static void main(String[] args) {
        port(6789);
        
        staticFiles.location("/public");
        
        //post("/produto/insert", (request, response) -> EstabService.insert(request, response));

        //get("/produto/:id", (request, response) -> EstabService.get(request, response));
        
        //get("/produto/list/:orderby", (request, response) -> EstabService.getAll(request, response));
        
        get("/produto", (request, response) -> EstabService.getAll(request, response));
        get("/login/entrar", (request, response) -> UserService.get(request, response));
        
        //get("/produto/update/:id", (request, response) -> EstabService.getToUpdate(request, response));
        
        //post("/produto/update/:id", (request, response) -> EstabService.update(request, response));
           
        //get("/produto/delete/:id", (request, response) -> EstabService.delete(request, response));

             
    }
}