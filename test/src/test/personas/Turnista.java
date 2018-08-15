package test.personas;

import java.util.ArrayList;
import java.util.List;

public class Turnista extends Dipendente{
	private Integer indexTurno = null;
	private Integer numeroGiorniLavorati = 0;
	private static final Integer maxGGLavorativi = 18;
	private static final Integer maxGGLavoratiConsecutivi = 5;
	private Integer giorniLavoratiConsecutivi = 0;
	private List<String> turniMensili = new ArrayList<String>();
	
	
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
	
	
	public List<String> getTurniMensili() {
		return turniMensili;
	}

	public void setTurniMensili(List<String> turniMensili) {
		this.turniMensili = turniMensili;
	}
	
	public void addTurno(String turno, boolean increase){
		this.turniMensili.add(turno);
		if(increase)
			this.incrementaGiorniLavorati();
	}
	
	public void settaRiposo(String turno, boolean increase){
		this.setGiorniLavoratiConsecutivi(0);
		this.addTurno(turno,increase);
	}

	public void incrementaGiorniLavorati(){
		this.setGiorniLavoratiConsecutivi(this.getGiorniLavoratiConsecutivi() + 1);
		this.setNumeroGiorniLavorati(this.getNumeroGiorniLavorati() + 1);
	}

	@Override
	public String toString() {
		return "Turnista [indexTurno=" + indexTurno + ", numeroGiorniLavorati=" + numeroGiorniLavorati
				+ ", giorniLavoratiConsecutivi=" + giorniLavoratiConsecutivi + ", turniMensili=" + turniMensili + "]";
	}
	
	
	
	

}
