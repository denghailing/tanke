/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke.strategy;

import java.io.Serializable;

import com.dhl.tanke.Tanke;

/**
 * 
 * @author DHL
 * @version 2020年6月3日
 */
public interface FireStrategy extends Serializable {
	public void fire(Tanke t);
}
