
public class Circulo extends FiguraGeometrica {
	private double raio;
	
		
	public double area (double r) {
		//A = pi . r^2
		return 3.14*r*r;
	}
	
	public double perimetro (double r) {
		//P = 2 pi . r
		return 2 * 3.14 * r;
	}
	@Override
	public String toString() {
		String s = "";
		s += "CIRCULO DE RAIO " + this.getRaio() + "\n";
		
		return s;
	}
	
	public double getRaio() {
		return raio;
	}

	public void setRaio(double r) {
		this.raio = r;
	}

}
