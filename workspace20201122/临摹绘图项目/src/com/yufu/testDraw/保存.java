package com.yufu.testDraw;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class 保存 {
	public static void 保存图像(JFrame frame,BufferedImage bfImg) {
		JFileChooser jfchoo=new JFileChooser();
		jfchoo.setDialogTitle("保存图像");
		FileNameExtensionFilter filter=new FileNameExtensionFilter("JPG", new String[] {"jpg"});
		jfchoo.setFileFilter(filter);
		SimpleDateFormat 日期格式=new SimpleDateFormat("yyyymmddhhmmss");
		FileSystemView 文件显示=FileSystemView.getFileSystemView();
		File 文件路径=文件显示.getHomeDirectory();
		String 文件名字=日期格式.format(new Date());
		File 保存文件=new File(文件路径, 文件名字+".jpg");
		jfchoo.setSelectedFile(保存文件);
		
		int flag=jfchoo.showSaveDialog(null);
		if(flag==0) {
			try {
				ImageIO.write(bfImg, "jpg", 保存文件);
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				JOptionPane.showMessageDialog(frame, "文件无法保存", "错误", 0);
			}
		}
		
		
	}
	
}
