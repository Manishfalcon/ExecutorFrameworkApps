package com.hm.core.java.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.hm.core.java.model.Task;

public class SingleFuture {

	
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(2);
		Future<Integer> future = service.submit(new Task());
		System.out.println("[" + Thread.currentThread().getName() + "]" + "- Started");
		try {
			Integer val = future.get();
			System.out.println("Generated Integer : " + val);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("[" + Thread.currentThread().getName() + "]" + "- Stopped");
	}
}
