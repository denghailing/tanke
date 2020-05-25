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
		while(true){
			Thread.sleep(50);
			frame.repaint();
		}
	}
}
