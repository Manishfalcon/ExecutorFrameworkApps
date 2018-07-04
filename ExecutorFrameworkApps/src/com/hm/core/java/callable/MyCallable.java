package com.hm.core.java.callable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCallable implements Callable<String>{

	public static void main(String[] args) {
		System.out.println("[" + Thread.currentThread().getName() + "]" + "- Started");
		ExecutorService service = Executors.newFixedThreadPool(5);
		List<Future<?>> listF = new ArrayList<>();
		Callable<String> callable = new MyCallable();
		for (int i=0;i<10;i++) {
			Future<String> future = service.submit(callable);
			listF.add(future);
		}
		
		for(Future<?> future : listF) {
			try {
				System.out.println(new Date() + " " +future.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		service.shutdown();
		System.out.println("[" + Thread.currentThread().getName() + "]" + "- Stopped");
	}

	@Override
	public String call() throws Exception {
		return Thread.currentThread().getName();
	}

}
