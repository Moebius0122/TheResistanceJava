package resistancegui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 717, 544);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("39px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("43px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("23px"),}));
		
		JLabel lblPlayer = new JLabel("Player 1");
		frame.getContentPane().add(lblPlayer, "2, 2, 2, 1, left, center");
		
		JCheckBox chckbxSpy = new JCheckBox("Spy?");
		frame.getContentPane().add(chckbxSpy, "4, 2, 2, 1");
		
		JRadioButton rdbtnLeader_1 = new JRadioButton("Leader");
		frame.getContentPane().add(rdbtnLeader_1, "6, 2");
		
		JLabel lblPlayer_1 = new JLabel("Player 2");
		frame.getContentPane().add(lblPlayer_1, "2, 4, 2, 1, left, center");
		
		JCheckBox checkBox = new JCheckBox("Spy?");
		frame.getContentPane().add(checkBox, "4, 4, 2, 1");
		
		JRadioButton rdbtnLeader_2 = new JRadioButton("Leader");
		frame.getContentPane().add(rdbtnLeader_2, "6, 4");
		
		JLabel lblPlayer_2 = new JLabel("Player 3");
		frame.getContentPane().add(lblPlayer_2, "2, 6, left, center");
		
		JCheckBox checkBox_1 = new JCheckBox("Spy?");
		frame.getContentPane().add(checkBox_1, "4, 6, 2, 1");
		
		JRadioButton rdbtnLeader_3 = new JRadioButton("Leader");
		frame.getContentPane().add(rdbtnLeader_3, "6, 6");
		
		JLabel lblPlayer_3 = new JLabel("Player 4");
		frame.getContentPane().add(lblPlayer_3, "2, 8, left, center");
		
		JCheckBox checkBox_2 = new JCheckBox("Spy?");
		frame.getContentPane().add(checkBox_2, "4, 8, 2, 1");
		
		JRadioButton rdbtnLeader_4 = new JRadioButton("Leader");
		frame.getContentPane().add(rdbtnLeader_4, "6, 8");
		
		JLabel lblPlayer_4 = new JLabel("Player 5");
		frame.getContentPane().add(lblPlayer_4, "2, 10, left, center");
		
		JCheckBox checkBox_3 = new JCheckBox("Spy?");
		frame.getContentPane().add(checkBox_3, "4, 10, 2, 1");
		
		JRadioButton rdbtnLeader_5 = new JRadioButton("Leader");
		frame.getContentPane().add(rdbtnLeader_5, "6, 10");
		
		ButtonGroup group = new ButtonGroup();
		    group.add(rdbtnLeader_1);
		    group.add(rdbtnLeader_2);
		    group.add(rdbtnLeader_3);
		    group.add(rdbtnLeader_4);
		    group.add(rdbtnLeader_5);
	}

}
