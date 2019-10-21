package host.progamernothd.ktanemanual.windows;

import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import host.progamernothd.ktanemanual.enums.KTANESymbol;
import host.progamernothd.ktanemanual.solver.SymbolSolver;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SymbolWindow {

	private JFrame frame;
	private JTextArea txtrOut;
	LinkedList<KTANESymbol> symbolList = new LinkedList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SymbolWindow window = new SymbolWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	private void addSymbol(KTANESymbol s) {
		symbolList.add(s);
		reDrawList();
	}
	private void reDrawList() {
		getTxtrOut().setText(symbolList.toString());
	}
	private void solve() {
		try {
			getTxtrOut().setText("Set: " + SymbolSolver.solve(symbolList).toString());
		} catch (IllegalArgumentException e) {
			getTxtrOut().setText("Row not found! " + getTxtrOut().getText());
		}
		System.out.println("Done");
	}
	
	
	public SymbolWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 626, 380);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		JPanel panel_2 = new JPanel();
		
		JPanel panel_3 = new JPanel();
		
		JPanel panel_4 = new JPanel();
		
		JPanel panel_5 = new JPanel();
		
		JLabel lblSchnrkel = new JLabel("Schn\u00F6rkel");
		
		JLabel lblSymbole = new JLabel("Symbole");
		
		JLabel lblNewLabel = new JLabel("2 Zeichen");
		
		JLabel lblGedrehtes = new JLabel("Gedrehtes");
		
		JLabel lblSterne = new JLabel("Sterne");
		
		JPanel panel_1 = new JPanel();
		
		txtrOut = new JTextArea();
		txtrOut.setLineWrap(true);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(12, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 462, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblSchnrkel)
							.addGap(104))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSterne)
										.addComponent(lblGedrehtes))
									.addGap(44))
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblSymbole)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtrOut, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(80)
									.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)))
							.addGap(238)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(289)
					.addComponent(lblSterne)
					.addContainerGap(36, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(40)
							.addComponent(lblSchnrkel))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(6)
											.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(6)
											.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(18)
											.addComponent(lblGedrehtes))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(30)
									.addComponent(lblSymbole)))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(44)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addComponent(txtrOut, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		
		JButton btnRckgngig = new JButton("R\u00FCckg\u00E4ngig");
		panel_1.add(btnRckgngig);
		
		JButton btnAllesLschen = new JButton("Alles L\u00F6schen");
		panel_1.add(btnAllesLschen);
		
		JButton btnBerechnen = new JButton("Berechnen");
		panel_1.add(btnBerechnen);
		btnBerechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				solve();
			}
		});
		btnAllesLschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				symbolList.clear();
				reDrawList();
			}
		});
		btnRckgngig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				symbolList.remove(symbolList.size()-1);
				reDrawList();
			}
		});
		
		JButton btnSternLeer = new JButton("Stern Leer");
		btnSternLeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSymbol(KTANESymbol.EmptyStar);
			}
		});
		panel_5.add(btnSternLeer);
		
		JButton btnSternVoll = new JButton("Stern Voll");
		btnSternVoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSymbol(KTANESymbol.FilledStar);
			}
		});
		panel_5.add(btnSternVoll);
		
		JButton btnDreh = new JButton("Dreh 9");
		btnDreh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSymbol(KTANESymbol.Turned9);
			}
		});
		panel_4.add(btnDreh);
		
		JButton btnDreh_1 = new JButton("Dreh ?");
		btnDreh_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSymbol(KTANESymbol.TurnedQM);
			}
		});
		panel_4.add(btnDreh_1);
		
		JButton btnAt = new JButton("AT");
		btnAt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSymbol(KTANESymbol.AT);
			}
		});
		panel_3.add(btnAt);
		
		JButton btnTb = new JButton("TB");
		btnTb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSymbol(KTANESymbol.TB);
			}
		});
		panel_3.add(btnTb);
		
		JButton btnAe = new JButton("AE");
		btnAe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSymbol(KTANESymbol.AE);
			}
		});
		panel_3.add(btnAe);
		
		JButton btnSmiley = new JButton("Smiley");
		btnSmiley.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSymbol(KTANESymbol.Smiley);
			}
		});
		panel_2.add(btnSmiley);
		
		JButton btnLffel = new JButton("L\u00F6ffel");
		btnLffel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSymbol(KTANESymbol.Spoon);
			}
		});
		panel_2.add(btnLffel);
		
		JButton btnWelle = new JButton("Welle");
		btnWelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSymbol(KTANESymbol.Wave);
			}
		});
		panel_2.add(btnWelle);
		
		JButton btnKrake = new JButton("Krake");
		btnKrake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				addSymbol(KTANESymbol.Kraken);
			}
		});
		panel_2.add(btnKrake);
		
		JButton btnLuftzug = new JButton("Luftzug");
		btnLuftzug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSymbol(KTANESymbol.Breeze);
			}
		});
		
		JButton btnCopyrigh = new JButton("\u00A9");
		btnCopyrigh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSymbol(KTANESymbol.Copyright);
			}
		});
		panel_2.add(btnCopyrigh);
		panel_2.add(btnLuftzug);
		
		JButton btnKerzenhalter = new JButton("Kerzenhalter");
		btnKerzenhalter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSymbol(KTANESymbol.CandleHolder);
			}
		});
		panel_2.add(btnKerzenhalter);
		
		JButton btnLego = new JButton("Lego");
		btnLego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSymbol(KTANESymbol.Lego);
			}
		});
		panel_2.add(btnLego);
		
		JButton btnOmaga = new JButton("Omaga");
		btnOmaga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSymbol(KTANESymbol.Omaga);
			}
		});
		panel_2.add(btnOmaga);
		
		JButton btnSnUnten = new JButton("Sn 3 Unten");
		btnSnUnten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSymbol(KTANESymbol.Sn3down);
			}
		});
		panel.add(btnSnUnten);
		
		JButton btnSnGes = new JButton("Sn 3 ges");
		btnSnGes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSymbol(KTANESymbol.Sn3all);
			}
		});
		panel.add(btnSnGes);
		
		JButton btnSnA = new JButton("Sn A");
		btnSnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSymbol(KTANESymbol.SnA);
			}
		});
		panel.add(btnSnA);
		
		JButton btnCPunkt = new JButton("C Punkt");
		btnCPunkt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSymbol(KTANESymbol.SnCwP);
			}
		});
		panel.add(btnCPunkt);
		
		JButton btnCPunktDreh = new JButton("C Punkt Dreh");
		btnCPunktDreh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSymbol(KTANESymbol.SnCTurnedwP);
			}
		});
		panel.add(btnCPunktDreh);
		
		JButton btnSnE = new JButton("Sn E");
		btnSnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSymbol(KTANESymbol.SnE);
			}
		});
		panel.add(btnSnE);
		
		JButton btnSnH = new JButton("Sn H");
		btnSnH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSymbol(KTANESymbol.SnH);
			}
		});
		panel.add(btnSnH);
		
		JButton btnSnP = new JButton("Sn P");
		btnSnP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSymbol(KTANESymbol.SnP);
			}
		});
		
		JButton btnSnN = new JButton("Sn N");
		panel.add(btnSnN);
		panel.add(btnSnP);
		
		JButton btnSnW = new JButton("Sn W");
		btnSnW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSymbol(KTANESymbol.SnW);
			}
		});
		panel.add(btnSnW);
		
		JButton btnSnX = new JButton("Sn X");
		btnSnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSymbol(KTANESymbol.SnX);
			}
		});
		panel.add(btnSnX);
		frame.getContentPane().setLayout(groupLayout);
	}
	public JTextArea getTxtrOut() {
		return txtrOut;
	}
}
