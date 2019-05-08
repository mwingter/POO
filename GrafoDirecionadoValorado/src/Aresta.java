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
	 * @param valor the valor to set
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}

	/**
	 * @return the v1
	 */
	public Vertice getV1() {
		return v1;
	}

	/**
	 * @param v1 the v1 to set
	 */
	public void setV1(Vertice v1) {
		this.v1 = v1;
	}

	/**
	 * @return the v2
	 */
	public Vertice getV2() {
		return v2;
	}

	/**
	 * @param v2 the v2 to set
	 */
	public void setV2(Vertice v2) {
		this.v2 = v2;
	}
	
	/**
	 * Verifica se a aresta dada existe no grafo.
	 * @return 	1 se a aresta existe;
	 * 			0 se a aresta não existe.
	 */
	public int existeAresta(Vertice v1, Vertice v2) {
		if((this.v1 == v1)&&(this.v2 == v2))
			return 1; //existe aresta
		if((this.v1 == v2)&&(this.v2 == v1)) 
			return 1; //existe aresta
		
		return 0; //a aresta não existe
	}
}
