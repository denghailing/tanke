/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke.observer;

import com.dhl.tanke.Tanke;

/**
 * 
 * @author DHL
 * @version 2020年6月19日
 */
public class TankeFireHandler implements TankeObserver{

	@Override
	public void actionOnFire(TankeFireEvent e) {
		Tanke tanke = e.getResource();
		if(tanke.getFireStrategy() == 1){
			tanke.fire(1);
		}else if(tanke.getFireStrategy() == 0){
			tanke.fire(0);
		}
	}

}
