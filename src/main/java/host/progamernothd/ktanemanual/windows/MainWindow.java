package host.progamernothd.ktanemanual.windows;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class MainWindow {

	public JFrame frame;
	public JTextField txtEptd;
	public static String serialID;
	public JComboBox<String> batteryComboBox;
	public JCheckBox frkCheckbox;
	public JCheckBox carCheckbox;
	public JCheckBox paralellCheckbox;
	public static int strikes;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtEptd = new JTextField();
		
		txtEptd.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				update(e);
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				update(e);
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				update(e);
				
			}
			void update(DocumentEvent e) {
				Document d = e.getDocument();
				try {
					serialID = d.getText(0, d.getLength());
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
				System.out.println(serialID);
			}
		});
		
		txtEptd.setText("EP1TD2");
		txtEptd.setColumns(10);
		
		JLabel lblSerialId = new JLabel("Serial id");
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		
		JPanel panel_3 = new JPanel();
		
		JPanel panel_4 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_2, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEptd, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSerialId, Alignment.TRAILING)
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblSerialId)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtEptd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(43)
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18))))
		);
		
		paralellCheckbox = new JCheckBox("Parallel");
		panel_4.add(paralellCheckbox);
		
		JButton btnNewButton = new JButton("Kabel");
		panel_3.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CableWindow.main(null);
			}
		});
		
		JButton btnKnopf = new JButton("Knopf");
		panel_3.add(btnKnopf);
		btnKnopf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ButtonWindow.main(null);
			}
		});
		
		JButton btnZeichen = new JButton("Zeichen");
		panel_3.add(btnZeichen);
		btnZeichen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SymbolWindow.main(null);
			}
		});
		
		JButton btnSenso = new JButton("Senso");
		panel_3.add(btnSenso);
		
		JButton btnWhosOnFirst = new JButton("Who's on first");
		btnWhosOnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WhosOnFirstWindow.main(null);
			}
		});
		panel_3.add(btnWhosOnFirst);
		btnSenso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SensoWindow.main(null);
			}
		});
		
		JLabel lblStrikes = new JLabel("Strikes");
		panel_2.add(lblStrikes);
		
		JComboBox strikesBox = new JComboBox();
		strikesBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				strikes = strikesBox.getSelectedIndex();
			}
		});
		strikesBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2"}));
		panel_2.add(strikesBox);
		
		JLabel lblBatteries = new JLabel("Batteries");
		panel_1.add(lblBatteries);
		
		batteryComboBox = new JComboBox();
		batteryComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(batteryComboBox.getSelectedIndex());
			}
		});
		panel_1.add(batteryComboBox);
		batteryComboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5"}));
		
		frkCheckbox = new JCheckBox("FRK");
		panel.add(frkCheckbox);
		
		carCheckbox = new JCheckBox("CAR");
		panel.add(carCheckbox);
		frame.getContentPane().setLayout(groupLayout);
	}
	public JCheckBox getFrkCheckbox() {
		return frkCheckbox;
	}
	public JCheckBox getCarCheckbox() {
		return carCheckbox;
	}
	@SuppressWarnings("rawtypes")
	public JComboBox getBatteryComboBox() {
		return batteryComboBox;
	}
	public JCheckBox getParalellCheckbox() {
		return paralellCheckbox;
	}
}
