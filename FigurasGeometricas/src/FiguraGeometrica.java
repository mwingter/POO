import java.io.IOException;

/**
 * Classe que representa as figuras geométricas: círculo, retângulo e quadrado. Para
 * todas elas devem ser implementados métodos para retornar a área e o perímetro. O círculo possui
 * um raio e as outras classes os tamanhos dos lados. Além disso as figuras possuem uma cor, definida
 * por um atributo string e um atributo “filled” que diz se a figura é preenchida pela cor ou se é vazia.
 * @author Michelle Wingter da Silva
 * @author 10783243
 *
 */
public class FiguraGeometrica {
	protected String cor;
	protected int filled;
	FiguraGeometrica fig;
		
	
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public static void main (String[] args) throws NumberFormatException, IOException {
		System.out.println("Escolha a figura geométrica:\n"
							+ "1 - Circulo\n"
							+ "2 - Quadrado\n"
							+ "3 - Retangulo\n");
		int tipo = EntradaTeclado.leInt();
		
		if(tipo == 1) { //circulo
			Circulo c = new Circulo();
			System.out.println("Raio: ");
			c.setRaio(EntradaTeclado.leDouble());
			System.out.println("Cor: ");
			String color = EntradaTeclado.leString();
			c.setCor(color);
			
			System.out.println("\nPerímetro: " + c.perimetro(c.getRaio()) 
								+ "\nÁrea: " + c.area(c.getRaio())
								+ "\nCor: " + c.getCor());
			
		}
		else if(tipo == 2) { //quadrado
			Quadrado q = new Quadrado();
			System.out.println("Base: ");
			q.setBase(EntradaTeclado.leDouble());
			System.out.println("Cor: ");
			String color = EntradaTeclado.leString();
			q.setCor(color);
			
			System.out.println("\nPerímetro: " + q.perimetro(q.getBase()) 
							+ "\nÁrea: " + q.area(q.getBase())
							+ "\nCor: " + q.getCor());
		}
		else if(tipo == 3) { //retangulo
			Retangulo r = new Retangulo();
			System.out.println("Base: ");
			r.setBase(EntradaTeclado.leDouble());
			System.out.println("Altura: ");
			r.setAltura(EntradaTeclado.leDouble());
			System.out.println("Cor: ");
			String color = EntradaTeclado.leString();
			r.setCor(color);
			
			System.out.println("\nPerímetro: " + r.perimetro(r.getBase(), r.getAltura()) 
							+ "\nÁrea: " + r.area(r.getBase(), r.getAltura())
							+ "\nCor: " + r.getCor());
		}
		
	}
	
}
