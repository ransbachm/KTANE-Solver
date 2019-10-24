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
		
		textAreaOut = new JTextArea();
		
		JButton btnLsen = new JButton("Berechnen");
		btnLsen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				solve();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
							.addComponent(textAreaIn, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnLsen)
							.addPreferredGap(ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
							.addComponent(textAreaOut, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textAreaIn, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textAreaOut, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(btnLsen)
							.addContainerGap())))
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
		
		JButton btnLed = new JButton("LED");
		btnLed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCable(Star);
			}
		});
		panel.add(btnLed);
		frame.getContentPane().setLayout(groupLayout);
	}
	public JTextArea getTextAreaIn() {
		return textAreaIn;
	}
	public JTextArea getTextAreaOut() {
		return textAreaOut;
	}
}
