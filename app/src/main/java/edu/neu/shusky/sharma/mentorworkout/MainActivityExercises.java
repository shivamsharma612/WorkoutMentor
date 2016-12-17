package edu.neu.shusky.sharma.mentorworkout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivityExercises extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_exercises);
    }

    public void buttonClickFunction(View v){
        Intent intent = new Intent(getApplicationContext(), chest.class);
        startActivity(intent);
    }

    public void buttonClickFunction2(View v){
        Intent intent = new Intent(getApplicationContext(), arms.class);
        startActivity(intent);
    }

    public void buttonClickFunction3(View v){
        Intent intent = new Intent(getApplicationContext(), legs.class);
        startActivity(intent);
    }

    public void buttonClickFunction4(View v){
        Intent intent = new Intent(getApplicationContext(), back.class);
        startActivity(intent);
    }

    public void buttonClickFunction5(View v){
        Intent intent = new Intent(getApplicationContext(), abs.class);
        startActivity(intent);
    }

    public void buttonClickFunction6(View v){
        Intent intent = new Intent(getApplicationContext(), shoulders.class);
        startActivity(intent);
    }
}
