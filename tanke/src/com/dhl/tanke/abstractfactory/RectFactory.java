/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke.abstractfactory;

import com.dhl.tanke.Dir;
import com.dhl.tanke.GameModel;
import com.dhl.tanke.Group;
import com.dhl.tanke.TankeFrame;

/**
 * 
 * @author DHL
 * @version 2020年6月9日
 */
public class RectFactory extends GameFactory {

	@Override
	public BaseTanke creatTanke(int x, int y, Dir dir, Group group, GameModel gm) {
		// TODO Auto-generated method stub
		return new RectTanke(x, y, dir, group, gm);
	}

	@Override
	public BaseBullet creatBullet(int x, int y, Dir dir, Group group, GameModel gm) {
		// TODO Auto-generated method stub
		return new RectBullet(x, y, dir, group, gm);
	}

	@Override
	public BaseExplode creatExplode(int x, int y, GameModel gm) {
		// TODO Auto-generated method stub
		return new RectExplode(x,y,gm);
	}

}
