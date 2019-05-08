import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * @author Michelle Wingter da Silva
 * @author 10783243
 *
 */
class GrafoTest {
	Grafo G;
	//private double matrizAdj[][];
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		G = new Grafo("Arquivo.txt");
	}

	/**
	 * Test method for Grafo constructor.
	 */
	@Test
	void testGrafo() {
		//Grafo G = new Grafo("Arquivo.txt");
	}

	/**
	 * Test method for {@link Grafo#caminho_minimo()}.
	 */
	@Test
	void testCaminho_minimo() {
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
		
		int[] obtido = G.caminho_minimo(0, G.matrizAdj, G.vertices.size());
		int[] esperado = {0, 36, 28, 34, 69, 141, 234};
		//System.out.println("esperado " + esperado[1]);
		
		for(int i = 0; i < G.vertices.size(); i++) {
			assertEquals(obtido[i], esperado[i]);
		}
		
	}

	/**
	 * Test method for {@link Grafo#contemVerticeNaLista(Vertice)}.
	 */
	@Test
	void testContemVerticeNaListaTrue() {
		Vertice v = new Vertice("Americana");
		boolean esperado = G.contemVerticeNaLista(v);
		
		assertEquals(esperado, true);
	}
	/**
	 * Test method for {@link Grafo#contemVerticeNaLista(Vertice)}.
	 */
	@Test
	void testContemVerticeNaListaFalse() {
		Vertice v = new Vertice("China");
		boolean esperado = G.contemVerticeNaLista(v);
		
		assertEquals(esperado, false);
		
	}

	/**
	 * Test method for {@link Grafo#existeAresta(Vertice, Vertice)}.
	 */
	@Test
	void testExisteArestaYes() {
		Vertice v1 = new Vertice("Americana");
		Vertice v2 = new Vertice("Campinas");
		
		double obtido = G.existeAresta(v1, v2);
		//System.out.println("Valor = " + obtido);
		
		double esperado = 36.0;

		assertEquals(esperado, obtido, 0);
	}
	
	/**
	 * Test method for {@link Grafo#existeAresta(Vertice, Vertice)}.
	 */
	@Test
	void testExisteArestaNo() {
		Vertice v1 = new Vertice("Americana");
		Vertice v2 = new Vertice("China");
		double obtido = G.existeAresta(v1, v2);
		
		//System.out.println("Valor = " + obtido);
		
		double esperado = 0.0;

		assertEquals(esperado, obtido, 0);
	}



}
