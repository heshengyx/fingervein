package com.grgbanking.fingervein.page;

import java.util.List;

public interface IPagination<T> {

	public int count();
	public List<T> query(int start, int end);
}
