package test.personas;

public class Turnista extends Dipendente{
	private Integer indexTurno = null;
	private Integer numeroGiorniLavorati = 0;
	private static final Integer maxGGLavorativi = 18;
	private static final Integer maxGGLavoratiConsecutivi = 5;
	private Integer giorniLavoratiConsecutivi = 0;
	
	
	public Turnista(String nome){
		super(nome);
		generateEdInsertId();
	}
	
	private void generateEdInsertId(){
		this.id = new Long(Turnisti.getLastIdInserted()+1);
		Turnisti.addTurnistaToList(this);
	}
	
	public Integer getIndexTurno() {
		return indexTurno;
	}

	public void setIndexTurno(Integer indexTurno) {
		this.indexTurno = indexTurno;
	}

	public Integer getNumeroGiorniLavorati() {
		return numeroGiorniLavorati;
	}

	public void setNumeroGiorniLavorati(Integer numeroGiorniLavorati) {
		this.numeroGiorniLavorati = numeroGiorniLavorati;
	}

	public static Integer getMaxgglavorativi() {
		return maxGGLavorativi;
	}

	public Integer getGiorniLavoratiConsecutivi() {
		return giorniLavoratiConsecutivi;
	}

	public void setGiorniLavoratiConsecutivi(Integer giorniLavoratiConsecutivi) {
		this.giorniLavoratiConsecutivi = giorniLavoratiConsecutivi;
	}

	public static Integer getMaxgglavoraticonsecutivi() {
		return maxGGLavoratiConsecutivi;
	}
	
	
	
	

}
