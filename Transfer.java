import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Transfer extends JPanel
{
	ArrayList<BankAccount> names = new ArrayList<BankAccount>();
	JPanel thisPanel = this;
	public Transfer(ArrayList<BankAccount> list)
	{
		names = list;
		setSize(400, 300);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;
		JLabel lblName = new JLabel("Name: ");
		add(lblName, gbc);
		gbc.gridx=1;
		JTextField txtName = new JTextField();
		txtName.setPreferredSize(new Dimension(180,30));
		add(txtName,gbc);
		gbc.gridx = 0;
		gbc.gridy=1;
		JLabel lblAccountNum = new JLabel("Your Account Number: ");
		add(lblAccountNum, gbc);
		gbc.gridx = 0;
		gbc.gridy=3;
		JLabel secAccountNum = new JLabel("Second Account Number: ");
		add(secAccountNum, gbc);
		gbc.gridx=1;
		gbc.gridy=3;
		JTextField txtAcctNum2 = new JTextField();
		txtAcctNum2.setPreferredSize(new Dimension(180, 30));
		add(txtAcctNum2, gbc);
		
		gbc.gridx=1;
		gbc.gridy=1;
		JTextField txtAcctNum = new JTextField();
		txtAcctNum.setPreferredSize(new Dimension(180, 30));
		add(txtAcctNum, gbc);
		JLabel amt = new JLabel("Amount: ");
		gbc.gridx=0;
		gbc.gridy=2;
		add(amt, gbc);
		JTextField txtAmt = new JTextField();
		txtAmt.setPreferredSize(new Dimension(180, 30));
		gbc.gridx=1;
		gbc.gridy=2;
		add(txtAmt, gbc);
		gbc.gridx=1;
		gbc.gridy=4;
		
		JButton getName = new  JButton("Submit");
		getName.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						int acctNum = -1;
						double amt = 0;
						if (isNumeric(txtAmt.getText()) && inArrayList(txtAcctNum.getText(), names) && inArrayList(txtAcctNum2.getText(), names) && Integer.parseInt(txtAmt.getText()) >= 0)
						{
						int index1 = -1;
						int index2 = -1;
						for (int i = 0; i < names.size(); i++)
						{
						if (names.get(i).getAcctNum() == Integer.parseInt(txtAcctNum.getText()))
						{
						index1 = i;
						}
						else if (names.get(i).getAcctNum() == Integer.parseInt(txtAcctNum2.getText()))
						index2 = i;
						}
						try 
						{
							names.get(index1).transfer(names.get(index2), Integer.parseInt(txtAmt.getText()));
							JOptionPane.showMessageDialog(thisPanel, "success");
						} 
						catch (IllegalArgumentException a)
						{
							JOptionPane.showMessageDialog(thisPanel, "fail");
						}}
						else
						{
							JOptionPane.showMessageDialog(thisPanel, "bad input");
						}
						txtAcctNum.setText("");
						txtAcctNum2.setText("");
						txtAmt.setText("");
						
					}
		
				});
		add(getName, gbc);
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
	
	public boolean inArrayList(String str, ArrayList<BankAccount> accts)
	{
		try {
			int acctNum = Integer.parseInt(str);
			for (int i = 0; i < accts.size(); i++)
			{
				if (acctNum == accts.get(i).getAcctNum())
				{
					return true;
				}
			}
			return false;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}
}
