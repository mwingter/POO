package ListStructure;
/**
 * Classe Par representa um par de dados qualquer
 * @author Michelle Wingter da Silva
 * @author 10783243
 *
 * @param <X> Tipo do primeiro parâmetro da classe Par
 * @param <Y> Tipo do segundo parâmetro da classe Par
 */
public class Par <X,Y> {
	private X dado1;
	private Y dado2;
	
	
	/**
	 * Construtor da classe Par
	 * @param d1 Tipo do primeiro dado.
	 * @param d2 Tipo do segundo dado.
	 */
	public Par(X d1, Y d2) {
		this.dado1 = d1;
		this.dado2 = d2;
	}
	/**
	 * @return the dado1
	 */
	public X getDado1() {
		return dado1;
	}
	/**
	 * @param dado1 the dado1 to set
	 */
	public void setDado1(X dado1) {
		this.dado1 = dado1;
	}
	/**
	 * @return the dado2
	 */
	public Y getDado2() {
		return dado2;
	}
	/**
	 * @param dado2 the dado2 to set
	 */
	public void setDado2(Y dado2) {
		this.dado2 = dado2;
	}
	
	
	
}
