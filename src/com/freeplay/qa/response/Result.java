package com.freeplay.qa.response;

import java.util.HashMap;
import java.util.Map;

/**
 * Action
 * 
 * @author Fengdalu
 */
public enum Result {
	SUCCESS(0), FAIL(-1), DENY(-2);
	private int context;

	public int getContext() {
		return this.context;
	}

	private Result(int context) {
		this.context = context;
	}

	@Override
	public String toString() {
		return String.valueOf(this.context);
	}
}
