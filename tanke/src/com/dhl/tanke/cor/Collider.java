/**
 * Copyright (c) 2013-Now http://denghailing.com All rights reserved.
 */
package com.dhl.tanke.cor;

import com.dhl.tanke.GameObject;

/**
 * 
 * @author DHL
 * @version 2020年6月14日
 */
public interface Collider {
	boolean collide(GameObject o1,GameObject o2);

}
