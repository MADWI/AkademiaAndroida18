package com.mad.fastfinger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	private Player player1 = new Player();
	private Player player2 = new Player();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	private void init() {
		player1.init(findViewById(R.id.boardPlayer1));
		player2.init(findViewById(R.id.boardPlayer2));
	}
}
