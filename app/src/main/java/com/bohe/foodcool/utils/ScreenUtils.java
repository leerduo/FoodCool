package com.bohe.foodcool.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;


/**
 * Created by wangteng.
 * Time:2015/11/2
 * Email:843203996@qq.com
 */
/**
 * 
 * 1. 屏幕px --->转换dp<br/>
 * 2.	获得控件在屏幕中的位置<br/>
 * 3. 获得当前窗口的宽高 <br/>
 * 
 */
public class ScreenUtils {
   
	private static int[] px = new int[101];
	private static int[] py = new int[101];
	private int w,h;
	private DisplayMetrics dm;
	public ScreenUtils(Activity activity){
		dm = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		w = dm.widthPixels;
		h = dm.heightPixels;
		int length = px.length;
		for(int index=0;index<length;index++){
			px[index] = (int)(w*0.01*index);
			py[index] = (int)(h*0.01*index);
		}
	}

	/**
	 * 根据手机当前的屏幕密度，进行 dp 到 px 单位的换算
	 * @param context
	 * @param dp    待转换的
	 * @return
	 */
	public static int dp2px(Context context,    int dp){
		int ret = 0;
		Resources resources = context.getResources();
		//  获取屏幕的测量信息
		DisplayMetrics metrics = resources.getDisplayMetrics();
		// px = dp * (dpi /160)
		ret = (int)(dp * metrics.density);
		return ret;
	}
	
	/**
	 * 获取当前屏幕的宽度
	 * @return
	 */
	public int getScreenWidth(){
		return w;
	}

	/**
	 * 获取当前的屏幕的高
	 * @return
	 */
	public int getScreenHeight(){
		return h;
	}

	/**
	 * <li>获取控件在窗口中的位置</li>
	 * <li>调用需要在界面创建之后</li>
	 * <li>状态栏不被计算在内</li>
	 * @param view
	 * @return
	 */
	public int[] getLocationInWindow(View view){
		int[] ret = null;
		if (view != null) {
			ret = new int[2];
			view.getLocationInWindow(ret);
		}
		return ret;
	}

	/**
	 *<li>获取控件在整个屏幕上的位置</li>
	 * <li>不属于应用的状态条也计算在内。</li>
	 * <li>调用需要在界面创建之后</li>
	 * @param view
	 * @return
	 */
	public int[] getLocationOnScreen(View view){

		int[] ret = null;

		if (view != null) {
			ret = new int[2];
			view.getLocationOnScreen(ret);
		}
		return ret;
	}

	/**
	 * 获得x点值
	 * @param index
	 * @return
	 */
	public static int getpixels_x(int index){
		return px[index];
	}
	/**
	 * 获得y点值
	 * @param index
	 * @return
	 */
	public static int getpixels_y(int index){
		return py[index];
	}
}
