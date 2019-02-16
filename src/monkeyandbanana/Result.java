package monkeyandbanana;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Result extends JFrame {

	private JPanel contentPane;
	private int score;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Result(int score) {
		this.score=score;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JLabel lblYourFinalScore = new JLabel("Your Final Score is "+score);
		lblYourFinalScore.setBounds(85, 38, 363, 255);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		ImageIcon img=new ImageIcon("./src/img/monkey.jpg");
		panel.setLayout(null);
		lblYourFinalScore.setIcon(img);
		panel.add(lblYourFinalScore);
		
		
	}

}
