import java.io.IOException;

/*
 *  Exercicio: Crie uma hierarquia de classes para representar os produtos de uma loja: livros, CDs e DVDs.
Um produto é identificado unicamente pelo seu código de barras. Implemente, também, uma classe
Loja que permite que sejam armazenados os produtos e que permita que possam ser adicionados
produtos (numa certa quantidade), possam ser buscados produtos por código de barras ou por nome
e possam ser vendidos produtos, dado seu código de barras. É desejável, também, uma
funcionalidade que permita verificar todo o estoque da loja, mostrando o número de itens por
produto e por categoria.
*/

public class Main {

	/**
	 * Menu de opções da loja.
	 * @return A opção escolhida.
	 */
	public static int menu(){
		System.out.println("\nDigite o que deseja fazer:\n"
						+ "1 - Adicionar produto.\n"
						+ "2 - Buscar produto.\n" //por cod de barras ou nome
						+ "3 - Vender produto.\n"
						+ "=========================="); //por cod barras
						
		int op = tryCatch(1, 3);
		return op;
	}
	 
	 /**
	 * Lê um numero e verifica se a opção digitada é valida, ou seja, está dentro do intervalo desejado.
	 * @param menor Menor valor do intervalo que se deseja verificar.
	 * @param maior Maior valor do intervalo que se deseja verificar.
	 * @return Retorna o primeiro valor válido digitado pelo usuário.
	 */
	public static int tryCatch(int menor, int maior) {
		int valorDigitado = 0;
		do {
			try {
				valorDigitado = EntradaTeclado.leInt();
			} catch (Exception e) {
				System.out.print("Isto não é um número. ");
			}
			if(valorDigitado  < menor || valorDigitado > maior) {
				System.out.println("Digite uma opção válida.");
			}
		}while (valorDigitado  < menor || valorDigitado > maior);
		
		return valorDigitado;
	}
	
	public static void main (String[] args) throws IOException{
		int option;
		
		Loja loja = new Loja();
		
		while(true){
			option = menu();
			if(option == 1){ //ADICIONAR
				/*System.out.println("Tipo de produto:\n"
								+ "1 - Livro.\n"
								+ "2 - CD.\n"
								+ "3 - DVD.\n");
				int tipo = tryCatch(1, 3);*/
				System.out.println("Nome: ");
				String nome = EntradaTeclado.leString();
				System.out.println("Código de Barras: ");
				String CB = EntradaTeclado.leString();
				System.out.println("Quantidade: ");
				int qtd = EntradaTeclado.leInt();
				
				Produto p = new Produto();
				p.setNome(nome);
				p.setCodBarras(CB);
				p.setQuantidade(qtd);
				loja.armazenar(p);
				
			}
			else if(option == 2){ //BUSCAR
				System.out.println("Digite 1 para buscar por nome, ou 2 para buscar por Código de Barras do produto.");
				int opt = tryCatch(1, 2);
				int index;
				if(opt == 1){
					System.out.println("Nome: ");
					String nome = EntradaTeclado.leString();
					index = loja.buscarPorNome(nome);
				}
				else{
					System.out.println("Código de Barras: ");
					String CB = EntradaTeclado.leString();
					index = loja.buscarPorCod(CB);
				}
				
				if(index == -1){
					System.out.println("Produto não encontrado!");
				}else{
					String s = loja.produto.get(index).toString();
					System.out.println(s);
				}
				
			}
			else{ //VENDER
				System.out.println("Código de barras: ");
				String CB = EntradaTeclado.leString();
				loja.removeProduto(CB);
			}
		}
		
	}
}
