
public class PoupancaOuro extends ContaPoupanca{
	double taxa = 1.5;
	
	public PoupancaOuro(String n, int dia) {
		super(n, dia);
		// TODO Auto-generated constructor stub
	}

	public void atualiza(double taxa) {
		double s = getSaldo();
		setSaldo(s * (1.0 + taxa));
	}
}
