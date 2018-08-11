package test.personas;

public class Dipendente {
	private String nome;
	private String cognome;
	protected Long id;
	
	public Dipendente(){
		super();
	}
	
	public Dipendente(String nome){
		this.setNome(nome);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Dipendente [nome=%s, cognome=%s, id=%s, ]",
				nome, cognome, id);
	}
	
	

}
