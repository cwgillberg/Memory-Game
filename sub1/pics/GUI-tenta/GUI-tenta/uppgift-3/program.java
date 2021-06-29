//anonymiseringskod: DVGA11-0027-DGX

import java.awt.event.*;
import java.util.Random;
import java.awt.*;
import javax.swing.*;

public class program {
	public JButton hitButton, standButton, startButton;
	public JLabel playerScore, computerScore;
	public JLabel statusLabel, pLabel, cLabel;;
	public JPanel buttonPanel, scorePanel, headerPanel, scoreMasterPanel;
	boolean cstand, pstand;
	public Random random;

	public frontEnd frontend;
	public backEnd backend;

	public program() {
		random = new Random();
		frontend = new frontEnd();
		frontend.setupLayout();
		backend = new backEnd();

	}
	

	
	public static void main(String[] args) {
		new program();
	}



	class frontEnd extends JFrame {

		private backEnd backend;

		private void setupLayout() {
			backend = new backEnd();

			hitButton = new JButton("Hit");
			standButton = new JButton("Stand");
			startButton = new JButton("Start");
			playerScore = new JLabel("0");
			computerScore = new JLabel("0");
			statusLabel = new JLabel("Press start to start");
			hitButton.addActionListener(backend);
			standButton.addActionListener(backend);
			startButton.addActionListener(backend);
			scorePanel = new JPanel();
			scoreMasterPanel = new JPanel();
			buttonPanel = new JPanel();
			headerPanel = new JPanel();
			pLabel = new JLabel("Player Score: ");
			cLabel = new JLabel("Computer Score: ");



			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(400, 400);
			setVisible(true);
			scorePanel.setLayout(new GridLayout(3, 2, 10, 10));
			scoreMasterPanel.setLayout(new FlowLayout());

			buttonPanel.setLayout(new FlowLayout());
			headerPanel.setLayout(new FlowLayout());

			scorePanel.add(pLabel);
			scorePanel.add(playerScore);
			scorePanel.add(cLabel);
			scorePanel.add(computerScore);

			scoreMasterPanel.add(scorePanel);
			buttonPanel.add(startButton);
			buttonPanel.add(hitButton);
			buttonPanel.add(standButton);


			headerPanel.add(statusLabel);
			hitButton.setEnabled(false);
			standButton.setEnabled(false);

			add(headerPanel);
			add(scoreMasterPanel);
			add(buttonPanel);
			setLayout(new GridLayout(4, 1, 10, 50));

		}
	}

	class backEnd implements ActionListener {

		private frontEnd frontend;

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == startButton) {
				playerScore.setText("0");
				computerScore.setText("0");
				statusLabel.setText("Play");
				hitButton.setEnabled(true);
				standButton.setEnabled(true);
				startButton.setEnabled(false);
				cstand = false;
				pstand = false;
			}

			boolean gameover = false;
			int pscore = Integer.parseInt(playerScore.getText());
			int cscore = Integer.parseInt(computerScore.getText());
			if(e.getSource() == hitButton) {
				pscore += random.nextInt(12) + 1;
				if(pscore > 21) {
					statusLabel.setText("You Lose");
					gameover = true;
				}else if (pscore == 21) {
					statusLabel.setText("You Win");
					gameover = true;
				}

				if(!cstand && !gameover) {
					cscore += random.nextInt(12) + 1;
					if(cscore > 21) {
						statusLabel.setText("Computer Lose");
					}else if (cscore == 21)
						statusLabel.setText("Computer Win");
					else if (cscore > 16)
						cstand = true;
				}

			}
			else if (e.getSource() == standButton) {
				while(!gameover && ! (cscore > pscore)) {
					cscore += random.nextInt(12) + 1;
					if(cscore > 21) {
						statusLabel.setText("Computer Lose");
						gameover = true;
					}else if (cscore == 21) {
						statusLabel.setText("Computer Win");
						gameover = true;
					}else if (cscore > pscore) {
						statusLabel.setText("Computer Win");
						gameover = true;
					}
				}
				if(cscore > pscore)
					statusLabel.setText("Computer Win");
			}

			if(statusLabel.getText() != "Play") {
				hitButton.setEnabled(false);
				standButton.setEnabled(false);
				startButton.setEnabled(true);
			}

			playerScore.setText(Integer.toString(pscore));
			computerScore.setText(Integer.toString(cscore));
		}
	}
}
