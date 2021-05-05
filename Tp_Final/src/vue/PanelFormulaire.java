package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;

import Controleur.Controleur;
import modele.*;

/**
 * La classe PanelFormulaire sert à ajouter des événements depuis l'interface.
 * 
 * @author BOUCHDI Yassine
 *
 */
public class PanelFormulaire extends JPanel {
	Evt chEvtSaisi;
	JButton chBouton = new JButton("+");

	Date chDate = new Date();
	static JTextField chZoneTitre = new JTextField();
	JTextArea chZoneDesc = new JTextArea(8, 8);
	JTextField chZoneLieu = new JTextField();
	JComboBox chComboBoxFinHeu = new JComboBox();
	JComboBox chComboBoxDerMin = new JComboBox();
	JComboBox chComboBoxPreHeu = new JComboBox();
	JComboBox chComboBoxPreMin = new JComboBox();
	GregorianCalendar chAujourdhui = new GregorianCalendar();
	String chMaintH = Integer.toString(chAujourdhui.get(Calendar.HOUR_OF_DAY));
	String chMaintM = Integer.toString(chAujourdhui.get(Calendar.MINUTE));

	JLabel chDateJour = new JLabel(chDate.toString(), JLabel.LEFT);

	public PanelFormulaire() {

		GridBagConstraints contrainte = new GridBagConstraints();
		setLayout(new GridBagLayout());
		if (chAujourdhui.get(Calendar.HOUR_OF_DAY) < 10) {
			chMaintH = "0" + chMaintH;
		}
		if (chAujourdhui.get(Calendar.MINUTE) < 10) {
			chMaintM = "0" + chMaintM;
		}

		// combox
		String heures[] = new String[24];
		String minutes[] = new String[60];
		for (int i = 0; i < 10; i += 1) {
			heures[i] = "0" + Integer.toString(i);
		}

		for (int i = 10; i < 24; i += 1) {
			heures[i] = Integer.toString(i);
		}

		for (int i = 0; i < 10; i += 1) {

			minutes[i] = "0" + Integer.toString(i);
		}
		for (int i = 10; i < 60; i += 1) {

			minutes[i] = Integer.toString(i);
		}
		chComboBoxFinHeu = new JComboBox(heures);
		chComboBoxDerMin = new JComboBox(minutes);
		chComboBoxPreHeu = new JComboBox(heures);
		chComboBoxPreMin = new JComboBox(minutes);

		// bouton

		contrainte.gridx = 4;
		contrainte.gridy = 0;
		contrainte.gridheight = 1;
		contrainte.fill = GridBagConstraints.BOTH;
		contrainte.insets = new Insets(10, 10, 10, 10);
		this.add(chBouton, contrainte);

		// date
		contrainte.gridx = 0;
		contrainte.gridy = 0;
		contrainte.gridheight = 1;
		contrainte.fill = GridBagConstraints.BOTH;
		contrainte.insets = new Insets(10, 10, 10, 10);
		this.add(chDateJour, contrainte);

		// titre
		JLabel titre = new JLabel("Titre", JLabel.LEFT);
		titre.setDisplayedMnemonic('T');
		contrainte.gridx = 0;
		contrainte.gridy = 1;
		contrainte.gridheight = 1;
		contrainte.fill = GridBagConstraints.BOTH;
		contrainte.insets = new Insets(10, 10, 10, 10);
		this.add(titre, contrainte);

		// zoneTitre
		contrainte.gridx = 2;
		contrainte.gridy = 1;
		contrainte.gridheight = 1;
		contrainte.gridwidth = 3;
		contrainte.insets = new Insets(10, 10, 10, 10);
		this.add(chZoneTitre, contrainte);
		titre.setLabelFor(chZoneTitre);

		// Lieu
		JLabel Lieu = new JLabel("Lieu", JLabel.LEFT);
		Lieu.setDisplayedMnemonic('L');
		contrainte.gridx = 0;
		contrainte.gridy = 2;
		contrainte.gridheight = 1;
		contrainte.gridwidth = 1;
		contrainte.fill = GridBagConstraints.BOTH;
		contrainte.insets = new Insets(10, 10, 10, 10);
		this.add(Lieu, contrainte);

		// zoneLieu
		contrainte.gridx = 2;
		contrainte.gridy = 2;
		contrainte.gridheight = 1;
		contrainte.gridwidth = 3;
		contrainte.insets = new Insets(10, 10, 10, 10);
		this.add(chZoneLieu, contrainte);
		Lieu.setLabelFor(chZoneLieu);

		// debut
		JLabel debut = new JLabel("debut", JLabel.LEFT);
		debut.setDisplayedMnemonic('D');
		contrainte.gridx = 0;
		contrainte.gridy = 3;
		contrainte.gridheight = 1;
		contrainte.gridwidth = 1;
		contrainte.insets = new Insets(10, 10, 10, 10);
		this.add(debut, contrainte);

		// debutheure
		contrainte.gridx = 2;
		contrainte.gridy = 3;
		contrainte.gridheight = 1;
		contrainte.gridwidth = 1;
		contrainte.fill = GridBagConstraints.BOTH;
		contrainte.insets = new Insets(10, 10, 10, 10);
		this.add(chComboBoxPreHeu, contrainte);
		debut.setLabelFor(chComboBoxPreHeu);
		chComboBoxPreHeu.setSelectedItem(chMaintH);
		// sep
		JLabel sep = new JLabel(":", JLabel.CENTER);
		contrainte.gridx = 3;
		contrainte.gridy = 3;
		contrainte.gridheight = 1;
		contrainte.gridwidth = 1;
		contrainte.fill = GridBagConstraints.BOTH;
		contrainte.insets = new Insets(10, 10, 10, 10);
		this.add(sep, contrainte);

		// debutminute
		contrainte.gridx = 4;
		contrainte.gridy = 3;
		contrainte.gridheight = 1;
		contrainte.gridwidth = 1;
		contrainte.fill = GridBagConstraints.BOTH;
		contrainte.insets = new Insets(10, 10, 10, 10);
		contrainte.anchor = GridBagConstraints.CENTER;
		this.add(chComboBoxPreMin, contrainte);
		chComboBoxPreMin.setSelectedItem(chMaintM);

		// fin
		JLabel fin = new JLabel("Fin", JLabel.LEFT);
		fin.setDisplayedMnemonic('F');
		contrainte.gridx = 0;
		contrainte.gridy = 4;
		contrainte.gridheight = 1;
		contrainte.gridwidth = 1;
		contrainte.fill = GridBagConstraints.BOTH;
		contrainte.insets = new Insets(10, 10, 10, 10);
		this.add(fin, contrainte);

		// finheure
		contrainte.gridx = 2;
		contrainte.gridy = 4;
		contrainte.gridheight = 1;
		contrainte.gridwidth = 1;
		contrainte.fill = GridBagConstraints.BOTH;
		contrainte.insets = new Insets(10, 10, 10, 10);
		this.add(chComboBoxFinHeu, contrainte);
		chComboBoxFinHeu.setSelectedItem(chMaintH);
		fin.setLabelFor(chComboBoxFinHeu);
		// sep1
		JLabel sep1 = new JLabel(":", JLabel.CENTER);
		contrainte.gridx = 3;
		contrainte.gridy = 4;
		contrainte.gridheight = 1;
		contrainte.gridwidth = 1;
		contrainte.fill = GridBagConstraints.BOTH;
		contrainte.insets = new Insets(10, 10, 10, 10);
		this.add(sep1, contrainte);

		// finminute
		contrainte.gridx = 4;
		contrainte.gridy = 4;
		contrainte.gridheight = 1;
		contrainte.gridwidth = 1;
		contrainte.insets = new Insets(10, 10, 10, 10);
		this.add(chComboBoxDerMin, contrainte);
		chComboBoxDerMin.setSelectedItem(chMaintM);

		// desc
		JLabel desc = new JLabel("Description", JLabel.LEFT);
		desc.setDisplayedMnemonic('e');
		contrainte.gridx = 0;
		contrainte.gridy = 5;
		contrainte.gridheight = 1;
		contrainte.gridwidth = 3;
		contrainte.fill = GridBagConstraints.BOTH;
		contrainte.insets = new Insets(10, 10, 10, 10);
		this.add(desc, contrainte);
		// zonedesc
		contrainte.gridx = 2;
		contrainte.gridy = 5;
		contrainte.gridheight = 2;
		contrainte.gridwidth = 3;
		contrainte.insets = new Insets(10, 10, 10, 10);
		desc.setLabelFor(chZoneDesc);
		this.add(chZoneDesc, contrainte);
		// Couleurs & Formes
		chDateJour.setFont(new Font("Times New Roman", Font.BOLD, 15));
		titre.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Lieu.setFont(new Font("Times New Roman", Font.BOLD, 15));
		debut.setFont(new Font("Times New Roman", Font.BOLD, 15));
		fin.setFont(new Font("Times New Roman", Font.BOLD, 15));
		desc.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chBouton.setBackground(Data.CouleurBoutons);
		chComboBoxFinHeu.setBackground(Data.CouleurBoutons);
		chComboBoxDerMin.setBackground(Data.CouleurBoutons);
		chComboBoxPreHeu.setBackground(Data.CouleurBoutons);
		chComboBoxPreMin.setBackground(Data.CouleurBoutons);

	}

