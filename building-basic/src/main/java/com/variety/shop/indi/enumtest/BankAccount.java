package com.variety.shop.indi.enumtest;

/**
 * 坦白来说，这是我写的最正常的写法
 *
 * Created by rongbin.xie on 2017/9/30.
 */
public class BankAccount {
	private final BankAccountType type;

	public BankAccount(BankAccountType type) {
		this.type = type;
	}

	public double getInterestRate() {
		switch (type) {
			case CHECKING:
				return 0.03; // 3%
			case SAVINGS:
				return 0.04; // 4%
			case CERTIFICATE_OF_DEPOSIT:
				return 0.05; // 5%
			default:
				throw new UnsupportedOperationException();
		}
	}

	public boolean supportsDeposits() {
		switch (type) {
			case CHECKING:
				return true;
			case SAVINGS:
				return true;
			case CERTIFICATE_OF_DEPOSIT:
				return false;
			default:
				throw new UnsupportedOperationException();
		}
	}
}
