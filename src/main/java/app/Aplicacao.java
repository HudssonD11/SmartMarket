package app;

import static spark.Spark.*;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.servlet.MultipartConfigElement;

import service.EstabelecimentoService;
import service.ProdutoService;
import service.UsuarioService;

import spark.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class Aplicacao {
	
	private static EstabelecimentoService EstabService = new EstabelecimentoService();
    private static UsuarioService UserService = new UsuarioService();
    private static ProdutoService ProdService = new ProdutoService();
	
    public static void main(String[] args) {
        port(6789);
        
        staticFiles.location("/public");

        File uploadDir = new File("src/main/resources/public/notasFiscais");
//        uploadDir.mkdir();
        
        post("/ocr", (req, res) -> {            
        	Path tempFile = Files.createTempFile(uploadDir.toPath(), "", "");

        	req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));

        	try (InputStream input = req.raw().getPart("uploaded_file").getInputStream()) { // getPart needs to use same "name" as input field in form
        		Files.copy(input, tempFile, StandardCopyOption.REPLACE_EXISTING);
        	}

        	String nome = logInfo(req, tempFile);
        	int idMercado = Integer.parseInt(req.queryParams("mercado")); 
        	
        	try 
        	{
        		Runtime run = Runtime.getRuntime();
        		String comando = "./callOcr "+nome+" "+idMercado;
        		run.exec(comando);
        	} catch(Exception e)
        	{
        		e.getMessage();
        	}
//        	return "<h1>You uploaded this image:<h1><img src='" + tempFile.getFileName() + "'>";
        	return ("<html>"
        			+ "<head>"
        			+ "	<title>Carregando</title>"
        			+ "	<head>"
        			+ "	<meta http-equiv=\"refresh\" content=1;url=\"/RefreshPrices.html\"></head>"
        			+ "	<meta content=\"text/html; charset = UTF-8\" http-equiv=\"content-type\">"
        			+ "<body>"
        			+ "</body>"
        			+ "</html>");
        });
        
        //post("/produto/insert", (request, response) -> EstabService.insert(request, response));

        //get("/produto/:id", (request, response) -> EstabService.get(request, response));
        
        //get("/produto/list/:orderby", (request, response) -> EstabService.getAll(request, response));
        get("/mercados", (request, response) -> EstabService.getAll(request, response));
        get("/mercados/:idEstab", (request, response) -> ProdService.getByEstab(request, response));
        get("/mercado", (request, response) -> EstabService.getAdd(request, response));
        post("/mercado/adicionar", (request, response) -> EstabService.insert(request, response));

        get("/produto", (request, response) -> ProdService.getAdd(request, response));
        get("/produtos", (request, response) -> ProdService.getAll(request, response));
        get("/produtos/:idProduct", (request, response) -> EstabService.getByProduct(request, response));
        post("/produto/adicionar", (request, response) -> ProdService.insert(request, response));
        
        get("/login/entrar", (request, response) -> UserService.get(request, response));
        get("/login", (request, response) -> UserService.getLogin(request, response));
        post("/login/cadastrar", (request, response) -> UserService.insert(request, response));

        get("/edit", (request, response) -> UserService.getEdit(request, response));
        post("/edit/user", (request, response) -> UserService.getEditUser(request, response));
        post("/edit/senha", (request, response) -> UserService.getEditSenha(request, response));
        //get("/produto/update/:id", (request, response) -> EstabService.getToUpdate(request, response));
        
        //post("/produto/update/:id", (request, response) -> EstabService.update(request, response));
           
        //get("/produto/delete/:id", (request, response) -> EstabService.delete(request, response));

             
    }
    
    private static String logInfo(Request req, Path tempFile) throws IOException, ServletException {
        String nome = tempFile.toAbsolutePath() + "";
        return nome;
    }

/*    private static void logInfo(Request req, Path tempFile) throws IOException, ServletException {
        String nome = ("Uploaded file '" + getFileName(req.raw().getPart("uploaded_file")) + "' saved as '" + tempFile.toAbsolutePath() + "'");
    }
*/
    private static String getFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

}