import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainFrame extends JFrame 
{

	ArrayList<BankAccount> bankAccts = new ArrayList<BankAccount>();
	
	public MainFrame()
	{
		setBounds(300,300,400,400);
		CardLayout cl = new CardLayout();
		JPanel overall = new JPanel();
		overall.setLayout(cl);
		JMenuBar mBar = new JMenuBar();
		JMenu home = new JMenu("Home");
		JMenuItem welcome = new JMenuItem("Welcome");
		JMenu acct = new JMenu("Account");
		JMenuItem newAcct = new JMenuItem("New Account");
		JMenuItem getNum = new JMenuItem("Get Account Number");
		JMenuItem removeAcct = new JMenuItem("Remove Account");
		JMenu trans = new JMenu("Transaction");
		JMenuItem deposit = new JMenuItem("Deposit");
		JMenuItem withdraw = new JMenuItem("Withdraw");
		JMenuItem transfer = new JMenuItem("Transfer");
		JMenuItem getBal = new JMenuItem("Get Balance");
		home.add(welcome);
		mBar.add(home);
		acct.add(newAcct);
		acct.add(getNum);
		acct.add(removeAcct);
		mBar.add(acct);
		trans.add(deposit);
		trans.add(withdraw);
		trans.add(transfer);
		trans.add(getBal);
		mBar.add(trans);
		setJMenuBar(mBar);
		
		JPanel welcomePanel = new Welcome();
		JPanel newAcctPanel = new NewAcct(bankAccts);
		JPanel getNumPanel = new GetAccountPanel(bankAccts);
		JPanel removeAcctPanel = new RemoveAcct(bankAccts);
		JPanel depositPanel = new Deposit(bankAccts);
		JPanel withdrawPanel = new Withdraw(bankAccts);
		JPanel transferPanel = new Transfer(bankAccts);
		JPanel getBalPanel = new GetBal(bankAccts);
		overall.add(welcomePanel, "welcomePanel");
		overall.add(newAcctPanel, "newAcctPanel");
		overall.add(getNumPanel, "getNumPanel");
		overall.add(removeAcctPanel, "removeAcctPanel");
		overall.add(depositPanel, "depositPanel");
		overall.add(withdrawPanel, "withdrawPanel");
		overall.add(transferPanel, "transferPanel");
		overall.add(getBalPanel, "getBalPanel");
		add(overall);
		cl.show(overall, "welcomePanel");
		
		welcome.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cl.show(overall, "welcomePanel");
			}
			
		});
		newAcct.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				cl.show(overall, "newAcctPanel");
			}
			
		});
		getNum.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cl.show(overall, "getNumPanel");
			}
			
		});
		removeAcct.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cl.show(overall, "removeAcctPanel");
			}
			
		});
		deposit.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cl.show(overall, "depositPanel");
			}
			
		});
		withdraw.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				cl.show(overall, "withdrawPanel");
			}
			
		});
		transfer.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cl.show(overall, "transferPanel");
			}
			
		});
		getBal.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				cl.show(overall, "getBalPanel");
			}
			
		});
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) 
	{
		new MainFrame();
		

	}

}
