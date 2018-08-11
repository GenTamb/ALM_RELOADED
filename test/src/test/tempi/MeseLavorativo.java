package test.tempi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import test.personas.Turnista;
import test.personas.Turnisti;

public class MeseLavorativo {
	
	private static final Integer maxGG = 28;
	private List<Giorno> listGiorni = new ArrayList<Giorno>();
	private static List<String> patternTurni = Arrays.asList("M","M","M","R","N","N","N","R","R","P","P","P","R","R");
	public MeseLavorativo(){
		super();
		List<Turnista> list = Turnisti.getListaTurnisti();
		Collections.shuffle(list);
		
		Double numDipendentiPerTurno = new Double(Turnisti.getListaTurnisti().size()/3);
		
		if(numDipendentiPerTurno>=Turno.getMinTurnisti()){
			for (int i = 1; i <= maxGG; i++) {
				Turno mattina = new Turno();
				Turno pomeriggio = new Turno();
				Turno sera = new Turno();
				Giorno giorno = new Giorno(i);
				
				//mattina
				while(mattina.getDipendentiTurnisti().size()<=numDipendentiPerTurno){
					for(Turnista dip : list){
						if(dip.getNumeroGiorniLavorati()>=Turnista.getMaxgglavorativi()){ //vincolo 1 - max 18 giorni lavorati
							continue;
						}
						if(dip.getGiorniLavoratiConsecutivi()>=dip.getGiorniLavoratiConsecutivi()){ //vincolo 2 - max 5 giorni lavorati consecutivi
							continue;
						}
						if(dip.getIndexTurno()==null){
							Integer indexRndTurno = ThreadLocalRandom.current().nextInt(0, MeseLavorativo.patternTurni.size() + 1);
							String turnoRand = MeseLavorativo.patternTurni.get(indexRndTurno);
							dip.setIndexTurno(indexRndTurno);
							if(turnoRand.equals("R")){  //vincolo 2 - update giorni lavorati
								dip.setGiorniLavoratiConsecutivi(0);
							}
							else{
								dip.setGiorniLavoratiConsecutivi(dip.getGiorniLavoratiConsecutivi()+1);
								dip.setNumeroGiorniLavorati(dip.getNumeroGiorniLavorati()+1);
							}
						}
						
						
						
							
					
					}
				}
					
				
				giorno.setMattina(mattina);
				giorno.setPomeriggio(pomeriggio);
				giorno.setSera(sera);
				
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
