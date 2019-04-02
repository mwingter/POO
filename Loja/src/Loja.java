import java.util.ArrayList;

/*
 *
	*/
/**
 *  Classe Loja:
 * - permite que sejam armazenados os produtos 
 *	-permita que possam ser adicionados produtos (numa certa quantidade), 
 *	-possam ser buscados produtos por c�digo de barras ou por nome
 *	-possam ser vendidos produtos, dado seu c�digo de barras
 * @author Michelle Wingter da Silva
 * @author 10783243
 *
 */
public class Loja {
	ArrayList<Produto> produto = new ArrayList<Produto>();
	
	/**
	 * Adiciona produtos na loja. 
	 * @param prod Produto a ser adicionado.
	 */
	public void armazenar(Produto prod){
		produto.add(prod);
	}
	
	/**
	 * Busca na loja um dado produto atrav�s de seu c�digo de barras.
	 * @param cod C�digo de barras do produto.
	 * @return O indice do produto na loja, ou -1 se n�o encontrado.
	 */
	public int buscarPorCod (String cod){
		int i;
		
		for(i = 0; i < produto.size(); i++){
			if(produto.get(i).getCodBarras().compareTo(cod) == 0){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Busca na loja um dado produto atrav�s de seu nome.
	 * @param cod Nome do produto.
	 * @return O indice do produto na loja, ou -1 se n�o encontrado.
	 */
	public int buscarPorNome (String nome){
		int i;
		
		for(i = 0; i < produto.size(); i++){
			if(produto.get(i).getNome().compareTo(nome) == 0){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Remove um dado produto da loja atrav�s de seu c�digo de barras.
	 * @param cod C�digo de barras do produto.
	 */
	public void removeProduto (String cod){
		int index = buscarPorCod(cod);
		if(index == -1){
			System.out.println("N�o h� produtos com este C�digo de barras para remover!\n");
		}
		else{
			produto.remove(index);
			System.out.println("Produto removido!\n");
		}
	}
}
