package test.tempi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import test.personas.Turnista;

public class Giorno {

	private List<Map<String, Object>> listaTurniGiornaliera;
	private Integer numGiorno;
	private static final List<String> turniStandardLavorativi = Arrays.asList("mattina", "pomeriggio", "sera");
	private Map<String,Integer> numeroTurnisti;
	
	public Giorno(Integer numGiorno, Double numDipendentiPerTurno) {
		super();
		this.numGiorno = numGiorno;
		this.listaTurniGiornaliera = new ArrayList<Map<String, Object>>();
	}

	public List<Map<String, Object>> getListaTurniGiornaliera() {
		return listaTurniGiornaliera;
	}

	public void setListaTurniGiornaliera(List<Map<String, Object>> listaTurniGiornaliera) {
		this.listaTurniGiornaliera = listaTurniGiornaliera;
	}

	public Integer getNumGiorno() {
		return numGiorno;
	}

	public void setNumGiorno(Integer numGiorno) {
		this.numGiorno = numGiorno;
	}
	
	

	public Map<String, Integer> getNumeroTurnisti() {
		return numeroTurnisti;
	}

	public void setNumeroTurnisti(Map<String, Integer> numeroTurnisti) {
		this.numeroTurnisti = numeroTurnisti;
	}

	public static List<String> getTurnistandardlavorativi() {
		return turniStandardLavorativi;
	}

	public void istanziaTurniGiornalieri(List<Turnista> listaTurnisti, Double numDipendentiPerTurno) {
		boolean exec = true;
		for (Turnista dip : listaTurnisti) {
			if (dip.getNumeroGiorniLavorati() >= Turnista.getMaxgglavorativi() && exec) { // vincolo 1 - max 18 giorni lavorati
				dip.settaRiposo("R",false);
				exec = false;
			}
			if (dip.getGiorniLavoratiConsecutivi() > Turnista.getMaxgglavoraticonsecutivi() && exec) { // vincolo 2 - max 5 giorni lavorati consecutivi
				dip.settaRiposo("R",false);
				exec = false;
			}

			if (exec) {
				Integer indexNextTurno;

				if (dip.getIndexTurno() == null) { // se è null, significa che è il primo giro
					indexNextTurno = ThreadLocalRandom.current().nextInt(0, MeseLavorativo.patternTurni.size() - 1);
				} else {
					indexNextTurno = dip.getIndexTurno() + 1;
					if (indexNextTurno > MeseLavorativo.patternTurni.size() - 1) {
						indexNextTurno = 0;
					}
				}

				String turnoNext = MeseLavorativo.patternTurni.get(indexNextTurno);
				dip.setIndexTurno(indexNextTurno);
				if (turnoNext.equals("R")) { // vincolo 2 - update giorni lavorati
					dip.settaRiposo(turnoNext,false);
				} else {
					dip.addTurno(turnoNext,true);
				}
			}
			exec = true;
			
			
			this.addTurnoGiorno(dip.getNome(),dip.getTurniMensili().get(dip.getTurniMensili().size()-1));

		}
	}
	
	private void addTurnoGiorno(String nome, String turno){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(nome,turno);
		this.listaTurniGiornaliera.add(map);
		switch(turno){
			case "M":
				if(this.getNumeroTurnisti().containsKey("mattina")){
					Integer numTurnistiMattina = this.getNumeroTurnisti().get("mattina");
					this.getNumeroTurnisti().put("mattina", numTurnistiMattina++);
				}
				else{
					this.getNumeroTurnisti().put("mattina", 1);
				}
				break;
			case "P":
				if(this.getNumeroTurnisti().containsKey("pomeriggio")){
					Integer numTurnistiPomeriggio = this.getNumeroTurnisti().get("pomeriggio");
					this.getNumeroTurnisti().put("pomeriggio", numTurnistiPomeriggio++);
				}
				else{
					this.getNumeroTurnisti().put("pomeriggio", 1);
				}
				break;
			case "N":
				if(this.getNumeroTurnisti().containsKey("sera")){
					Integer numTurnistiSera = this.getNumeroTurnisti().get("sera");
					this.getNumeroTurnisti().put("sera", numTurnistiSera++);
				}
				else{
					this.getNumeroTurnisti().put("sera", 1);
				}
				break;
			default:
				if(this.getNumeroTurnisti().containsKey("altro")){
					Integer altro = this.getNumeroTurnisti().get("altro");
					this.getNumeroTurnisti().put("altro", altro++);
				}
				else{
					this.getNumeroTurnisti().put("altro", 1);
				}
		}
		
	}

	@Override
	public String toString() {
		return "Giorno [listaTurniGiornaliera=" + listaTurniGiornaliera + ", numGiorno=" + numGiorno
				+ ", numeroTurnisti=" + numeroTurnisti + "]";
	}
	
//	private void compensaGiorno(){
//		if(this.numTurnistiMattina>=2 && this.numTurnistiPomeriggio>=2 && this.numTurnistiSera>=2) return;
//		else{
//			//trova il minimo
//			List<Integer> numeriTurni = Arrays.asList(this.numTurnistiMattina,this.numTurnistiPomeriggio,this.numTurnistiSera);
//			Collections.sort(numeriTurni);
//			Integer min = numeriTurni.get(0);
//			//trova il max
//			Integer max = numeriTurni.get(numeriTurni.size()-1);
//			
//		}
//	}

	
	

}
