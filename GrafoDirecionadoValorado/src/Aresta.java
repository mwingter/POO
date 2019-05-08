/**
 * Classe que representa uma aresta. Um aresta relaciona dois vértices e além disso,
 * possui um custo, ou um valor, sempre maior que zero
 * @author Michelle Wingter da Silva
 * @author 10783243
 *
 */
public class Aresta {
	private double valor;
	private Vertice v1;
	private Vertice v2;
	
	public Aresta(Vertice v1, Vertice v2, double n) {
		super();
		this.v1 = v1;
		this.v2 = v2;
		this.valor = n;
	}

	/**
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}


	/**
	 * @return the v1
	 */
	public Vertice getV1() {
		return v1;
	}


	/**
	 * @return the v2
	 */
	public Vertice getV2() {
		return v2;
	}

}
