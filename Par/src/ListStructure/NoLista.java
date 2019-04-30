package ListStructure;
/**
 * Implementação de um nó de uma Lista ligada genérica
 * @author Michelle Wingter da Silva
 * @author 10783243
 *
 * @param <ELEM> tipo do elemento da lista
 */
public class NoLista<ELEM> {
	ELEM elem;
	NoLista<ELEM> prox;
		
	/**
	 * Construtor da classe NoLista. Cria um nó com os valores dados.
	 * @param elem Valor do elemento do NoLista
	 * @param prox Valor do ponteiro para o proximo elemento da lista
	 */
	public NoLista(ELEM elem, NoLista<ELEM> prox) {
		this.elem = elem;
		this.prox = prox;
	}

	/**
	 * 
	 * @return elem
	 */
	public ELEM getElem() {
		return elem;
	}
	
	/**
	 * 
	 * @return prox
	 */
	public NoLista<ELEM> getProx() {
		return prox;
	}
	
	/**
	 *
	 * @param prox Proximo elemento da lista
	 */
	public void setProx(NoLista<ELEM> prox) {
		this.prox = prox;
	}

	/**
	 * Retorna o elemento anterior ao elemento atual da lista
	 * @param l Primeiro elemento da lista a ser percorrida
	 * @param tam Tamanho da lista a ser percorrida
	 * @return Elemento anterior ao elemento atual da lista
	 */
	public NoLista<ELEM> getAnterior(NoLista<ELEM> l, int tam) {
		NoLista<ELEM> anterior = l; //anterior = inicio da lista
		for (int i = 1; i < tam - 1; i++) {
			anterior = anterior.getProx();
		}
		return anterior;
	}

	
	
	
}
