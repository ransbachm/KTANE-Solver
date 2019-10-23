package host.progamernothd.ktanemanual.windows;

import java.awt.EventQueue;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

import host.progamernothd.ktanemanual.enums.KTANEColor;
import host.progamernothd.ktanemanual.solver.SensoSolver;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SensoWindow {

	private JFrame frame;
	JTextArea textAreaIn;
	LinkedList<KTANEColor> colorList = new LinkedList<>();
	private JTextArea textAreaOut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SensoWindow window = new SensoWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void addColor(KTANEColor c) {
		colorList.add(c);
		reDrawList();
	}
	private void reDrawList() {
		textAreaIn.setText(colorList.toString());
	}
	private void removeLast() {
		colorList.remove(colorList.size()-1);
		reDrawList();
	}
	private void removeAll() {
		colorList.clear();
		reDrawList();
	}
	private void solve() {
		getTextAreaOut().setText(SensoSolver.solve(colorList).toString());
	}
	

	public SensoWindow() {
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
		
		JPanel panel_2 = new JPanel();
		
		JButton button = new JButton("R\u00FCckg\u00E4ngig");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeLast();
			}
		});
		panel_2.add(button);
		
		JButton button_1 = new JButton("Alles L\u00F6schen");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
			}
		});
		panel_2.add(button_1);
		
		JButton button_2 = new JButton("Berechnen");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				solve();
			}
		});
		panel_2.add(button_2);
		
		textAreaOut = new JTextArea();
		textAreaOut.setLineWrap(true);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(textAreaIn, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addComponent(textAreaOut, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textAreaIn, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textAreaOut, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		JButton btnNewButton = new JButton("Rot");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addColor(KTANEColor.Red);
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Gr\u00FCn");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addColor(KTANEColor.Green);
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Blau");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addColor(KTANEColor.Blue);
			}
		});
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Gelb");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addColor(KTANEColor.Yellow);
			}
		});
		panel.add(btnNewButton_3);
		frame.getContentPane().setLayout(groupLayout);
	}
	protected JTextArea getTextAreaIn() {
		return textAreaIn;
	}
	public JTextArea getTextAreaOut() {
		return textAreaOut;
	}
}
