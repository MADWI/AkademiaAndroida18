package com.mad.intentexplorer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	public static final String MESSAGE_KEY = "message_key";
	private TextInputEditText messageInputView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initViews();
	}

	private void initViews() {
		messageInputView = findViewById(R.id.message_input_view);
		Button sendButton = findViewById(R.id.send_button);
		sendButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(this, DetailsActivity.class);
		String message = messageInputView.getText().toString();
		intent.putExtra(MESSAGE_KEY, message);
		startActivity(intent);

	}
}
