package host.progamernothd.ktanemanual.windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import host.progamernothd.ktanemanual.enums.KTANEColor;
import host.progamernothd.ktanemanual.solver.CableSolver;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class CableWindow {

	private JFrame frame;
	LinkedList<KTANEColor> cableList = new LinkedList<>();
	JTextArea textArea;
	JTextArea targetValue;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CableWindow window = new CableWindow();
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
	public CableWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void addCable(KTANEColor c) {
		cableList.add(c);
		reDrawList();
	}
	private void reDrawList() {
		textArea.setText(cableList.toString());
	}
	private void solve() {
		int target = CableSolver.solve(cableList);
		targetValue.setText(Integer.toString(target));
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 317);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		
		JPanel panel = new JPanel();
		
		JLabel lblAddCable = new JLabel("Kabel hinzuf\u00FCgen");
		
		JPanel panel_1 = new JPanel();
		
		JLabel lblAktionen = new JLabel("Aktionen");
		
		targetValue = new JTextArea();
		targetValue.setLineWrap(true);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAktionen)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 163, Short.MAX_VALUE)
							.addComponent(lblAddCable, Alignment.LEADING)))
					.addGap(95)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(targetValue, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(16)
					.addComponent(lblAddCable)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(textArea)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAktionen)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(targetValue, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		
		JButton btnRckgngig = new JButton("R\u00FCckg\u00E4ngig");
		btnRckgngig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cableList.removeLast();
				reDrawList();
			}
		});
		panel_1.add(btnRckgngig);
		
		JButton btnAllesLschen = new JButton("Alles L\u00F6schen");
		btnAllesLschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cableList.clear();
				reDrawList();
			}
		});
		panel_1.add(btnAllesLschen);
		
		JButton btnBerechnen = new JButton("Berechnen");
		btnBerechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				solve();
			}
		});
		panel_1.add(btnBerechnen);
		
		JButton btnRot = new JButton("Rot");
		panel.add(btnRot);
		btnRot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCable(KTANEColor.Red);
			}
		});
		
		JButton btnGelb = new JButton("Gelb");
		btnGelb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCable(KTANEColor.Yellow);
			}
		});
		panel.add(btnGelb);
		
		JButton btnWei = new JButton("Wei\u00DF");
		btnWei.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCable(KTANEColor.White);
			}
		});
		panel.add(btnWei);
		
		JButton btnBlau = new JButton("Blau");
		btnBlau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCable(KTANEColor.Blue);
			}
		});
		panel.add(btnBlau);
		
		JButton btnSchwarz = new JButton("Schwarz");
		btnSchwarz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCable(KTANEColor.Black);
			}
		});
		panel.add(btnSchwarz);
		frame.getContentPane().setLayout(groupLayout);
	}
}
