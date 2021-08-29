package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class GUI {

	private static final double FRAME_REDUCTION = 1.3;
	private static final String INDEX_CONFIG = "1";
	private static final String INDEX_TRADUCTOR = "2";
	private static final String INDEX_APRENDER = "3";
	private static final String INDEX_PRACTICAR = "4";

	private static JFrame mainFrame;

	private static JPanel mainPanel;
	private static JPanel pnlConfig;
	private static JPanel pnlTraductor;
	private static JPanel pnlAprender;

	private static JMenuItem mnTraductor;
	private static JMenuItem mnAprender;
	private static JMenuItem mnConfig;
	private static JMenuItem mnPracticar;

	private static final Color PANEL_GREY_BACKGROUND = new Color(36, 36, 36);

	private static Translator translator = new Translator();
	private static Learn learn = new Learn();

	private static CardLayout cl = new CardLayout();

	public static void main(String[] args) {

		init();

	}

	public static void init() {
		createGUI();
	}

	public static void createGUI() {
		mainFrame = createFrame();
		mainFrame.setJMenuBar(createMenuBar());
		mainFrame.add(createMainPanel());
		mainFrame.setVisible(true);
	}

	public static JFrame createFrame() {
		JFrame frame = new JFrame("Word-Swapper");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		Dimension screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();

		int height = (int) (screenDimensions.getHeight() / FRAME_REDUCTION);
		int width = (int) (screenDimensions.getWidth() / FRAME_REDUCTION);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);

		return frame;
	}

	private static JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		int fontSize = 15;
		
		mnConfig = new JMenuItem("Config");
		mnConfig.setMnemonic(KeyEvent.VK_C);
		mnConfig.setFont(new Font("Verdana", Font.BOLD, fontSize));
		mnConfig.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(mainPanel, INDEX_CONFIG);
			}
		});

		mnTraductor = new JMenuItem("Translator");
		mnTraductor.setMnemonic(KeyEvent.VK_T);
		mnTraductor.setFont(new Font("Verdana", Font.BOLD, fontSize));
		mnTraductor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(mainPanel, INDEX_TRADUCTOR);
			}
		});
		
		mnAprender = new JMenuItem("Learn");
		mnAprender.setMnemonic(KeyEvent.VK_A);
		mnAprender.setFont(new Font("Verdana", Font.BOLD, fontSize));
		mnAprender.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(mainPanel, INDEX_APRENDER);
			}
		});
		
		mnPracticar = new JMenuItem("Practice");
		mnPracticar.setMnemonic(KeyEvent.VK_P);
		mnPracticar.setFont(new Font("Verdana", Font.BOLD, fontSize));
		mnPracticar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(mainPanel, INDEX_PRACTICAR);
			}
		});

		menuBar.add(mnConfig);
		menuBar.add(mnTraductor);
		menuBar.add(mnAprender);
		menuBar.add(mnPracticar);

		return menuBar;
	}

	private static JPanel createMainPanel() {
		mainPanel = new JPanel();
		mainPanel.setLayout(cl);

		createSubPanels();

		mainPanel.add(pnlConfig, INDEX_CONFIG);
		mainPanel.add(pnlTraductor, INDEX_TRADUCTOR);
		mainPanel.add(pnlAprender, INDEX_APRENDER);
		mainPanel.add(pnlAprender, INDEX_PRACTICAR);

		cl.show(mainPanel, INDEX_TRADUCTOR);

		return mainPanel;
	}

	private static void createSubPanels() {
		pnlConfig = configSubPanel();
		pnlTraductor = configSubPanel();
		pnlAprender = configSubPanel();

		pnlTraductor.add(translator.createContentTraductor());
		pnlAprender.add(learn.createContentLearn());
	}

	private static JPanel configSubPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(PANEL_GREY_BACKGROUND);
		panel.setLayout(new GridLayout(1, 1));
		return panel;
	}

}
