package sticker_java.dia1;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;


public class GeradorDeSticker {
	
		
	public static void main(String[]args) throws IOException {
		var geradora = new GeradorDeSticker();
		geradora.cria();
	}


	void cria() throws IOException {
		//Ler a imagem
		
		//BufferedImage ImagemOriginal =  ImageIO.read(new File("img/cartaz.png"));	
		
		
		
		//InputStream inputStream = new FileInputStream(new File("D:\\Users\\L.A.A\\Downloads\\64d\\workspace\\imers�o_java\\src\\img"));
        InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
        BufferedImage ImagemOriginal = ImageIO.read(inputStream);
		
		
		
		
		//criar uma nova imagem com transparencia e com tamanho novo
		
		int largura = ImagemOriginal.getWidth();//largura
		int altura = ImagemOriginal.getHeight();
		int novaAltura = altura + 200;
		
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);//fundo transparente
		//copiar a imagem original para novo imagem (em mem�ria)
		
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(ImagemOriginal,0,0,null);
		
		//configurar uma nova fonte
		Font fonte = new Font(Font.SANS_SERIF,Font.BOLD,64);
		graphics.setColor(Color.YELLOW);
		graphics.setFont(fonte);
		
		//escrever uma frase na nova imagem 
		graphics.drawString("Mensagem",0, novaAltura - 100);
		
		
		//escrever a nova imagem em um arquivo
		ImageIO.write(novaImagem,"png",new File("imers�o_java/dia1/saida/imagem.png"));
	}

}
