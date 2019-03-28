import java.util.ArrayList;
//Classe Mao, usada para administrar atributos de uma mão.
/**
 * Administra atributos de uma mão de cartas.
 * @author Michelle Wingter da Silva
 * @author 10783243
 *
 */
public class Mao extends ArrayList<Carta> {
	
	
	/*
	 * ************************************************************************************								
	 * _____________________________COMBINAÇÕES__________________________________________ *
	 *	Combinação 												Prêmio					  *	
	 *	Dois pares 												1 X Valor da aposta		  *
	 *	Trinca 													2 X valor da aposta		  *
	 *	Straight (5 cartas em sequência de naipes diferentes) 	5 X valor da aposta		  *
	 *	Flush (5 cartas do mesmo naipe não seguidas) 			10 X valor da aposta	  *
	 *	Full hand (uma trinca e um par) 						20 X valor da aposta	  *
	 *	Quadra 													50 X valor da aposta	  *
	 *	Straight Flush (5 cartas seguidas do mesmo naipe) 		100 X valor da aposta	  *
	 *	Royal Straight Flush 									200 X valor da aposta	  *
	 *	(5 cartas seguidas do mesmo naipe de 10 até o As) 								  *
	 * ___________________________________________________________________________________*
	 **************************************************************************************
	 */
	
	private static final long serialVersionUID = 1L;

	/**
	 * Conta cartas de valores iguais e armazena no indice (em seus respectivos valores) do vetor.
	 * @param m Mão de cartas a ser contado.
	 * @return count Vetor com a contagem das cartas da mão.
	 */
	public static int[] conta(Mao m) {
		int [] count = new int [13];
		for(int j = 0; j < 13; j++) {
			count[j] = 0;
		}
		for(int k = 0; k < 5; k++) {
			for(int i = 0; i < 13; i++) {
				if(m.get(k).getValor() == Baralho.valores[i]) {
					count[i] ++; 
				}
			}
		}
		return count;
		
	}
	
	/**
	 * Verifica se a mão tem 2 pares.
	 * @param m Mão de cartas a ser verificado.
	 * @return 1 se a mão tiver Dois Pares, 0 se não tiver.
	 */
	public static int doisPares(Mao m) {
		int [] iguais = conta(m);
		int count = 0;
		for(int i = 0; i < 13; i++) {
			if(iguais[i] == 2) {
				count ++;
			}
		}
		if(count == 2) {
			return 1; //tem dois pares
		}
		else {
			return 0; //não tem dois pares
		}
	}

	/**
	 * Verifica se a mão tem uma trinca, ou seja, 3 cartas de mesmo valor (por ex: três J's, ou três 5's).
	 * @param m Mão de cartas a ser verificada.
	 * @return 1 se a mão tiver uma Trinca, ou 0 se não tiver.
	 */
	public static int trinca(Mao m) { 
		
		int [] iguais = conta(m);
		//int count = 0;
		for(int i = 0; i < 13; i++) {
			if(iguais[i] == 3) {
				return 1; //tem trinca
			}
		}
		return 0; //não tem trinca
	}
	
	/**
	 * Verifica se a mão tem uma quadra, ou seja, 4 cartas de mesmo valor (por ex: 4 J's, ou 4 5's).
	 * @param m Mão de cartas a ser verificada.
	 * @return 1 se a mão tiver uma Quadra, ou 0 se não tiver.
	 */
	public static int quadra(Mao m) {
			
		int [] iguais = conta(m);
		//int count = 0;
		for(int i = 0; i < 13; i++) {
			if(iguais[i] == 4) {
				return 1; //tem quadra
			}
		}
		return 0; //não tem quadra
	}
		

