package com.periplanisi.sectionadapterexampleapp.ui;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.periplanisi.sectionadapterexampleapp.R;
import com.periplanisi.sectionadapterexampleapp.data.ExampleItem;
import com.periplanisi.sectionadapterexampleapp.data.ExampleItemsList;

public class ExampleActivity extends Activity {

	public static Intent getStartIntent(final Context context) {
		final Intent intent = new Intent(context, ExampleActivity.class);
		return intent;
	}

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_list);

		final ListView listView = (ListView) findViewById(R.id.list_countries);
		
		ExampleItemsList list = createMockData();
		
		final ExampleInfoSectionAdapter adapter = new ExampleInfoSectionAdapter(list.getAdapterSectionList());
		listView.setAdapter(adapter);
	}

	private static ExampleItemsList createMockData() {
		final List<ExampleItem> allCountries = new ArrayList<ExampleItem>();
		allCountries.add(new ExampleItem("01", 1415644156000L));
		allCountries.add(new ExampleItem("02", 1415622556000L));
		allCountries.add(new ExampleItem("03", 1415622556100L));
		allCountries.add(new ExampleItem("04", 1415622556200L));
		allCountries.add(new ExampleItem("05", 1415622556300L));
		allCountries.add(new ExampleItem("06", 1415622556400L));
		allCountries.add(new ExampleItem("07", 1415622556500L));
		allCountries.add(new ExampleItem("08", 1415622556600L));
		allCountries.add(new ExampleItem("10", 1415536156000L));
		allCountries.add(new ExampleItem("11", 1415557756100L));
		allCountries.add(new ExampleItem("12", 1415557756200L));
		allCountries.add(new ExampleItem("13", 1415536156100L));
		allCountries.add(new ExampleItem("14", 1415536156200L));
		allCountries.add(new ExampleItem("21", 1415471356000L));
		allCountries.add(new ExampleItem("22", 1415471356000L));
		allCountries.add(new ExampleItem("23", 1415471356000L));
		allCountries.add(new ExampleItem("24", 1415471356000L));
		allCountries.add(new ExampleItem("25", 1415471356000L));
		
		ExampleItemsList list = new ExampleItemsList();
		list.items = allCountries;
		
		return list;
	}

}
