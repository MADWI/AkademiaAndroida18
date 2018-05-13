package com.mad.fastfinger;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Board {

	private final Player player1 = new Player();
	private final Player player2 = new Player();

	public void init(@NonNull View boardViewPlayer1, @NonNull View boardViewPlayer2) {
		initPointsView(boardViewPlayer1, player1);
		initPointsView(boardViewPlayer2, player2);
	}

	private void initPointsView(@NonNull View playerBoardView, @NonNull final Player player) {
		final TextView pointsView = playerBoardView.findViewById(R.id.pointsView);
		Button pointsButton = playerBoardView.findViewById(R.id.pointButton);
		pointsButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				player.addPoint();
				String pointsText = String.valueOf(player.getPoints());
				pointsView.setText(pointsText);
			}
		});
	}
}
