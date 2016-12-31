package com.grgbanking.fingervein.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {
	
	private ListUtil() {}
	
	public static <T> List<List<T>> splitList(List<T> list, int limit) {
		// 获取被拆分的数组个数
		int size = list.size() % limit == 0 ? list.size() / limit : list
				.size() / limit + 1;
		List<List<T>> results = new ArrayList<List<T>>(size);
		for (int i = 0; i < size; i++) {
			List<T> sub = new ArrayList<T>();
			// 把指定索引数据放入到list中
			for (int j = i * limit; j <= limit * (i + 1) - 1; j++) {
				if (j <= list.size() - 1) {
					sub.add(list.get(j));
				}
			}
			results.add(sub);
		}
		return results;
	}
}
