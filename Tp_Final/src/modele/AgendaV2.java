package modele;

import java.io.Serializable;
import java.util.*;

/**
 * La classe Agenda contient les événements ajoutés.
 * 
 * @author BOUCHDI Yassine
 *
 */
public class AgendaV2 implements Serializable {

	private TreeMap<Integer, TreeSet<Evt>> chTreeMap = new TreeMap<Integer, TreeSet<Evt>>();

	/**
	 * La méthode toString gère la forme de l'agenda.
	 * 
	 * @return String
	 */
	public String toString() {

		String message = "TreeMap : \n";
		Set<Integer> cles = chTreeMap.keySet();
		for (Integer cle : cles) {
			Iterator<Evt> Set = chTreeMap.get(cle).iterator();
			message += ("Dans la semaine " + cle + "  on a : " + "\n");
			while (Set.hasNext()) {
				message += (Set.next() + "\n");
			}
		}
		return message;
	}

	/**
	 * La méthode ajoutMap gère l'ajout des nouveaux événements à la TreeMap : Elle
	 * classe les événements par leur numéro de semaine.
	 * 
	 * @param parNvEvenement : Le nouveau événement à ajouter.
	 */
	public void ajoutMap(Evt parNvEvenement) {
		int numdesemaine = parNvEvenement.getDate().getnumdeSemaine();
		Set<Integer> cles = chTreeMap.keySet();
		if (cles.contains(numdesemaine)) {
			TreeSet<Evt> Set = chTreeMap.get(numdesemaine);
			Set.add(parNvEvenement);
		} else {
			TreeSet<Evt> nouv = new TreeSet();
			nouv.add(parNvEvenement);
			chTreeMap.put(numdesemaine, nouv);
		}
	}

	/**
	 * La méthode getEvtSemaine renvoie le(les) événement(s) de la semaine passée en
	 * paramètre
	 * 
	 * @param parSem : La semaine séléctionée dans le calendrier
	 * @return TreeSet : La TreeSet qui contient les événement de la semaine sélectionnée.
	 */
	public TreeSet<Evt> getEvtSemaine(int parSem) {
		TreeSet<Evt> semTree = chTreeMap.get(parSem);
		return semTree;
	}

}
