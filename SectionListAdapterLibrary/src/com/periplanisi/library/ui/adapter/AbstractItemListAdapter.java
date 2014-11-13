package com.periplanisi.library.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import android.widget.BaseAdapter;

@Deprecated
public abstract class AbstractItemListAdapter<T> extends BaseAdapter {

	private List<T> items;
	private boolean isPassive;


	public AbstractItemListAdapter(final List<T> items) {
		this.items = items;
		this.isPassive = false;
	}

	public AbstractItemListAdapter() {
		this(new ArrayList<T>(0));
	}

	public void setItems(final List<T> items) {
		this.items = items;
	}

	public void appendItems(final List<T> items) {
		this.items.addAll(items);
	}

	public void setPassiveMode(final boolean isPassive) {
		if (this.isPassive != isPassive) {
			this.isPassive = isPassive;
			notifyDataSetChanged();
		}
	}

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public T getItem(final int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(final int position) {
		return position;
	}

	protected boolean isPassive() {
		return isPassive;
	}

	protected List<T> getItems() {
		return items;
	}
}
