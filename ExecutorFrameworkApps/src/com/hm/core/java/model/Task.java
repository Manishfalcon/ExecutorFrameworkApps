package com.hm.core.java.model;

import java.util.Random;
import java.util.concurrent.Callable;

public class Task implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		System.out.println(Thread.currentThread().getName());
		return new Random().nextInt(10);
	}

}
