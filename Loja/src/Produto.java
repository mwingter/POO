/**
 * Administra atributos de um produto da loja.
 * @author Michelle Wingter da Silva
 * @author 10783243
 *
 */
public class Produto {
	private String codBarras;
	private String nome;
	private int quantidade;
	
	
	public String getCodBarras() {
		return codBarras;
	}
	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
}
