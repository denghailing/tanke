/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package test;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

/**
 * 
 * @author DHL
 * @version 2020年5月26日
 */
public class ImageTest {

	@Test
	public void test() {
		try {
			//获取将ImageTest类的实例加载到内存的ClassLoader()方法get到，让用该方法去classpath下面找到images/bulletD.gif文件，
			//然后以AsStream形式用getResourceAsStream()方法读出来。将读出的数据赋值给image对象形成图片
			BufferedImage image = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
			assertNotNull(image);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
