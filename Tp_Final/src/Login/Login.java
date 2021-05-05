
package Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import modele.*;
import vue.*;


/**
 * La classe Login gère l'authentification des utilisateurs, chacun a sa propre agenda!!
 * @author BOUCHDI Yassine
 *
 */
public class Login extends JFrame implements ActionListener, Serializable {

	public static File fichTes;

	private JLabel chFirstMsg = new JLabel("Log in or sign up :");
	private JLabel chScndMsg = new JLabel("Sign up :");
	private JLabel chLabelInvUserPass = new JLabel("Invalid Username or Password");
	JLabel chLabelCnxReq = new JLabel("Registration successful, log in !");
	JLabel chLabelUser = new JLabel("Username* :");
	JLabel chLabelPass = new JLabel("Password* :");
	JLabel chLabelMail = new JLabel("E-mail :");
	JLabel chLabelAgeContr = new JLabel("Age¹ :");
	JLabel chLabelOblg = new JLabel("*These fields must be entered.");
	JLabel chLabelAgeMean = new JLabel("¹You must have 16 years or more.");
	JLabel chLabelFieldErr = new JLabel("You didn't complete all the obligatory fields.");
	JLabel chLabelExiErr = new JLabel("Username already Exists, Choose another one...!!");

	private JPanel chContentPane = new JPanel();

	private static JTextField chUsernameField = new JTextField();
	private JTextField chMailField = new JTextField();

	private JPasswordField chPasswordField = new JPasswordField();

	private static Login chFrame;

	JButton btnLogin = new JButton("log-in");
	JButton btnInsc = new JButton("Sign up");
	JButton btnValide = new JButton("Sign up");
	JButton btnBack = new JButton("Back");


	String chAge[] = new String[100];
	JComboBox comboAge = new JComboBox();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chFrame = new Login("Agenda DB - Connexion");
					chFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login(String parTitre) {
		super(parTitre);

		GridBagConstraints contrainte = new GridBagConstraints();
		setLayout(new GridBagLayout());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);


		for (int i = 0; i < 100; i += 1)
			chAge[i] = Integer.toString(i);

		comboAge = new JComboBox(chAge);

		chContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(chContentPane);
		chContentPane.setLayout(null);

		chLabelUser.setDisplayedMnemonic('U');
		chLabelPass.setDisplayedMnemonic('P');
		chLabelMail.setDisplayedMnemonic('E');
		chLabelAgeContr.setDisplayedMnemonic('A');

		chLabelUser.setLabelFor(chUsernameField);
		chLabelPass.setLabelFor(chPasswordField);
		chLabelMail.setLabelFor(chMailField);
		chLabelAgeContr.setLabelFor(comboAge);

		chFirstMsg.setFont(new Font("Courier New", Font.BOLD, 20));
		chScndMsg.setFont(new Font("Courier New", Font.BOLD, 20));
		chLabelUser.setFont(new Font("Courier New", Font.BOLD, 17));
		chLabelPass.setFont(new Font("Courier New", Font.BOLD, 17));
		chLabelMail.setFont(new Font("Courier New", Font.BOLD, 17));
		chLabelAgeContr.setFont(new Font("Courier New", Font.BOLD, 17));
		chLabelInvUserPass.setFont(new Font("Courier New", Font.BOLD, 15));
		chLabelCnxReq.setFont(new Font("Courier New", Font.BOLD, 15));
		chLabelFieldErr.setFont(new Font("Courier New", Font.BOLD, 15));
		chLabelExiErr.setFont(new Font("Courier New", Font.BOLD, 15));
		btnLogin.setFont(new Font("Courier New", Font.BOLD, 15));
		btnInsc.setFont(new Font("Courier New", Font.BOLD, 15));
		btnValide.setFont(new Font("Courier New", Font.BOLD, 15));
		btnBack.setFont(new Font("Courier New", Font.BOLD, 15));
		chLabelOblg.setFont(new Font("Courier New", Font.BOLD, 11));
		chLabelAgeMean.setFont(new Font("Courier New", Font.BOLD, 11));

		chLabelInvUserPass.setForeground(new Color(255, 0, 0));
		chLabelCnxReq.setForeground(new Color(0, 200, 0));
		chLabelFieldErr.setForeground(new Color(255, 0, 0));
		chLabelExiErr.setForeground(new Color(255, 0, 0));

		comboAge.setBackground(Data.CouleurBoutons);
		btnLogin.setBackground(Data.CouleurBoutons);
		btnInsc.setBackground(Data.CouleurBoutons);
		btnValide.setBackground(Data.CouleurBoutons);
		btnBack.setBackground(Data.CouleurBoutons);


