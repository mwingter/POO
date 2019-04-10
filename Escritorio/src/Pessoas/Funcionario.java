package Pessoas;
import Util.VerificaCPF;


public abstract class Funcionario {
	String nome;
	String CPF;
	double salarioBase;
	
	//construtor de Funcionário
	public Funcionario(String nome, String cpf, double salarioBase) {
		this.nome = nome;
		CPF = cpf;
		this.salarioBase = salarioBase;
	}
		
	public double getSalarioBase() {
		return salarioBase;
	}


	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}


	abstract double calculaSalario();
	
	
	public static int verificaCPF(String s) {
		if(VerificaCPF.isCPF(s)) {
			return 1;
		}
		return 0;
	}



	
	
	
}
