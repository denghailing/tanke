/**
 * Copyright (c) 2013-Now http://denghailing//tanke.com All rights reserved.
 */
package com.dhl.tanke;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.text.AbstractDocument.BranchElement;

/**
 * 
 * @author DHL
 * @version 2020年5月23日
 */
public class TankeFrame extends Frame{
	Tanke myTanke = new Tanke(200, 200, Dir.DOWN, this);
	Bullet mybullet = new Bullet(300, 300, Dir.DOWN,this);
	List<Bullet> bullets = new ArrayList<>();
	static final int GAME_WIDTH = 800,GAME_HEIGHT = 600;
	public TankeFrame() {
		// TODO Auto-generated constructor stub
		setVisible(true);
		setSize(GAME_WIDTH,GAME_HEIGHT);
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
	//利用双缓冲解决游戏闪屏的问题（游戏开发用到的技术）
	Image offScreenImage = null;
	@Override
	public void update(Graphics g) {
		if(offScreenImage == null){
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics goffscreen = offScreenImage.getGraphics();
		Color c = goffscreen.getColor();
		goffscreen.setColor(Color.BLACK);
		goffscreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		goffscreen.setColor(c);
		paint(goffscreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	@Override
	public void paint(Graphics g) {
		myTanke.paint(g);
		Color color = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("子弹数量："+ bullets.size(),10,60);
		g.setColor(color);
		for (int i = 0;i < bullets.size();i++){
			bullets.get(i).paint(g);
		}
		//mybullet.paint(g);
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
			setMainTankDir();
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
			case KeyEvent.VK_SPACE:
				myTanke.fire();
				break;
			default:
				break;
			}
			setMainTankDir();
		}
		
		private void setMainTankDir() {
			if(!bl && !bu && !br && !bd) myTanke.setMOVING(false);
			else{
				myTanke.setMOVING(true);
				if(bl) myTanke.setDir(Dir.LEFT);
				if(bu) myTanke.setDir(Dir.UP);
				if(br) myTanke.setDir(Dir.RIGHT);
				if(bd) myTanke.setDir(Dir.DOWN);
			}
		}
	}
}