		chContentPane.add(chFirstMsg);
		chContentPane.add(chScndMsg);
		chContentPane.add(chLabelUser);
		chContentPane.add(chUsernameField);
		chContentPane.add(chLabelPass);
		chContentPane.add(chPasswordField);
		chContentPane.add(chLabelMail);
		chContentPane.add(chMailField);
		chContentPane.add(chLabelAgeContr);
		chContentPane.add(comboAge);
		chContentPane.add(chLabelInvUserPass);
		chContentPane.add(chLabelCnxReq);
		chContentPane.add(chLabelFieldErr);
		chContentPane.add(chLabelExiErr);
		chContentPane.add(btnLogin);
		chContentPane.add(btnInsc);
		chContentPane.add(btnValide);
		chContentPane.add(btnBack);
		chContentPane.add(chLabelOblg);
		chContentPane.add(chLabelAgeMean);

		chFirstMsg.setBounds(140, 40, 250, 30);
		chScndMsg.setBounds(180, 40, 250, 30);
		chLabelUser.setBounds(100, 100, 120, 30);
		chUsernameField.setBounds(270, 100, 130, 30);
		chLabelPass.setBounds(100, 150, 120, 30);
		chPasswordField.setBounds(270, 150, 130, 30);
		chLabelMail.setBounds(100, 200, 100, 30);
		chMailField.setBounds(270, 200, 130, 30);
		chLabelInvUserPass.setBounds(120, 200, 300, 30);
		chLabelCnxReq.setBounds(100, 200, 300, 30);
		chLabelFieldErr.setBounds(50, 300, 450, 30);
		chLabelExiErr.setBounds(50, 300, 450, 30);
		chLabelAgeContr.setBounds(100, 250, 100, 30);
		comboAge.setBounds(300, 250, 50, 30);
		btnLogin.setBounds(80, 250, 140, 30);
		btnInsc.setBounds(260, 250, 140, 30);
		btnValide.setBounds(80, 350, 140, 30);
		btnBack.setBounds(260,350,140,30);
		chLabelOblg.setBounds(100, 290, 300, 15);
		chLabelAgeMean.setBounds(100, 400, 300, 15);

		chUsernameField.setColumns(20);

