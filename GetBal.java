import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GetBal extends JPanel
{
	private ArrayList<BankAccount> names;
	private JPanel thisPanel = this;
	
	public GetBal(ArrayList<BankAccount> list)
	{
	names = list;
	setSize(400, 400);
	setLayout(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();
	gbc.gridx = 0;
	gbc.gridy = 0;
	JLabel lblNum = new JLabel("Enter account number: ");
	add(lblNum, gbc);
	gbc.gridx++;
	JTextField txtNum = new JTextField();
	txtNum.setPreferredSize(new Dimension(180, 30));
	add(txtNum, gbc);
	gbc.gridx--;
	gbc.gridy++;
	JLabel lblBal = new JLabel("Balance:");
	add(lblBal, gbc);
	gbc.gridx++;
	JTextField txtBal = new JTextField();
	txtBal.setPreferredSize(new Dimension(180, 30));
	add(txtBal, gbc);
	gbc.gridx--;
	gbc.gridy++;
	JButton btnSubmit = new JButton("submit");
	add(btnSubmit, gbc);
	btnSubmit.addActionListener(new ActionListener() 
	{
		
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			if (inArrayList(txtNum.getText(), names))
			{
			int index = -1;
			for (int i = 0; i < names.size(); i++)
			{
			if (names.get(i).getAcctNum() == Integer.parseInt(txtNum.getText()))
				index = i;
			}
			txtBal.setText("" + names.get(index).getBalance());
			}
		}
		
	});
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
