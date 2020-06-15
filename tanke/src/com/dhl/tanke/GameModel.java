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
import com.dhl.tanke.cor.TankeTankeCollider;
import com.dhl.tanke.cor.BulletTankeCollider;
import com.dhl.tanke.cor.Collider;
import com.dhl.tanke.cor.ColliderChain;

/**
 * 
 * @author DHL
 * @version 2020年6月14日
 */
public class GameModel {

	Tanke myTanke = new Tanke(200, 400, Dir.DOWN,Group.GOOD,this);
	private List<GameObject> objects = new ArrayList<>();
	//Collider collider = new BulletTankeCollider();
	//Collider collider2 = new TankeTankeCollider();
	ColliderChain colliderChain = new ColliderChain();
	//public GameFactory gf = new DefaultFactory();
	public GameModel(){
		int initTankeCount = PropertyMgr.getInt("initTankeCount");
		//初始化敌方坦克
		for(int i = 0; i < initTankeCount; i++){
			add(new Tanke(50+i*80, 200, Dir.DOWN,Group.BAD,this));
		}
	}
	public void paint(Graphics g) {
		myTanke.paint(g);
		Color color = g.getColor();
		g.setColor(Color.WHITE);
//		g.drawString("子弹数量："+ bullets.size(),10,60);
//		g.drawString("敌人数量："+ enemyTank.size(),10,80);
//		g.drawString("爆炸数量："+ explodes.size(),10,100);
		g.setColor(color);
		for (int i = 0;i < objects.size();i++){
			objects.get(i).paint(g);
		}
		//相互碰撞
		for (int i=0;i < objects.size();i++){
			for(int j=0;j < objects.size();j++){
				GameObject o1 = objects.get(i);
				GameObject o2 = objects.get(j);
				//collider.collide(o1, o2);
				//collider2.collide(o1, o2);
				colliderChain.collide(o1,o2);
			}
		}
		
		
//		for(int i = 0;i < bullets.size();i++ ){
//			for(int j = 0;j < enemyTank.size();j++)
//				bullets.get(i).collideWith(enemyTank.get(j));
//		}
	}
	public Tanke getmyTanke() {
		// TODO Auto-generated method stub
		return myTanke;
	}
	public void add(GameObject go){
		this.objects.add(go);
	}
	public void remove(GameObject go){
		this.objects.remove(go);
	}
}
