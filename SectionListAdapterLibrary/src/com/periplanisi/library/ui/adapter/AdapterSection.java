package com.periplanisi.library.ui.adapter;

import java.util.List;

/**
 * Object to facilitate grouping items in sections for ListAdapter
 * 
 * @author Ioannis
 * 
 * @param <S>
 *            class for section title (ie simplest form could be a String)
 * @param <I>
 *            class for section item (the actual item for the ListAdapter)
 */
public class AdapterSection<S, I> {

	private final S sectorTitle;
	private final List<I> items;

	public AdapterSection(final S sectorTitle, final List<I> items) {
		super();
		this.sectorTitle = sectorTitle;
		this.items = items;
	}

	/**
	 * Get sector title
	 * 
	 * @return
	 */
	public S getSectorTitle() {
		return sectorTitle;
	}

	/**
	 * Get list of items in this section
	 * 
	 * @return
	 */
	public List<I> getItems() {
		return items;
	}

}
