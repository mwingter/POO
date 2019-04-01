import java.util.ArrayList;


/**
 * 		Nessa agenda, contatos podem ser adicionados, removidos, ou pesquisados por nome ou por CPF/CNPJ. 
 * Deve ser possível, também, visualizar todos os contatos da agenda.
 *		Dois tipos de contatos podem fazer parte da agenda: pessoa física e pessoa jurídica.
 * @author Michelle Wingter da Silva
 * @author 10783243
 *
 */
public class Agenda {
	
	/**
	 * Busca contato por CPF ou CNPJ.
	 * @param doc Número do CPF/CNPJ.
	 * @param array Array da agenda de contatos.
	 * @return Index do contato encontrado na agenda, ou -1 caso não encontre.
	 */
	public static int buscaContato(String doc, ArrayList<ContatoBasico> array) {
		int i;
		
		for(i = 0; i < array.size(); i++) {
			if(array.get(i) instanceof PessoaFisica) {
				if(array.get(i).getCpf().compareTo(doc) == 0) {
					//System.out.println("Contato de PF de nome ("+ array.get(i).getNome() 
					//		+") e CPF (" + array.get(i).getCpf() +")encontrado em " + i);
					return i;
				}
			}else {
				if(array.get(i).getCnpj().compareTo(doc) == 0) {
					//System.out.println("Contato de PJ de nome ("+ array.get(i).getNome() 
					//		+") e CNPJ (" + array.get(i).getCnpj() +")encontrado em " + i);
					return i;
				}
			}
		}
		System.out.println("Contato não encontrado!");
		return -1; //pessoa não encontrada
	}
	
	/**
	 * Busca contatos por nome.
	 * @param nome Nome do contato que se deseja encontrar.
	 * @param array Agenda de Contatos.
	 * @return Index do contato encontrado, ou -1 se não encontrar o contato.
	 */
	public static int buscaContatoPorNome(String nome, ArrayList<ContatoBasico> array) {
		int i;
		
		for(i = 0; i < array.size(); i++) {
			if(array.get(i).getNome().compareTo(nome) == 0) {
				//System.out.println("Contato de nome ("+ array.get(i).getNome() +")encontrado em " + i);
				return i;
			}
		}
		System.out.println("Contato não encontrado!");
		return -1; //pessoa não encontrada
	}
	
	/**
	 * Coloca a agenda em ordem crescente de CPF/CNPJ. Além disso, todas as pessoas físicas 
	 * devem aparecer antes das pessoas jurídicas. 
	 * @param array Array da agenda de Pessoas Basicas
	 * @return Array da agenda ordenado
	 */
	public static ArrayList<ContatoBasico> ordenaAgenda(ArrayList<ContatoBasico> array){ 
		
		//arrays list de pessoa fisica e juridica separados
		ArrayList<PessoaFisica> arrayPF = new ArrayList<PessoaFisica>();
		ArrayList<PessoaJuridica> arrayPJ = new ArrayList<PessoaJuridica>();
		
		String strI;
		String strJ;
		
		//Separando o array em dois: um pra pessoa fisica e outro pra pessoa juridica
		for(int i = 0; i < array.size(); i++) {
			if(array.get(i) instanceof PessoaFisica) {
				arrayPF.add((PessoaFisica) array.get(i));
			}else {
				arrayPJ.add((PessoaJuridica) array.get(i));
			}
		}
		
		
		//ordenando o array de Pessoa Fisica por cpf/cnpj
		PessoaFisica aux1;
		for(int i = 0; i < arrayPF.size(); i++) {
			for(int j = 0; j < arrayPF.size() - 1; j++) {
				strI = arrayPF.get(j).getCpf();
				strJ = arrayPF.get(j+1).getCpf();
				if(strJ.compareTo(strI) < 1) { //se o nome(j) <= nome(i)
					aux1 = arrayPF.get(j);
					arrayPF.set(j, arrayPF.get(j+1));
					arrayPF.set(j+1, aux1);
				}
			}
		}
		
		//ordenando o array de Pessoa Juridica por cpf/cnpj
		PessoaJuridica aux2;
		for(int i = 0; i < arrayPJ.size(); i++) {
			for(int j = 0; j < arrayPJ.size() - 1; j++) {
				strI = arrayPJ.get(j).getCnpj();
				strJ = arrayPJ.get(j+1).getCnpj();
				if(strJ.compareTo(strI) < 1) { //se o nome(j) <= nome(i)
					aux2 = arrayPJ.get(j);
					arrayPJ.set(j, arrayPJ.get(j+1));
					arrayPJ.set(j+1, aux2);
				}
			}
		}
		
		int j = 0;
		//passando os arrays de pessoa fisica e juridica ordenados para o vetor original
		for(int i = 0; i < array.size(); i++) {
			//passando primeiro os elementos da Pessoa Fisica
			if(i < arrayPF.size()) {
				array.set(i, arrayPF.get(i));
			}
			else {
				array.set(i, arrayPJ.get(j));
				j++;
			}
		}
	
				
		return array;
	}
	
	/**
	 * Coloca a agenda em ordem crescente de nome. Além disso, todas as pessoas físicas 
	 * devem aparecer antes das pessoas jurídicas. 
	 * @param array Array da agenda de Pessoas Basicas
	 * @return Array da agenda ordenado
	 */
	public static ArrayList<ContatoBasico> ordenaAgendaPorNome(ArrayList<ContatoBasico> array){
		
		String strI;
		String strJ;
		ContatoBasico aux;

		//ordenar por nome
			System.out.println("Ordenando por nome");
			for(int i = 0; i < array.size(); i++) {
				for(int j = 0; j < array.size() - 1; j++) {
					strI = array.get(j).getNome();
					strJ = array.get(j+1).getNome();
					System.out.println("str1: " + strI + " str2: " + strJ);
					if(strJ.compareTo(strI) < 1) { //se o nome(j) <= nome(i)
						aux = array.get(j);
						array.set(j, array.get(j+1));
						array.set(j+1, aux);
					}
				}
			}
		
		return array;
	}
	
	
	public static void printAgenda(ArrayList<ContatoBasico> ag) {
		for(int i = 0; i < ag.size(); i++) {
			System.out.println("Printando contato " + i);
			System.out.println(ag.get(i).toString() + "\n");
			
		}
	}

}
