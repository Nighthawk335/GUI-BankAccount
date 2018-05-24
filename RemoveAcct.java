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

public class RemoveAcct extends JPanel
{
	private ArrayList<BankAccount> names;
	private JPanel thisPanel = this;
	
	public RemoveAcct(ArrayList<BankAccount> list)
	{
	names = list;
	setSize(400, 400);
	setLayout(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();
	gbc.gridx = 0;
	gbc.gridy = 0;
	JLabel lblNum = new JLabel("Enter Account Number:");
	add(lblNum, gbc);
	gbc.gridx++;
	JTextField txtNum = new JTextField();
	txtNum.setPreferredSize(new Dimension(180, 30));
	add(txtNum, gbc);
	gbc.gridx--;
	gbc.gridy++;
	JButton submit = new JButton("submit");
	add(submit, gbc);
	submit.addActionListener(new ActionListener() 
	{
		
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			int index = -1;
			for (int i = 0; i < names.size(); i++)
			{
			if (names.get(i).getAcctNum() == Integer.parseInt(txtNum.getText()))
			{
			index = i;
			}
			}
			if (index != -1)
			{
			names.remove(index);
			JOptionPane.showMessageDialog(thisPanel, "success");
			}
			else
			{
			JOptionPane.showMessageDialog(thisPanel, "number doesn't exist");
			}
			txtNum.setText("");
		}

	});
}}
