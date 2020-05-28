/**
 * Copyright (c) 2013-Now http://denghailing//tanke.com All rights reserved.
 */
package com.dhl.tanke;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 
 * @author DHL
 * @version 2020年5月22日
 */
public class main {
	public static void main(String[] args) throws InterruptedException{
		TankeFrame frame = new TankeFrame();
		//初始化敌方坦克
		for(int i = 0; i < 5; i++){
			frame.enemyTank.add(new Tanke(50+i*80, 200, Dir.DOWN , frame));
		}
		while(true){
			Thread.sleep(50);
			frame.repaint();
		}
	}
}
