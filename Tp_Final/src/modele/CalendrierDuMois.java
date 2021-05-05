package modele;

import java.util.*;

/**
 * 
 * La classe CalendrierDuMois génère les dates d'un mois d'une année.
 * spécifique .
 * 
 * @author BOUCHDI Yassine
 *
 */
public class CalendrierDuMois {
	private Collection<Date> chDates;

	/**
	 * La methode CalendrierMois ajoute à une liste toutes les dates du mois de
	 * l'année passée en paramètre.
	 * 
	 * @param mois : C'est le mois séléctionné.
	 * @param annee : C'est l'année séléctionnée.
	 */
	public CalendrierDuMois(int mois, int annee) {
		chDates = new TreeSet<Date>();
		Date date = new Date(1, mois, annee);
		int indiceJour = date.getJourSemaine() == 1 ? 6 : date.getJourSemaine() - 2;
		for (int indice = indiceJour; indice >= 0; indice--) {
			chDates.add(date);
			date = date.dateDeLaVeille();
		}
		date = new Date(2, mois, annee);
		indiceJour = indiceJour + 1 % 7;
		while (date.getMois() == mois) {
			while (indiceJour < 7) {
				chDates.add(date);
				date = date.dateDuLendemain();
				indiceJour++;
			}
			indiceJour = 0;
		}
	}

	/**
	 * La méthode Collection renvoie une collection de type Date contenant la liste.
	 * des dates.
	 * 
	 * @return Collection de Liste de type Date
	 */
	public Collection<Date> getDates() {
		return chDates;
	}

}
