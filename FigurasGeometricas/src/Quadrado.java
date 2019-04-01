
public class Quadrado extends FiguraGeometrica {
	private double base;
	
	public double area (double l) {
		return l*l/2;
	}
	
	public double perimetro (double l) {
		return 4*l;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

}
