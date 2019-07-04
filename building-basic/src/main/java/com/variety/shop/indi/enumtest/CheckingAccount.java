package com.variety.shop.indi.enumtest;

/**
 * 新建一个银行账号
 *
 * Created by rongbin.xie on 2017/9/30.
 */
public class CheckingAccount implements IBankAccount {
	@Override
	public double getInterestRate() {
		return 0;
	}

	@Override
	public boolean supportsDeposits() {
		return false;
	}
}
