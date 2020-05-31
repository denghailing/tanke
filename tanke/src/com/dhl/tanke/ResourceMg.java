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
	public static BufferedImage goodtankl,goodtanku,goodtankr,goodtankd;
	public static BufferedImage badtankl,badtanku,badtankr,badtankd;
	public static BufferedImage bulletl,bulletr,bulletu,bulletd;
	public static BufferedImage[] explodes = new BufferedImage[16];
	static{
		try {
			badtanku = ImageIO.read(ResourceMg.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
			badtankl = ImageUtil.rotateImage(badtanku, -90);
			badtankd = ImageUtil.rotateImage(badtanku, 180);
			badtankr = ImageUtil.rotateImage(badtanku, 90);
			
			goodtanku = ImageIO.read(ResourceMg.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
			goodtankl = ImageUtil.rotateImage(goodtanku, -90);
			goodtankd = ImageUtil.rotateImage(goodtanku, 180);
			goodtankr = ImageUtil.rotateImage(goodtanku, 90);
			
			for (int i = 0; i < 16;i++) 
				explodes[i] = ImageIO.read(ResourceMg.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static{
		try {
			bulletu = ImageIO.read(ResourceMg.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
			bulletl = ImageUtil.rotateImage(bulletu, -90);
			bulletd = ImageUtil.rotateImage(bulletu, 180);
			bulletr = ImageUtil.rotateImage(bulletu, 90);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
