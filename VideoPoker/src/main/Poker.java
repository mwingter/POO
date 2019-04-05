package main;
import java.io.IOException;
import carta.Baralho;
import carta.Mao;
import excessao.ETException;
import util.EntradaTeclado;

/**
 * 		VIDEO POKER
 *		O video poker é um jogo de cartas em que o usuário interage com o computador,
 *fazendo apostas e tentando conseguir algumas combinações específicas (as mesmas
 *do poker normal) que lhe dão recompensas, proporcionais ao valor que o jogador
 *apostou.
 *		Cada jogo inicia com o jogador recebendo uma quantidade fixa de créditos (200
 *créditos). 
 *		Cada rodada inicia com o jogador apostando um certo número de créditos,
 *maior que zero e menor ou igual ao número de créditos que possui. 
 *		Feito isso, o jogador recebe cinco cartas e deve tentar fazer uma das combinações 
 *que lhe paguem os prêmios. Para isso, o jogador pode escolher trocar de zero a cinco cartas
 *que recebeu. Em seguida, pode trocar mais uma vez as cartas para alcançar alguma
 *combinação.
 */


/**
 * Administra e roda o jogo.
 * @author Michelle Wingter da Silva
 * @author 10783243
 *
 */
public class Poker {
	/**
	 **************************************************************************************								
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
	 *																					  *
	 **************************************************************************************
	 */
	
	/**
	 * Encontra combinações de uma mão de cartas.
	 * @param m Mão que será verificada.
	 * @return Valor do bônus que a combinação encontrada concede como prêmio
	 */
	public static int premio (Mao m) { //verifica qual será o premio recebido e retorna o valor a ser multiplicado pelo valor da aposta
		if (Mao.royalStraightFlush(m) == 1) {
			System.out.println("Parabéns! Você conseguiu um Royal Straight Flush! :D\n");
			return 200;
		}
		if (Mao.straightFlush(m) == 1) {
			System.out.println("Parabéns! Você conseguiu um Straight Flush! :D\n");
			return 100;
		}
		if(Mao.quadra(m) == 1) {
			System.out.println("Parabéns! Você conseguiu uma Quadra! :D\n");
			return 50;
		}
		if(Mao.fullHand(m) == 1) {
			System.out.println("Parabéns! Você conseguiu uma Full Hand! :D\n");
			return 20;
		}
		if(Mao.flush(m) == 1) {
			System.out.println("Parabéns! Você conseguiu um Flush! :D\n");
			return 10;
		}
		if(Mao.straight(m) == 1) {
			System.out.println("Parabéns! Você conseguiu um Straight! :D\n");
			return 5;
		}
		if(Mao.trinca(m) == 1) {
			System.out.println("Parabéns! Você conseguiu uma Trinca! :D\n");
			return 2;
		}
		if(Mao.doisPares(m) == 1) {
			System.out.println("Parabéns! Você conseguiu Dois Pares! :D\n");
			return 1;
		}
		System.out.println("Que pena! Você não conseguiu nenhuma combinação! :(\n");
		return 0;
	}
	
	public static void main (String [] args) throws IOException {
		System.out.println("~*~*~ BEM VINDO AO VIDEO POKER!!!! ~*~*~\n");
		
		int enter = 0;
		/*
		System.out.println("Digite 1 para começar.\n");
		while (enter != 1) {
			enter = EntradaTeclado.leInt();
			if (enter != 1) System.out.println("Digite 1 para começar.\n");
		}
		*/
			do {
				try {
					System.out.println("Digite 1 para começar.\n");
					enter = EntradaTeclado.intBetween(1, 1);
				}
				catch (ETException e) {
					System.out.println("Valor inválido!");
				}
				
			}
			while(enter != 1);
		
		
		double saldo = 200;
		
		int rodada = 0;
		
		do {
			//--------NOVA RODADA--------
			//criando baralho
			Baralho baralho = new Baralho();
			//embaralhando o baralho
			baralho.embaralha(baralho.size());
			
			//criando mão
			Mao mao = new Mao(baralho);
			
			rodada++;
			System.out.println("\n###### RODADA " + rodada + " ######");	
			System.out.printf("Saldo: $%.2f \n", saldo);
			
			
			//fazendo a aposta
			System.out.println("\nDigite o valor que deseja apostar: ");
			
			double aposta = -1;		
			do {
				try {
					System.out.printf("Digite um valor entre $0,00 e $%.2f.\n$", saldo);
					aposta = EntradaTeclado.doubleBetween(0, saldo);
				}
				catch (ETException e) {
					System.out.println("\nValor inválido.");
				}	
			}while(aposta < 0 || aposta > saldo);
			
			saldo = saldo - aposta;
			

			System.out.println("Suas cartas são: ");
			//printando a mão
	        System.out.print("\n");
			Mao.printaMao(mao);
			
			//PRIMEIRA TROCA
			System.out.println("******PRIMEIRA TROCA****** \n--->Digite quantas cartas deseja tocar (de 0 a 5): ");
			int n = -1;		
			do {
				try {
					System.out.println("Digite um número de 0 a 5.");
					n = EntradaTeclado.intBetween(0, 5);
				}
				catch (ETException e) {
					System.out.println("Valor inválido.");
				}	
			}while(n < 0 || n > 5);
			
			int option;
			for(int i = 0; i < n; i++) {
				System.out.printf("Digite a(s) carta(s) que deseja trocar\n");
				option = -1;
				
				do {
					try {
						System.out.println("Digite um número de 1 a 5.\n");
						option = EntradaTeclado.intBetween(1, 5);
					}
					catch (ETException e) {
						System.out.println("Valor inválido.");
					}	
				}
				while(option < 1 || option > 5);
				
				//trocando a carta escolhida
				baralho.TrocarCarta(mao, option-1);
			}
			
			System.out.println("Sua mão atualizada é: ");
			Mao.printaMao(mao);
			
			
			//SEGUNDA TROCA
			System.out.println("******SEGUNDA TROCA****** \n--->Digite quantas cartas deseja tocar (de 0 a 5): ");
			n = -1;		
			do {
				try {
					System.out.println("Digite um número de 0 a 5.");
					n = EntradaTeclado.intBetween(0, 5);
				}
				catch (ETException e) {
					System.out.println("Valor inválido.");
				}	
			}while(n < 0 || n > 5);
			
			for(int i = 0; i < n; i++) {
				System.out.printf("Digite a(s) carta(s) que deseja trocar\n");
				option = -1;
				
				do {
					try {
						System.out.println("Digite um número de 1 a 5.\n");
						option = EntradaTeclado.intBetween(1, 5);
					}
					catch (ETException e) {
						System.out.println("Valor inválido.");
					}	
				}
				while(option < 1 || option > 5);
				
				//trocando a carta escolhida
				baralho.TrocarCarta(mao, option-1);
			}
			
			System.out.println("Suas mão atualizada é: ");
			Mao.printaMao(mao);
			
			//FIM DA RODADA -- RESULTADOS:
			System.out.println("###### FIM DA RODADA " + rodada + " ######\n");
			int bonus = premio(mao);
			
			saldo = saldo + (aposta * bonus); //atualizando o saldo com o premio ganho
			
			//FIM DA RODADA
						
		}while(saldo > 0);
		
		
		System.out.println("Seu saldo acabou!\n FIM DE JOGO!\n");
		
		
	}
	

}
