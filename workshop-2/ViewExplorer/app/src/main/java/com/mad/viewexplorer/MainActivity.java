package com.mad.viewexplorer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.choose_view, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		Class<?> activityClass = getActivityClassByMenuId(id);
		if (activityClass != null) {
			startActivity(new Intent(this, activityClass));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private Class<? extends AppCompatActivity> getActivityClassByMenuId(int itemId) {
		switch (itemId) {
			case R.id.relative:
				return RelativeViewActivity.class;
			case R.id.frame:
				return FrameViewActivity.class;
			case R.id.constraint:
				return ConstraintViewActivity.class;
			default:
				return null;
		}
	}
}
