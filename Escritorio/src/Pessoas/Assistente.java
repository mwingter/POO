package Pessoas;

public class Assistente extends Funcionario {

	public Assistente(String nome, String cpf, double salarioBase) {
		super(nome, cpf, salarioBase);
		double sal = calculaSalario();
		this.setSalarioBase(sal);
	}
	
	double calculaSalario() {
		double sal = getSalarioBase();
		return sal;
	}
}
