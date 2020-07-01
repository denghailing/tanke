/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke.observer;

import java.io.Serializable;

import com.dhl.tanke.Tanke;

/**
 * 
 * @author DHL
 * @version 2020年6月19日
 */
public interface TankeObserver extends Serializable {
	abstract void actionOnFire(TankeFireEvent e);
}
