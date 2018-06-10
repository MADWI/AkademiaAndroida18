package com.mad.intentexplorer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MessageReceiverActivity extends AppCompatActivity implements View.OnClickListener {

	private static final String userName = "Alice";
	private TextView messageSenderView;
	private TextInputEditText messageInputView;
	private TextView incomingMessageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message_receiver);
		init();
	}

	private void init() {
		setupBarTitle();
		initViews();
		initSendButton();
		setupIncomingViews();
	}

	private void setupBarTitle() {
		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null) {
			actionBar.setTitle(userName);
		}
	}

	private void initViews() {
		messageInputView = findViewById(R.id.message_input);
		messageSenderView = findViewById(R.id.message_sender);
		incomingMessageView = findViewById(R.id.incoming_message);
	}

	private void initSendButton() {
		Button sendButton = findViewById(R.id.send_button);
		sendButton.setOnClickListener(this);
	}

	private void setupIncomingViews() {
		Intent intent = getIntent();
		if (intent == null) {
			return;
		}
		String message = intent.getStringExtra(MainActivity.MESSAGE_KEY);
		incomingMessageView.setText(message);
		String messageSenderLabel = getMessageSenderLabelFromIntent(intent);
		messageSenderView.setText(messageSenderLabel);
	}

	@NonNull
	private String getMessageSenderLabelFromIntent(@NonNull Intent intent) {
		String messageSender = intent.getStringExtra(MainActivity.MESSAGE_SENDER_KEY);
		return getString(R.string.message_sender_format, messageSender);
	}

	@Override
	public void onClick(View v) {
		finish();
	}

	@Override
	public void finish() {
		Intent intent = getResultIntent();
		setResult(RESULT_OK, intent);
		super.finish();
	}

	@NonNull
	private Intent getResultIntent() {
		String message = messageInputView.getText().toString();
		Intent intent = new Intent();
		intent.putExtra(MainActivity.MESSAGE_KEY, message);
		intent.putExtra(MainActivity.MESSAGE_SENDER_KEY, userName);
		return intent;
	}
}
