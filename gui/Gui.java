package gui;



import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import data.RiftData;
import data.WispData;
import zaDivination.ZaDivination;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();



	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 266, 344);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JRadioButton rdbtnPaleWisp = new JRadioButton("Pale Wisp");
		buttonGroup.add(rdbtnPaleWisp);
		rdbtnPaleWisp.setBounds(10, 71, 109, 23);
		frame.getContentPane().add(rdbtnPaleWisp);
		
		final JRadioButton rdbtnFlickeringWisp = new JRadioButton("Flickering Wisp");
		buttonGroup.add(rdbtnFlickeringWisp);
		rdbtnFlickeringWisp.setBounds(120, 71, 109, 23);
		frame.getContentPane().add(rdbtnFlickeringWisp);
		
		final JRadioButton rdbtnBrightWisp = new JRadioButton("Bright Wisp");
		buttonGroup.add(rdbtnBrightWisp);
		rdbtnBrightWisp.setBounds(10, 97, 109, 23);
		frame.getContentPane().add(rdbtnBrightWisp);
		
		final JRadioButton rdbtnGlowingWisp = new JRadioButton("Glowing Wisp");
		buttonGroup.add(rdbtnGlowingWisp);
		rdbtnGlowingWisp.setBounds(120, 97, 109, 23);
		frame.getContentPane().add(rdbtnGlowingWisp);
		
		final JRadioButton rdbtnSparklingWisp = new JRadioButton("Sparkling Wisp");
		buttonGroup.add(rdbtnSparklingWisp);
		rdbtnSparklingWisp.setBounds(10, 123, 109, 23);
		frame.getContentPane().add(rdbtnSparklingWisp);
		
		final JRadioButton rdbtnGleamingWisp = new JRadioButton("Gleaming Wisp");
		buttonGroup.add(rdbtnGleamingWisp);
		rdbtnGleamingWisp.setBounds(120, 123, 109, 23);
		frame.getContentPane().add(rdbtnGleamingWisp);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{

				if(rdbtnPaleWisp.isSelected())
				{
					ZaDivination.wispData = WispData.PALEWISP;
				}
				else if(rdbtnFlickeringWisp.isSelected())
				{
					ZaDivination.wispData = WispData.FLICKERINGWISP;
				}
				else if(rdbtnBrightWisp.isSelected())
				{
					ZaDivination.wispData = WispData.BRIGHTWISP;
				}
				else if(rdbtnGlowingWisp.isSelected())
				{
					ZaDivination.wispData = WispData.GLOWINGWISP;
				}
				else if(rdbtnSparklingWisp.isSelected())
				{
					ZaDivination.wispData = WispData.SPARKLINGWISP;
				}
				else if(rdbtnGleamingWisp.isSelected())
				{
					ZaDivination.wispData = WispData.GLEAMINGWISP;
				}else
				{
					return;
				}
				ZaDivination.riftData = RiftData.RIFT;
				frame.setVisible(false);
				ZaDivination.startingTime = System.currentTimeMillis();
				ZaDivination.started = true;
				
			}
		});
		btnStart.setBounds(10, 229, 89, 23);
		frame.getContentPane().add(btnStart);
	}

}
