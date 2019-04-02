
public class CD extends Produto{
	private String gravadora;

	public String getGravadora() {
		return gravadora;
	}

	public void setGravadora(String gravadora) {
		this.gravadora = gravadora;
	}
	
	@Override
	public String toString() {
		return "CD" +
				"Nome: " + getNome() + 
				"Gravadora: " + gravadora + 
				"Codigo de Barras: " + getCodBarras() + 
				"Quantidade: " + getQuantidade() + 
				"Classe: " + getClass() +
				"----------------------";
	}
	
}
