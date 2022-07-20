package sticker_java.dia1;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;


public class App {

	public static void main(String[] args) throws Exception{
		
		//fazer uma conenexï¿½o HTTP e buscar os top 250 conteudos
		
		/*String url= "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";*///url da api
		String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
		
		
		var http = new ClienteHttp();
		String json = http.buscaDados(url);
		
		
		//pegar sï¿½ os dados que interessam(titulo,poster,classificaï¿½ï¿½o)
		JsonParser parser = new JsonParser();
		List <Map<String,String>> listaDeConteudos= parser.parse(json);
		//System.out.println(listaDeconteudos.size());
		
		//System.out.println(listaDeconteudos.size());
		//System.out.println(listaDeconteudos.get(0));
		
		
		//exibir e manipular os dados
		/*
		String CSI = "\u001B[";
        System.out.print (CSI + "31" + "m");
        System.out.print ("Texto vermelho");
        System.out.println (CSI + "m");
		*/
		
		//imprime todos os conteudos
		
		var geradora = new GeradorDeSticker();
		
		for(int i = 0; i< 3; i++) {
		
			Map<String,String> conteudo = listaDeConteudos.get(i);
			
			//conteudo.get("image")
				String urlImagem = conteudo.get("url").replaceAll("(@+)(.*).jpg","S1.jpg");
				String titulo = conteudo.get("title");
				
				//diretorio "java_Sticker\\src\\img" 
				InputStream inputStream = new URL(urlImagem).openStream();
				String nomeArquivo =   conteudo.get(titulo) + ".png";
				
				
				geradora.cria(inputStream, nomeArquivo);
				
				System.out.println(titulo);
				System.out.println();
				/*
				System.out.println("#######################################################################");
				System.out.println("Nome do conteudo");
				System.out.println(conteudo.get("title"));
				System.out.println("Cartaz do conteudo ");
				System.out.println(conteudo.get("image"));
				System.out.println("Nota do conteudo");
				System.out.println(conteudo.get("imDbRating"));
				System.out.println("#######################################################################");
				System.out.println(); 
				*/
		
		}
		 

	}

}
