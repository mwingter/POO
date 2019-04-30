
public class PoupancaOuro extends ContaPoupanca{
	double taxa = 1.5;
	
	public PoupancaOuro(String n, int dia) {
		super(n, dia);
		// chamo o construtor da super classe
	}

	public void atualiza(double taxa) {
		double s = getSaldo();
		setSaldo(s * (1.0  + 1.5 * taxa));
	}
	
	@Override
	public int compareTo(ContaBancaria conta) {
		if(conta instanceof PoupancaSimples) {
			return -1; //ouro < simples
		}
		else if(conta instanceof ContaEspecial) {
			return 1;
		}
		return super.compareTo(conta);
	}
}