	/**
	 * La methode enregistreEcouteur met les boutons de PanelFormulaire en Ecoute
	 * du controleur.
	 * 
	 * @param parControleur : Le controleur qui gère les clics.
	 */
	public void enregistreEcouteur(Controleur parControleur) {
		chBouton.addActionListener(parControleur);
		chBouton.setActionCommand("+");
	}

	/**
	 * La méthode getEvenement renvoie l'événement saisi.
	 * 
	 * @return Evt : L'événement saisi.
	 */
	public Evt getEvenement() {
		String Titre = chZoneTitre.getText();
		String Lieu = chZoneLieu.getText();
		String Description = chZoneDesc.getText();
		String HeureDebut = chComboBoxPreHeu.getSelectedItem().toString();
		String Mindebut = chComboBoxPreMin.getSelectedItem().toString();
		String Heurefin = chComboBoxFinHeu.getSelectedItem().toString();
		String Minufin = chComboBoxDerMin.getSelectedItem().toString();
		int entierHeureDebut = Integer.parseInt(HeureDebut);
		int entierMindebut = Integer.parseInt(Mindebut);
		int entierHeurefin = Integer.parseInt(Heurefin);
		int entierMinufin = Integer.parseInt(Minufin);
		chEvtSaisi = new Evt(chDate, Titre, Lieu, Description, entierHeureDebut, entierMindebut, entierHeurefin,
				entierMinufin);
		chZoneTitre.setText("");
		chZoneLieu.setText("");
		chZoneDesc.setText("");
		chComboBoxPreHeu.setSelectedItem(chMaintH);
		chComboBoxPreMin.setSelectedItem(chMaintM);
		chComboBoxFinHeu.setSelectedItem(chMaintH);
		chComboBoxDerMin.setSelectedItem(chMaintM);
		chZoneTitre.requestFocus();
		return chEvtSaisi;
	}

	/**
	 * La méthode getzoneTitre renvoie le contenu de la zone de titre de
	 * PanelFormulaire.
	 * 
	 * @return JtextField
	 */
	public static JTextField getzoneTitre() {
		return chZoneTitre;
	}

	/**
	 * La méthode setDate permet d'assigner la date en paramètre à la date de
	 * PanelFormulaire.
	 * 
	 * @param parDate : La date choisie.
	 */
	public void setDate(Date parDate) {
		chDate = parDate;
		chDateJour.setText(chDate.toString());
	}

}
