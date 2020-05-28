/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * @author DHL
 * @version 2020年5月27日
 */
public class ResourceMg {
	public static BufferedImage tankl,tanku,tankr,tankd;
	public static BufferedImage bulletl,bulletr,bulletu,bulletd;
	public static BufferedImage[] explodes = new BufferedImage[16];
	static{
		try {
			tankl = ImageIO.read(ResourceMg.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
			tanku = ImageIO.read(ResourceMg.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
			tankd = ImageIO.read(ResourceMg.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
			tankr = ImageIO.read(ResourceMg.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
			for (int i = 0; i < 16;i++) 
				explodes[i] = ImageIO.read(ResourceMg.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static{
		try {
			bulletl = ImageIO.read(ResourceMg.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
			bulletu = ImageIO.read(ResourceMg.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
			bulletd = ImageIO.read(ResourceMg.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
			bulletr = ImageIO.read(ResourceMg.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
