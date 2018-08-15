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
				Giorno giorno = new Giorno(i,numDipendentiPerTurno);
				
				giorno.istanziaTurniGiornalieri(listaTurnisti, numDipendentiPerTurno);
				
				System.out.println(giorno.toString());
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
	
//	public String stampaMese(){
//		StringBuilder sb = new StringBuilder();
//		sb.append("*****mese*****\n");
//		for (Giorno giorno : listGiorni) {
//			sb.append("giorno numero: ").append(giorno.getNumGiorno()).append("\n");
//			List<Turno> listTurni = giorno.getListaTurniGiornaliera();
//			for (Turno turno : listTurni) {
//				sb.append("******\n");
//				sb.append("nome Turno: ").append(turno.getNomeTurno()).append("\n");
//				sb.append("**turnisti**\n");
//				List<Turnista> turnisti = turno.getDipendentiTurnisti();
//				for (Turnista turnista : turnisti) {
//					sb.append("\nnome: ").append(turnista.getNome()).append(" ggLavoratiConsecutivi: ").append(turnista.getGiorniLavoratiConsecutivi()).append(" ggLavoratiTotali: ").append(turnista.getNumeroGiorniLavorati());
//				}
//			}
//		}
//		
//		return sb.toString();
//		
//	}
	
}
