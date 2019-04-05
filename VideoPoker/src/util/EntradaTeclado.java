package util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import excessao.ETException;


/**
 * Esta classe foi desenhada para facilitar a entrada de dados
 * pelo teclado. Basicamente ela implementa funções para
 * ler strings, inteiros e doubles. 
 * Ela não faz verificações se o que foi digitado realmente
 * é o esperado.
 * Todos 
 * @author delamaro
 *
 */
public class EntradaTeclado {
static InputStreamReader isr = new InputStreamReader(System.in);
static BufferedReader br = new BufferedReader(isr);
	
	/**
	 * Le um string digitado pelo teclado, até que seja pressionado
	 * um enter. Ou seja, le a linha toda.
	 * @return o string que foi digitado pelo usuário.
	 * @throws IOException
	 */
	public static String leString() throws IOException {
		String x;
		x = br.readLine();
		return x;

	}

	/**
	 * Le um string do teclado (uma linha toda) e tenta transformá-lo num inteiro. 
	 * Porém não faz qualquer verificação sobre a validade do dado digitado.
	 * @return  o valor inteiro digitado pelo usuário. 
	 * @throws IOException
	 */
	public static int leInt() throws IOException {
		String x = leString();
		return Integer.parseInt(x);
	}

	/**
	 * Le um string do teclado (uma linha toda) e tenta transformá-lo num double. 
	 * Porém não faz qualquer verificação sobre a validade do dado digitado.
	 * @return  o valor double digitado pelo usuário. 
	 * @throws IOException
	 */

	public static double leDouble() throws IOException {
		String x = leString();
		return Double.parseDouble(x);

	}
	
	 /**
	 * Lê um numero e verifica se a opção digitada é valida, ou seja, está dentro do intervalo desejado.
	 * @param menor Menor valor do intervalo que se deseja verificar.
	 * @param maior Maior valor do intervalo que se deseja verificar.
	 * @return Retorna o primeiro valor válido digitado pelo usuário.
	 */
	public static int intBetween(int menor, int maior) throws ETException {
		int valorDigitado = 0;
		do {
			try {
				valorDigitado = EntradaTeclado.leInt();
			} catch (Exception e) {
				//System.out.print("Isto não é um número. ");
				throw new ETException("Isso não é um número.");
			}
			if(valorDigitado  < menor || valorDigitado > maior) {
				//System.out.println("Digite uma opção válida.");
				throw new ETException("Digite uma opção válida.");
			}
		}while (valorDigitado  < menor || valorDigitado > maior);
		
		return valorDigitado;
	}
	
	public static double doubleBetween(double menor, double maior) throws ETException {
		double valorDigitado = 0;
		do {
			try {
				valorDigitado = EntradaTeclado.leDouble();
			} catch (Exception e) {
				//System.out.print("Isto não é um número. ");
				throw new ETException("Isso não é um número.");
			}
			if(valorDigitado  < menor || valorDigitado > maior) {
				//System.out.println("Digite uma opção válida.");
				throw new ETException("Digite uma opção válida.");
			}
		}while (valorDigitado  < menor || valorDigitado > maior);
		
		return valorDigitado;
	}
}
