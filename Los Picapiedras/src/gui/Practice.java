package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import sounds.TranslatorSounds;

public class Practice {

	private static TranslatorSounds ts = new TranslatorSounds();

	private static boolean isFirst = true;
	private static boolean isFirst2 = true;

	private static JPanel pnlTop = new JPanel();
	private static JPanel pnlBot = new JPanel();

	private static JLabel lblImage = new JLabel();

	private static JButton btn1 = new JButton("1");
	private static JButton btn2 = new JButton("2");
	private static JButton btn3 = new JButton("3");
	private static JButton btn4 = new JButton("4");

	private static String[] fileNames = { "a.png", "and.png", "ar.png", "b, but.png", "by, was.png", "c, can.png",
			"cc, con.png", "ch, child.png", "com.png", "d.png", "dd, dis.png", "e, every.png", "ea.png", "ed.png",
			"en, enough.png", "er.png", "f, from.png", "ff, to.png", "for.png", "g, go.png", "gg, were.png", "gh.png",
			"h, have.png", "i.png", "in.png", "ing.png", "j, just.png", "k, knowledge.png", "l, like.png",
			"m, more.png", "n, not.png", "o.png", "of.png", "ou, out.png", "ow.png", "p, people.png", "q, quite.png",
			"r, rather.png", "s.png", "sh, shall.png", "st, still.png", "t, that.png", "th, this.png", "the.png",
			"u, us.png", "v, very.png", "w, will.png", "wh, which.png", "with.png", "x, it.png", "y, you.png",
			"z, as.png" };

	private static int currentCorrectAnswer = getRandomInt();
	private static String correctAnswer;

	private static final Color GREY_BUTTON = new Color(54, 54, 54);
	private static final Color BLUE = new Color(115, 165, 186);
	private static final Color RED_WRONG = new Color(99, 33, 28);
	private static final Color GREEN_CORRECT = new Color(33, 138, 61);
	private static final Color DARK_GREY = new Color(23, 23, 23);

	public JPanel createContentPractice() {
		JPanel panel = new JPanel();

		correctAnswer = selectRandom(fileNames);

		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setBackground(null);

		int in = 35;
		panel.setBorder(BorderFactory.createEmptyBorder(in, in, in, in));

		configPanels();

		configTopPanel();
		configBotPanel();

		panel.add(pnlTop);
		panel.add(Box.createRigidArea(new Dimension(0, 35)));
		panel.add(pnlBot);

		return panel;
	}

	private static void configPanels() {
		pnlTop.setBackground(null);
		pnlTop.setLayout(new GridLayout(1, 1));

		pnlBot.setBackground(null);
		pnlBot.setLayout(new GridLayout(2, 2, 30, 30));
	}

	private void configTopPanel() {
		pnlTop.add(lblImage);
		pnlTop.setMaximumSize(new Dimension(10000, 150));
		changeImage(selectRandom(fileNames));
	}

	private void configBotPanel() {
		btn1 = createButton(1, "1");
		btn2 = createButton(2, "2");
		btn3 = createButton(3, "3");
		btn4 = createButton(4, "4");

		pnlBot.add(btn1);
		pnlBot.add(btn2);
		pnlBot.add(btn3);
		pnlBot.add(btn4);

		changeButtonColor(true, 0);
	}

	private void changeImage(String imageName) {
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(imageName));

		int x = 150;

