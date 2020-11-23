package com.yufu.testDraw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JWindow;

public class 多边形窗口 extends JWindow {
	private 多边形 多边形;
	private 获取多边形 获取多边形框架;

	public 多边形窗口(获取多边形 获取多边形框架) {
		super();
		this.获取多边形框架 = 获取多边形框架;
		多边形窗口初始化();
	}

	public 多边形窗口(int x, int y, 获取多边形 获取多边形框架) {
		this.获取多边形框架 = 获取多边形框架;
		setLocation(x, y);
		多边形窗口初始化();
	}

	private void 多边形窗口初始化() {
		setSize(200, 100);
		Container 容器 = getContentPane();
		容器.setLayout(new BorderLayout());

		JPanel 中间面板 = new JPanel();
		JPanel 南方面板 = new JPanel();

		Ellipse2D 椭圆 = new Ellipse2D.Double(0.0D, 0.0D, 14.0D, 14.0D);
		多边形按钮 多边形按钮_圆=new 多边形按钮(椭圆);
		中间面板.add(多边形按钮_圆);
		
		Rectangle2D 方=new Rectangle2D.Double(0.0D,0.0D,14.0D,14.0D);
		多边形按钮 多边形按钮_方=new 多边形按钮(方);
		中间面板.add(多边形按钮_方);
		容器.add(中间面板,"Center");
		
		南方面板.setLayout(new FlowLayout(2));
		JButton 取消=new JButton("取消");
		南方面板.add(取消);
		容器.add(南方面板,"South");
		pack();
		
		取消.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				多边形窗口.this.dispose();
				// TODO 自动生成的方法存根
				
			}
		});
		// TODO 自动生成的方法存根

	}

	class 多边形按钮 extends JPanel {

		public 多边形按钮(Shape 多边形) {
			setSize(20, 20);
			setLayout(new BorderLayout());

			BufferedImage img = new BufferedImage(15, 15, 4);
			Graphics2D g2D = img.createGraphics();
			g2D.setColor(Color.white);
			g2D.fillRect(0, 0, img.getWidth(), img.getHeight());
			g2D.setColor(Color.BLACK);
			g2D.draw(多边形);

			JButton 带显示形状图片的按钮 = new JButton();
			带显示形状图片的按钮.setIcon(new ImageIcon(img));

			JPanel 选择多边形图形的面板 = new JPanel();
			选择多边形图形的面板.add(带显示形状图片的按钮);
			add(选择多边形图形的面板, "Center");
			JPanel 南方面板 = new JPanel();
			南方面板.setLayout(new FlowLayout());

			JSpinner jspi_宽 = new JSpinner();
			jspi_宽.setValue(Integer.valueOf(50));
			南方面板.add(new Label("宽"));
			南方面板.add(jspi_宽);

			JSpinner jspi_高 = new JSpinner();
			jspi_高.setValue(Integer.valueOf(50));
			南方面板.add(new Label("高"));
			南方面板.add(jspi_高);

			add(南方面板, "South");

			带显示形状图片的按钮.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (多边形 instanceof Ellipse2D) {
						多边形窗口.this.多边形 = new 多边形(6243589, ((Integer) jspi_宽.getValue()).intValue(),
								((Integer) jspi_高.getValue()).intValue());
					}
					if (多边形 instanceof Rectangle2D) {
						多边形窗口.this.多边形 = new 多边形(6262598, ((Integer) jspi_宽.getValue()).intValue(),
								((Integer) jspi_高.getValue()).intValue());
					}
					多边形窗口.this.获取多边形框架.get多边形(多边形窗口.this.多边形);
					多边形窗口.this.dispose();
					// TODO 自动生成的方法存根

				}
			});

		}
	}
}