	/**
	 * Verifica se a mão tem um Straight (5 cartas em sequencia, de naipes diferentes).
	 * @param m Mão de cartas a ser verificada.
	 * @return 1 se a mão tiver um Straight, e 0 se não tiver.
	 */
	public static int straight(Mao m) {
		//Ordenando as cartas da mão do maior pro menor (As, K, Q, J, 10, 9, 8, 7, 6, 5, 4, 3, 2)
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(m.get(i).getIntValor() < m.get(j).getIntValor()) {
					Carta aux = m.get(i);
					m.set(i, m.get(j));
					m.set(j, aux);
				}
			}
		}
		/*System.out.print("\nMao ordenada\n");
        for (int i = 0; i < 5; i ++) 
            System.out.print(m.get(i).getValor() + m.get(i).getNaipe() + ", "); 
           */
		
        int nCards = 5;
		String a = m.get(4).getValor();
		String b = m.get(0).getValor();
		int seq = 0;
		int dif = 0;
		if(a == "As" && b == "2") {
			seq++;//se a carta a for As e a carta b for 2, a diferença entre elas é 1
			nCards--;
		}
		
		for(int k = 1; k < nCards; k++) {
			dif = (m.get(k).getIntValor()) - (m.get(k-1).getIntValor());
			//System.out.print("\ndif = " + dif);
			if(dif == 1) {
				seq++;
			}
		}
		//System.out.print("\nseq = " + seq);
		if(seq == 4) {
			return 1; //tem straight
		}
		return 0; //não tem straight
	}
	

	/**
	 * Verifica se a mão tem um Flush (5 cartas do mesmo naipe, não em sequência).
	 * @param m Mão de cartas a ser verificada.
	 * @return 1 se a mão tiver um Flush, ou 0 se não.
	 */
	public static int flush(Mao m) {
		for(int i = 1; i < 5; i++) {
			if(m.get(i-1).getNaipe() != m.get(i).getNaipe()) {
				return 0;
			}
		}
		return 1;
	}
	

	/**
	 * Verifica se a mão tem um Straight Flush (5 cartas em sequencia e de mesmo naipe).
	 * @param m Mão de cartas a ser verificada.
	 * @return 1 se a mão tiver um Straight Flush, ou 0 se não.
	 */
	public static int straightFlush(Mao m) {
		if (flush(m) == 1 && straight(m) == 1) {
			return 1;
		}
		return 0;
	}
	
	/**
	 * Verifica se a mão tem um Full Hand (uma trinca e um par)
	 * @param m Mão de cartas a ser verificada.
	 * @return 1 se a mão tiver um Full Hand, ou 0 se não.
	 */
	public static int fullHand(Mao m) {
		int [] iguais = conta(m);
		int temPar = 0;
		int temTrinca = 0;
		for(int i = 0; i < 13; i++) {
			if(iguais[i] == 2) {
				temPar = 1;
			}
			if(iguais[i] == 3) {
				temTrinca = 1;
			}
		}
		if(temPar == 1 && temTrinca == 1) {
			return 1;
		}
		return 0;
	}
	

	/**
	 * Verifica de a mão tem um Royal Straight Flush (5 cartas seguidas, do mesmo naipe, do 10 até o As).
	 * @param m Mão de cartas a ser verificada.
	 * @return 1 se a mão tiver um Royal Straight Flush, ou 0 se não.
	 */
	public static int royalStraightFlush(Mao m) {
		/*System.out.print("\nMao ta ordenada??\n");
        for (int i = 0; i < 5; i ++) 
            System.out.print(m.get(i).getValor() + m.get(i).getNaipe() + ", "); 
		 */
		if(straightFlush(m) == 1) { //se for do mesmo naipe
			if(m.get(0).getValor() == "10" && m.get(4).getValor() == "As") { //se a sequencia começa no 10 e termina no As
				return 1; //é Royal Straigh Flush
			}
		}
		return 0;
	}
	
	/**
	 * Printa as 5 cartas de uma mão.
	 * @param m Mão de cartas a ser printada.
	 */
	public static void printaMao(Mao m) {
		String r = "";  
		String aresta = "+---------------+";    
		String parede = "|";
		//primeira linha
		for(int i = 0; i < 5; i++){
			r += aresta;
			r += "\t";
		}
		r += "\n";
		
		//Valor
		for(int i = 0; i < 5; i++) {
			r += parede + " \t " + m.get(i).getValor() + "\t" + parede;
			r += "\t";	
			
		}
		r += "\n";
		
		//Naipe
		for(int i = 0; i < 5; i++) {
			r += parede + "    " + m.get(i).getNaipe() + "\t" + parede;
			r += "\t";
		}
		r += "\n";
		
		//fim
		for(int i = 0; i < 5; i++){
			r += aresta;
			r += "\t";
		}
		r += "\n";
		
			
		r += "\t" + "(1)" + "\t\t\t" + "(2)" + "\t\t\t" + "(3)" + "\t\t\t" + "(4)" + "\t\t\t" + "(5)" + "\n";
		
		System.out.println(r);
	}
	
	//Construtor da mão
	/**
	 * Cria uma mão de 5 cartas, removendo-as de um baralho.
	 * @param b Baralho de onde serão sacadas as cartas e colocadas na mão.
	 */
	public Mao(Baralho b) {
		super();
		//setCreditos(200);
		b.embaralha(52);
		
		for(int i = 0; i < 5; i++) {
			this.add(b.SacarCarta(i));
		}
		
	}
	/* TESTE
	public static void main (String[] args) {
		Baralho deck = new Baralho();
		//Mao m = new Mao(deck);
		
		//mão montada manualmente:
		Carta c1 = new Carta("K", "Ouros", 11);//String valor, String naipe, int intValor
		Carta c2 = new Carta("10", "Ouros", 8);
		Carta c3 = new Carta("As", "Ouros", 12);
		Carta c4 = new Carta("Q", "Ouros", 10);
		Carta c5 = new Carta("J", "Ouros", 9);
		Mao m2 = new Mao(deck);
		m2.clear();
		m2.add(c1);
		m2.add(c2);
		m2.add(c3);
		m2.add(c4);
		m2.add(c5);
			
		
		//printando a mão
        for (int i = 0; i < 5; i ++) 
            System.out.print(m2.get(i).getValor() + m2.get(i).getNaipe() + ", "); 
        
       // System.out.print("");
        
        int pares = doisPares(m2);
        System.out.print("\nTem dois pares? " + pares);
        
        int trinca = trinca(m2);
        System.out.print("\nTem trinca? " + trinca);
        	
        
        int quadra = quadra(m2);
        System.out.print("\nTem quadra? " + quadra);
        
        int straigh = straight(m2);
        System.out.print("\nTem straight? " + straigh);
        
        int flush = flush(m2);
        System.out.print("\nTem flush? " + flush);
        
        int straightFlush = flush(m2);
        System.out.print("\nTem Straight flush? " + straightFlush);
        
        int fullHand = fullHand(m2);
        System.out.print("\nTem Full Hand? " + fullHand);
        
        int royalStraightFlush = royalStraightFlush(m2);
        System.out.print("\nTem Royal Straight Flush? " + royalStraightFlush);
       
	}
	*/

}
