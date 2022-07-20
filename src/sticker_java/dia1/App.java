package sticker_java.dia1;


import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;


public class App {

	public static void main(String[] args) throws Exception{
		
		//fazer uma conenexï¿½o HTTP e buscar os top 250 filmes
		
		String url= "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";//url da api
		URI endereco = URI.create(url);
		HttpClient client = HttpClient.newHttpClient();
		
		//request
		
		HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();
		
		//System.out.println(body);
		
		//pegar sï¿½ os dados que interessam(titulo,poster,classificaï¿½ï¿½o)
		JsonParser parser = new JsonParser();
		List <Map<String,String>> listaDeFilmes = parser.parse(body);
		//System.out.println(listaDeFilmes.size());
		
		//System.out.println(listaDeFilmes.size());
		//System.out.println(listaDeFilmes.get(0));
		
		
		//exibir e manipular os dados
		/*
		String CSI = "\u001B[";
        System.out.print (CSI + "31" + "m");
        System.out.print ("Texto vermelho");
        System.out.println (CSI + "m");
		*/
		
		//imprime todos os filmes
		
		var geradora = new GeradorDeSticker();
		
		for(Map<String,String> filme: listaDeFilmes) {
			
			
			String urlImagem = filme.get("image");
			String titulo = filme.get("title");
			
			
			InputStream inputStream = new URL(urlImagem).openStream();
			String nomeArquivo = titulo + ".png";
			
			
			geradora.cria(inputStream, nomeArquivo);
			
			System.out.println(titulo);
			System.out.println();
			/*
			System.out.println("#######################################################################");
			System.out.println("Nome do filme");
			System.out.println(filme.get("title"));
			System.out.println("Cartaz do filme ");
			System.out.println(filme.get("image"));
			System.out.println("Nota do filme");
			System.out.println(filme.get("imDbRating"));
			System.out.println("#######################################################################");
			System.out.println(); 
			*/
		}
		
		 

	}

}
