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

public class GetAccountPanel extends JPanel
{
ArrayList<BankAccount> names = new ArrayList<BankAccount>();
JPanel thisPanel = this;
JLabel nums;
GridBagConstraints gbc;
	
	public GetAccountPanel(ArrayList<BankAccount> list)
	{
		names = list;
		setSize(400, 300);
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;
		JLabel lblName = new JLabel("Name: ");
		add(lblName, gbc);
		gbc.gridx++;
		JTextField txtName = new JTextField();
		txtName.setPreferredSize(new Dimension(180,30));
		add(txtName,gbc);
		
		gbc.gridx=0;
		gbc.gridy=3;
		
		
		JButton printList = new JButton("print");
		printList.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						gbc.gridy=5;
						int count = 0;
						for (int i = 0; i < names.size(); i++)
						{
						if (names.get(i).getName().equals(txtName.getText()))
						{
//						nums.setText(nums.getText() + "\n" + names.get(i).toString());
						thisPanel.add(new JLabel(names.get(i).toString()), gbc);
						gbc.gridy++;
						count++;
						}
						}
						if (count == 0)
						{
						nums.setText("No Accounts Found");
						}
						txtName.setText("");
					}
				}
				);
		add(printList, gbc);
		gbc.gridy++;
		gbc.gridx++;
		nums = new JLabel("Account Numbers: ");
		add(nums,gbc);
				
	}
}
