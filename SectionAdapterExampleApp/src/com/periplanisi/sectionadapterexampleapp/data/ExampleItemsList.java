package com.periplanisi.sectionadapterexampleapp.data;

import java.util.Calendar;


public class ExampleItemsList extends GroupListItems<ExampleSection, ExampleItem> {

	@Override
	protected ExampleSection getGroupIdentifier(ExampleItem item) {
		if(item == null) {
			return null;
		} else {
			return new ExampleSection(item.timestamp);
		}
	}

	@Override
	protected boolean isSameGroup(ExampleItem item1, ExampleItem item2) {
		if(item1 == null) {
			if(item2 == null) {
				return true;
			} else {
				return false;
			}
		} else if(item2 == null) {
			return false;
		}
		
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTimeInMillis(item1.timestamp);
		cal2.setTimeInMillis(item2.timestamp);
		boolean sameDay = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
		                  cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
		
	    return sameDay;
	}

}
