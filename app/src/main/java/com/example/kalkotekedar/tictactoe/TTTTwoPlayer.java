package com.example.kalkotekedar.tictactoe;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TTTTwoPlayer extends AppCompatActivity implements View.OnClickListener {

    Context context = this;
    TextView player1, player2;
    int value[][];
    Button b[][];
    int k = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttttwo_player);

        setBoard();
        initViews();
    }

    private void initViews() {
        player1 = (TextView) findViewById(R.id.tv_player1);
        player2 = (TextView) findViewById(R.id.tv_mobile);

        b[0][0] = (Button) findViewById(R.id.bt_00);
        b[0][1] = (Button) findViewById(R.id.bt_01);
        b[0][2] = (Button) findViewById(R.id.bt_02);

        b[1][0] = (Button) findViewById(R.id.bt_10);
        b[1][1] = (Button) findViewById(R.id.bt_11);
        b[1][2] = (Button) findViewById(R.id.bt_12);

        b[2][0] = (Button) findViewById(R.id.bt_20);
        b[2][1] = (Button) findViewById(R.id.bt_21);
        b[2][2] = (Button) findViewById(R.id.bt_22);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                b[i][j].setOnClickListener(this);
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (k % 2 == 0) {
            Toast.makeText(TTTTwoPlayer.this, "Player 2's Turn", Toast.LENGTH_SHORT).show();
            player2.setTextColor(getResources().getColor(R.color.colorAccent));
            player1.setTextColor(getResources().getColor(R.color.black));
        } else {
            Toast.makeText(TTTTwoPlayer.this, "Player 1's Turn", Toast.LENGTH_SHORT).show();
            player1.setTextColor(getResources().getColor(R.color.colorAccent));
            player2.setTextColor(getResources().getColor(R.color.black));
        }
        k++;
        switch (v.getId()) {
            case R.id.bt_00:
                markOnBoard(0, 0, k);
                break;
            case R.id.bt_01:
                markOnBoard(0, 1, k);
                break;
            case R.id.bt_02:
                markOnBoard(0, 2, k);
                break;

            case R.id.bt_10:
                markOnBoard(1, 0, k);
                break;
            case R.id.bt_11:
                markOnBoard(1, 1, k);
                break;
            case R.id.bt_12:
                markOnBoard(1, 2, k);
                break;

            case R.id.bt_20:
                markOnBoard(2, 0, k);
                break;
            case R.id.bt_21:
                markOnBoard(2, 1, k);
                break;
            case R.id.bt_22:
                markOnBoard(2, 2, k);
                break;
        }
        checkTheGameStatus();
    }

    /**
     * This is to start the game with new empty values
     */
    private void setBoard() {
        k = 0;
        b = new Button[3][3];
        value = new int[3][3];
    }

    /**
     * This is to check the game status who won or the tie the game
     *
     * @return true or false
     */
    public boolean checkTheGameStatus() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((value[0][0] == 1 && value[1][0] == 1 && value[2][0] == 1)
                        || (value[0][1] == 1 && value[1][1] == 1 && value[2][1] == 1)
                        || (value[0][2] == 1 && value[1][2] == 1 && value[2][2] == 1)
                        || (value[0][0] == 1 && value[0][1] == 1 && value[0][2] == 1)
                        || (value[1][0] == 1 && value[1][1] == 1 && value[1][2] == 1)
                        || (value[2][0] == 1 && value[2][1] == 1 && value[2][2] == 1)
                        || (value[0][0] == 1 && value[1][1] == 1 && value[2][2] == 1)
                        || (value[0][2] == 1 && value[1][1] == 1 && value[2][0] == 1)) {
                    showDialogBox("Player 1 won the game");
                    return true;
                } else if ((value[0][0] == 2 && value[1][0] == 2 && value[2][0] == 2)
                        || (value[0][1] == 2 && value[1][1] == 2 && value[2][1] == 2)
                        || (value[0][0] == 2 && value[0][1] == 2 && value[0][2] == 2)
                        || (value[1][0] == 2 && value[1][1] == 2 && value[1][2] == 2)
                        || (value[2][0] == 2 && value[2][1] == 2 && value[2][2] == 2)
                        || (value[0][2] == 2 && value[1][2] == 2 && value[2][2] == 2)
                        || (value[0][0] == 2 && value[1][1] == 2 && value[2][2] == 2)
                        || (value[0][2] == 2 && value[1][1] == 2 && value[2][0] == 2)) {
                    showDialogBox("Player 2 won the game");
                    return true;
                }
            }
            if (k == 9) {
                showDialogBox("Sorry no one won the Game");
            }
        }
        return false;
    }

    /**
     * this is to mark the player position on the board
     *
     * @param i
     * @param j
     * @param k
     */
    private void markOnBoard(int i, int j, int k) {
        b[i][j].setEnabled(false);
        if (k % 2 == 0) {
            b[i][j].setText("X");
            player1.setTextColor(getResources().getColor(R.color.colorAccent));
        } else if (k % 2 == 1) {
            b[i][j].setText("O");
            player1.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        value[i][j] = (k % 2) + 1;
    }

    /**
     * To disable all the cards when the game is done
     */
    private void disableBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                b[i][j].setEnabled(false);
            }
        }
    }


    /**
     * This is to show to dialog box with the custom message
     *
     * @param msg
     */
    private void showDialogBox(String msg) {
        disableBoard();
        new AlertDialog.Builder(context)
                .setMessage(msg)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                })
                .show();
    }
}