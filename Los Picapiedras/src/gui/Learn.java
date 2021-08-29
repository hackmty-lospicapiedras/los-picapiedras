package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Learn {

	private static JPanel pnlTop = new JPanel();
	private static JPanel pnlBot = new JPanel();

	private static JLabel lblImage = new JLabel();

	private static JButton btn1 = new JButton("1");
	private static JButton btn2 = new JButton("2");
	private static JButton btn3 = new JButton("3");
	private static JButton btn4 = new JButton("4");

	private static int currentCorrectAnswer = 1;

	private static final Color OPTIONS_BACKGROUND = new Color(40, 40, 40);

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
		changeImage("w");
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

	}

	private static void changeImage(String imageName) {
		ImageIcon icon = new ImageIcon("Braille/" + imageName + ".png");

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
			System.out.println(currentCorrectAnswer + " is the correct answer");
			currentCorrectAnswer = r.nextInt((max - min) + 1) + min;
			btn1.setBackground(Color.CYAN);
			btn2.setBackground(Color.CYAN);
			btn3.setBackground(Color.CYAN);
			btn4.setBackground(Color.CYAN);
		}
		else if (answer == 1) {
			btn1.setBackground(Color.RED);
		}
		else if (answer == 2) {
			btn2.setBackground(Color.RED);
		}
		else if (answer == 3) {
			btn3.setBackground(Color.RED);
		}
		else if (answer == 4) {
			btn4.setBackground(Color.RED);
		}
		String[] a = getFileNames("Braille/");

		System.out.println(selectRandom(a));

		System.out.println(answer);
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
		int max = length;
		int min = 0;
		int rand = r.nextInt((max - min) + 1) + min;

		return array[rand];
	}

}
