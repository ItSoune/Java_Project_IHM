package vue;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.Reader;
import java.io.Serializable;


import javax.swing.*;

import Controleur.Controleur;
import Login.Login;
import modele.*;

/**
 * La classe PanelAgendaV2 permet la gestion de l'agenda globalement c'est dans
 * cette classe que s'effectue l'instanciations des autres pannels.
 * 
 * @author BOUCHDI Yassine
 *
 */
public class PanelAgendaV2 extends JPanel implements ActionListener, Serializable {
	CardLayout chLayout = new CardLayout();
	AgendaV2 chAgenda = new AgendaV2();
	public static File fichTes;

	public PanelAgendaV2() {


		Login chLog = new Login("Agenda DB - Connexion/Inscription" );

		String chCurrentUser = chLog.getCurrentUsername();


		AgendaV2 chAgenda = new AgendaV2();



		if (Login.fichTes.length() == 0) {

			fichTes = new File("fich.Agenda" + File.separator + chCurrentUser + ".ser");

		}

		else {

			LectureEcriture chLecEcr = new LectureEcriture();
			chAgenda = (AgendaV2) chLecEcr.lecture(Login.fichTes);
			System.out.println("apres");
			System.out.println(chAgenda);

		}

		PanelFormulaire form = new PanelFormulaire();
		PanelCalendrier Calendrier = new PanelCalendrier();
		PanelAffichage panelAffichage = new PanelAffichage(chAgenda);
		Controleur contr = new Controleur(chAgenda, form, Calendrier, panelAffichage);
		this.setLayout(chLayout);

		this.add(Calendrier, Data.MENU[0]);
		this.add(form, Data.MENU[1]);
		this.add(panelAffichage, Data.MENU[2]);

	}

	/**
	 * Cette méthode permet la gestion des cliques sur PanelAgendaV2
	 */
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		for (int i = 0; i < Data.MENU.length; i++) {
			if (actionCommand.equals(Data.MENU[i])) {
				chLayout.show(this, Data.MENU[i]);

			}
		}
		if (actionCommand.equals(Data.MENU[3])) {
			int saisi = JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de vouloir fermer la fenêtre ?",
					"Dialogue de confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			switch (saisi) {
			case JOptionPane.CLOSED_OPTION:
				break;
			case JOptionPane.YES_OPTION:
				System.exit(0);
				break;
			case JOptionPane.NO_OPTION:
				break;
			}
		}
	}
}
