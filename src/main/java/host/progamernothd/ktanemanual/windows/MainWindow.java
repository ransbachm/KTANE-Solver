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
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class MainWindow {

	public JFrame frame;
	public JTextField txtEptd;
	public static String serialID;

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
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
							.addComponent(txtEptd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblSerialId)
							.addGap(36))))
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
					.addContainerGap(215, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
