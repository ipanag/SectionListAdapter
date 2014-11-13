package com.periplanisi.sectionadapterexampleapp.data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ExampleSection {

	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.UK);
	
	public final long timestamp;

	public ExampleSection(final long timestamp) {
		super();
		this.timestamp = timestamp;
	}

	public String getName() {
		return formatter.format(new Date(timestamp));
	}

}
