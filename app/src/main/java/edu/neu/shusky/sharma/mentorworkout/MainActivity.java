package edu.neu.shusky.sharma.mentorworkout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import static android.R.attr.button;
import static android.R.attr.id;
import static edu.neu.shusky.sharma.mentorworkout.R.id.button3;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void buttonClickFunction(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivityExercises.class);
        startActivity(intent);
    }
    public void buttonClickHelp(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivityHelp.class);
        startActivity(intent);
    }

    public void buttonClickStopWatch(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivityStopwatch.class);
        startActivity(intent);
    }
}
