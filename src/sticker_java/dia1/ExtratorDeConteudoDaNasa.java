package sticker_java.dia1;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa {
	public List<Conteudo> extraiConteudo(String json){
		
		//extrai somente os contudos que interessam
		JsonParser parser = new JsonParser();
		List <Map<String,String>> listaDeAtributos= parser.parse(json);
		
		List<Conteudo> conteudos = new ArrayList<>(); 
		
		
		//poupular a lista de conteudos
		for (Map<String, String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url");

            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }

        return conteudos;
	}
}
