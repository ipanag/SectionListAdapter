package com.periplanisi.sectionadapterexampleapp.data;

import java.util.ArrayList;
import java.util.List;

import com.periplanisi.library.ui.adapter.AdapterSection;

public abstract class GroupListItems<S, T> {

	public List<T> items;
	
	abstract protected S getGroupIdentifier(T item);
	abstract protected boolean isSameGroup(T item1, T item2);
	
	public List<AdapterSection<S, T>> getAdapterSectionList() {
		if(items == null) {
			return null;
		}
		
		final List<AdapterSection<S, T>> sections = new ArrayList<AdapterSection<S, T>>();
		
		T previousItem = null;
		S group = null;
		List<T> groupItems = null;
		boolean sameGroup;
		
		int size = items.size();
		int i = 0;
		for(T item : items) {
			sameGroup = isSameGroup(item, previousItem);
			
			if(!sameGroup) {
				if(i != 0) {
					// add previous section
					AdapterSection<S, T> section = new AdapterSection<S, T>(group, groupItems);
					sections.add(section);
				}
				
				// start a new section
				group = getGroupIdentifier(item);
				groupItems = new ArrayList<T>();
			}
			
			// add item to section
			groupItems.add(item);
			
			if(i == size - 1) {
				// add last section
				AdapterSection<S, T> section = new AdapterSection<S, T>(group, groupItems);
				sections.add(section);
			}
			
			previousItem = item;
			i++;
		}
		
		return sections;
	}
	
}
