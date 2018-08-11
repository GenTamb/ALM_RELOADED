package test.tempi;

import java.util.List;

import test.personas.Turnisti;

public class Turno {
	
	private List<Turnisti> dipendentiTurnisti;
	private static Integer minTurnisti = 2;
	
	public List<Turnisti> getDipendentiTurnisti() {
		return dipendentiTurnisti;
	}
	public void setDipendentiTurnisti(List<Turnisti> dipendentiTurnisti) {
		this.dipendentiTurnisti = dipendentiTurnisti;
	}
	public static Integer getMinTurnisti() {
		return minTurnisti;
	}
	public static void setMinTurnisti(Integer minTurnisti) {
		Turno.minTurnisti = minTurnisti;
	}
	
	
	
}
