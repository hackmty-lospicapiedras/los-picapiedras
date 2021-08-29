package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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

public class Learn {

	private static boolean isFirst = true;

	private static JPanel pnlTop = new JPanel();
	private static JPanel pnlBot = new JPanel();

	private static JLabel lblImage = new JLabel();

	private static JButton btn1 = new JButton("1");
	private static JButton btn2 = new JButton("2");
	private static JButton btn3 = new JButton("3");
	private static JButton btn4 = new JButton("4");

	private static String[] fileNames = getFileNames("Answers/");

	private static int currentCorrectAnswer = getRandomInt();
	private static String correctAnswer = selectRandom(fileNames);

	private static final Color GREY_BUTTON = new Color(54, 54, 54);
	private static final Color BLUE = new Color(115, 165, 186);
	private static final Color RED_WRONG = new Color(99, 33, 28);
	private static final Color GREEN_CORRECT = new Color(33, 138, 61);
	private static final Color DARK_GREY = new Color(23, 23, 23);

	public JPanel createContentLearn() {
		JPanel panel = new JPanel();

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

	private static void configTopPanel() {
		pnlTop.add(lblImage);
		pnlTop.setMaximumSize(new Dimension(10000, 150));
		changeImage(selectRandom(fileNames));
	}

	private static void configBotPanel() {
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

	private static void changeImage(String imageName) {
		ImageIcon icon = new ImageIcon("Answers/" + imageName);

		int x = 150;

		Image scaledImage = icon.getImage().getScaledInstance(50 + x, 70 + x, Image.SCALE_DEFAULT);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		lblImage.setIcon(scaledIcon);
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);

		pnlTop.repaint();
		pnlTop.revalidate();
	}

	private static JButton createButton(int identifier, String title) {
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

	private static void checkAnswer(int answer) {
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

	private static String[] getFileNames(String dir) {
		File[] files = new File(dir).listFiles();

		String[] array = new String[files.length];

		for (int i = 0; i < array.length; i++) {
			if (files[i].isFile()) {
				array[i] = files[i].getName();
			}
		}

		return array;
	}

	private static String selectRandom(String[] array) {
		int length = array.length;

		Random r = new Random();
		int max = length - 1;
		int min = 0;
		int rand = r.nextInt((max - min) + 1) + min;

		return array[rand];
	}

	private static void changeButtonColor(boolean isCorrect, int identifier) {
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

	private static void resetButtons() {
		btn1.setBackground(GREY_BUTTON);
		btn2.setBackground(GREY_BUTTON);
		btn3.setBackground(GREY_BUTTON);
		btn4.setBackground(GREY_BUTTON);
		btn1.setForeground(BLUE);
		btn2.setForeground(BLUE);
		btn3.setForeground(BLUE);
		btn4.setForeground(BLUE);

		correctAnswer = selectRandom(fileNames);
		changeImage(correctAnswer);

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

}
