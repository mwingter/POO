package ListStructure;
import ListStructure.Par;
import ListStructure.ListaLigada;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Michelle Wingter da Silva
 * @author 10783243
 *
 */
class ListaLigadaTest {
	ListaLigada<Par<Integer,Double>> lista;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		lista = new ListaLigada<Par<Integer,Double>>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		lista = null;
	}

	/**
	 * Testa a função getInicio()
	 */
	@Test
	public void testGetInicio() {
		Par<Integer, Double> par2 = new Par<Integer,Double>(2, 2.1);
		lista.insere_fim(par2);
		Par<Integer, Double> par1 = new Par<Integer,Double>(2, 2.1);
		lista.insere_inicio(par1);

		
		Par<Integer, Double> esperado = lista.getInicio().getElem();
		assertEquals(esperado, par1);
	}
	
	/**
	 * Testa a função getFim()
	 */
	@Test
	public void testGetFim() {
		Par<Integer, Double> par1 = new Par<Integer,Double>(2, 2.1);
		lista.insere_inicio(par1);
		Par<Integer, Double> par2 = new Par<Integer,Double>(2, 2.1);
		lista.insere_fim(par2);
		
		Par<Integer, Double> esperado = lista.getFim().getElem();
		assertEquals(esperado, par2);
	}
	
	/**
	 * Testa a função getTamanho()
	 */
	@Test
	public void testGetTamanho() {
		Par<Integer, Double> par1 = new Par<Integer,Double>(2, 2.1);
		lista.insere_inicio(par1);
		Par<Integer, Double> par2 = new Par<Integer,Double>(2, 2.1);
		lista.insere_inicio(par2);
		Par<Integer, Double> par3 = new Par<Integer,Double>(2, 2.1);
		lista.insere_inicio(par3);
		
		int esperado = lista.getTamanho();
		assertEquals(esperado, 3);
	}
	
	/**
	 * Testa a função estaVazia() para o caso em que retorna true
	 */
	@Test
	public void TestEstaVaziaTrue() {
		boolean esperado = lista.estaVazia();
		assertEquals(esperado, true);
	}
	
	/**
	 * Testa a função estaVazia() para o caso em que retorna false
	 */
	@Test
	public void TestEstaVaziaFalse() {
		Par<Integer, Double> par1 = new Par<Integer,Double>(2, 2.1);
		lista.insere_inicio(par1);
		Par<Integer, Double> par2 = new Par<Integer,Double>(2, 2.1);
		lista.insere_fim(par2);
		
		boolean esperado = lista.estaVazia();
		assertEquals(esperado, false);
	}
	
	/**
	 * Testa a função insere_inicio()
	 */
	@Test
	public void TestInsereInicio() {

		Par<Integer, Double> par2 = new Par<Integer,Double>(2, 2.1);
		lista.insere_inicio(par2);
		Par<Integer, Double> par1 = new Par<Integer,Double>(2, 2.1);
		lista.insere_inicio(par1);
		
		Par<Integer, Double> esperado = lista.getInicio().getElem();
		assertEquals(esperado, par1);
	}
	
	/**
	 * Testa a função insere_fim()
	 */
	@Test
	public void TestInsereFim() {

		Par<Integer, Double> par2 = new Par<Integer,Double>(2, 2.1);
		lista.insere_fim(par2);
		Par<Integer, Double> par1 = new Par<Integer,Double>(2, 2.1);
		lista.insere_fim(par1);
		
		Par<Integer, Double> esperado = lista.getFim().getElem();
		assertEquals(esperado, par1);
	}
	
	/**
	 * Testa a função remove_inicio();
	 */
	@Test
	public void TestRemoveInicio() {

		Par<Integer, Double> par2 = new Par<Integer,Double>(2, 2.1);
		lista.insere_fim(par2);
		Par<Integer, Double> par1 = new Par<Integer,Double>(2, 2.1);
		lista.insere_fim(par1);
		
		lista.remove_inicio();
		
		Par<Integer, Double> esperado = lista.getInicio().getElem();
		assertEquals(esperado, par1);
	}
	
	/**
	 * Testa a função remove_inicio() para o caso em remove o unico elemento da lista
	 */
	@Test
	public void TestRemoveInicioUnicoNo() {

		Par<Integer, Double> par1 = new Par<Integer,Double>(2, 2.1);
		lista.insere_fim(par1);
		
		lista.remove_inicio();
		
		NoLista<Par<Integer, Double>> esperado = lista.getInicio();
		assertEquals(esperado, null);
	}
	
	/**
	 * Testa a função remove_inicio(), tentando remover um elemento de uma lista vazia 
	 */
	@Test
	public void testRemoveInicioListaVazia() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> lista.remove_inicio());	
	}
	
	/**
	 * Testa a função remove_fim(), tentando remover um elemento de uma lista vazia 
	 */
	@Test
	public void testRemoveFimListaVazia() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> lista.remove_fim());	
	}
	

	/**
	 * Testa a função remove_fim()
	 */
	@Test
	public void TestRemoveFim() {

		Par<Integer, Double> par2 = new Par<Integer,Double>(2, 2.1);
		lista.insere_fim(par2);
		Par<Integer, Double> par1 = new Par<Integer,Double>(2, 2.1);
		lista.insere_fim(par1);
		
		lista.remove_fim();
		
		Par<Integer, Double> esperado = lista.getFim().getElem();
		assertEquals(esperado, par2);
	}
	
	/**
	 * Testa a função remove_fim() para o caso em que remove o unico elemento da lista
	 */
	@Test
	public void TestRemoveFimUnicoNo() {

		Par<Integer, Double> par1 = new Par<Integer,Double>(2, 2.1);
		lista.insere_fim(par1);
		
		lista.remove_fim();
		
		NoLista<Par<Integer, Double>> esperado = lista.getFim();
		assertEquals(esperado, null);
	}
	

	
	

}
