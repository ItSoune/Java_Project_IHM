package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;

import Controleur.Controleur;
import modele.Data;

/**
 * La classe PanelCalendrier permet l'affichage et la gestion des dates des mois
 * de l'année.
 * 
 * @author BOUCHDI Yassine
 *
 */
public class PanelCalendrier extends JPanel implements ActionListener {

	private final static String[] chIntitulesDesBoutons = { "<<", "<", ">", ">>" };
	private final static JButton[] chBoutons = new JButton[4];
	private final static String[] chMois = { "Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août",
			"Septembre", "Octobre", "Novembre", "Décembre" };

	CardLayout chGestionnaireDeCartes = new CardLayout(5, 5);
	JPanel chPanelCentre = new JPanel();
	JPanel chPanelSud = new JPanel();
	JPanel chPanelNord = new JPanel();
	JLabel chLabelMois;
	JLabel chJours[] = new JLabel[7];

	GregorianCalendar chAujourdhui = new GregorianCalendar();
	int chMoisCourant = chAujourdhui.get(Calendar.MONTH);
	int chIndiceMOIS = chMoisCourant;

	PanelMois cal;
	GridBagConstraints contrainte = new GridBagConstraints();
	ArrayList<PanelMois> LesPanelsMOis = new ArrayList<PanelMois>();

	public PanelCalendrier() {

		this.setLayout(new BorderLayout(9, 9));

		// sud
		chPanelSud.setLayout(new BorderLayout(20, 20));
		chLabelMois = new JLabel(chMois[chIndiceMOIS] + " : ", JLabel.CENTER);
		chLabelMois.setFont(new Font("Times New Roman", Font.BOLD, 20));
		chPanelSud.add(chLabelMois);
		for (int i = 0; i < chBoutons.length; i++) {
			chBoutons[i] = new JButton(chIntitulesDesBoutons[i]);
			chPanelSud.add(chBoutons[i]);
			chBoutons[i].setOpaque(true);
			chPanelSud.add(chBoutons[i]);
			chBoutons[i].addActionListener(this);
			chPanelSud.add(chBoutons[i]);
			chPanelSud.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 8));
			chBoutons[i].setBackground(Data.CouleurBoutons);

		}

		// Centre
		chPanelCentre.setLayout(chGestionnaireDeCartes);

		for (int j = 1; j <= chMois.length; j++) {
			cal = new PanelMois(j);
			chPanelCentre.add(cal, chMois[j - 1]);
			LesPanelsMOis.add(cal);
		}

		chGestionnaireDeCartes.show(chPanelCentre, chMois[chMoisCourant]);

		// Nord
		chPanelNord.setLayout(new GridBagLayout());
		for (int i = 0; i < Data.JOUR_ABR.length; i++) {
			chJours[i] = new JLabel(Data.JOUR_ABR[i], JLabel.CENTER);
			contrainte.insets = new Insets(10, 100, 10, 85);
			contrainte.gridx = i;
			contrainte.gridy = 0;
			chPanelNord.add(chJours[i], contrainte);
			chJours[i].setFont(new Font("Times New Roman", Font.BOLD, 20));

		}
		setBackground(new Color(0, 0, 100));

		// Global
		add(chPanelSud, BorderLayout.SOUTH);
		add(chPanelCentre, BorderLayout.CENTER);
		add(chPanelNord, BorderLayout.NORTH);

	}

	/**
	 * La méthode enregistreEcouteur met chaque PanelMois de PanelCelendrier en
	 * écoute du controleur.
	 * 
	 * @param parControleur : Le controleur qui gère les clics. 
	 */
	public void enregistreEcouteur(Controleur parControleur) {
		for (int i = 0; i < LesPanelsMOis.size(); i++) {
			LesPanelsMOis.get(i).enregistreEcouteur(parControleur);
		}
	}

	/**
	 * Cette méthode permet de gérer les événements sur PanelCalendrier.
	 */
	public void actionPerformed(ActionEvent parEvt) {
		if (parEvt.getSource() == chBoutons[3]) {
			chGestionnaireDeCartes.last(chPanelCentre);
			chIndiceMOIS = chMois.length - 1;

		}

		else if (parEvt.getSource() == chBoutons[0]) {

			chGestionnaireDeCartes.first(chPanelCentre);
			chIndiceMOIS = 0;
		} else if (parEvt.getSource() == chBoutons[1]) {

			chGestionnaireDeCartes.previous(chPanelCentre);
			if (chIndiceMOIS == 0) {
				chIndiceMOIS = chMois.length - 1;
			} else {
				--chIndiceMOIS;
			}

		} else if (parEvt.getSource() == chBoutons[2]) {

			chGestionnaireDeCartes.next(chPanelCentre);
			if (chIndiceMOIS == chMois.length - 1) {
				chIndiceMOIS = 0;

			} else {
				++chIndiceMOIS;
			}

		}

		chLabelMois.setText(chMois[chIndiceMOIS] + " : ");

	}

}
