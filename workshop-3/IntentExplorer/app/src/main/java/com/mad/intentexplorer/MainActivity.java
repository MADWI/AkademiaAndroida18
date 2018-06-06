package com.mad.intentexplorer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.Group;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	public static final String MESSAGE_KEY = "message_key";
	public static final String MESSAGE_SENDER_KEY = "message_sender_key";
	private static final String userName = "Bob";
	private static final int REQUEST_CODE = 123;
	private TextInputEditText messageInputView;
	private TextView incomingMessageView;
	private TextView messageSenderView;
	private Group incomingViewsGroup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	private void init() {
		setupBarTitle();
		bindViews();
		hideIncomingViews();
		initSendButton();
	}

	private void setupBarTitle() {
		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null) {
			actionBar.setTitle(userName);
		}
	}

	private void bindViews() {
		messageSenderView = findViewById(R.id.message_sender);
		incomingMessageView = findViewById(R.id.incoming_message);
		incomingViewsGroup = findViewById(R.id.incoming_group);
		messageInputView = findViewById(R.id.message_input);
	}

	private void hideIncomingViews() {
		incomingViewsGroup.setVisibility(View.GONE);
	}

	private void showIncomingViews() {
		incomingViewsGroup.setVisibility(View.VISIBLE);
	}

	private void initSendButton() {
		Button sendButton = findViewById(R.id.send_button);
		sendButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = getIntentWithMessageData();
		startActivityForResult(intent, REQUEST_CODE);
		messageInputView.getText().clear();
	}

	@NonNull
	private Intent getIntentWithMessageData() {
		Intent intent = new Intent(this, DetailsActivity.class);
		String message = messageInputView.getText().toString();
		intent.putExtra(MESSAGE_KEY, message);
		intent.putExtra(MESSAGE_SENDER_KEY, userName);
		return intent;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
			setupIncomingViewsFromIntent(data);
			showIncomingViews();
		}
	}

	private void setupIncomingViewsFromIntent(Intent data) {
		String message = data.getStringExtra(MESSAGE_KEY);
		String messageSenderLabel = getMessageSenderLabelFromIntent(data);
		messageSenderView.setText(messageSenderLabel);
		incomingMessageView.setText(message);
	}

	@NonNull
	private String getMessageSenderLabelFromIntent(Intent data) {
		String messageSender = data.getStringExtra(MESSAGE_SENDER_KEY);
		return getString(R.string.message_sender_format, messageSender);
	}
}
