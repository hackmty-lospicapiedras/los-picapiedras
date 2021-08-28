package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
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

public class Translator {

	private static JPanel spContainer;

	private static JScrollPane spOutput;

	private static JTextArea taTraductorInput;

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
		ta.setFont(new Font("Verdana", Font.BOLD, 16));

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

	private static JScrollPane createScrollPaneTraductor() {
		spContainer = new JPanel();
		spContainer.setLayout(new BoxLayout(spContainer, BoxLayout.LINE_AXIS));
		spContainer.setBackground(GREY_TEXT_AREA);

		int inT = 0;
		int inS = 18;
		spContainer.setBorder(BorderFactory.createEmptyBorder(inT, inS, inT, inS));

		spOutput = new JScrollPane(spContainer);
		spOutput.setMaximumSize(new Dimension(4000, 1900));
		spOutput.createHorizontalScrollBar();
		spOutput.setBackground(null);
		spOutput.getHorizontalScrollBar().setBackground(PANEL_BACKGROUND_COLOR);
		spOutput.getHorizontalScrollBar().setUI(new BasicScrollBarUI() {

			@Override
			protected void configureScrollBarColors() {
				this.thumbColor = SCROLL_BAR;
			}
		});

		for (int i = 0; i < 100; i++) {
			spContainer.add(createImage("C:\\Users\\gabal\\Desktop\\Downloads\\h.png"));
		}

		return spOutput;
	}

	private static JPanel createButtonTraductor() {
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

		JButton button = new JButton("Translate");

		button.setBackground(GREY_BUTTON);
		button.setForeground(BLUE);
		button.setFont(new Font("Verdana", Font.BOLD, 24));
		button.setFocusPainted(false);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addImagesToOutput();
			}
		});

		panel.add(button);

		return panel;
	}

	private static void addImagesToOutput() {
		spContainer.removeAll();

		for (int i = 0; i < 10; i++) {
			spContainer.add(createImage2());
		}

		spContainer.add(Box.createRigidArea(new Dimension(25, 0)));

		for (int i = 0; i < 10; i++) {
			spContainer.add(createImage2());
		}

		spContainer.revalidate();
		spContainer.repaint();
		spOutput.revalidate();
		spOutput.repaint();
	}

	private static JLabel createImage(String dir) {
		ImageIcon icon = new ImageIcon(dir);

		return new JLabel(icon);
	}

	private static JLabel createImage2() {
		ImageIcon icon = new ImageIcon("C:\\Users\\gabal\\Desktop\\Downloads\\w.png");

		return new JLabel(icon);
	}

}
