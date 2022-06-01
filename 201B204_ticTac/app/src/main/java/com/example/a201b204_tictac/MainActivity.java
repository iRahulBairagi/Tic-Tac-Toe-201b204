package com.example.a201b204_tictac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TintableImageSourceView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean isWinner = false;
    int imageClicked = -1;
    int player =1;
    int [][]winningSates = {{0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}};

    int []gameSate = {-1,-1,-1,-1,-1,-1,-1,-1,-1};

    public void load(View view)
    {

            ImageView v = (ImageView) view;
            int tag = Integer.parseInt(v.getTag().toString());
            imageClicked = gameSate[tag];
            if(isWinner== false && imageClicked==-1) {
            if (player == 1) {
                v.setImageResource(R.drawable.cross);
                gameSate[tag] = player;
                Toast.makeText(this, tag + "" + "Cross", Toast.LENGTH_SHORT).show();
                player = 0;
            } else {
                v.setImageResource(R.drawable.zero);
                gameSate[tag] = player;
                Toast.makeText(this, tag + "" + "Zero", Toast.LENGTH_SHORT).show();
                player = 1;
            }
            for (int i = 0; i < winningSates.length; i++) {
                if (gameSate[winningSates[i][0]] == gameSate[winningSates[i][1]] && gameSate[winningSates[i][1]] == gameSate[winningSates[i][2]] && (gameSate[winningSates[i][0]] > 1)) {
                    Toast.makeText(this, tag + "" + "Winner is" + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                    isWinner= true;

                }
            }
        }
    }

    public void reset(View view){
        androidx.gridlayout.widget.GridLayout gridLayout = findViewById(R.id.gridlayout);
        int total_images=gridLayout.getChildCount();
        for (int i=0; i<total_images;i++){
            ImageView v = (ImageView) gridLayout.getChildAt(i);
            v.setImageDrawable(null);
        }
        isWinner = false;
        imageClicked=-1;
        player=1;
        for (int i=0; i<gameSate.length;i++)
            gameSate[i]=-1;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
