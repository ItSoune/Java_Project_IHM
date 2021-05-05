package modele;

import java.io.Serializable;
import java.util.*;

/**
 * La classe Agenda contient les �v�nements ajout�s.
 * 
 * @author BOUCHDI Yassine
 *
 */
public class AgendaV2 implements Serializable {

	private TreeMap<Integer, TreeSet<Evt>> chTreeMap = new TreeMap<Integer, TreeSet<Evt>>();

	/**
	 * La m�thode toString g�re la forme de l'agenda.
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
	 * La m�thode ajoutMap g�re l'ajout des nouveaux �v�nements � la TreeMap : Elle
	 * classe les �v�nements par leur num�ro de semaine.
	 * 
	 * @param parNvEvenement : Le nouveau �v�nement � ajouter.
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
	 * La m�thode getEvtSemaine renvoie le(les) �v�nement(s) de la semaine pass�e en
	 * param�tre
	 * 
	 * @param parSem : La semaine s�l�ction�e dans le calendrier
	 * @return TreeSet : La TreeSet qui contient les �v�nement de la semaine s�lectionn�e.
	 */
	public TreeSet<Evt> getEvtSemaine(int parSem) {
		TreeSet<Evt> semTree = chTreeMap.get(parSem);
		return semTree;
	}

}
