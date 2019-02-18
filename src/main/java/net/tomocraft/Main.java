package net.tomocraft;

import org.reflections.Reflections;

import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Reflections reflections = new Reflections("java");
		Set<Class<? extends Throwable>> classes = reflections.getSubTypesOf(Throwable.class);
		for (Class<? extends Throwable> clazz : classes) {
			try {
				throw clazz.newInstance();
			} catch (Throwable throwable) {
				System.out.println("Thrown: " + throwable.getClass().getName());
			}
		}
	}
}
