package host.progamernothd.ktanemanual.windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import host.progamernothd.ktanemanual.enums.ButtonInstruction;
import host.progamernothd.ktanemanual.enums.KTANEColor;
import host.progamernothd.ktanemanual.solver.ButtonSolver;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ButtonWindow {

	private JFrame frame;
	private final ButtonGroup buttonGroupText = new ButtonGroup();
	private final ButtonGroup buttonGroupColor = new ButtonGroup();
	public ButtonInstruction crrInstruction;
	public KTANEColor crrColor;
	private JTextArea txtrOut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ButtonWindow window = new ButtonWindow();
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
	public ButtonWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel actionPanel = new JPanel();
		
		JPanel colorPanel = new JPanel();
		
		JButton btnSolve = new JButton("Solve");
		btnSolve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(crrColor + " " + crrInstruction);
				getTxtrOut().setText(ButtonSolver.solve(crrColor, crrInstruction).toString());
			}
		});
		
		txtrOut = new JTextArea();
		
		JTextArea txtrBlau = new JTextArea();
		txtrBlau.setText("Blau -> 4\r\nWei\u00DF -> 1\r\nGelb -> 5\r\nAndere -> 1");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(actionPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(colorPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
							.addComponent(txtrOut, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSolve)
							.addPreferredGap(ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
							.addComponent(txtrBlau, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(txtrOut, Alignment.LEADING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(actionPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(colorPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSolve)
						.addComponent(txtrBlau, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(131, Short.MAX_VALUE))
		);
		
		JRadioButton rdbtnBlau = new JRadioButton("Blau");
		rdbtnBlau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crrColor = KTANEColor.Blue;
			}
		});
		buttonGroupColor.add(rdbtnBlau);
		colorPanel.add(rdbtnBlau);
		
		JRadioButton rdbtnWei = new JRadioButton("Wei\u00DF");
		rdbtnWei.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crrColor = KTANEColor.White;
			}
		});
		buttonGroupColor.add(rdbtnWei);
		colorPanel.add(rdbtnWei);
		
		JRadioButton rdbtnGelb = new JRadioButton("Gelb");
		rdbtnGelb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crrColor = KTANEColor.Yellow;
			}
		});
		buttonGroupColor.add(rdbtnGelb);
		colorPanel.add(rdbtnGelb);
		
		JRadioButton rdbtnRot = new JRadioButton("Rot");
		rdbtnRot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crrColor = KTANEColor.Red;
			}
		});
		buttonGroupColor.add(rdbtnRot);
		colorPanel.add(rdbtnRot);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Abort");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crrInstruction = ButtonInstruction.Abort;
			}
		});
		buttonGroupText.add(rdbtnNewRadioButton);
		actionPanel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnDetonate = new JRadioButton("Detonate");
		rdbtnDetonate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crrInstruction = ButtonInstruction.Detonate;
			}
		});
		buttonGroupText.add(rdbtnDetonate);
		actionPanel.add(rdbtnDetonate);
		
		JRadioButton rdbtnHold = new JRadioButton("Hold");
		rdbtnHold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crrInstruction = ButtonInstruction.Hold;
			}
		});
		buttonGroupText.add(rdbtnHold);
		actionPanel.add(rdbtnHold);
		frame.getContentPane().setLayout(groupLayout);
	}
	protected JTextArea getTxtrOut() {
		return txtrOut;
	}
}
