package test;

import test.personas.Turnisti;
import test.tempi.MeseLavorativo;
import test.personas.Responsabile;
import test.personas.Turnista;

public class MainTestDipendenti {

	public static void main(String[] args) {
		Turnisti turnisti = new Turnisti();
		Responsabile resp = new Responsabile("Massimo");
		Turnista turn1 = new Turnista("Diego");
		Turnista turn2 = new Turnista("Fausto");
		Turnista turn3 = new Turnista("Giorgio");
		Turnista turn4 = new Turnista("Gennaro");
		Turnista turn5 = new Turnista("Mirko");
		Turnista turn6 = new Turnista("Thomas");
		Turnista turn7 = new Turnista("Anna");
		Turnista turn8 = new Turnista("Davide");
		Turnista turn9 = new Turnista("Carola");
		Turnista turn10 = new Turnista("Matteo");
		Turnista turn11 = new Turnista("Marzia");
		Turnista turn12 = new Turnista("Gabriele");
		Turnista turn13 = new Turnista("Paolo");
		Turnista turn14 = new Turnista("Fabio");
		Turnista turn15 = new Turnista("Fabrizio");
		
		MeseLavorativo mese = new MeseLavorativo();
		
		System.out.println(turnisti.getListaTurnisti());
	}

}
