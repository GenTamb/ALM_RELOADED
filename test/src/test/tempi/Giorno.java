package test.tempi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import test.personas.Turnista;

public class Giorno {

	private List<Turno> listaTurniGiornaliera;
	private Integer numGiorno;
	private static final List<String> turniStandard = Arrays.asList("mattina", "pomeriggio", "sera","riposo");

	public Giorno(Integer numGiorno) {
		super();
		this.numGiorno = numGiorno;
		this.listaTurniGiornaliera = new ArrayList<Turno>();
	}

	public List<Turno> getListaTurniGiornaliera() {
		return listaTurniGiornaliera;
	}

	public void setListaTurniGiornaliera(List<Turno> listaTurniGiornaliera) {
		this.listaTurniGiornaliera = listaTurniGiornaliera;
	}

	public Integer getNumGiorno() {
		return numGiorno;
	}

	public void setNumGiorno(Integer numGiorno) {
		this.numGiorno = numGiorno;
	}

	public void istanziaTurniGiornalieri(List<Turnista> listaTurnisti, Double numDipendentiPerTurno) {
		while (this.listaTurniGiornaliera.size() <= turniStandard.size()-1) {
			Turno turno = new Turno();
			turno.setNomeTurno(turniStandard.get(this.listaTurniGiornaliera.size()));

			while (turno.getDipendentiTurnisti().size() <= numDipendentiPerTurno) {
				for (Turnista dip : listaTurnisti) {
					if (dip.getNumeroGiorniLavorati() >= Turnista.getMaxgglavorativi()) { // vincolo 1 - max 18 giorni lavorati
						this.listaTurniGiornaliera.get(this.listaTurniGiornaliera.size()-1).getDipendentiTurnisti().add(dip); //aggiungo a turno riposo
						continue;
					}
					if (dip.getGiorniLavoratiConsecutivi() > dip.getGiorniLavoratiConsecutivi()) { // vincolo 2 - max 5 giorni lavorati consecutivi
						this.listaTurniGiornaliera.get(this.listaTurniGiornaliera.size()-1).getDipendentiTurnisti().add(dip); //aggiungo a turno riposo
						continue;
					}
					Integer indexNextTurno;

					if (dip.getIndexTurno() == null) { // se è null, significa che è il primo giro
						indexNextTurno = ThreadLocalRandom.current().nextInt(0, MeseLavorativo.patternTurni.size());
					} else {
						indexNextTurno = dip.getIndexTurno() + 1;
						if (indexNextTurno > MeseLavorativo.patternTurni.size()) {
							indexNextTurno = 0;
						}

						String turnoNext = MeseLavorativo.patternTurni.get(indexNextTurno);
						dip.setIndexTurno(indexNextTurno);
						if (turnoNext.equals("R")) { // vincolo 2 - update
														// giorni lavorati
							dip.setGiorniLavoratiConsecutivi(0);
						} else {
							dip.setGiorniLavoratiConsecutivi(dip.getGiorniLavoratiConsecutivi() + 1);
							dip.setNumeroGiorniLavorati(dip.getNumeroGiorniLavorati() + 1);
						}
					}

				}
			}
			this.listaTurniGiornaliera.add(turno); // aggiungo turno al giorno
		}
	}

}
