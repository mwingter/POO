package Pessoas;

public class Vendedor extends Funcionario{
	double comissao;
	
	//construtor de Vendedor
	public Vendedor(String nome, String cpf, double salarioBase) {
		super(nome, cpf, salarioBase);
		double sal = calculaSalario();
		this.setSalarioBase(sal);
	}	
	
	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}



	double calculaSalario() {
		double sal = getSalarioBase();
		return sal + this.getComissao();
	}

}
