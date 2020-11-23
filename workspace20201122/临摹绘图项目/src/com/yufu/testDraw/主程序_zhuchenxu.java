package com.yufu.testDraw;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;
import java.awt.Component;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class 主程序_zhuchenxu extends JFrame implements 获取多边形 {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	// 因为绘图需要纸&笔&颜色,所以对应要初始化这些参数--------------------------->
	private 画纸_huazhi 画纸 = new 画纸_huazhi(); // <----画纸
	BufferedImage bfImg = new BufferedImage(570, 390, BufferedImage.TYPE_INT_BGR);// <----图形缓存的区域
	Graphics gs = bfImg.getGraphics(); // <----画笔
	Graphics2D 画笔2D = (Graphics2D) gs;// <---画笔转换成2D画笔
	Color 前景色 = Color.BLACK; // <---颜色,用黑的颜色画图形
	Color 背景色 = Color.WHITE; // <---颜色,用白的颜色做底色
	private final ButtonGroup buttonGroup = new ButtonGroup();
	// <---------------------------------------------------------------------------

	// 添加鼠标监听需要的参数------------------------------------------>
	int x = -1; // <------------需要存储鼠标在屏幕上的x轴坐标位置
	int y = -1; // <------------需要存储鼠标在屏幕上的y轴坐标位置
	boolean 橡皮擦 = false;// <-------------判断橡皮的状态,是否执行橡皮擦除动作
	// <----------------------------------------------------------------

	// 添加按钮监听事件的参数----------------------------->
	JButton btn_保存;
	JToggleButton tglbtn_极细线;
	JToggleButton tglbtn_中等线;
	JToggleButton tglbtn_粗线;
	// <---------------------------------------------------------

	JButton btn_前景色;
	JButton btn_背景色;
	JButton btn_图形;
	JButton btn_清除;
	JButton btn_橡皮;
	多边形 多边形;
	boolean 多边形状态 = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					主程序_zhuchenxu frame = new 主程序_zhuchenxu();
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
	public 主程序_zhuchenxu() {
		setResizable(false);
		setTitle("绘图程序");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 570, 460);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		载入绘图程序();
		对象监听程序();
	}

	private void 载入绘图程序() {

		contentPane.add(画纸);
		画笔2D.setColor(背景色); // <------设置画笔颜色为背景色(白色)
		画笔2D.fillRect(0, 0, 570, 390); // <--------用背景色画一个矩形570.390大小的画布
		画笔2D.setColor(前景色); // <-----设置画笔颜色为前景色(黑色)
		画纸.setImg(bfImg); // <-----画纸设置图像模式为画纸的函数

		// 添加控制的功能按钮------------->
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);

		btn_保存 = new JButton("保存");

		toolBar.add(btn_保存);
		toolBar.addSeparator();

		tglbtn_极细线 = new JToggleButton("极细线");
		tglbtn_极细线.setSelected(true);
		buttonGroup.add(tglbtn_极细线);
		toolBar.add(tglbtn_极细线);

		tglbtn_中等线 = new JToggleButton("中等线");
		buttonGroup.add(tglbtn_中等线);
		toolBar.add(tglbtn_中等线);

		tglbtn_粗线 = new JToggleButton("粗线");
		buttonGroup.add(tglbtn_粗线);
		toolBar.add(tglbtn_粗线);

		toolBar.addSeparator();

		btn_前景色 = new JButton("前景色");
		toolBar.add(btn_前景色);

		btn_背景色 = new JButton("背景色");
		toolBar.add(btn_背景色);

		toolBar.addSeparator();

		btn_图形 = new JButton("图形");

		toolBar.add(btn_图形);

		toolBar.addSeparator();

		btn_清除 = new JButton("清除");
		toolBar.add(btn_清除);

		btn_橡皮 = new JButton("橡皮");

		toolBar.add(btn_橡皮);

		// <---------------------------添加控制的功能按钮

		// 添加控制的与功能按钮相同的控制菜单------------------>
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("系统");
		mnNewMenu.setMnemonic('F');
		menuBar.add(mnNewMenu);

		JMenuItem mntm_水印 = new JMenuItem("水印");
		mnNewMenu.add(mntm_水印);

		JMenuItem mntm_保存 = new JMenuItem("保存");
		mnNewMenu.add(mntm_保存);

		JSeparator separator1 = new JSeparator();
		mnNewMenu.add(separator1);

		JMenuItem mntm_退出 = new JMenuItem("退出");
		mntm_退出.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntm_退出);

		JMenu menu = new JMenu("线型");
		menuBar.add(menu);

		JMenuItem mntm_极细 = new JMenuItem("极细");
		menu.add(mntm_极细);

		JMenuItem mntm_中等 = new JMenuItem("中等");
		menu.add(mntm_中等);

		JMenuItem mntm_粗线 = new JMenuItem("粗线");
		menu.add(mntm_粗线);

		JMenu mnNewMenu_2 = new JMenu("颜色");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntm_前景色 = new JMenuItem("前景色");
		mnNewMenu_2.add(mntm_前景色);

		JMenuItem mntm_背景色 = new JMenuItem("背景色");
		mnNewMenu_2.add(mntm_背景色);

		JMenu mnNewMenu_3 = new JMenu("编辑");
		menuBar.add(mnNewMenu_3);

		JMenuItem mntm_清除 = new JMenuItem("清除");
		mnNewMenu_3.add(mntm_清除);

		JMenuItem mntm_橡皮 = new JMenuItem("橡皮");
		mnNewMenu_3.add(mntm_橡皮);
		// <------------------------------添加控制的与功能按钮相同的控制菜单

		// TODO 自动生成的方法存根

	}

	// ***事件监听------------------------------------->
	private void 对象监听程序() {

		画纸.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if (x > 0 && y > 0) {
					if (橡皮擦) {
						画笔2D.setColor(背景色);
						画笔2D.fillRect(x, y, 10, 10);
					} else {
						画笔2D.drawLine(x, y, e.getX(), e.getY());
					}

				}
				x = e.getX();
				y = e.getY();

				画纸.repaint();
			}

		});

		画纸.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (多边形状态) {
					switch (多边形.get类型标识号()) {
					case com.yufu.testDraw.多边形.圆的标识号码:
						int 圆X = e.getX() - 多边形.get多边形_宽() / 2;
						int 圆Y = e.getY() - 多边形.get多边形_高() / 2;
						Ellipse2D 圆 = new Ellipse2D.Double(圆X, 圆Y, 多边形.get多边形_宽(), 多边形.get多边形_高());
						画笔2D.draw(圆);
						break;
					case com.yufu.testDraw.多边形.方的标识号码:
						int 方X = e.getX() - 多边形.get多边形_宽();
						int 方Y = e.getY() - 多边形.get多边形_高();
						Rectangle2D 方=new Rectangle2D.Double(方X, 方Y, 多边形.get多边形_宽(), 多边形.get多边形_高());
						画笔2D.draw(方);
						break;
					}
					画纸.repaint();
					多边形状态=false;
				}

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				x = -1;
				y = -1;
			}
		});

		btn_保存.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				保存.保存图像(主程序_zhuchenxu.this, bfImg);
				;
			}
		});

		tglbtn_极细线.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BasicStroke 极细线 = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
				画笔2D.setStroke(极细线);

			}
		});
		tglbtn_中等线.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BasicStroke 中等线 = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
				画笔2D.setStroke(中等线);
			}
		});
		tglbtn_粗线.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BasicStroke 粗线 = new BasicStroke(7, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
				画笔2D.setStroke(粗线);
			}
		});

		btn_前景色.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color 选择的前景色 = JColorChooser.showDialog(rootPane, "颜色选择", Color.GREEN);
				if (选择的前景色 != null) {
					前景色 = 选择的前景色;
				}
				btn_前景色.setBackground(前景色);
				画笔2D.setColor(背景色);
				画笔2D.fillRect(0, 0, 570, 390);
				画笔2D.setColor(前景色);
				画纸.repaint();
			}
		});

		btn_背景色.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color 选择的背景色 = JColorChooser.showDialog(rootPane, "颜色选择", Color.BLUE);
				if (选择的背景色 != null) {
					背景色 = 选择的背景色;
				}
				btn_背景色.setBackground(背景色);
				画笔2D.setColor(背景色);
				画笔2D.fillRect(0, 0, 570, 390);
				画笔2D.setColor(前景色);
				画纸.repaint();
			}
		});

		btn_图形.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				多边形窗口 多边形窗口 = new 多边形窗口(主程序_zhuchenxu.this);
				int 获得多边形按钮宽度 = btn_图形.getWidth();
				int 获得多边形窗口宽度 = 多边形窗口.getWidth();
				int 多边形按钮X = btn_图形.getX();
				int 多边形按钮Y = btn_图形.getY();

				int 多边形窗口X = getX() + 多边形按钮X - (获得多边形窗口宽度 - 获得多边形按钮宽度) / 2;
				int 多边形窗口Y = getY() + 多边形按钮Y + 80;
				多边形窗口.setLocation(多边形窗口X, 多边形窗口Y);
				多边形窗口.setVisible(true);
			}
		});

		btn_清除.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				画笔2D.setColor(背景色);
				画笔2D.fillRect(0, 0, 570, 390);
				画笔2D.setColor(前景色);

				画纸.repaint();
			}
		});

		btn_橡皮.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (btn_橡皮.getText().equals("橡皮")) {
					橡皮擦 = true;
					btn_橡皮.setText("绘图");

				} else {
					橡皮擦 = false;
					btn_橡皮.setText("橡皮");
					画笔2D.setColor(前景色);
				}
			}
		});

		// TODO 自动生成的方法存根

	}
	// ***<--------------事件监听

	@Override
	public void get多边形(多边形 多边形) {
		this.多边形 = 多边形;
		多边形状态 = true;

		// TODO 自动生成的方法存根

	}

}
