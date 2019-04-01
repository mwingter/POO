/**
 * A classe contato básico possui os atributos básicos de qualquer pessoa fisica ou juridica: nome, endereço, email.
 * @author Michelle Wingter da Silva
 * @author 10783243
 *
 */
public class ContatoBasico {
	protected String nome;
	protected String endereco;
	protected String email;
	
	/**
	 * Construtor de Contato Básico - Cria um contato básico, com nome, endereço e email
	 * @param n Nome
	 * @param end Endereço
	 * @param m Email
	 */
	public ContatoBasico(String n, String end, String m) {
		nome = n;
		endereco = end;
		email = m;
	}

	public String getNome() {
		return nome;
	}
/*
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereço) {
		this.endereco = endereço;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDataNascimento() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEstadoCivil() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getCpf() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getCnpj() {
		// TODO Auto-generated method stub
		return 0;
	}
*/

	public String getCpf() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCnpj() {
		// TODO Auto-generated method stub
		return null;
	}



	
}
