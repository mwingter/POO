package ListStructure;

/**
 * Implementação de uma Lista Ligada generica
 * @author Michelle Wingter da Silva
 * @author 10783243
 *
 * @param <ELEM> tipo do elemento da lista
 */
public class ListaLigada<ELEM> { //obs: esse tipo F será trocado por tipo Par na hora q criar a lista
	NoLista<ELEM> inicio;
	NoLista<ELEM> fim;
	int tamanho;
	
	/**
	 * Construtor da classe ListaLigada. Cria uma lista vazia
	 */
	public ListaLigada() {
		this.inicio = null; //primeiro item da lista
		this.fim = null; //ultimo item da lista
		this.tamanho = 0;
	}

	/**
	 * @return the inicio
	 */
	public NoLista<ELEM> getInicio() {
		return inicio;
	}

	/**
	 * @return the fim
	 */
	public NoLista<ELEM> getFim() {
		return fim;
	}

	/**
	 * @return the tamanho
	 */
	public int getTamanho() {
		return tamanho;
	}
	
	/**
	 * Função que verifica se a lista está vazia.
	 * @return True se lista vazia, ou false se lista não vazia.
	 */
	public boolean estaVazia() {
		if(this.tamanho == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Insere um elemento no início da lista.
	 * @param elem Elemento a ser inserido na lista
	 */
	public void insere_inicio(ELEM elem) {
		NoLista<ELEM> no = new NoLista<ELEM>(elem, this.inicio);
		this.inicio = no;
		if(this.estaVazia()) {
			this.fim = this.inicio;
		}
		this.tamanho++;
		
	}
	
	/**
	 * Insere um elemento no fim da lista.
	 * @param elem Elemento a ser inserido.
	 */
	public void insere_fim(ELEM elem) {
		if (this.tamanho == 0) {
		      this.insere_inicio(elem);
		} 
		else {
		      NoLista<ELEM> nova = new NoLista<ELEM>(elem, null);
		      this.fim.setProx(nova);
		      this.fim = nova;
		      this.tamanho++;
		}
	}
	
	/**
	 * Remove o primeiro elemento da lista
	 */
	public void remove_inicio() {
		if(this.estaVazia()) {
			throw new IllegalArgumentException("Lista vazia, não há itens para remover.");
		}
		this.inicio = this.inicio.getProx();
		this.tamanho--;
			  
		if (this.estaVazia()) {
			this.fim = null;
		}
	}
	
	
	/**
	 * Remove o último elemento da lista.
	 */
	public void remove_fim() {
		if(this.estaVazia()) {
			throw new IllegalArgumentException("Lista vazia, não há itens para remover.");
		}
		if (this.tamanho == 1) {
			this.remove_inicio();
		} 
		else {
			NoLista<ELEM> anterior = this.fim.getAnterior(this.inicio, this.tamanho); //anterior será o ultimo elemento
			anterior.setProx(null);
			this.fim = anterior;
			this.tamanho--;
		}
	}
	
}
