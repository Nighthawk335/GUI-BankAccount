import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class BankAccountFrame extends JFrame
{
	public BankAccountFrame()
	{
		
		setBounds(50,100,100,100);
		add(new GetAccountPanel());
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	public static void main(String[] args)
	{
		new BankAccountFrame();
	}
}
