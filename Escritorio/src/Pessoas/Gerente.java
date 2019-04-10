package Pessoas;

public class Gerente extends Funcionario{
	
	//Construtor de Gerente
	public Gerente(String nome, String cpf, double salarioBase) {
		super(nome, cpf, salarioBase);
		double sal = calculaSalario();
		this.setSalarioBase(sal);
	}

	double calculaSalario() {
		double sal = getSalarioBase();
		return sal*2;
	}
}
