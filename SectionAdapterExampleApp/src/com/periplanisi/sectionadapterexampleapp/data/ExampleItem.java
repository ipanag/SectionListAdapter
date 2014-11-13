package com.periplanisi.sectionadapterexampleapp.data;

public class ExampleItem {

	private final String name;
	public final long timestamp;

	public ExampleItem(final String name, long timestamp) {
		super();
		this.name = name;
		this.timestamp = timestamp;
	}

	public String getName() {
		return name;
	}

}
