
public class ContaEspecial extends ContaBancaria {
	private double limite;

	public ContaEspecial(String n, double l) {
		super(n);
		limite = l;
	}
	
	@Override
	public void saca(double qto) {
		double s = getSaldo();
		if ( qto > s + limite )
			throw new IllegalArgumentException("Limite excedido para esse saque");
		setSaldo( s - qto );
	}

	@Override
	public void atualiza(double taxa) {
		return;
		//m�todo n�o faz nada
	}
	
	@Override
	public int compareTo(ContaBancaria conta) {
		if( ! (conta instanceof ContaEspecial)) {
			return -1;
		}
		return super.compareTo(conta);
	}
	
	

}
