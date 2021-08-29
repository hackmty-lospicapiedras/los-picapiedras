package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;

import sounds.TranslatorSounds;

public class Translator {

	private static TranslatorSounds ts = new TranslatorSounds();

	private static JPanel spContainer;

	private static JScrollPane spOutput;

	private static JTextArea taTraductorInput;
	
	private static JButton btnTranslate;

	private static final Color GREY_TEXT_COLOR = new Color(237, 237, 237);
	private static final Color GREY_TEXT_AREA = new Color(70, 70, 70);
	private static final Color GREY_BUTTON = new Color(54, 54, 54);
	private static final Color WHITE = new Color(250, 250, 250);
	private static final Color BLUE = new Color(115, 165, 186);
	private static final Color PANEL_BACKGROUND_COLOR = new Color(45, 45, 45);
	private static final Color SCROLL_BAR = new Color(60, 60, 60);

	public JPanel createContentTraductor() {
		JPanel panel = new JPanel();

		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setBackground(null);

		int in = 35;
		panel.setBorder(BorderFactory.createEmptyBorder(in, in, in, in));

		taTraductorInput = createTextArea();

		panel.add(createLabelTitle());
		panel.add(Box.createRigidArea(new Dimension(0, 25)));
		panel.add(createScrollPaneTraductor(taTraductorInput));
		panel.add(Box.createRigidArea(new Dimension(0, 15)));
		panel.add(createButtonTraductor());
		panel.add(Box.createRigidArea(new Dimension(0, 15)));
		panel.add(createScrollPaneTraductor());

		return panel;
	}

	private static JPanel createLabelTitle() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 1));
		panel.setBackground(null);
		panel.setMaximumSize(new Dimension(10000, 150));

		JLabel label = new JLabel("Translate your text from english to grade 1 braille.");
		label.setBackground(null);
		label.setForeground(WHITE);
		label.setFont(new Font("Verdana", Font.BOLD, 26));
		label.setHorizontalAlignment(SwingConstants.CENTER);

		panel.add(label);

		return panel;
	}

	private static JTextArea createTextArea() {
		int insets = 25;

		JTextArea ta = new JTextArea();

		ta.setEditable(true);
		ta.setLineWrap(true);
		ta.setMargin(new Insets(insets, insets, insets, insets));
		ta.setWrapStyleWord(true);
		ta.setBackground(GREY_TEXT_AREA);
		ta.setForeground(GREY_TEXT_COLOR);
		ta.setCaretColor(WHITE);
		ta.setFont(new Font("Verdana", Font.BOLD, 24));

		return ta;
	}

	private static JScrollPane createScrollPaneTraductor(JTextArea ta) {
		JScrollPane sp = new JScrollPane(ta);
		sp.createVerticalScrollBar();
		sp.setBackground(null);
		sp.getVerticalScrollBar().setBackground(PANEL_BACKGROUND_COLOR);
		sp.getVerticalScrollBar().setUI(new BasicScrollBarUI() {

			@Override
			protected void configureScrollBarColors() {
				this.thumbColor = SCROLL_BAR;
			}
		});

		return sp;
	}

	private static JPanel createScrollPaneTraductor() {
		JPanel panel = new JPanel();

		int height = 120;
		panel.setMinimumSize(new Dimension(10, height));
		panel.setPreferredSize(new Dimension(10, height));
		panel.setMaximumSize(new Dimension(10000, height));
		panel.setLayout(new GridLayout(1, 1));

		spContainer = new JPanel();
		spContainer.setLayout(new BoxLayout(spContainer, BoxLayout.LINE_AXIS));
		spContainer.setBackground(GREY_TEXT_AREA);

		int inT = 0;
		int inS = 18;
		spContainer.setBorder(BorderFactory.createEmptyBorder(inT, inS, inT, inS));

		spOutput = new JScrollPane(spContainer);
		spOutput.createHorizontalScrollBar();
		spOutput.setBackground(null);
		spOutput.getHorizontalScrollBar().setBackground(PANEL_BACKGROUND_COLOR);
		spOutput.getHorizontalScrollBar().setUI(new BasicScrollBarUI() {

			@Override
			protected void configureScrollBarColors() {
				this.thumbColor = SCROLL_BAR;
			}
		});

		panel.add(spOutput);

		return panel;
	}

	private JPanel createButtonTraductor() {
		JPanel panel = new JPanel();
		panel.setBackground(null);
		panel.setLayout(new GridLayout(1, 1));

		int height = 100;
		panel.setMinimumSize(new Dimension(200, height));
		panel.setPreferredSize(new Dimension(200, height));
		panel.setMaximumSize(new Dimension(10000, height));

		int inT = 0;
		int inS = 35;
		panel.setBorder(BorderFactory.createEmptyBorder(inT, inS, inT, inS));

		btnTranslate = new JButton("Translate");

		btnTranslate.setBackground(GREY_BUTTON);
		btnTranslate.setForeground(BLUE);
		btnTranslate.setFont(new Font("Verdana", Font.BOLD, 24));
		btnTranslate.setFocusPainted(false);

		btnTranslate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addImagesToOutput();
			}
		});

		panel.add(btnTranslate);

		return panel;
	}

	private void addImagesToOutput() {
		spContainer.removeAll();

		String text = taTraductorInput.getText();

		char[] charArray = text.toCharArray();

		for (char c : charArray) {
			if (c == ' ') {
				spContainer.add(Box.createRigidArea(new Dimension(25, 0)));
				continue;
			}
			if (c == '\n') {
				spContainer.add(Box.createRigidArea(new Dimension(75, 0)));
				continue;
			}

			spContainer.add(createImage(c));
		}

		spContainer.revalidate();
		spContainer.repaint();
		spOutput.revalidate();
		spOutput.repaint();

		btnTranslate.setEnabled(false);
		
		Runnable r = new Runnable() {

			public void run() {
				for (char c : charArray) {
					if (c == ' ') {
						ts.playSpaceSound();
						continue;
					}
					if (c == '\n') {
						continue;
					}
					ts.playCharacterSound(c);
				}
				btnTranslate.setEnabled(true);
			}
		};

		new Thread(r).start();
	}

	private JLabel createImage(char imageName) {
		ImageIcon icon;

		String name = Character.toString(imageName);
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

		if (letters.contains(name)) {
			icon = new ImageIcon(getClass().getClassLoader().getResource(name + ".png"));
		}
		else {
			icon = new ImageIcon(getClass().getClassLoader().getResource("null.png"));
		}

		int x = 15;

		Image scaledImage = icon.getImage().getScaledInstance(50 + x, 70 + x, Image.SCALE_DEFAULT);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		return new JLabel(scaledIcon);
	}

}
