import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
	
	public void criaMapa() {
		int ocorrencia = 0;
		String aux;

		while(scanner.hasNext()) {
			aux = scanner.next().toLowerCase();
			if(map.contains(aux)) {
				ocorrencia = map.get(aux);
				ocorrencia++;
				map.put(aux, ocorrencia);			
			}
			else {
				//palavra.add(aux);
				ocorrencia = 1;
				map.put(aux, ocorrencia);
			}			
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
	
	public static void main(String args[]) {
		ContaPalavra cp = new ContaPalavra();
	}
		
	
}
