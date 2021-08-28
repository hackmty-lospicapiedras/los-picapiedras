import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class GUI {

	private static final double FRAME_REDUCTION = 1.3;
	private static final String INDEX_CONFIG = "1";
	private static final String INDEX_TRADUCTOR = "2";
	private static final String INDEX_APRENDER = "3";

	private static JFrame mainFrame;

	private static JPanel mainPanel;
	private static JPanel pnlConfig;
	private static JPanel pnlTraductor;
	private static JPanel pnlAprender;

	private static JMenuItem mnTraductor;
	private static JMenuItem mnAprender;
	private static JMenuItem mnConfig;

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
		JFrame frame = new JFrame("NOMBRE");

		Dimension screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();

		int height = (int) (screenDimensions.getHeight() / FRAME_REDUCTION);
		int width = (int) (screenDimensions.getWidth() / FRAME_REDUCTION);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);

		return frame;
	}

	private static JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		mnConfig = new JMenuItem("Config");
		mnConfig.setMnemonic(KeyEvent.VK_C);
		mnConfig.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(mainPanel, INDEX_CONFIG);
			}
		});

		mnTraductor = new JMenuItem("Traductor");
		mnTraductor.setMnemonic(KeyEvent.VK_T);
		mnTraductor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(mainPanel, INDEX_TRADUCTOR);
			}
		});

		mnAprender = new JMenuItem("Aprender");
		mnAprender.setMnemonic(KeyEvent.VK_A);
		mnAprender.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(mainPanel, INDEX_APRENDER);
			}
		});

		menuBar.add(mnConfig);
		menuBar.add(mnTraductor);
		menuBar.add(mnAprender);

		return menuBar;
	}

	private static JPanel createMainPanel() {
		mainPanel = new JPanel();
		mainPanel.setLayout(cl);

		createSubPanels();

		mainPanel.add(pnlConfig, INDEX_CONFIG);
		mainPanel.add(pnlTraductor, INDEX_TRADUCTOR);
		mainPanel.add(pnlAprender, INDEX_APRENDER);

		cl.show(mainPanel, INDEX_TRADUCTOR);

		return mainPanel;
	}

	private static void createSubPanels() {
		pnlConfig = configSubPanel("Config");
		pnlTraductor = configSubPanel("Traductor");
		pnlAprender = configSubPanel("Aprender");
	}

	private static JPanel configSubPanel(String text) {
		JPanel panel = new JPanel();
		panel.add(new JLabel(text));
		return panel;
	}

}
