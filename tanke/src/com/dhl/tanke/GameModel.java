/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	private static final GameModel INSTANCE = new GameModel();
	private String path = PropertyMgr.getString("savePath");
	Tanke myTanke;
	private List<GameObject> objects = new ArrayList<>();
	ColliderChain colliderChain = new ColliderChain();
	//public GameFactory gf = new DefaultFactory();
	
	public static GameModel getInstance(){
		return INSTANCE;
	}
	//将原本初始化的语句放到init中，静态语句块在类加载时执行
	static{
		INSTANCE.init();
	}
	private  GameModel(){}
	//打破new  Tanke 里面又调用构造方法，构造方法里面又new Tanke的循环
	private void init(){
		myTanke = new Tanke(200, 400, Dir.DOWN, Group.GOOD);
		int initTankeCount = PropertyMgr.getInt("initTankeCount");
		//初始化敌方坦克
		for(int i = 0; i < initTankeCount; i++){
			add(new Tanke(i*200, 50, Dir.DOWN,Group.BAD));
		}
		add(new Wall(150,150, 200, 50));
		add(new Wall(500,150, 200, 50));
		add(new Wall(300,300, 50, 200));
		add(new Wall(550,300, 50, 200));
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
		int sum = 0;
		for(int i = 0;i < objects.size();i++ ){
			if(objects.get(i) instanceof Bullet)
				sum++;
		}
		g.drawString("子弹数量："+ sum,10,60);
	}
	public Tanke getmyTanke() {
		return myTanke;
	}
	public void add(GameObject go){
		this.objects.add(go);
	}
	public void remove(GameObject go){
		this.objects.remove(go);
	}
	public void save(){
		File f = new File(path);
		if(!f.exists())
			f.getParentFile().mkdirs();
			try {
				f.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream(f));
				ooStream.writeObject(myTanke);
				ooStream.writeObject(objects);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}	
	}
	public void load() {
		File file = new File(path);
			ObjectInputStream ois;
			try {
				ois = new ObjectInputStream(new FileInputStream(file));
				myTanke = (Tanke)ois.readObject();
				objects = (List)ois.readObject();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
}
