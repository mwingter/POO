
public abstract class ContaPoupanca extends ContaBancaria {
private int vencimento;
	
	public ContaPoupanca(String n, int dia) {
		super(n);
		vencimento = dia;
	}

	public int getVencimento() {
		return vencimento;
	}

	public void setVencimento(int vencimento) {
		this.vencimento = vencimento;
	}

	/* não preciso desse metodo aqui, pq essa classe eh abstrata, entao herda o metodo abstrato da ContaBancaria
	public void atualiza(double taxa) {
		double s = getSaldo();
		setSaldo(s * (1.0 + taxa));
	}
	*/
}
