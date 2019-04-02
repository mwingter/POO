import java.util.ArrayList;

/*
 *  Crie uma hierarquia de classes para representar os produtos de uma loja: livros, CDs e DVDs.
Um produto � identificado unicamente pelo seu c�digo de barras. Implemente, tamb�m, uma classe
Loja que permite que sejam armazenados os produtos e que permita que possam ser adicionados
produtos (numa certa quantidade), possam ser buscados produtos por c�digo de barras ou por nome
e possam ser vendidos produtos, dado seu c�digo de barras. � desej�vel, tamb�m, uma
funcionalidade que permita verificar todo o estoque da loja, mostrando o n�mero de itens por
produto e por categoria.
*/
public class Loja {
	ArrayList<Produto> produto = new ArrayList<Produto>();
	
	public void armazenar(Produto prod){
		produto.add(prod);
	}
	
	public int buscarPorCod (String cod){
		int i;
		
		for(i = 0; i < produto.size(); i++){
			if(produto.get(i).getCodBarras().compareTo(cod) == 0){
				return i;
			}
		}
		return -1;
	}
	
	public int buscarPorNome (String nome){
		int i;
		
		for(i = 0; i < produto.size(); i++){
			if(produto.get(i).getNome().compareTo(nome) == 0){
				return i;
			}
		}
		return -1;
	}
	
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
