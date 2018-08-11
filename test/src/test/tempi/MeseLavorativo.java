package test.tempi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import test.personas.Turnista;
import test.personas.Turnisti;

public class MeseLavorativo {
	
	private static final Integer maxGG = 28;
	private List<Giorno> listGiorni = new ArrayList<Giorno>();
	public static List<String> patternTurni = Arrays.asList("M","M","M","R","N","N","N","R","R","P","P","P","R","R");
	public MeseLavorativo(){
		super();
		List<Turnista> listaTurnisti = Turnisti.getListaTurnisti();
		Collections.shuffle(listaTurnisti);
		
		Double numDipendentiPerTurno = new Double(Turnisti.getListaTurnisti().size()/3);
		
		if(numDipendentiPerTurno>=Turno.getMinTurnisti()){
			for (int i = 1; i <= maxGG; i++) {
				Giorno giorno = new Giorno(i);
				
				giorno.istanziaTurniGiornalieri(listaTurnisti, numDipendentiPerTurno);
				
				listGiorni.add(giorno);
				
			}
		}
		else{
			throw new RuntimeException();
		}
	}
	
	
	public List<Giorno> getListGiorni() {
		return listGiorni;
	}
	public void setListGiorni(List<Giorno> listGiorni) {
		this.listGiorni = listGiorni;
	}
	public static Integer getMaxgg() {
		return maxGG;
	}
	
	public static List<String> getPatternTurni() {
		return patternTurni;
	}
	public static void setPatternTurni(List<String> patternTurni) {
		MeseLavorativo.patternTurni = patternTurni;
	}
	
	public static String getTurnoByIndex(int index){
		return MeseLavorativo.patternTurni.get(index);
	}
	
	
}
