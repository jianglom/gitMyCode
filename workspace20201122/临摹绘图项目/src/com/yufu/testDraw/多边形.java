package com.yufu.testDraw;

public class 多边形 {

	public static final int 圆的标识号码=6243589;
	public static final int 方的标识号码=6262598;

	private int 类型标识号;
	
	
	private int 多边形_宽;
	private int 多边形_高;

	public int get类型标识号() {
		return 类型标识号;
	}

	public void set类型标识号(int 类型标识号) {
		this.类型标识号 = 类型标识号;
	}

	public int get多边形_宽() {
		return 多边形_宽;
	}

	public void set多边形_宽(int 多边形_宽) {
		this.多边形_宽 = 多边形_宽;
	}

	public int get多边形_高() {
		return 多边形_高;
	}

	public void set多边形_高(int 多边形_高) {
		this.多边形_高 = 多边形_高;
	}

	public 多边形() {
	}

	public 多边形(int 类型标识号, int 多边形_宽, int 多边形_高) {
		super();
		this.类型标识号 = 类型标识号;
		this.多边形_宽 = 多边形_宽;
		this.多边形_高 = 多边形_高;
	}

	@Override
	public String toString() {
		return "多边形 [类型标识号=" + 类型标识号 + ", 多边形_宽=" + 多边形_宽 + ", 多边形_高=" + 多边形_高 + "]";
	}
}
