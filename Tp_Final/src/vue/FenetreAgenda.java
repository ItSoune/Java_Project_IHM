package vue;

import java.awt.*;
import javax.swing.*;

import modele.Data;
import modele.Date;
import modele.Evt;

/**
 * La classe FenetreAgenda est notre fenetre m?re qui contient le PanelAgendaV2.
 * 
 * @author BOUCHDI Yassine
 *
 */
public class FenetreAgenda extends JFrame {

	public FenetreAgenda(String parTitre) {
		super(parTitre);
		PanelAgendaV2 chContentPane = new PanelAgendaV2();
		JMenuBar chMenuBar = new JMenuBar();
		this.setJMenuBar(chMenuBar);

		for (int i = 0; i < Data.MENU.length; i++) {
			JMenuItem Menu = new JMenuItem(Data.MENU[i]);
			Menu.setMnemonic(Data.MENU[i].charAt(0));
			Menu.addActionListener(chContentPane);
			Menu.setActionCommand(Data.MENU[i]);
			chMenuBar.add(Menu);
		}
		setContentPane(chContentPane);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		JTextField zoneTitre = new JTextField();
		zoneTitre = PanelFormulaire.getzoneTitre();
		zoneTitre.requestFocus();
		// setLocation (445,0);
	}

	/**
	 * Cette methode permet l'execution du programme
	 * 
	 * @param args : Tableau d'argument de la m?thode main.
	 */
	public static void main(String[] args) {
		new FenetreAgenda("Agenda 2020");
		

	}

}
