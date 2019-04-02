
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
		// TODO Auto-generated method stub
		
	}
	

	
	

}
