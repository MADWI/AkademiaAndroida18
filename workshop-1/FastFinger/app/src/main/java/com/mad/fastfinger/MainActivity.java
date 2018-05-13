package com.mad.fastfinger;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Board board = new Board();
		board.init(findViewById(R.id.boardPlayer1), findViewById(R.id.boardPlayer2));
	}

	private boolean isInPortraitOrientation() {
		return getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
	}
}
