import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Kiki_Nguyen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kiki_Nguyen frame = new Kiki_Nguyen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Kiki_Nguyen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Cộng");
		btnNewButton.setBounds(39, 70, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int currentValue = Integer.parseInt(textField.getText());
		        currentValue++;
		        textField.setText(String.valueOf(currentValue));
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(133, 71, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
	}

}
