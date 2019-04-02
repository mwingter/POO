/**
 * Administra atributos de um Livro.
 * @author Michelle Wingter da Silva
 * @author 10783243
 *
 */
public class Livro extends Produto{
	private String autor;
	private String editora;
	
	/**
	 * Retorna o autor do Livro.
	 * @return String do autor do livro.
	 */
	public String getAutor() {
		return autor;
	}
	
	/**
	 * Define o autor do livro.
	 * @param autor String do autor do livro.
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	/**
	 * Retorna a String da editora do livro.
	 * @return String da editora do livro.
	 */
	public String getEditora() {
		return editora;
	}
	
	/**
	 * Define a editora do livro.
	 * @param editora String da editora do livro.
	 */
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	@Override
	public String toString() {
		return "Livro" +
				"Nome: " + getNome() + 
				"Autor: " + autor + 
				"Editora: " + editora +
				"Codigo de Barras: " + getCodBarras() + 
				"Quantidade: " + getQuantidade() + 
				"Classe: " + getClass() +
				"----------------------";
	}

	
}
