package test.personas;

import java.util.ArrayList;
import java.util.List;
//la classe simula un DB
public class Turnisti {
	
	private static List<Turnista> listaTurnisti = null;
	private static Long lastIdInserted = 0L;
	public Turnisti(){
		Turnisti.setListaTurnisti(new ArrayList<Turnista>());
	}
	public static List<Turnista> getListaTurnisti() {
		return listaTurnisti;
	}
	public static void setListaTurnisti(List<Turnista> listaTurnisti) {
		Turnisti.listaTurnisti = listaTurnisti;
	}
	
	public static void addTurnistaToList(Turnista dip){
		Turnisti.listaTurnisti.add(dip);
		Turnisti.lastIdInserted++;
	}
	
	public static boolean removeDipendenteFromList(Dipendente dip){
		if(Turnisti.listaTurnisti.contains(dip)){
			return Turnisti.listaTurnisti.remove(dip);
		}
		else return false;
	}
	
	public static boolean removeDipendenteFromListById(Long id){
		for (Dipendente dipendente : listaTurnisti) {
			if(dipendente.getId().compareTo(id)==0){
				return listaTurnisti.remove(dipendente);
			}
		}
		return false;
	}
	public static int getNumTurnisti(){
		return Turnisti.listaTurnisti.size();
	}
	
	public static Long getLastIdInserted() {
		return lastIdInserted;
	}
	public static void setLastIdInserted(Long lastIdInserted) {
		Turnisti.lastIdInserted = lastIdInserted;
	}
	
	
	
}
