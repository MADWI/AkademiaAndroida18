package com.mad.intentexplorer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);
		init();
	}

	private void init() {
		String message = getMessageFromIntent();
		TextView messageView = findViewById(R.id.message_view);
		messageView.setText(message);
	}

	private String getMessageFromIntent() {
		Intent intent = getIntent();
		if (intent == null) {
			return null;
		}
		return intent.getStringExtra(MainActivity.MESSAGE_KEY);
	}
}
