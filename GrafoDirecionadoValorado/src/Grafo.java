import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 * Classe que representa um grafo.  Um grafo é um conjunto de vértices e de arestas.
 * @author Michelle Wingter da Silva
 * @author 10783243
 *
 */
public class Grafo {
	public ArrayList<Aresta> arestas;
	public ArrayList<Vertice> vertices;
	
	double matrizAdj[][];
	
	private Scanner scanner;
	private File inFile;
	
	FileWriter arquivo;
	

	
	public Grafo(String nome) throws FileNotFoundException {
		arestas = new ArrayList<Aresta>();
		vertices = new ArrayList<Vertice>();
		
		inFile = new File(nome);
		scanner = new Scanner(inFile);
		//scanner.useDelimiter("\\p{javaWhitespace}+");
		//scanner.useDelimiter("\\s");
			
		while ( scanner.hasNextLine() ) {
			String a = scanner.next();
			String b = scanner.next();
			String arestaStr = scanner.next();
			
			//System.out.println("a = |" + a + "| e b= |" + b + "| e n = |" + arestaStr + "|" );
			
			//float n = scanner.nextFloat(); //valor da aresta
			
			Vertice v1 = new Vertice(a);
			Vertice v2 = new Vertice(b);
			//se os vertices ainda não estão na lista de vertices, adicionar
			if(contemVerticeNaLista(v1) == false) {
				vertices.add(v1);
			}
			if(contemVerticeNaLista(v2) == false) {
				vertices.add(v2);
			}
			
			double valor = Double.parseDouble(arestaStr);
			Aresta a1 = new Aresta(v1, v2, valor);
			//if(arestas.contains(a1) == false) {
				arestas.add(a1);
			//}
			

							
		 }
			
	}
	
	/**
	 * Função que, dado um vértice inicial, encontra o menor caminho entre ele e todos
	 * os outros vértices. (Algoritmo do caminho mínimo)
	 * @param args
	 */
	public int[] caminho_minimo(int inicio, double[][] ma, int tam){
	    int[] distancias = new int[tam];
	    Queue<Integer> fila = new LinkedList<Integer>();

	    // Inicializando a menor distância de todos os vértices ao inicial como -1
	    for(int i=0; i<tam; i++) {
	    	distancias[i] = -1;
	    }
	        

	    // A distância do vértice inicial a ele mesmo é zero
	    distancias[inicio] = 0;
	    fila.add(inicio);

	    // Executando a busca lateral
	    while(!fila.isEmpty()){
	        int atual = fila.remove();
	        for(int i = 0; i < tam; i++)
	            if(ma[atual][i] != 0 && distancias[i] == -1){
	                distancias[i] = (int) (distancias[atual] + ma[atual][i]);
	                fila.add(i);
	            }
	    }
	    return distancias;
	}
	
	/**
	 * Função que verifica se o vértice dado já existe na lista
	 * @param v vértice
	 * @return true se o vértice já existe, false se não existe
	 */
	public boolean contemVerticeNaLista(Vertice v) {
		for(int i = 0; i < vertices.size(); i++) {
			//System.out.println(v.getNome() + " == " + vertices.get(i).getNome());
			if(v.getNome().compareTo(vertices.get(i).getNome())  == 0) {
				return true; //o vertice v já existe na lista
			}
		}
		return false;
	}
	
	/**
	 * Função que verifica se existe aresta entre dois vertices, retornando o valor da aresta
	 * @param v1 Vertice 1 da aresta
	 * @param v2 Vertice 2 da aresta
	 * @return Valor da aresta se esta existe, 0 se a aresta não existe
	 */
	public double existeAresta(Vertice v1, Vertice v2) {
		for(int i = 0; i < arestas.size(); i++) {
			if((arestas.get(i).getV1().getNome().compareTo(v1.getNome()) == 0 && arestas.get(i).getV2().getNome().compareTo(v2.getNome()) == 0) || (arestas.get(i).getV2().getNome().compareTo(v1.getNome()) == 0 && arestas.get(i).getV1().getNome().compareTo(v2.getNome()) == 0)){ //se a aresta existe
				//System.out.println("Tem aresta! v1 = " + arestas.get(i).getV1().getNome() + ", v2 = " + arestas.get(i).getV2().getNome() + ", valor = " + arestas.get(i).getValor());
				return arestas.get(i).getValor();
			}
		}
		return 0.0;
	}
	
	
	public static void main(String args[]) throws FileNotFoundException {
		Grafo G = new Grafo("Arquivo.txt");
			
		//for(int index = 0; index < G.arestas.size(); index++) {
		//	System.out.println("Aresta: [" + G.arestas.get(index).getV1().getNome() + "] e [" + G.arestas.get(index).getV2().getNome() + "], com valor = " + G.arestas.get(index).getValor());
		//}
		
		//printando a lista de vertices		
		//for(int i = 0; i < G.vertices.size(); i++) {
		//	System.out.println("v[" + i + "] = " + G.vertices.get(i).getNome());
		//}
		
		Vertice va;
		Vertice vb;
		G.matrizAdj=new double[G.vertices.size()][G.vertices.size()];
		
		for(int i = 0; i < G.vertices.size(); i++) {
			for(int j = 0; j < G.vertices.size(); j++) {
				va = G.vertices.get(i);
				vb = G.vertices.get(j);
				//System.out.println("v1 = " + va.getNome() + ", v2 = " + vb.getNome());
				G.matrizAdj[i][j] = G.existeAresta(va, vb);
				//System.out.println("M[" + i + "][" + j + "] = " + G.matrizAdj[i][j]);				
			}		
		}
		
		//int caminho[] = new int[G.vertices.size()];
		//int[] distancia = menor_distancia(0, G.matrizAdj, G.vertices.size());
		
		for(int i = 0; i < G.vertices.size(); i++) {
			int[] distancia = G.caminho_minimo(i, G.matrizAdj, G.vertices.size());
			System.out.println("- O menor caminho entre:");
			for(int j = 0; j < G.vertices.size(); j++) {
				if(i != j && distancia[j] != -1) {
					System.out.println("\t" + G.vertices.get(i).getNome() + " e " + G.vertices.get(j).getNome() + " tem " + distancia[j] + " km de distância.");
				}
				else if(distancia[j] == -1) {
					System.out.println("\t*Não há caminho entre " + G.vertices.get(i).getNome() + " e " + G.vertices.get(j).getNome() + ".*");
				}
			}
			System.out.println("==================================================");
			
		}
	}
	
	
	
}
