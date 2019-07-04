package com.variety.shop.indi.enumtest;

/**
 * Created by rongbin.xie on 2017/9/30.
 */
public enum BankAccountType {
	CHECKING("1"),
	SAVINGS("2"),
	CERTIFICATE_OF_DEPOSIT("3");
	private String value;

	public String value() {
		return this.value;
	}

	BankAccountType(String value) {
		this.value = value;
	}
}
