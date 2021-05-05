package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modele.*;

/**
 * La classe PanelAffichage gère l'affichage de l'agenda sous forme de JTable.
 * 
 * @author BOUCHDI Yassine
 *
 */
public class PanelAffichage extends JPanel {
	Date chToday = new Date();
	AgendaV2 chAgenda;
	ModeleTable chModele;
	JTable chTableSemaine;

	public PanelAffichage(AgendaV2 parAgenda) {
		this.setLayout(new BorderLayout());
		ModeleTable chModele = new ModeleTable(chToday, parAgenda);
		chTableSemaine = new JTable(chModele);
		chTableSemaine.getTableHeader().setBackground(new Color(0, 0, 100));
		chTableSemaine.getTableHeader().setForeground(new Color(255, 255, 255));
		chTableSemaine.getTableHeader().setFont((new Font("Times New Roman", Font.BOLD, 12)));
		chTableSemaine.getTableHeader().setResizingAllowed(false);
		chTableSemaine.getTableHeader().setReorderingAllowed(false);
		chTableSemaine.setRowHeight(40);
		chTableSemaine.setDefaultRenderer(String.class, new CelluleRenderer());
		JScrollPane scrollPane = new JScrollPane(chTableSemaine, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(850, 280));
		this.add(scrollPane, BorderLayout.CENTER);
		setBackground(new Color(0, 0, 100));
		chTableSemaine.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JTable table = (JTable) evt.getSource();

				ModeleTable model = (ModeleTable) table.getModel();
				Point point = evt.getPoint();

				int rowIndex = table.rowAtPoint(point);
				int colIndex = table.columnAtPoint(point);

				final JFrame frame = new JFrame("Frame");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setAlwaysOnTop(true);
				frame.setSize(500, 500);
				frame.setLocation(500, 500);

				if (table.getValueAt(rowIndex, colIndex) != null) {
					JOptionPane.showMessageDialog(frame, model.getValueAt(rowIndex, colIndex));

				}
			}
		});

	}

	/**
	 * La méthode setModelTable permet de créer une JTable ModelTable (associée à
	 * une date) à la table de PanelAffichage.
	 * 
	 * @param parDate : La Date à affecter au ModelTable
	 * @param parAgenda : L'agenda à affecter au ModelTable
	 */
	public void setModeleTable(Date parDate, AgendaV2 parAgenda) {
		chModele = new ModeleTable(parDate, parAgenda);
		chTableSemaine.setModel(chModele);
	}
}
