package br.com.app.parser;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.com.app.model.LivroModel;
import br.com.app.util.Utilitarios;

/**
 * Classe responsavel ela conversao do objeto livro.
 * 
 * @author hmiranda
 *
 */
public class LivroParser {

	
	/**
	 * Metodo que converte o objeto livro pra um XML.
	 * 
	 * @param livro
	 */
	public String livroToXml(LivroModel livro) {
		
		String retorno = null;
		
		try {
			
			// Cria uma instancia de JAXBContext responsavel por obter as caracteristicas da classe model
			JAXBContext context = JAXBContext.newInstance(LivroModel.class);
			
		    // Cria a instancai de Marshaller responsavel por manipular o objeto e o xml
			Marshaller marshaller = context.createMarshaller();
			
		    // Habilita a formatacao legivel do XML, sem ela o xml sai em uma linha
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
		    // classe usada para escrita do XML.
			StringWriter sw = new StringWriter();
			
		    // Converte o livro para uma string.
			marshaller.marshal(livro, sw);
			
		    // Salva o xml formatado no objeto de retorno do metodo.
			retorno = sw.toString();			
		} 
			
		catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	/**
	 * Classe que converte o XML para um objeto do tipo Livro.
	 * 
	 * @param xml
	 * @return
	 */
	public LivroModel xmlToLivro (String xml) {
		
		LivroModel retorno = null;
		
		try {			
			
			// Cria uma instancia de JAXBContext responsavel por obter as caracteristicas da classe model			
			JAXBContext	context = JAXBContext.newInstance(LivroModel.class);
			
			// Cria a instancia de Unmarshaller responsavel por manipular o XML e o objeto
			Unmarshaller unmarshaller = context.createUnmarshaller();
		
			// Gera um objeto do tipo f que sera usado para obter os dados XML.
			File f = Utilitarios.salvaTemp(xml);
			
			// Converte o XML salvo no file temporario para o objeto.
			LivroModel livro = (LivroModel) unmarshaller.unmarshal(f);
			
			// Salva a saida
			retorno = livro;
		} 
			
		catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return retorno;		
	}
}