		Image scaledImage = icon.getImage().getScaledInstance(50 + x, 70 + x, Image.SCALE_DEFAULT);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		lblImage.setIcon(scaledIcon);
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);

		pnlTop.repaint();
		pnlTop.revalidate();
	}

	private JButton createButton(int identifier, String title) {
		JButton button = new JButton(title);

		button.setBackground(GREY_BUTTON);
		button.setForeground(BLUE);
		button.setFont(new Font("Verdana", Font.BOLD, 24));
		button.setFocusPainted(false);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				checkAnswer(identifier);
			}
		});

		return button;
	}

	private void checkAnswer(int answer) {
		Random r = new Random();
		int max = 4;
		int min = 1;

		if (answer == currentCorrectAnswer) {
			int previousAnswer = currentCorrectAnswer;
			currentCorrectAnswer = r.nextInt((max - min) + 1) + min;
			changeButtonColor(true, previousAnswer);
		}
		else if (answer == 1) {
			changeButtonColor(false, 1);
		}
		else if (answer == 2) {
			changeButtonColor(false, 2);
		}
		else if (answer == 3) {
			changeButtonColor(false, 3);
		}
		else if (answer == 4) {
			changeButtonColor(false, 4);
		}
	}

	private static String selectRandom(String[] array) {
		int length = array.length;

		Random r = new Random();
		int max = length - 1;
		int min = 0;
		int rand = r.nextInt((max - min) + 1) + min;

		return array[rand];
	}

	private void changeButtonColor(boolean isCorrect, int identifier) {
		if (isCorrect) {
			if (identifier == 1) {
				btn1.setBackground(GREEN_CORRECT);
				btn1.setForeground(DARK_GREY);
			}
			else if (identifier == 2) {
				btn2.setBackground(GREEN_CORRECT);
				btn2.setForeground(DARK_GREY);
			}
			else if (identifier == 3) {
				btn3.setBackground(GREEN_CORRECT);
				btn3.setForeground(DARK_GREY);
			}
			else if (identifier == 4) {
				btn4.setBackground(GREEN_CORRECT);
				btn4.setForeground(DARK_GREY);
			}
			
			btn1.setEnabled(false);
			btn2.setEnabled(false);
			btn3.setEnabled(false);
			btn4.setEnabled(false);

			if (!isFirst) {
				ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

				Runnable task = () -> SwingUtilities.invokeLater(() -> resetButtons());

				executor.schedule(task, 1500, TimeUnit.MILLISECONDS);
				executor.shutdown();
			}
			
			else {
				isFirst = false;
				resetButtons();
			}
		}
		else {
			if (identifier == 1) {
				btn1.setBackground(RED_WRONG);
				btn1.setForeground(DARK_GREY);
			}
			else if (identifier == 2) {
				btn2.setBackground(RED_WRONG);
				btn2.setForeground(DARK_GREY);
			}
			else if (identifier == 3) {
				btn3.setBackground(RED_WRONG);
				btn3.setForeground(DARK_GREY);
			}
			else if (identifier == 4) {
				btn4.setBackground(RED_WRONG);
				btn4.setForeground(DARK_GREY);
			}

		}
	}

	private void resetButtons() {
		btn1.setBackground(GREY_BUTTON);
		btn2.setBackground(GREY_BUTTON);
		btn3.setBackground(GREY_BUTTON);
		btn4.setBackground(GREY_BUTTON);
		btn1.setForeground(BLUE);
		btn2.setForeground(BLUE);
		btn3.setForeground(BLUE);
		btn4.setForeground(BLUE);
		btn1.setEnabled(true);
		btn2.setEnabled(true);
		btn3.setEnabled(true);
		btn4.setEnabled(true);

		correctAnswer = selectRandom(fileNames);
		changeImage(correctAnswer);

		if (!isFirst2) {
			getPracticeSoundName();
		}

		changeButtonTexts();
	}

	private static void changeButtonTexts() {
		String answer = correctAnswer.replace(".png", "");
		String temp = "";

		if (currentCorrectAnswer == 1) {
			btn1.setText(answer);

			while (temp.equals("") || temp.equals(answer) || temp.equals(btn1.getText()) || temp.equals(btn2.getText())
					|| temp.equals(btn3.getText()) || temp.equals(btn4.getText())) {
				temp = selectRandom(fileNames).replace(".png", "");
			}
			btn2.setText(temp);
			temp = "";

			while (temp.equals("") || temp.equals(answer) || temp.equals(btn1.getText()) || temp.equals(btn2.getText())
					|| temp.equals(btn3.getText()) || temp.equals(btn4.getText())) {
				temp = selectRandom(fileNames).replace(".png", "");
			}
			btn3.setText(temp);
			temp = "";

			while (temp.equals("") || temp.equals(answer) || temp.equals(btn1.getText()) || temp.equals(btn2.getText())
					|| temp.equals(btn3.getText()) || temp.equals(btn4.getText())) {
				temp = selectRandom(fileNames).replace(".png", "");
			}
			btn4.setText(temp);
			temp = "";
		}
		else if (currentCorrectAnswer == 2) {
			btn2.setText(answer);

			while (temp.equals("") || temp.equals(answer) || temp.equals(btn1.getText()) || temp.equals(btn2.getText())
					|| temp.equals(btn3.getText()) || temp.equals(btn4.getText())) {
				temp = selectRandom(fileNames).replace(".png", "");
			}
			btn1.setText(temp);
			temp = "";

			while (temp.equals("") || temp.equals(answer) || temp.equals(btn1.getText()) || temp.equals(btn2.getText())
					|| temp.equals(btn3.getText()) || temp.equals(btn4.getText())) {
				temp = selectRandom(fileNames).replace(".png", "");
			}
			btn3.setText(temp);
			temp = "";

			while (temp.equals("") || temp.equals(answer) || temp.equals(btn1.getText()) || temp.equals(btn2.getText())
					|| temp.equals(btn3.getText()) || temp.equals(btn4.getText())) {
				temp = selectRandom(fileNames).replace(".png", "");
			}
			btn4.setText(temp);
			temp = "";
		}
		else if (currentCorrectAnswer == 3) {
			btn3.setText(answer);

			while (temp.equals("") || temp.equals(answer) || temp.equals(btn1.getText()) || temp.equals(btn2.getText())
					|| temp.equals(btn3.getText()) || temp.equals(btn4.getText())) {
				temp = selectRandom(fileNames).replace(".png", "");
			}
			btn1.setText(temp);
			temp = "";

			while (temp.equals("") || temp.equals(answer) || temp.equals(btn1.getText()) || temp.equals(btn2.getText())
					|| temp.equals(btn3.getText()) || temp.equals(btn4.getText())) {
				temp = selectRandom(fileNames).replace(".png", "");
			}
			btn2.setText(temp);
			temp = "";

			while (temp.equals("") || temp.equals(answer) || temp.equals(btn1.getText()) || temp.equals(btn2.getText())
					|| temp.equals(btn3.getText()) || temp.equals(btn4.getText())) {
				temp = selectRandom(fileNames).replace(".png", "");
			}
			btn4.setText(temp);
			temp = "";
		}
		else if (currentCorrectAnswer == 4) {
			btn4.setText(answer);

			while (temp.equals("") || temp.equals(answer) || temp.equals(btn1.getText()) || temp.equals(btn2.getText())
					|| temp.equals(btn3.getText()) || temp.equals(btn4.getText())) {
				temp = selectRandom(fileNames).replace(".png", "");
			}
			btn1.setText(temp);
			temp = "";

			while (temp.equals("") || temp.equals(answer) || temp.equals(btn1.getText()) || temp.equals(btn2.getText())
					|| temp.equals(btn3.getText()) || temp.equals(btn4.getText())) {
				temp = selectRandom(fileNames).replace(".png", "");
			}
			btn2.setText(temp);
			temp = "";

			while (temp.equals("") || temp.equals(answer) || temp.equals(btn1.getText()) || temp.equals(btn2.getText())
					|| temp.equals(btn3.getText()) || temp.equals(btn4.getText())) {
				temp = selectRandom(fileNames).replace(".png", "");
			}
			btn3.setText(temp);
			temp = "";
		}
	}

	private static int getRandomInt() {
		Random r = new Random();
		return r.nextInt((4 - 1) + 1) + 1;
	}

	public static void getPracticeSoundName() {

		if (GUI.isSoundEnable) {
			Runnable r = new Runnable() {

				public void run() {
					ts.playStringSound(correctAnswer);
				}
			};
			new Thread(r).start();
		}
	}

	public static void init() {
		if (!isFirst) {
			getPracticeSoundName();
			isFirst2 = false;
		}
	}
}
