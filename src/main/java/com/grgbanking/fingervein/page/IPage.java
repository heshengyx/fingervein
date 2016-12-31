package com.grgbanking.fingervein.page;

import java.util.Collection;

public interface IPage<T> {

	int getTotal();
	Collection<T> getRows();
}
