/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke.abstractfactory;

import com.dhl.tanke.Bullet;
import com.dhl.tanke.Dir;
import com.dhl.tanke.Group;
import com.dhl.tanke.TankeFrame;

/**
 * 
 * @author DHL
 * @version 2020年6月9日
 */
public abstract class GameFactory {
	public abstract BaseTanke creatTanke(int x,int y,Dir dir,Group group,TankeFrame tf);
	public abstract BaseBullet creatBullet(int x,int y,Dir dir,Group group,TankeFrame tf);
	public abstract BaseExplode creatExplode(int x,int y,TankeFrame tf);
}