		chFirstMsg.setVisible(true);
		chScndMsg.setVisible(false);
		chLabelMail.setVisible(false);
		chMailField.setVisible(false);
		chLabelInvUserPass.setVisible(false);
		chLabelCnxReq.setVisible(false);
		chLabelFieldErr.setVisible(false);
		chLabelExiErr.setVisible(false);
		chLabelAgeContr.setVisible(false);
		comboAge.setVisible(false);
		btnValide.setVisible(false);
		chLabelOblg.setVisible(true);
		chLabelAgeMean.setVisible(false);
		btnBack.setVisible(false);

		
		btnInsc.addActionListener(this);
		btnLogin.addActionListener(this);
		btnValide.addActionListener(this);
		btnBack.addActionListener(this);
	}

	/**
	 * La méthode actionPerformed gère les clics :
	 * <p>Le clic sur Inscription affiche des boutons et enlève d'autres(afin de donner l'illusion que c'est une nouvelle fenêtre). 
	 * Dans ce cas l'actionPerformed gère l'inscription en ecrivant dans le fichier Users.txt (Serialisation) et toutes les exceptions que ça peut rencontrer
	 * (champs vides, utilisateur déjà inscrit ...)
	 * <p>Le clic sur Login gère la connection de l'utilisateur en créant un fichier .ser avec comme nom le username et toutes les exceptions que ça peut rencontrer
	 * (champs vides, utilisateur pas inscrit, faux mot de passe ...).
	 * <p>Le clic sur Back fait revenir l'utilisateur vers la "fenêtre" d'authentification c'est util si jamais l'utilisateur s'est trompé en cliquant sur sign up. 
	 */
	public void actionPerformed(ActionEvent parEvt) {

		if (parEvt.getSource() == btnLogin) {

			try {
				boolean flag = true;
				String UsernameStr = chUsernameField.getText().trim();
				String Pwd = chPasswordField.getText();
				if ("".equals(String.valueOf(UsernameStr).trim()) || "".equals(String.valueOf(Pwd).trim())) {
					chLabelInvUserPass.setVisible(true);
					return;
				}

				FileReader reader = new FileReader("fich.Users" + File.separator + "Users.txt");
				BufferedReader bufferedReader = new BufferedReader(reader);
				String line;

				while ((line = bufferedReader.readLine()) != null) {

					String unpd[] = line.split(";");
					unpd[0] = unpd[0].trim();
					unpd[1] = unpd[1].trim();
					if (UsernameStr == null ? unpd[0] == null : UsernameStr.equals(unpd[0].toString())) {
						if (Pwd == null ? unpd[1] == null : Pwd.equals(unpd[1].toString())) {
							flag = false;
							break;
						}

					}
				}
				reader.close();
				fichTes = new File("fich.Agenda" + File.separator + chUsernameField.getText() + ".ser");
				FenetreAgenda a = null;

				if (flag) {
					chLabelCnxReq.setVisible(false);
					chLabelInvUserPass.setVisible(true);
					
				} else {
					a = new FenetreAgenda("Agenda DB - Principal");
					a.setVisible(true);
					chFrame.dispose();

				}
			}

			catch (java.lang.Exception ex) {
				// Si erreur du pgm Java
				ex.printStackTrace();
			} // catch Java
		} else {

			if (parEvt.getSource() == btnInsc) {
				setBounds(100, 100, 500, 490);
				chLabelOblg.setBounds(100, 390, 300, 15);

				chLabelInvUserPass.setVisible(false);
				chLabelFieldErr.setVisible(false);
				chLabelExiErr.setVisible(false);

				chFirstMsg.setVisible(false);
				chScndMsg.setVisible(true);
				btnLogin.setVisible(false);
				btnInsc.setVisible(false);
				chLabelMail.setVisible(true);
				chMailField.setVisible(true);
				chLabelAgeContr.setVisible(true);
				comboAge.setVisible(true);
				chLabelOblg.setVisible(true);
				chLabelAgeMean.setVisible(true);
				btnValide.setVisible(true);
				btnBack.setVisible(true);

			}
			if (parEvt.getSource() == btnValide) {

				FileReader reader = null;
				String UsernameStr = chUsernameField.getText().trim();
				String Pwd = chPasswordField.getText();
				try {

					if ("".equals(String.valueOf(UsernameStr).trim()) || "".equals(String.valueOf(Pwd).trim())) {
						chLabelFieldErr.setVisible(false);
						chLabelFieldErr.setVisible(true);
						chUsernameField.setText("");
						chLabelUser.requestFocus();
						chPasswordField.setText("");
						return;
					}

					reader = new FileReader("fich.Users" + File.separator + "Users.txt");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				BufferedReader bufferedReader = new BufferedReader(reader);

				String line;
				String Accounts = "";

				try {

					while ((line = bufferedReader.readLine()) != null) {

						Accounts += line + "\r\n";
						String unpd[] = line.split(";");
						unpd[0] = unpd[0].trim();
						unpd[1] = unpd[1].trim();
						
						if(UsernameStr.equals(unpd[0]))
						{
							chLabelExiErr.setVisible(false);
							chLabelExiErr.setVisible(true);
							return;
						}
					}

					Accounts += UsernameStr + ";" + Pwd;
					FileWriter writer = new FileWriter("fich.Users" + File.separator + "Users.txt");
					fichTes = new File("fich.Agenda" + File.separator + chUsernameField.getText() + ".ser");
					writer.write(Accounts);
					writer.close();
					reader.close();

					setBounds(100, 100, 500, 400);
					
					chLabelOblg.setBounds(100,290,300,15);

					chScndMsg.setVisible(false);
					chFirstMsg.setVisible(true);
					chLabelMail.setVisible(false);
					chMailField.setVisible(false);
					chLabelAgeContr.setVisible(false);
					comboAge.setVisible(false);
					chLabelFieldErr.setVisible(false);
					chLabelExiErr.setVisible(false);
					btnLogin.setVisible(true);
					btnInsc.setVisible(true);
					btnValide.setVisible(false);
					btnBack.setVisible(false);
					chLabelOblg.setVisible(false);
					chLabelAgeMean.setVisible(false);

					chLabelInvUserPass.setBounds(120, 200, 300, 30);
					chLabelInvUserPass.setVisible(false);
					chLabelCnxReq.setVisible(true);

					chUsernameField.setText("");
					chLabelUser.requestFocus();
					chPasswordField.setText("");

				} catch (IOException ex) {

					ex.printStackTrace();
				}

			}
		}
		if (parEvt.getSource() == btnBack) {
			
			setBounds(100, 100, 500, 400);
			
			chLabelOblg.setBounds(100,290,300,15);
			
		
			chScndMsg.setVisible(false);
			chFirstMsg.setVisible(true);
			chLabelMail.setVisible(false); 
			chMailField.setVisible(false);
			chLabelAgeContr.setVisible(false);
			comboAge.setVisible(false);
			chLabelFieldErr.setVisible(false);
			chLabelExiErr.setVisible(false);
			btnLogin.setVisible(true);
			btnInsc.setVisible(true);
			btnValide.setVisible(false);
			btnBack.setVisible(false);
			chLabelOblg.setVisible(true);
			chLabelAgeMean.setVisible(false);
			
			
			chLabelInvUserPass.setBounds(120, 200, 300, 30);
			chLabelInvUserPass.setVisible(false);
			
			chUsernameField.setText("");
			chLabelUser.requestFocus();
			chPasswordField.setText("");
		}

	}

	
	/**
	 * Cette méthode retoune le nom de l'utilisateur actuellement connecté.
	 * @return String : username.
	 */
	public static String getCurrentUsername() {
		return chUsernameField.getText();
	}

}
