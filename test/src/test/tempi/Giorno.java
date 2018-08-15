package test.tempi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import test.personas.Turnista;

public class Giorno {

//	private List<Turno> listaTurniGiornaliera;
	private Integer numGiorno;
	private static final List<String> turniStandardLavorativi = Arrays.asList("mattina", "pomeriggio", "sera");
	private Double numDipendentiPerTurno = null;
	
	public Giorno(Integer numGiorno, Double numDipendentiPerTurno) {
		super();
		this.numGiorno = numGiorno;
		this.numDipendentiPerTurno = numDipendentiPerTurno;
//		this.listaTurniGiornaliera = new ArrayList<Turno>();
	}

//	public List<Turno> getListaTurniGiornaliera() {
//		return listaTurniGiornaliera;
//	}

//	public void setListaTurniGiornaliera(List<Turno> listaTurniGiornaliera) {
//		this.listaTurniGiornaliera = listaTurniGiornaliera;
//	}

	public Integer getNumGiorno() {
		return numGiorno;
	}

	public void setNumGiorno(Integer numGiorno) {
		this.numGiorno = numGiorno;
	}

	public void istanziaTurniGiornalieri(List<Turnista> listaTurnisti, Double numDipendentiPerTurno) {
//		Turno riposo = new Turno();
//		riposo.setNomeTurno("riposo");
//		while (this.listaTurniGiornaliera.size() <= turniStandardLavorativi.size()-1) {
//			Turno turno = new Turno();
//			turno.setNomeTurno(turniStandardLavorativi.get(i-1));

//			while (turno.getDipendentiTurnisti().size() <= numDipendentiPerTurno) {
				for (Turnista dip : listaTurnisti) {
					if (dip.getNumeroGiorniLavorati() >= Turnista.getMaxgglavorativi()) { // vincolo 1 - max 18 giorni lavorati
//						this.settaTurnoRiposo(dip,riposo);//aggiungo a turno riposo
						dip.settaRiposo("R");
						continue;
					}
					if (dip.getGiorniLavoratiConsecutivi() > dip.getGiorniLavoratiConsecutivi()) { // vincolo 2 - max 5 giorni lavorati consecutivi
//						this.settaTurnoRiposo(dip,riposo);//aggiungo a turno riposo
						dip.settaRiposo("R");
						continue;
					}
					Integer indexNextTurno;

					if (dip.getIndexTurno() == null) { // se è null, significa che è il primo giro
						indexNextTurno = ThreadLocalRandom.current().nextInt(0, MeseLavorativo.patternTurni.size()-1);
					} else {
						indexNextTurno = dip.getIndexTurno() + 1;
						if (indexNextTurno > MeseLavorativo.patternTurni.size()-1) {
							indexNextTurno = 0;
						}
					}
					
//					if()

					String turnoNext = MeseLavorativo.patternTurni.get(indexNextTurno);
					dip.setIndexTurno(indexNextTurno);
					if (turnoNext.equals("R")) { // vincolo 2 - update giorni lavorati
//						this.settaTurnoRiposo(dip,riposo);//aggiungo a turno riposo
						dip.settaRiposo(turnoNext);
					} else {
//						if(turnoNext.equals("M") && turno.getNomeTurno().equals("mattina"))
//							settaTurno(dip,turno);
//						if(turnoNext.equals("P") && turno.getNomeTurno().equals("pomeriggio"))
//							settaTurno(dip,turno);
//						if(turnoNext.equals("N") && turno.getNomeTurno().equals("sera"))	
//							settaTurno(dip,turno);
						dip.addTurno(turnoNext);
					}

				}
			}
//			this.listaTurniGiornaliera.add(turno); // aggiungo turno al giorno
//		}
//		this.listaTurniGiornaliera.add(riposo);
//	}
	
	private void settaTurnoRiposo(Turnista dip, Turno riposo){
//		riposo.addTurnista(dip);
		dip.setGiorniLavoratiConsecutivi(0);
	}
	
	private void settaTurno(Turnista dip, Turno turno){
		dip.incrementaGiorniLavorati();
		turno.addTurnista(dip);
	}

}
