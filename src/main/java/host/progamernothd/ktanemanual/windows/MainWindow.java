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

public class MainWindow {

	public JFrame frame;
	public JTextField txtEptd;
	public static String serialID;
	public JComboBox<String> batteryComboBox;
	public JCheckBox frkCheckbox;
	public JCheckBox carCheckbox;

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
		
		JButton btnNewButton = new JButton("Kabel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CableWindow.main(null);
			}
		});
		
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
		
		JButton btnKnopf = new JButton("Knopf");
		btnKnopf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ButtonWindow.main(null);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSerialId)
							.addGap(36))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnKnopf, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtEptd, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSerialId)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(txtEptd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnKnopf)))
					.addContainerGap(120, Short.MAX_VALUE))
		);
		
		JLabel lblBatteries = new JLabel("Batteries");
		panel_1.add(lblBatteries);
		
		batteryComboBox = new JComboBox();
		panel_1.add(batteryComboBox);
		batteryComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		
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
}
