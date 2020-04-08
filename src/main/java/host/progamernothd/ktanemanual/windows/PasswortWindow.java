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
import host.progamernothd.ktanemanual.solver.PasswordSolver;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class PasswortWindow {

	private JFrame frame;
	private final ButtonGroup buttonGroupText = new ButtonGroup();
	private final ButtonGroup buttonGroupColor = new ButtonGroup();
	public ButtonInstruction crrInstruction;
	public KTANEColor crrColor;
	private JTextArea textField;
	private JTextField txtLetterByLetter;
	private JTextArea textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswortWindow window = new PasswortWindow();
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
	public PasswortWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		textField = new JTextArea();
		textField.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				String newValue = textField.getText();
				System.out.println("Text changed. New value: " + newValue);
				if(!newValue.isEmpty()) {
					textField_1.setText(PasswordSolver.solve(newValue).toString());
				}
			}
		});
		textField.setColumns(10);
		
		txtLetterByLetter = new JTextField();
		txtLetterByLetter.setHorizontalAlignment(SwingConstants.CENTER);
		txtLetterByLetter.setText("Letter by letter that is possible split with ; example : aegf;aasdw;asda;");
		txtLetterByLetter.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Possible Letters");
		
		JLabel lblNewLabel_1 = new JLabel("Possible Words");
		
		textField_1 = new JTextArea();
		textField_1.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtLetterByLetter, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addComponent(lblNewLabel, Alignment.LEADING)
						.addComponent(lblNewLabel_1, Alignment.LEADING)
						.addComponent(textField_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(7)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
					.addComponent(txtLetterByLetter, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
