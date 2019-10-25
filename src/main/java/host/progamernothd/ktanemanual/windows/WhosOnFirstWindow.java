package host.progamernothd.ktanemanual.windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import host.progamernothd.ktanemanual.solver.WhosOnFirstSolverStage1;
import host.progamernothd.ktanemanual.solver.WhosOnFirstSolverStage2;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class WhosOnFirstWindow {

	private JFrame frame;
	private JTextField inField1;
	private JTextField outField1;
	private JTextField inField2;
	private JTextArea outField2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WhosOnFirstWindow window = new WhosOnFirstWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void solve1() {
		getOutField1().setText(WhosOnFirstSolverStage1.solve(getInField1().getText()).toString());
	}
	
	private void solve2() {
		getOutField2().setText(Arrays.toString(WhosOnFirstSolverStage2.solve(getInField2().getText())));
	}
	public WhosOnFirstWindow() {
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
		
		JPanel panel_1 = new JPanel();
		
		inField2 = new JTextField();
		inField2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				solve2();
			}
		});
		inField2.setColumns(10);
		panel_1.add(inField2);
		
		JButton button = new JButton("Berechnen");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				solve2();
			}
		});
		panel_1.add(button);
		
		outField2 = new JTextArea();
		outField2.setLineWrap(true);
		outField2.setColumns(10);
		
		JLabel lblEnterGehtAuch = new JLabel("Enter geht auch");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(outField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblEnterGehtAuch)
							.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEnterGehtAuch)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(outField2, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)))
					.addContainerGap())
		);
		
		inField1 = new JTextField();
		panel.add(inField1);
		inField1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ENTER (the dungon)");
				solve1();
			}
		});
		inField1.setColumns(10);
		
		JButton btnBerechnen = new JButton("Berechnen");
		btnBerechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				solve1();
			}
		});
		panel.add(btnBerechnen);
		
		outField1 = new JTextField();
		panel.add(outField1);
		outField1.setColumns(10);
		frame.getContentPane().setLayout(groupLayout);
	}
	public JTextField getOutField1() {
		return outField1;
	}
	public JTextArea getOutField2() {
		return outField2;
	}
	public JTextField getInField1() {
		return inField1;
	}
	public JTextField getInField2() {
		return inField2;
	}
}
