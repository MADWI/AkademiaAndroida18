package com.mad.fastfinger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	private int score;
	private Button scoreButton;
	private TextView scoreTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	private void init() {
		initViews();
		setupScoreButton();
	}

	private void initViews() {
		scoreButton = findViewById(R.id.scoreButton);
		scoreTextView = findViewById(R.id.scoreTextView);
	}

	private void setupScoreButton() {
		setCurrentScoreToTextView();
		scoreButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				score++;
				setCurrentScoreToTextView();
			}
		});
	}

	private void setCurrentScoreToTextView() {
		String currentScoreText = String.valueOf(score);
		scoreTextView.setText(currentScoreText);
	}
}
