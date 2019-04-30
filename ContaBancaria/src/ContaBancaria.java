/**
 * Representa uma conta bancária genérica.
 * @author delamaro
 *
 */
public abstract class ContaBancaria implements Comparable<ContaBancaria>{

	private String nomeCliente;
	private int numConta;
	private double saldo;
	static private int proxConta = 0;
	
	/**
	 * Construtor. Cria uma conta com saldo 0
	 * @param n Nome do titular da conta
	 * @param num Numero atribuído à conta
	 */
	public ContaBancaria(String n) {
		nomeCliente = n;
		numConta = proxConta++;
		saldo = 0.0;
		//proxConta++;
	}

	/**
	 * Obtem o nome do titular da conta.
	 * @return Nome do titular da conta.
	 */
	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public double getSaldo() {
		return saldo;
	}
	
	protected void setSaldo(double s)
	{
		this.saldo = s;
	}
	
	public void saca(double qto) throws IllegalArgumentException {
		if ( saldo < qto) 
			throw new IllegalArgumentException("Saldo insuficiente para esse saque");
		saldo -= qto;
	}
	
	public void deposita(double qto) {
		saldo += qto;
	}
	
	public abstract void atualiza(double taxa);
	
	public int compareTo(ContaBancaria conta) {
	//se conta � do mesmo tipo
		if(this.getSaldo() < conta.getSaldo()) {
			return -1;
		}
		else if(this.getSaldo() == conta.getSaldo()) {
			return 0;
		}
		else { //if this > conta
			return 1;
		}
	
	}
	

}
