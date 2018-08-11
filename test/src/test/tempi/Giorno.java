package test.tempi;

public class Giorno {
	
	private Turno mattina,pomeriggio,sera;
	private Integer numGiorno;
	
	public Giorno(Integer numGiorno){
		super();
		this.numGiorno = numGiorno;
	}

	public Turno getMattina() {
		return mattina;
	}

	public void setMattina(Turno mattina) {
		this.mattina = mattina;
	}

	public Turno getPomeriggio() {
		return pomeriggio;
	}

	public void setPomeriggio(Turno pomeriggio) {
		this.pomeriggio = pomeriggio;
	}

	public Turno getSera() {
		return sera;
	}

	public void setSera(Turno sera) {
		this.sera = sera;
	}

	public Integer getNumGiorno() {
		return numGiorno;
	}

	public void setNumGiorno(Integer numGiorno) {
		this.numGiorno = numGiorno;
	}
	
	
}
