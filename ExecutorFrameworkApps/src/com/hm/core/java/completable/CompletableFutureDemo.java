package com.hm.core.java.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.hm.core.java.model.Order;

public class CompletableFutureDemo {

	public static void doCpuAndIOBoundOperation() {
		ExecutorService cpuBound = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		ExecutorService ioBound = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
		CompletableFuture.supplyAsync(() -> Order.getOrder())
				.thenApply(o -> Order.enrichOrder(o))
				.thenApply(o -> Order.payment(o))
				.thenAccept(o -> Order.email(o));
		}
	}

	public static void main(String[] args) {
		CompletableFutureDemo.doCpuAndIOBoundOperation();
	}

}
