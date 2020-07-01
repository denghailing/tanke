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

import com.dhl.tanke.abstractfactory.BaseBullet;
import com.dhl.tanke.abstractfactory.BaseExplode;
import com.dhl.tanke.abstractfactory.BaseTanke;
import com.dhl.tanke.abstractfactory.DefaultFactory;
import com.dhl.tanke.abstractfactory.GameFactory;

/**
 * 
 * @author DHL
 * @version 2020年5月23日
 */
public class TankeFrame extends Frame{
	GameModel gModel= GameModel.getInstance();
	
	public static final int GAME_WIDTH = 1080;
	public static final int GAME_HEIGHT = 960;
	public TankeFrame() {
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
		gModel.paint(g);

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
				gModel.getmyTanke().handFireKey();
				break;
			case KeyEvent.VK_SHIFT:
				gModel.getmyTanke().StrategyFireKey();
				break;
			case KeyEvent.VK_S:
				gModel.save();
				break;
			case KeyEvent.VK_L:
				gModel.load();
				break;	
			default:
				break;
			}
			setMainTankDir();
		}
		
		private void setMainTankDir() {
			if(!bl && !bu && !br && !bd) gModel.getmyTanke().setMOVING(false);
			else{
				gModel.getmyTanke().setMOVING(true);
				if(bl) gModel.getmyTanke().setDir(Dir.LEFT);
				if(bu) gModel.getmyTanke().setDir(Dir.UP);
				if(br) gModel.getmyTanke().setDir(Dir.RIGHT);
				if(bd) gModel.getmyTanke().setDir(Dir.DOWN);
			}
		}
	}
}
