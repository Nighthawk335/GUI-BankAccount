import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class NewAcct extends JPanel
{

	private ArrayList<BankAccount> names;
	private String[] accounts = {"Savings", "Checking"};
	private final double OVER_DRAFT_FEE = 15, RATE = .0025, TRANSACTION_FEE = 1.5, MIN_BAL = 300, MIN_BAL_FEE = 10;
	private final int FREE_TRANSACTIONS = 10;
	
	public NewAcct(ArrayList<BankAccount> list)
	{
	names = list;
	setSize(400, 400);
	setLayout(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();
	gbc.gridx = 0;
	gbc.gridy = 0;
	JLabel lblName = new JLabel("Name: ");
	add(lblName, gbc);
	gbc.gridx++;
	JTextField txtName = new JTextField();
	txtName.setPreferredSize(new Dimension(180, 30));
	add(txtName, gbc);
	gbc.gridx = 0;
	gbc.gridy++;
	JLabel lblInitial = new JLabel("Initial Deposit:");
	add(lblInitial, gbc);
	gbc.gridx++;
	JTextField txtDeposit = new JTextField();
	txtDeposit.setPreferredSize(new Dimension(180, 30));
	add(txtDeposit, gbc);
	gbc.gridx = 0;
	gbc.gridy++;
	JLabel lblAcct = new JLabel("Account Type: ");
	add(lblAcct, gbc);
	gbc.gridx++;
	JList accts = new JList(accounts);
	JScrollPane list1 = new JScrollPane(accts);
	list1.setPreferredSize(new Dimension(180, 20));
	add(list1, gbc);
	gbc.gridx = 0;
	gbc.gridy++;
	JButton submit = new JButton("submit");
	add(submit, gbc);
	submit.addActionListener(new ActionListener() 
	{
		
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			String name = txtName.getText();
			double bal = 0;
			if (isNumeric(txtDeposit.getText()))
			{
			bal = Double.parseDouble(txtDeposit.getText());
			}
			if (!(txtName.getText().equals("") || accts.getSelectedValue() == null) && (isNumeric(txtDeposit.getText()) || txtDeposit.getText().equals("")))
			{
				if (accts.getSelectedValue().equals("Savings"))
				{
				names.add(new SavingsAccount(name, bal, RATE, MIN_BAL, MIN_BAL_FEE));
				}
				else if (accts.getSelectedValue().equals("Checking"))
				{
				names.add(new CheckingAccount(name, bal, OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTIONS));
				}
				txtName.setText("");
				txtDeposit.setText("");
			}
		}
			
		});
		
	
	
	}
	
	public boolean isNumeric(String str)
	{
		try
		{
			Double.parseDouble(str);
			return true;
		}
		catch (IllegalArgumentException e)
		{
			return false;
		}
	}
		
}
