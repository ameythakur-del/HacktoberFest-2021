package inventoryManagement;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.awt.Rectangle;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;  


public class Main {

	static Statement stmt;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try{  
			
			
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:8000/inventory?characterEncoding=latin1&useConfigs=maxPerformance","root","Ak#47gun");  
			stmt=con.createStatement();  
			
			
			JFrame jframe = new JFrame();
			jframe.setBounds(0, 0, 1000, 800);
			jframe.setVisible(true);
			jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanel panel = new JPanel();
			jframe.getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
//			stmt.executeUpdate("drop table products");
			
//			createTable(stmt);
			
			
			JLabel lblNewLabel = new JLabel("Inventory Management System ");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 40));
			lblNewLabel.setBounds(205, 74, 588, 79);
			panel.add(lblNewLabel);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(39, 34, 98));
			panel_1.setBounds(75, 182, 224, 418);
			panel.add(panel_1);
			
			
			
			JButton btnNewButton = new JButton("Add New Product");
		
			
			JButton btnNewButton_1 = new JButton("View Products");
			panel_1.add(btnNewButton_1);
			panel_1.add(btnNewButton);
			
			JPanel panel_2 = new JPanel();
			
			panel_2.setLayout(null);
			panel_2.setBackground(UIManager.getColor("text"));
			panel_2.setBounds(321, 182, 588, 423);
			
			
			JTable table = new JTable();
		    
		    table.setBounds(new Rectangle(0, 0, 588, 423));
			
			
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jframe.setVisible(false);
					AddProduct product = new AddProduct();
				}
			});
			
			
			btnNewButton_1.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ResultSet rset = getProducts();
					
					try {
						rset.last();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					String[][] tableData = null;
					try {
						tableData = new String[rset.getRow()][4];
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					try {
						rset.first();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					int j=0;
					
					try {
						while(rset.next()) {
							
//							System.out.println("1");
							
							for(int i=2; i<6; i++) {
								tableData[j][i-2] = rset.getString(i);
							}
							j++;
						}
						String[] header = { "Product", "Category", "Price", "Quantity" };
						
					    table.setModel(new DefaultTableModel(tableData, header));
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			});
		
			
			
			panel.add(panel_2);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(43, 21, 499, 391);
			scrollPane.setViewportView(table);
			panel_2.add(scrollPane);
			jframe.getContentPane().add(panel);
			
			
			
			
		
			
			}catch(Exception e){ System.out.println(e);}  
		
		
		
		
		
//		Database database;
//		Products.createTable(Database.db);
//		Products.insert(Database.db, "Apple", "Fruits", "50 Rs", 100);
		
		
		
	}
	
	public static int getSize() {
		int count=0;
		try {
			stmt.executeQuery("select count(*) from products");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public static void createTable(Statement stmt) {
		try {
			stmt.executeUpdate("create table products (ID int AUTO_INCREMENT, name TEXT, category TEXT, price TEXT, quantity INTEGER, PRIMARY KEY (id))");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addProduct(String[] details) {
		try {
			String values = String.format("'%s', '%s', '%s','%d'", details[0], details[1], details[2], Integer.parseInt(details[3]));
			stmt.executeUpdate("insert into products (name, category, price, quantity) values("+ values +")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}											
	}
	
	public static ResultSet getProducts() {
		ResultSet set = null;
		try {
			set = stmt.executeQuery("select * from products");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return set;
	}
}