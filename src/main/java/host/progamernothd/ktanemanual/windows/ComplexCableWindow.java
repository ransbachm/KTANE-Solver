package host.progamernothd.ktanemanual.windows;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

import host.progamernothd.ktanemanual.enums.KTANEColor;
import host.progamernothd.ktanemanual.solver.ComplexCableSolver;
import host.progamernothd.ktanemanual.solver.SensoSolver;
import host.progamernothd.ktanemanual.enums.ComplexCableFeature;
import static host.progamernothd.ktanemanual.enums.ComplexCableFeature.*;

import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;

public class ComplexCableWindow {

	private JFrame frame;
	private JTextArea textAreaIn;
	private JTextArea textAreaOut;
	private LinkedList<ComplexCableFeature> cableList = new LinkedList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComplexCableWindow window = new ComplexCableWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void addCable(ComplexCableFeature f) {
		cableList.add(f);
		reDrawList();
	}
	private void reDrawList() {
		textAreaIn.setText(cableList.toString());
		System.out.println(cableList);
	}
	private void removeLast() {
		cableList.remove(cableList.size()-1);
		reDrawList();
	}
	private void removeAll() {
		cableList.clear();
		reDrawList();
	}
	private void solve() {
		getTextAreaOut().setText(ComplexCableSolver.solve(cableList));
	}
	
	public ComplexCableWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		textAreaIn = new JTextArea();
		textAreaIn.setLineWrap(true);
		
		textAreaOut = new JTextArea();
		textAreaOut.setLineWrap(true);
		
		JButton btnLsen = new JButton("Berechnen");
		btnLsen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				solve();
			}
		});
		
		JButton btnNewButton = new JButton("R\u00FCckg\u00E4ngig");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeLast();
			}
		});
		
		JButton btnAllesLschen = new JButton("Alles l\u00F6schen");
		btnAllesLschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLsen)
						.addComponent(btnNewButton)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAllesLschen, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(textAreaOut, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
						.addComponent(textAreaIn, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
					.addGap(23))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addComponent(textAreaIn, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnLsen)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAllesLschen))
						.addComponent(textAreaOut, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JButton btnRed = new JButton("Rot");
		btnRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCable(Red);
			}
		});
		panel.add(btnRed);
		
		JButton btnBlue = new JButton("Blau");
		btnBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCable(Blue);
			}
		});
		panel.add(btnBlue);
		
		JButton btnStar = new JButton("Stern");
		btnStar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCable(Star);
			}
		});
		panel.add(btnStar);
		
		JButton btnStar_1 = new JButton("LED");
		btnStar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCable(LED);
			}
		});
		panel.add(btnStar_1);
		frame.getContentPane().setLayout(groupLayout);
	}
	public JTextArea getTextAreaIn() {
		return textAreaIn;
	}
	public JTextArea getTextAreaOut() {
		return textAreaOut;
	}
}
