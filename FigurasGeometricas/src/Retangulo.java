
public class Retangulo extends FiguraGeometrica {
	private double altura;
	private double base;
	
	public double area (double b, double h) {
		return b*h/2;
	}
	
	public double perimetro (double b, double h) {
		return (b*2) + (h*2);
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}
}
