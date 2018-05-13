package com.mad.fastfinger;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Player {

	private int points;
	private TextView pointsView;

	//TODO consider replacement with constructor
	public void init(@NonNull View playerBoardView) {
		initPointsView(playerBoardView);
		initPointsButton(playerBoardView);
	}

	private void initPointsView(@NonNull View playerBoardView) {
		pointsView = playerBoardView.findViewById(R.id.pointsView);
		setCurrentPointsToView();
	}

	private void initPointsButton(@NonNull View playerBoardView) {
		Button pointsButton = playerBoardView.findViewById(R.id.pointButton);
		pointsButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				points++;
				setCurrentPointsToView();
			}
		});
	}

	private void setCurrentPointsToView() {
		String pointsText = String.valueOf(points);
		pointsView.setText(pointsText);
	}
}
