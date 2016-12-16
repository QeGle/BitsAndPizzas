package com.obuchalka.android.bitsandpizzas;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RestaurantFragment extends ListFragment {
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Intent intent = new Intent(RestaurantFragment.this.getActivity(), RestaurantActivity.class);
		intent.putExtra(RestaurantActivity.EXTRA_RESTAURANTNO,position+1);
		startActivity(intent);
	}

	public RestaurantFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		ArrayAdapter<String> adapter = new ArrayAdapter<>(
				inflater.getContext(),
				android.R.layout.simple_list_item_1,
				getResources().getStringArray(R.array.restaurants));
		setListAdapter(adapter);
		return super.onCreateView(inflater, container, savedInstanceState);
	}
}