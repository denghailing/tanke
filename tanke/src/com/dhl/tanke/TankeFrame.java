/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.dhl.tanke;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.text.AbstractDocument.BranchElement;

/**
 * 
 * @author DHL
 * @version 2020年5月23日
 */
public class TankeFrame extends Frame{
	int x = 200, y = 200;
	public TankeFrame() {
		// TODO Auto-generated constructor stub
		setVisible(true);
		setSize(800,600);
		setTitle("Tanke War");
		setResizable(false);
		//添加键盘监听事件，并把自定义的键盘监听对象赋值
		this.addKeyListener(new MykeyListener());
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	
	@Override
	public void paint(Graphics g) {
		g.fillRect(x,y,50,50);
	}
	//自定义键盘监听类
	class MykeyListener extends KeyAdapter{
		boolean bl = false;
		boolean bu = false;
		boolean br = false;
		boolean bd = false;
 		@Override
		public void keyPressed(KeyEvent paramKeyEvent) {
			// TODO Auto-generated method stub
			int keycode = paramKeyEvent.getKeyCode();
			switch (keycode){
			case KeyEvent.VK_LEFT:
				bl =  true;
				break;
			case KeyEvent.VK_UP:
				bu = true;
				break;
			case KeyEvent.VK_RIGHT:
				br = true;
				break;
			case KeyEvent.VK_DOWN:
				bd = true;
				break;
			default:
				break;
			}
			System.out.println("key press");
		}
 		//键盘抬起，将其设置为false，要不总是为true
		@Override
		public void keyReleased(KeyEvent paramKeyEvent) {
			// TODO Auto-generated method stub
			int keycode = paramKeyEvent.getKeyCode();
			switch (keycode){
			case KeyEvent.VK_LEFT:
				bl =  false;
				break;
			case KeyEvent.VK_UP:
				bu = false;
				break;
			case KeyEvent.VK_RIGHT:
				br = false;
				break;
			case KeyEvent.VK_DOWN:
				bd = false;
				break;
			default:
				break;
			}
			System.out.println("end do it");
			System.out.println("key Released");
		}
		
	}
}
