import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ContaPalavra {
	private Map<String, Integer> map;
	private Scanner scanner;
	private File inFile;
	
	public ContaPalavra(String nome) throws FileNotFoundException {
		map = new HashMap<String, Integer>();
		inFile = new File(nome);
		scanner = new Scanner(inFile);
		scanner.useDelimiter("\\W");
	}
	
	   public void criaMapa() 
	   {
	      // processamento texto de entrada 
	      while ( scanner.hasNext() ) // enquanto houver mais entrada
	      {
	         String word = scanner.next().toLowerCase(); // obtém palavra
	                  
	         // se o mapa contiver a palavra
	         if (map.containsKey( word )) // palavra está no mapa
	         {
	            int count = map.get( word ); // obtém contagem atual 
	            map.put( word, count + 1 );// incrementa a contagem de 
	         } // fim do if
	         else 
	            map.put( word, 1 );// adiciona nova palavra com uma contagem de 1 ao mapa
	       } 
	   }
	
	public void mostraMapa() {
		Set<String> keys = map.keySet();
		
		TreeSet<String> sortedKeys = new TreeSet<String>(keys);
		
		System.out.println("Mapa contém: \nChave\t\tValor");
		
		for(String key : sortedKeys) {
			System.out.printf("%-20s%10d\n", key, map.get(key));
		}
	
	}
	
	public static void main(String args[]) throws FileNotFoundException {
		ContaPalavra cp = new ContaPalavra("src/ContaPalavra.java");
		cp.criaMapa();
		cp.mostraMapa();
	}
		
	
}
