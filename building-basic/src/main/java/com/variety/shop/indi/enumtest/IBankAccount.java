package com.variety.shop.indi.enumtest;

/**
 * 接口化
 * <p>
 * Created by rongbin.xie on 2017/9/30.
 */
public interface IBankAccount {
	/**
	 * 获取利率
	 */
	double getInterestRate();

	/**
	 * 是否支持转账
	 */
	boolean supportsDeposits();
}
