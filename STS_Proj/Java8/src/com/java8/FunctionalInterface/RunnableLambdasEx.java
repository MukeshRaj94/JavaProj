package com.java8.FunctionalInterface;

public class RunnableLambdasEx {
	
	public static void main(String[] args) {
		Runnable runn = new Runnable() {
			public void run() {
				System.out.println("Runnning in old java");
			}
		};
		new Thread(runn).start();
		
		Runnable runn1 = ()->{System.out.println("New Java");};
		new Thread(runn1).start();
	}
}
