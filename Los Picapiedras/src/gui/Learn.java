package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private static JPanel pnlMiddle = new JPanel();
	private static JPanel pnlBot = new JPanel();

	private static JLabel lblImage = new JLabel();
	private static JLabel lblText = new JLabel();

	private static String current = "";

	private static String[] fileNames = { "a.png", "and.png", "ar.png", "b, but.png", "by, was.png", "c, can.png",
			"cc, con.png", "ch, child.png", "com.png", "d.png", "dd, dis.png", "e, every.png", "ea.png", "ed.png",
			"en, enough.png", "er.png", "f, from.png", "ff, to.png", "for.png", "g, go.png", "gg, were.png", "gh.png",
			"h, have.png", "i.png", "in.png", "ing.png", "j, just.png", "k, knowledge.png", "l, like.png",
			"m, more.png", "n, not.png", "o.png", "of.png", "ou, out.png", "ow.png", "p, people.png", "q, quite.png",
			"r, rather.png", "s.png", "sh, shall.png", "st, still.png", "t, that.png", "th, this.png", "the.png",
			"u, us.png", "v, very.png", "w, will.png", "wh, which.png", "with.png", "x, it.png", "y, you.png",
			"z, as.png" };

	private static final Color GREY_BUTTON = new Color(54, 54, 54);
	private static final Color WHITE = new Color(250, 250, 250);
	private static final Color BLUE = new Color(115, 165, 186);

	public JPanel createContentLearn() {
		JPanel panel = new JPanel();

		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setBackground(null);

		int in = 35;
		panel.setBorder(BorderFactory.createEmptyBorder(in, in, in, in));

		configPanels();

		configTopPanel();
		configMiddlePanel();
		configBotPanel();

		changeImageText(selectRandom(fileNames));

		panel.add(Box.createRigidArea(new Dimension(0, 25)));
		panel.add(pnlTop);
		panel.add(Box.createRigidArea(new Dimension(0, 35)));
		panel.add(pnlMiddle);
		panel.add(Box.createRigidArea(new Dimension(0, 35)));
		panel.add(pnlBot);

		return panel;
	}

	private void configPanels() {
		pnlTop.setBackground(null);
		pnlTop.setLayout(new GridLayout(1, 1));

		pnlMiddle.setBackground(null);
		pnlMiddle.setLayout(new GridLayout(1, 1));

		pnlBot.setBackground(null);
		pnlBot.setLayout(new GridLayout(1, 1));
	}

	private void configTopPanel() {
		pnlTop.add(lblImage);
		pnlTop.setMaximumSize(new Dimension(10000, 150));
	}

	private void configMiddlePanel() {
		lblText.setForeground(WHITE);
		lblText.setBackground(null);
		lblText.setFont(new Font("Verdana", Font.BOLD, 40));
		lblText.setHorizontalAlignment(SwingConstants.CENTER);

		pnlMiddle.add(lblText);
	}

	private void configBotPanel() {
		JButton button = new JButton("Next Word");
		button.setBackground(GREY_BUTTON);
		button.setForeground(BLUE);
		button.setFont(new Font("Verdana", Font.BOLD, 24));
		button.setFocusPainted(false);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				changeImageText(selectRandom(fileNames));
			}
		});

		pnlBot.add(button);
	}

	private void changeImageText(String imageName) {
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(imageName));

		int x = 200;

		Image scaledImage = icon.getImage().getScaledInstance(50 + x, 70 + x, Image.SCALE_DEFAULT);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		lblImage.setIcon(scaledIcon);
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);

		pnlTop.repaint();
		pnlTop.revalidate();

		String curr = current.replace(".png", "");
		lblText.setText(curr);
	}

	private static String selectRandom(String[] array) {
		int length = array.length;

		Random r = new Random();
		int max = length - 1;
		int min = 0;
		int rand = r.nextInt((max - min) + 1) + min;

		current = array[rand];

		System.out.println(current);

		return current;
	}

}