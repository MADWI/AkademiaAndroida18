package com.mad.fastfinger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	private static final String SCORE_KEY = "SCORE_KEY";
	private int score;
	private Button scoreButton;
	private TextView scoreTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init(savedInstanceState);
	}

	private void init(Bundle savedInstanceState) {
		readScoreFromSavedState(savedInstanceState);
		initViews();
		setupScoreButton();
	}

	private void readScoreFromSavedState(Bundle savedInstanceState) {
		if (savedInstanceState != null) {
			score = savedInstanceState.getInt(SCORE_KEY);
		}
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

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(SCORE_KEY, score);
	}
}
