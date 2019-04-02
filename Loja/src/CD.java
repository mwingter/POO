/**
 * Administra atributos de um CD.
 * @author Michelle Wingter da Silva
 * @author 10783243
 *
 */
public class CD extends Produto{
	private String gravadora;

	/**
	 * Retorna a String da gravadora do CD.
	 * @return String da gravadora do CD.
	 */
	public String getGravadora() {
		return gravadora;
	}

	/**
	 * Define a gravadora do CD.
	 * @param gravadora String da gravadora do CD.
	 */
	public void setGravadora(String gravadora) {
		this.gravadora = gravadora;
	}
	
	@Override
	public String toString() {
		return "CD" +
				"Nome: " + getNome() + 
				"Gravadora: " + gravadora + 
				"Codigo de Barras: " + getCodBarras() + 
				"Quantidade: " + getQuantidade() + 
				"Classe: " + getClass() +
				"----------------------";
	}
	
}
