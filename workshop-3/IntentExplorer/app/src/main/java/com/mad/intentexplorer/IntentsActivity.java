package com.mad.intentexplorer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class IntentsActivity extends AppCompatActivity implements View.OnClickListener {

	private Button browserButton;
	private Button cameraButton;
	private Button callButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intents);
		init();
	}

	private void init() {
		browserButton = findViewById(R.id.browser_button);
		browserButton.setOnClickListener(this);
		cameraButton = findViewById(R.id.camera_button);
		cameraButton.setOnClickListener(this);
		callButton = findViewById(R.id.call_button);
		callButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = getIntentByViewId(v.getId());
		if (intent != null && intent.resolveActivity(getPackageManager()) != null) {
			startActivity(intent);
		}
	}

	private Intent getIntentByViewId(int id) {
		switch (id) {
			case R.id.browser_button:
				return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.wi.zut.edu.pl"));
			case R.id.camera_button:
				return new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			case R.id.call_button:
				return new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "000000", null));
		}
		return null;
	}
}
