//Classe Carta, usada para administrar atributos de uma carta.
/**
 * Administra atributos de uma carta
 * @author Michelle Wingter da Silva
 * @author 10783243
 *
 */
public class Carta {

	//Conteudo de uma carta
	private String valor; //valor da carta em forma de string
	private int valor2; //valor da carta em forma de inteiro
	private String naipe;
	
	/**
	 * 
	 * @return String do valor da carta.
	 */
	public String getValor() {
		return valor;
	}
	
	/**
	 * Define o valor de uma carta.
	 * @param valor String do valor a ser setado na carta.
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	/**
	 * 
	 * @return Inteiro do valor da carta.
	 */
	public int getIntValor() {
		return valor2;
	}
	
	/**
	 * 
	 * @return String do naipe da carta.
	 */
	public String getNaipe() {
		return naipe;
	}
	
	/**
	 * Define o naipe de uma carta
	 * @param naipe String do naipe da carta.
	 */
	public void setNaipe(String naipe) {
		this.naipe = naipe;
	}
		
	//Construtor de carta
	/**
	 * Cria uma carta de baralho.
	 * @param valor String do valor da carta.
	 * @param naipe String do naipe da carta (Ouros, Copas, Paus, Espadas).
	 * @param intValor Inteiro do valor da carta.
	 */
	public Carta(String valor, String naipe, int intValor) {
		this.valor = valor;
		this.naipe = naipe;
		this.valor2 = intValor;
		
		
	}
}
	
	
