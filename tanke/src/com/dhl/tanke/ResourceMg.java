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
			tanku = ImageIO.read(ResourceMg.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
			tankl = ImageUtil.rotateImage(tanku, -90);
			tankd = ImageUtil.rotateImage(tanku, 180);
			tankr = ImageUtil.rotateImage(tanku, 90);
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
