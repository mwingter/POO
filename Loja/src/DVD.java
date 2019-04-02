/**
 * Administra atributos de um DVD.
 * @author Michelle Wingter da Silva
 * @author 10783243
 *
 */
public class DVD extends Produto {
	private String diretor;
	
	/**
	 * Retorna a String do diretor do DVD.
	 * @return String do diretor do DVD.
	 */
	public String getDiretor() {
		return diretor;
	}

	/**
	 * Define o diretor do DVD.
	 * @param diretor String do diretor do DVD.
	 */
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	@Override
	public String toString() {
		return 	"DVD" +
				"Nome: " + getNome() + 
				"Diretor: " + diretor + 
				"Codigo de Barras: " + getCodBarras() + 
				"Quantidade: " + getQuantidade() + 
				"Classe: " + getClass() +
				"----------------------";
	}
	

	
}
