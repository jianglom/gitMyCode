package com.txl;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.ComponentOrientation;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuItem;

public class 主窗口 extends JFrame {

	private JPanel contentPane;
	private JTextField textField_输入查询的框;
	private JTable table_数据显示的表格;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					主窗口 frame = new 主窗口();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public 主窗口() {
		setTitle("通讯录系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 564);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_账户 = new JMenu("账户");
		menuBar.add(mnNewMenu_账户);
		
		JMenuItem menuItem_2 = new JMenuItem("修改密码");
		mnNewMenu_账户.add(menuItem_2);
		
		JMenu mnNewMenu_数据图 = new JMenu("数据图");
		menuBar.add(mnNewMenu_数据图);
		
		JMenuItem menuItem = new JMenuItem("柱状图");
		mnNewMenu_数据图.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("饼状图");
		mnNewMenu_数据图.add(menuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		FlowLayout fl_panel = new FlowLayout(FlowLayout.LEFT, 5, 5);
		panel.setLayout(fl_panel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"姓名", "电话", "职务"}));
		panel.add(comboBox);
		
		textField_输入查询的框 = new JTextField();
		panel.add(textField_输入查询的框);
		textField_输入查询的框.setColumns(10);
		
		JButton btn_查询 = new JButton("查询");
		panel.add(btn_查询);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table_数据显示的表格 = new JTable();
		scrollPane.setViewportView(table_数据显示的表格);
		
		JLabel lblNewLabel = new JLabel("双击鼠标查看提示信息");
		contentPane.add(lblNewLabel, BorderLayout.SOUTH);
	}

}
