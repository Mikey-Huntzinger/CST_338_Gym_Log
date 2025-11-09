package com.example.hw04_gymlog_v300;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hw04_gymlog_v300.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    String mExercise;
    double mWeight;
    int mReps;

    private static final String TAG = "DAC_GYMLOG";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.logDisplayTextView.setMovementMethod(new ScrollingMovementMethod());
        binding.logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 getInformationFromDisplay();
                 updateDisplay();
            }
        });
    }

    private void updateDisplay(){
        String currentInfo = binding.logDisplayTextView.getText().toString();
        Log.d(TAG,"Current Info"+currentInfo);
        String newDisplay = String.format("Exercise:%s%nWeight:%.2f%nReps:%d%n=-=-=-=%n",mExercise,mWeight,mReps);

        binding.logDisplayTextView.append(newDisplay);
    }

    private void getInformationFromDisplay(){
        mExercise = binding.exerciseInputEditText.getText().toString();

        try {
            mWeight = Double.parseDouble(binding.weightInputEditText.getText().toString());
        }
        catch (NumberFormatException e){
            Log.d(TAG,getString(R.string.could_not_read_weight));
        }



        try {
            mReps = Integer.parseInt(binding.repInputEditText.getText().toString());
        }
        catch( NumberFormatException e ){
            Log.d(TAG,getString(R.string.could_not_read_reps));
        }
    }
}