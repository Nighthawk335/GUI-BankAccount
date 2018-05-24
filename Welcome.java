import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Welcome extends JPanel
{
	
	public Welcome()
	{
		setSize(400, 400);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		BufferedImage bankjpg = null;
		try
		{
			bankjpg = ImageIO.read(new File("bankjpg.png"));
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		JLabel lblHome  = new JLabel(new ImageIcon(bankjpg));
		add(lblHome, gbc);
	}
	
//	BufferedImage bankjpg = null;
//	{
//	try
//	{
//		bankjpg = ImageIO.read(new File("bankjpg.png"));
//	}
//	catch(IOException e1)
//	{
//		e1.printStackTrace();
//	}
//	JLabel lblHome  = new JLabel(new ImageIcon(bankjpg));
}

