package sticker_java.dia1;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;


public class App {

	public static void main(String[] args) throws IOException, InterruptedException{
		
		//fazer uma conenex�o HTTP e buscar os top 250 filmes
		
		String url= "https://alura-filmes.herokuapp.com/conteudos";//url da api
		URI endereco = URI.create(url);
		HttpClient client = HttpClient.newHttpClient();
		
		//request
		
		HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();
		
		//System.out.println(body);
		
		//pegar s� os dados que interessam(titulo,poster,classifica��o)
		JsonParser parser = new JsonParser();
		List <Map<String,String>> listaDeFilmes = parser.parse(body);
		//System.out.println(listaDeFilmes.size());
		
		System.out.println(listaDeFilmes.size());
		//System.out.println(listaDeFilmes.get(0));
		
		
		//exibir e manipular os dados
		/*
		String CSI = "\u001B[";
        System.out.print (CSI + "31" + "m");
        System.out.print ("Texto vermelho");
        System.out.println (CSI + "m");
		*/
		
		
		for(Map<String,String> filme: listaDeFilmes) {
			System.out.println("#######################################################################");
			System.out.println("Nome do filme");
			System.out.println(filme.get("title"));
			System.out.println("Cartaz do filme ");
			System.out.println(filme.get("image"));
			System.out.println("Nota do filme");
			System.out.println(filme.get("imDbRating"));
			System.out.println("#######################################################################");
			System.out.println(); 
			
		}
		
		 

	}

}
