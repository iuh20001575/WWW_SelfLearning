package main;

import jakarta.inject.Inject;

public class HelloWorld {
	@Inject
	private Hello hello;
	
	public String get() {
		return hello.getValue() + " world";
	}
}
