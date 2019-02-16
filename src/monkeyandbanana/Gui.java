package monkeyandbanana;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import monkeyandbanana.MonkeyController.TimerTask2;

import javax.swing.border.CompoundBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JTextField;

import java.util.Timer;
import java.util.TimerTask;


public class Gui extends JFrame {
	private JPanel contentPane;
    public int mx=0,my=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
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
	public JPanel j=new JPanel() {
		MonkeyController b=new MonkeyController();

		
		public void paint(Graphics g) {
			super.paint(g);    
			g.setColor(Color.BLUE);
			g.fillRect(mx, my, 10, 10);
			b.getMon(mx, my);
			b.Behavior();
			g.setColor(Color.YELLOW);
			g.fillRect(b.GetxPos(), b.GetyPos(), 10, 10);
			
			g.setColor(Color.GREEN);
			for(int i=0;i<=500;i+=10) {
				g.drawLine(i, 0, i, 500);
			}
			for(int j=0;j<=500;j+=10) {
				g.drawLine(0, j, 500, j);
			}
			textField.setText("Score:   "+b.score);	
			Time2.setText(""+b.time);
		    TotalTime.setText(""+b.Totaltime);
		   
		}
		
	};
	private JTextField textField;
	private JTextField TotalTime;
	private JTextField Time2;
	public int delay=1;

	public void keyaction() {
		
		j.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(delay==1) {
				int k=e.getKeyCode();
				Timer delay1=new Timer();
				delay1.schedule(new TimerTask4(), 250);
				delay=0;
				switch(k){
				case KeyEvent.VK_UP:
					my-=10;
					break;
				case KeyEvent.VK_DOWN:
					my+=10;
					break;
				case KeyEvent.VK_RIGHT:
					mx+=10;
					break;
				case KeyEvent.VK_LEFT:
					mx-=10;
					break;		
                        	}
				
               repaint();	
			}
			}
			
		});
	}
	
	public Gui() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 808, 570);
		keyaction();
		
		contentPane = j;
		j.setFocusable(true);
		contentPane.setBorder(new CompoundBorder());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Timer refresh=new Timer();
		refresh.schedule(new TimerTask3(), 0,100);
		
		
		
		textField = new JTextField();
		textField.setBounds(569, 116, 149, 43);
		j.add(textField);
		textField.setColumns(10);
		
		JLabel lblTotalTimeLeft = new JLabel("Total Time Left");
		lblTotalTimeLeft.setFont(new Font("宋体", Font.BOLD, 17));
		lblTotalTimeLeft.setBounds(553, 270, 165, 43);
		j.add(lblTotalTimeLeft);
		
		JLabel lblTimeToGet = new JLabel("Time to get next banana");
		lblTimeToGet.setFont(new Font("宋体", Font.BOLD, 17));
		lblTimeToGet.setBounds(522, 356, 324, 56);
		j.add(lblTimeToGet);
		
		TotalTime = new JTextField();
		TotalTime.setBounds(597, 342, 66, 21);
		j.add(TotalTime);
		TotalTime.setColumns(10);
		
		Time2 = new JTextField();
		Time2.setBounds(597, 439, 66, 21);
		j.add(Time2);
		Time2.setColumns(10);
		
		JLabel lblTimeIntervalFor = new JLabel("Time interval for");
		lblTimeIntervalFor.setFont(new Font("宋体", Font.BOLD, 17));
		lblTimeIntervalFor.setBounds(551, 10, 460, 43);
		j.add(lblTimeIntervalFor);
		
		JLabel lblEachMovements = new JLabel("each movement:0.25s");
		lblEachMovements.setFont(new Font("宋体", Font.BOLD, 17));
		lblEachMovements.setBounds(536, 63, 460, 43);
		j.add(lblEachMovements);
			
	}
	class TimerTask3 extends TimerTask{
		public void run() {
		repaint();
		}
	}
	class TimerTask4 extends TimerTask{
		public void run() {
          delay=1;
		}
	}
}
