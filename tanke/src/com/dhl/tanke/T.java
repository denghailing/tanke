/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
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
public class T {
	public static void main(String[] args){
		Frame frame = new Frame();
		frame.setVisible(true);
		frame.setSize(800,600);
		frame.setTitle("Tanke War");
		frame.setResizable(false);
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
}
