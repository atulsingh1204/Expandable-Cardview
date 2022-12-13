package com.atul.expandablecardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout expandableView;
    Button btn_downArrow;
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableView = findViewById(R.id.expandableView);
        btn_downArrow = findViewById(R.id.btn_downArrow);
        cardView = findViewById(R.id.cardView);

        btn_downArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expandableView.getVisibility() == view.GONE) {

                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView.setVisibility(View.VISIBLE);
                    btn_downArrow.setBackgroundResource(R.drawable.ic_arrow_up);

                } else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView.setVisibility(View.GONE);
                    btn_downArrow.setBackgroundResource(R.drawable.ic_arrow_down);
                }
            }
        });
    }
}