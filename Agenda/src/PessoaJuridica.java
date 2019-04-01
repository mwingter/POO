/**
 * A pessoa jurídica possui os seguintes atributos: CNPJ, nome, endereço, email, inscrição estadual,
 *razão social, outros que você achar necessários.
 * @author Michelle Wingter da Silva
 * @author 10783243
 *
 */
public class PessoaJuridica extends ContatoBasico {
	
	private String cnpj;
	private String inscrEstadual;
	private String razaoSocial;
	
	/**
	 * Construtor de Pessoa juridica
	 * @param n Nome
	 * @param end Endereço
	 * @param m Email
	 * @param num CNPJ
	 * @param insc Insrição Estadual
	 * @param razao Razao Social
	 */
	public PessoaJuridica(String n, String end, String m, String num, String insc, String razao) {
		super(n, end, m);
		this.cnpj = num;
		this.inscrEstadual = insc;
		this.razaoSocial = razao;
	}
	
	@Override
	public String toString() {
		String s = "";
		s += "Nome: " + nome + "\n";
		s += "Endereço: " + endereco + "\n";
		s += "E-mail: " + email + "\n";
		s += "CNPJ: " + cnpj + "\n";
		s += "Inscrição Estadual: " + inscrEstadual + "\n";
		s += "Razão Social: " + razaoSocial + "\n";
		s += "xxxxxxxxxxxxxxxxxxxxxxxxxxx";
		
		return s;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscrEstadual() {
		return inscrEstadual;
	}

	public void setInscrEstadual(String inscrEstadual) {
		this.inscrEstadual = inscrEstadual;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	
}
