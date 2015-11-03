package player;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MusicPlayer {

	private JFrame frame;
	private JPanel buttonPanel;
	private JPanel timerPanel;
	private JButton btnPlay;
	private JButton btnStop;
	private JButton btnPause;
	private JLabel label;
	private Player player;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusicPlayer window = new MusicPlayer();
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
	public MusicPlayer() {
		initialize();
		player = new Player(label);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		buttonPanel = new JPanel();
		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		btnPlay = new JButton("Play");
		btnPlay.addActionListener(new BtnPlayActionListener());
		buttonPanel.add(btnPlay);

		btnStop = new JButton("Stop");
		btnStop.addActionListener(new BtnStopActionListener());
		buttonPanel.add(btnStop);

		btnPause = new JButton("Pause");
		btnPause.addActionListener(new BtnPauseActionListener());
		buttonPanel.add(btnPause);

		timerPanel = new JPanel();
		frame.getContentPane().add(timerPanel, BorderLayout.CENTER);

		label = new JLabel("00:00");
		timerPanel.add(label);
	}

	public void oneSecond(String string) {
		label.setText(string);
	}

	private class BtnPlayActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			player.playMusic();
		}
	}

	private class BtnStopActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			player.stopMusic();

		}
	}

	private class BtnPauseActionListener implements ActionListener {
		public synchronized void actionPerformed(ActionEvent e) {
			player.pauseMusic();
		}
	}
}
