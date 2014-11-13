package com.periplanisi.library.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Abstract ListAdapter to handle sections
 * 
 * @author Ioannis
 * 
 * @param <S>
 *            class for section title (ie simplest form could be a String)
 * @param <I>
 *            class for section item (the actual item for the ListAdapter)
 */
public abstract class AbstractSectionItemListAdapter<S, T> extends BaseAdapter {

	private List<AdapterSection<S, T>> sections;
	private List<PositionMap> positionMapping;
	private boolean isLightMode;
	private int count;
	private int sectionCount;

	public AbstractSectionItemListAdapter(final List<AdapterSection<S, T>> sections) {
		this.positionMapping = new ArrayList<PositionMap>();
		setSections(sections);
		this.isLightMode = false;
	}

	public AbstractSectionItemListAdapter() {
		this(new ArrayList<AdapterSection<S, T>>(0));
	}

	/**
	 * Set a new list of sections (with items).<br>
	 * Caller needs to call {@link #notifyDataSetChanged()}
	 * 
	 * @param sections
	 */
	public void setSections(final List<AdapterSection<S, T>> sections) {
		this.sections = sections;

		// calculate new count
		count = 0;
		sectionCount = 0;
		positionMapping.clear();
		for (final AdapterSection<S, T> section : sections) {
			updateForNewSection(section);
		}
	}

	/**
	 * Append a new section (with items) to the existing list.<br>
	 * Caller needs to call {@link #notifyDataSetChanged()}
	 * 
	 * @param section
	 */
	public void addSection(final AdapterSection<S, T> section) {
		this.sections.add(section);
		updateForNewSection(section);
	}

	/**
	 * Optimize list by setting mode to light. This flag should be checked in the implementation of row view getter to
	 * provide a lighter loading.<br>
	 * It internally notifies for changes, when mode is actually changing.<br>
	 * For example while list flings
	 * 
	 * @param isLightMode
	 */
	public void setLightMode(final boolean isLightMode) {
		if (this.isLightMode != isLightMode) {
			this.isLightMode = isLightMode;
			notifyDataSetChanged();
		}
	}

	private void updateForNewSection(final AdapterSection<S, T> section) {
		positionMapping.add(new PositionMap(SectionAdapterRowType.TITLE, sectionCount, -1));

		final int sectionSize = section.getItems().size();
		for (int i = 0; i < sectionSize; i++) {
			positionMapping.add(new PositionMap(SectionAdapterRowType.ITEM, sectionCount, i));
		}

		count += sectionSize + 1;
		sectionCount++;
	}

	@Override
	public int getCount() {
		// precalculate count to avoid unnecessary multiple calculations
		return count;
	}

	@Override
	public Object getItem(final int position) {
		final PositionMap positionMap = positionMapping.get(position);
		final AdapterSection<S, T> section = sections.get(positionMap.getSectionIndex());

		if(positionMap.getRowType() == SectionAdapterRowType.TITLE) {
			return section.getSectorTitle();
		} else {
			return section.getItems().get(positionMap.getItemIndex());
		}
	}

	@Override
	public long getItemId(final int position) {
		return position;
	}

	@Override
	public int getViewTypeCount() {
		return SectionAdapterRowType.values().length;
	}

	@Override
	public int getItemViewType(final int position) {
		final PositionMap positionMap = positionMapping.get(position);

		return positionMap.getRowType().ordinal();
	}

	@Override
	public View getView(final int position, final View convertView, final ViewGroup parent) {
		final PositionMap positionMap = positionMapping.get(position);
		final AdapterSection<S, T> section = sections.get(positionMap.getSectionIndex());

		if (positionMap.getRowType() == SectionAdapterRowType.TITLE) {
			return getSectorView(position, convertView, parent, section.getSectorTitle());
		} else {
			final T item = section.getItems().get(positionMap.getItemIndex());
			return getItemView(position, convertView, parent, item);
		}
	}

	/**
	 * Check if light mode is on and load views accordingly
	 * 
	 * @return
	 */
	protected boolean isLightMode() {
		return isLightMode;
	}

	/**
	 * Get row view for sector title
	 * 
	 * @param position
	 * @param convertView
	 * @param parent
	 * @param sectorTitle
	 * @return
	 */
	protected abstract View getSectorView(final int position, final View convertView, final ViewGroup parent, final S sectorTitle);

	/**
	 * Get row view for sector item
	 * 
	 * @param position
	 * @param convertView
	 * @param parent
	 * @param item
	 * @return
	 */
	protected abstract View getItemView(final int position, final View convertView, final ViewGroup parent, final T item);

}
