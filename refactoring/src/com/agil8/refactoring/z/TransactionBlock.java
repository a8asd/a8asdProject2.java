package com.agil8.refactoring.z;

public class TransactionBlock {
	public TransactionBlock(AccountOpenApp.DbName name) {
		throw new RuntimeException();
	}

	public void Complete() {
		;
	}

	public void Dispose() {
		throw new RuntimeException();
	}
}
