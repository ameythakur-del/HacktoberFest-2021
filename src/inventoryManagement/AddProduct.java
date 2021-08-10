package inventoryManagement;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddProduct {
	private static JTextField txtName;
	private static JTextField txtCategory;
	private static JTextField txtPrice;
	private static JTextField txtInitialQuantity;
	
	public AddProduct(){
		JFrame jframe2 = new JFrame();
		jframe2.setBounds(0, 0, 1000, 800);
		jframe2.setVisible(true);
		jframe2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		JPanel panel = new JPanel();
		jframe2.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Product");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 40));
		lblNewLabel.setBounds(205, 74, 588, 79);
		panel.add(lblNewLabel);
		
		txtName = new JTextField();
		txtName.setBounds(205, 182, 226, 40);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtCategory = new JTextField();
		txtCategory.setBounds(534, 179, 259, 46);
		panel.add(txtCategory);
		txtCategory.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(205, 278, 226, 46);
		panel.add(txtPrice);
		txtPrice.setColumns(10);
		
		txtInitialQuantity = new JTextField();
		txtInitialQuantity.setBounds(534, 275, 259, 53);
		panel.add(txtInitialQuantity);
		txtInitialQuantity.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Serif", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(152, 175, 53, 50);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Category");
		lblNewLabel_2.setFont(new Font("Serif", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(472, 186, 63, 29);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setFont(new Font("Serif", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(156, 292, 49, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Quantity");
		lblNewLabel_4.setFont(new Font("Serif", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(472, 284, 49, 30);
		panel.add(lblNewLabel_4);
		
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String details[] = {txtName.getText(), txtCategory.getText(), txtPrice.getText(), txtInitialQuantity.getText()};
				
				Main.addProduct(details);
			}
		});
		btnNewButton.setBounds(414, 406, 160, 67);
		panel.add(btnNewButton);
		
		
		
	}
}
