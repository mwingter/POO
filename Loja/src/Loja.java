import java.util.ArrayList;

/*
 *  Crie uma hierarquia de classes para representar os produtos de uma loja: livros, CDs e DVDs.
Um produto é identificado unicamente pelo seu código de barras. Implemente, também, uma classe
Loja que permite que sejam armazenados os produtos e que permita que possam ser adicionados
produtos (numa certa quantidade), possam ser buscados produtos por código de barras ou por nome
e possam ser vendidos produtos, dado seu código de barras. É desejável, também, uma
funcionalidade que permita verificar todo o estoque da loja, mostrando o número de itens por
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
			System.out.println("Não há produtos com este Código de barras para remover!\n");
		}
		else{
			produto.remove(index);
			System.out.println("Produto removido!\n");
		}
	}
}
