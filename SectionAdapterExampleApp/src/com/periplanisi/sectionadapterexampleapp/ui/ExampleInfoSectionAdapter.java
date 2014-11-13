package com.periplanisi.sectionadapterexampleapp.ui;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.periplanisi.library.ui.adapter.AbstractSectionItemListAdapter;
import com.periplanisi.library.ui.adapter.AdapterSection;
import com.periplanisi.sectionadapterexampleapp.R;
import com.periplanisi.sectionadapterexampleapp.data.ExampleSection;
import com.periplanisi.sectionadapterexampleapp.data.ExampleItem;

public class ExampleInfoSectionAdapter extends AbstractSectionItemListAdapter<ExampleSection, ExampleItem> {

	public ExampleInfoSectionAdapter() {
		super();
	}

	public ExampleInfoSectionAdapter(final List<AdapterSection<ExampleSection, ExampleItem>> sections) {
		super(sections);
	}

	@Override
	protected View getSectorView(final int position, View convertView, final ViewGroup parent, final ExampleSection sectorTitle) {
		final Context context = parent.getContext();

		final SectorViewholder holder;

		if (convertView == null) {
			holder = new SectorViewholder();

			convertView = LayoutInflater.from(context).inflate(R.layout.list_section_row, parent, false);
			holder.textView = (TextView) convertView.findViewById(R.id.sector_title);

			convertView.setTag(holder);
		} else {
			holder = (SectorViewholder) convertView.getTag();
		}

		holder.textView.setText(sectorTitle.getName());

		return convertView;
	}

	@Override
	protected View getItemView(final int position, View convertView, final ViewGroup parent, final ExampleItem item) {
		final Context context = parent.getContext();

		final ItemViewholder holder;

		if (convertView == null) {
			holder = new ItemViewholder();

			convertView = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.list_item_row, parent, false);
			holder.textView = (TextView) convertView.findViewById(R.id.item_text);
			holder.imageView = (ImageView) convertView.findViewById(R.id.item_image);

			convertView.setTag(holder);
		} else {
			holder = (ItemViewholder) convertView.getTag();
		}

		holder.textView.setText(item.getName());
		holder.imageView.setImageResource(R.drawable.ic_launcher); // TODO get image

		return convertView;
	}

	private class ItemViewholder {
		public ImageView imageView;
		public TextView textView;
	}

	private class SectorViewholder {
		public TextView textView;
	}

}
