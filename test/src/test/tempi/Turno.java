package test.tempi;

import java.util.ArrayList;
import java.util.List;

import test.personas.Turnista;

public class Turno {
	
	private List<Turnista> dipendentiTurnisti;
	private String nomeTurno;
	private static Integer minTurnisti = 2;
	
	public Turno(){
		super();
		this.dipendentiTurnisti = new ArrayList<Turnista>();
	}
	public List<Turnista> getDipendentiTurnisti() {
		return dipendentiTurnisti;
	}
	public void setDipendentiTurnisti(List<Turnista> dipendentiTurnisti) {
		this.dipendentiTurnisti = dipendentiTurnisti;
	}
	public static Integer getMinTurnisti() {
		return minTurnisti;
	}
	public static void setMinTurnisti(Integer minTurnisti) {
		Turno.minTurnisti = minTurnisti;
	}
	public String getNomeTurno() {
		return nomeTurno;
	}
	public void setNomeTurno(String nomeTurno) {
		this.nomeTurno = nomeTurno;
	}
	
	public void addTurnista(Turnista dip){
		this.dipendentiTurnisti.add(dip);
	}
	
	
	
}
