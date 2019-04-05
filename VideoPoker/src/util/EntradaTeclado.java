package util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import excessao.ETException;


/**
 * Esta classe foi desenhada para facilitar a entrada de dados
 * pelo teclado. Basicamente ela implementa fun��es para
 * ler strings, inteiros e doubles. 
 * Ela n�o faz verifica��es se o que foi digitado realmente
 * � o esperado.
 * Todos 
 * @author delamaro
 *
 */
public class EntradaTeclado {
static InputStreamReader isr = new InputStreamReader(System.in);
static BufferedReader br = new BufferedReader(isr);
	
	/**
	 * Le um string digitado pelo teclado, at� que seja pressionado
	 * um enter. Ou seja, le a linha toda.
	 * @return o string que foi digitado pelo usu�rio.
	 * @throws IOException
	 */
	public static String leString() throws IOException {
		String x;
		x = br.readLine();
		return x;

	}

	/**
	 * Le um string do teclado (uma linha toda) e tenta transform�-lo num inteiro. 
	 * Por�m n�o faz qualquer verifica��o sobre a validade do dado digitado.
	 * @return  o valor inteiro digitado pelo usu�rio. 
	 * @throws IOException
	 */
	public static int leInt() throws IOException {
		String x = leString();
		return Integer.parseInt(x);
	}

	/**
	 * Le um string do teclado (uma linha toda) e tenta transform�-lo num double. 
	 * Por�m n�o faz qualquer verifica��o sobre a validade do dado digitado.
	 * @return  o valor double digitado pelo usu�rio. 
	 * @throws IOException
	 */

	public static double leDouble() throws IOException {
		String x = leString();
		return Double.parseDouble(x);

	}
	
	 /**
	 * L� um numero e verifica se a op��o digitada � valida, ou seja, est� dentro do intervalo desejado.
	 * @param menor Menor valor do intervalo que se deseja verificar.
	 * @param maior Maior valor do intervalo que se deseja verificar.
	 * @return Retorna o primeiro valor v�lido digitado pelo usu�rio.
	 */
	public static int intBetween(int menor, int maior) throws ETException {
		int valorDigitado = 0;
		do {
			try {
				valorDigitado = EntradaTeclado.leInt();
			} catch (Exception e) {
				//System.out.print("Isto n�o � um n�mero. ");
				throw new ETException("Isso n�o � um n�mero.");
			}
			if(valorDigitado  < menor || valorDigitado > maior) {
				//System.out.println("Digite uma op��o v�lida.");
				throw new ETException("Digite uma op��o v�lida.");
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
				//System.out.print("Isto n�o � um n�mero. ");
				throw new ETException("Isso n�o � um n�mero.");
			}
			if(valorDigitado  < menor || valorDigitado > maior) {
				//System.out.println("Digite uma op��o v�lida.");
				throw new ETException("Digite uma op��o v�lida.");
			}
		}while (valorDigitado  < menor || valorDigitado > maior);
		
		return valorDigitado;
	}
}
