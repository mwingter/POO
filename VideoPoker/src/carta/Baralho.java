package carta;
import util.Random;

import java.util.ArrayList;


/**
 * Administra atributos de um Baralho
 * @author Michelle Wingter da Silva
 * @author 10783243
 *
 */
public class Baralho extends ArrayList<Carta>{

	private static final long serialVersionUID = 1L;

	//Nomes dos naipes das cartas
	public static String [] naipes = {"Copas", "Ouros", "Espadas", "Paus"};
	
	//Nomes dos numeros das cartas
	public static String [] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "As"};

	
	//public Carta[] baralho = new Carta[52];
	
	//ArrayList<Carta> baralho = new ArrayList<Carta>(52);
	
	
	
	/**
	 * Embaralha um baralho.
	 * @param numCartas Número de cartas contidas no baralho a ser embaralhado.
	 */
	public void embaralha (int numCartas) {
		Random rand = new Random();
		 for(int i = 0; i < numCartas; i++) {
			 int x = rand.getIntRand(numCartas);
			 int y = rand.getIntRand(numCartas);
			 
			 Carta aux = this.get(x);
			 this.set(x, this.get(y));
			 this.set(y, aux);
			 
		 }
	}
	
	/**
	 * Saca uma carta de um baralho, removendo-a deste.
	 * @param index Índice da carta a ser sacada no baralho.
	 * @return A carta sacada.
	 */
	public Carta SacarCarta(int index) {
		Carta cartaSacada = this.get(index);
		this.remove(index);
	
		return cartaSacada;
	}
	
	//Metodo TrocarCarta: 
	/**
	 * Saca uma carta do baralho e a insere na mão, no lugar de outra carta, na posição escolhida.
	 * @param m Mão de cartas que será modificada.
	 * @param index Índice da carta que será trocada.
	 */
	public void TrocarCarta(Mao m, int index) {
		Carta nova = this.get(0); //pegando a primeira carta do baralho
		this.remove(0); //removendo a primeira carta do baralho
		m.set(index, nova); //adicionando a primeira carta do baralho na mão no lugar da q tava na posição index	
	}
	
	
	/**
	 * Cria um baralho de 53 cartas, ordenado.
	 */
	public Baralho() {
		super();
		for(int i = 0; i < naipes.length; i++) {
			for(int j = 0; j < valores.length; j++) {
				Carta c = new Carta(valores[j], naipes[i], j);
				this.add(c);
			}
			
		}
	}
	
	
	/* TESTE
    public static void main(String[] args)
    { 
       Baralho deck = new Baralho();
       
       
       

        // Printing all shuffled elements of cards 
   
        for (int i = 0; i < 52; i ++) 
            System.out.print(deck.get(i).getValor() + deck.get(i).getNaipe() + ", "); 
        
        System.out.print("\n");
        
       
        deck.embaralha(52);
       
        
        for (int i = 0; i < 52; i ++) 
            System.out.print(deck.get(i).getValor() + deck.get(i).getNaipe() + ", "); 
          
    } 
	*/
}
