package Main;
import Pessoas.Funcionario;
import Pessoas.Gerente;
import Pessoas.Assistente;
import Pessoas.Vendedor;

import Util.EntradaTeclado;

import java.io.IOException;
import java.util.ArrayList;


public class Main {
	
	//cria um funcionario escolhido
	static Funcionario criaPessoa(int tipo, String nome, String cpf, double salBase) {
		Funcionario f = null;
		if(tipo == 1) { //Gerente = 1
			f = new Gerente(nome, cpf, salBase); 
		}
		else if(tipo == 2) { //Vendedor = 2
			f = new Vendedor(nome, cpf, salBase);
		}
		else if(tipo == 3) { //Assistente = 3
			f = new Assistente(nome, cpf, salBase);
		}
		return f;
	}
	
	 /**
	 * L� um numero e verifica se a op��o digitada � valida, ou seja, est� dentro do intervalo desejado.
	 * @param menor Menor valor do intervalo que se deseja verificar.
	 * @param maior Maior valor do intervalo que se deseja verificar.
	 * @return Retorna o primeiro valor v�lido digitado pelo usu�rio.
	 */
	public static int checkBetween(int menor, int maior) {
		int valorDigitado = 0;
		do {
			try {
				valorDigitado = EntradaTeclado.leInt();
			} catch (Exception e) {
				System.out.print("Isto n�o � um n�mero. ");
			}
			if(valorDigitado  < menor || valorDigitado > maior) {
				System.out.println("Digite uma op��o v�lida.");
			}
		}while (valorDigitado  < menor || valorDigitado > maior);
		
		return valorDigitado;
	}
	
	// calcula a folha salarial dos todos os funcion�rios e	imprime o valor total.
	static double folhaSalarial(ArrayList<Funcionario> f) {
		double total = 0;
		for(int i = 0; i < f.size(); i++) {
			total += f.get(i).getSalarioBase();
		}
		return total;
	}
	
	
	public static void main (String[] args) throws NumberFormatException, IOException {
		
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		while(true) {
		
			System.out.println("Digite qual funcion�rio deseja adicionar:\n"
					+ "1 - Gerente;\n"
					+ "2 - Vendedor;\n"
					+ "3 - Assistente.\n");	
			int o = checkBetween(1, 3);
			
			System.out.print("CPF: ");
			String cpf = EntradaTeclado.leString();
			int v = Funcionario.verificaCPF(cpf);
			if(v == 0) {
				System.out.print("CPF inv�lido. ");
			}
			else {
				System.out.print("Nome: ");
				String nome = EntradaTeclado.leString();
	
				double salarioB = 1000;
			
				Funcionario f = criaPessoa(o, nome, cpf, salarioB);
				
				funcionarios.add(f);
				System.out.println("===Funcion�rio " + nome + " adicionado com sucesso!===\n");
			}
			
			double total = folhaSalarial(funcionarios);
			System.out.println("Folha salarial: $" + total);
			
		}
	}
}
