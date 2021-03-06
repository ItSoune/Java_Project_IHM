package Controleur;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serializable;

import javax.swing.*;

import Login.Login;
import modele.*;
import vue.*;

/**
 * La classe controleur permet de faire la liaison entre le modele et la vue.
 * 
 * @author BOUCHDI Yassine
 *
 */
public class Controleur implements ActionListener, Serializable {
	AgendaV2 chAgenda;
	PanelFormulaire chPanelFormulaire;
	PanelCalendrier chPanelCalendrier;
	PanelAffichage chPanelAffichage;
	Date chTempdate = new Date();
	Date chAujourdhui = new Date();
	BoutonDate chBoutemp = new BoutonDate(chAujourdhui);
	int chMois;
	
	/**
	 * Le constructeur prend en param?tre les diff?rentes classes du mod?le et de la
	 * vue pour les mettre en relation.
	 * 
	 * @param parAgenda Le controleur prend en param?tre l'agenda qui contient les ?venements.
	 * @param parPanelFormulaire Le controleur prend en param?tre le PanelFormulaire qui permet l'ajout des ?v?nements.
	 * @param parPanelCalendrier Le controleur prend en param?tre le PanelCalendrier qui contient le calendrier du mois.
	 * @param parPanelAffichage Le controleur prend en param?tre PanelAffichage qui contient ModelTable.
	 */
	public Controleur(AgendaV2 parAgenda, PanelFormulaire parPanelFormulaire, PanelCalendrier parPanelCalendrier,
			PanelAffichage parPanelAffichage) {
		chAgenda = parAgenda;
		chPanelFormulaire = parPanelFormulaire;
		chPanelCalendrier = parPanelCalendrier;
		chPanelAffichage = parPanelAffichage;
		chPanelFormulaire.enregistreEcouteur(this);
		chPanelCalendrier.enregistreEcouteur(this);
	}

	/**
	 * Le controleur mis ? l'?coute des actions sur les boutons de calendrier
	 * modifie le formulaire de PanelFormulaire et la JTable de PanelAffichage et
	 * ajoute l'agenda au fichier.
	 */
	public void actionPerformed(ActionEvent parEvt) {
		if (parEvt.getActionCommand().equals("+")) {
			chAgenda.ajoutMap(chPanelFormulaire.getEvenement());
			chPanelAffichage.setModeleTable(chTempdate, chAgenda);
			String currentUser;

			currentUser = Login.getCurrentUsername();

			LectureEcriture a = new LectureEcriture();

			a.ecriture(Login.fichTes, chAgenda);

		} else {
			BoutonDate bout = (BoutonDate) parEvt.getSource();
			if (chBoutemp != bout) {

				if (chBoutemp.getDate().compareTo(chAujourdhui) == 0) {
					chBoutemp.setBackground(new Color(0, 0, 100));
					chBoutemp.setForeground(new Color(255, 255, 255));

				} else if (chBoutemp.getDate().getMois() != bout.getDate().getMois()) {
					chBoutemp.setBackground(new Color(175, 175, 175));
					chBoutemp.setForeground(new Color(100, 100, 100));

				} else if (chBoutemp.getDate().getJourSemaine() == 7 || chBoutemp.getDate().getJourSemaine() == 1) {
					chBoutemp.setBackground(new Color(225, 225, 225));
					chBoutemp.setForeground(new Color(0, 0, 0));

				}

				else {
					chBoutemp.setBackground(new Color(200, 200, 200));
					chBoutemp.setForeground(new Color(0, 0, 0));

				}
			}

			if (parEvt.getSource() == bout) {
				Date date = bout.getDate();
				chTempdate = date;
				chPanelFormulaire.setDate(date);
				chPanelAffichage.setModeleTable(date, chAgenda);
				bout.setBackground(new Color(255, 255, 255));
				bout.setForeground(new Color(0, 0, 100));
				chBoutemp = bout;
			}
		}
	}
}
