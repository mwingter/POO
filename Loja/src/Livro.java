
public class Livro extends Produto{
	private String autor;
	private String editora;
	
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditora() {
		return editora;
	}
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
