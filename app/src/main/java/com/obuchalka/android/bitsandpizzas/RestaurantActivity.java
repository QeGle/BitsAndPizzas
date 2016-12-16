package com.obuchalka.android.bitsandpizzas;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RestaurantActivity extends Activity {
	private SQLiteDatabase db;
	private Cursor cursor;
	public static final String EXTRA_RESTAURANTNO = "RestaurantNo";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		int RestaurantNo = (Integer)getIntent().getExtras().get(EXTRA_RESTAURANTNO);
		setContentView(R.layout.activity_restaurant);
		ImageView photo = (ImageView)findViewById(R.id.imageViewRestaurant);
		TextView name = (TextView)findViewById(R.id.textViewRestaurantName);
		TextView description = (TextView)findViewById(R.id.textViewRestaurantDescription);

		try{
			SQLiteOpenHelper bitsandpizzasDatabaseHelper = new BAPDatabaseHelper(this);
			db = bitsandpizzasDatabaseHelper.getReadableDatabase();
			cursor = db.query("RESTAURANT", new String[]{"NAME","DESCRIPTION","IMAGE_RESOURCE_ID"},
					"_id = ?",
					new String[]{Integer.toString(RestaurantNo)},
					null,null,null);
			if (cursor.moveToFirst()){
				String nameText = cursor.getString(0);
				String descriptionText = cursor.getString(1);
				int photoId = cursor.getInt(2);
				name.setText(nameText);
				description.setText(descriptionText);
				photo.setImageResource(photoId);
				photo.setContentDescription(descriptionText);
			}

		}catch (SQLiteException e){
			Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		cursor.close();
		db.close();
	}
}
