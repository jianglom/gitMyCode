package com.yufu.testDraw;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class 画纸_huazhi extends JPanel{
    
	private Image img=null;
	
	public void setImg(Image img) {
		this.img = img;
	}

	public 画纸_huazhi(){
		
	}
	
	
	@Override
	public void paint(Graphics g) {
		// TODO 自动生成的方法存根
		super.paint(g);
		g.drawImage(img, 0, 0, null);
	}

	@Override
	public void update(Graphics g) {
		// TODO 自动生成的方法存根
		super.update(g);
		paint(g);
	}
	

}
