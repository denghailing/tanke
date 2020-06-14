/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.dhl.tanke.abstractfactory.BaseBullet;
import com.dhl.tanke.abstractfactory.BaseExplode;
import com.dhl.tanke.abstractfactory.BaseTanke;
import com.dhl.tanke.abstractfactory.DefaultFactory;
import com.dhl.tanke.abstractfactory.GameFactory;

/**
 * 
 * @author DHL
 * @version 2020年6月14日
 */
public class GameModel {
	public List<Bullet> bullets = new ArrayList<>();
	public List<Tanke> enemyTank = new ArrayList<>();
	public List<Explode> explodes = new ArrayList<>();
	Tanke myTanke = new Tanke(200, 400, Dir.DOWN,Group.GOOD,this);
	
	//public GameFactory gf = new DefaultFactory();
	public GameModel(){
		int initTankeCount = PropertyMgr.getInt("initTankeCount");
		//初始化敌方坦克
		for(int i = 0; i < initTankeCount; i++){
			enemyTank.add(new Tanke(50+i*80, 200, Dir.DOWN,Group.BAD,this));
		}
	}
	public void paint(Graphics g) {
		myTanke.paint(g);
		Color color = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("子弹数量："+ bullets.size(),10,60);
		g.drawString("敌人数量："+ enemyTank.size(),10,80);
		g.drawString("爆炸数量："+ explodes.size(),10,100);
		g.setColor(color);
		for (int i = 0;i < bullets.size();i++){
			bullets.get(i).paint(g);
		}
		for (int i = 0;i < enemyTank.size();i++){
			enemyTank.get(i).paint(g);
		}
		
		for (int i = 0;i < explodes.size();i++){
			explodes.get(i).paint(g);
		}
		
		for(int i = 0;i < bullets.size();i++ ){
			for(int j = 0;j < enemyTank.size();j++)
				bullets.get(i).collideWith(enemyTank.get(j));
		}
		//e.paint(g);
	}
	public Tanke getmyTanke() {
		// TODO Auto-generated method stub
		return myTanke;
	}

}
