package br.com.app.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "livro")
public class LivroModel {
	
	private Long id;
	private String nome;
	private String autor;
	private String editora;
	private String isbn;
	
	public LivroModel() {
		super();
	}

	public LivroModel(Long id, String nome, String autor, String editora, String isbn) {
		super();
		this.id = id;
		this.nome = nome;
		this.autor = autor;
		this.editora = editora;
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "LivroModel [id=" + id + ", nome=" + nome + ", autor=" + autor + ", editora=" + editora + ", isbn="
				+ isbn + "]";
	}

	public Long getId() {
		return id;
	}

	@XmlElement(name = "id")
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	@XmlElement(name = "titulo")
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	@XmlElement(name = "autor")
	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	@XmlElement(name = "editora")
	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}	
}