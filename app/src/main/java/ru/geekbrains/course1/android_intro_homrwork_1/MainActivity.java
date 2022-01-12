package ru.geekbrains.course1.android_intro_homrwork_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText inputNumberEditText;
    private Button buttonGenerate;
    private TextView taskResume;
    private TextView trueResult;
    int x; // загадываемое число
    String xString;
    private String result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();


        buttonGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                x = randomNum(1, 3);
                taskResume.setText(getNum());
                //x = 3;
                xString = Integer.toString(x);
                trueResult.setText("Было задано число " + xString);
            }
        });

    }

    private String getNum() {

        String inputNumberString = inputNumberEditText.getText().toString();
        int inputNumberInt = Integer.parseInt(inputNumberString);

        try {
            //int inputNumberInt = Integer.parseInt(inputNumberString);
            if (inputNumberInt < 1 || inputNumberInt > 3) {
                result = "ошибка ввода данных";
            } else {
                if (inputNumberInt == x)
                    result = "Вы угадали ";
                else result = "Вы не угадали ";
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();

        }
        return result;

    }

    public static int randomNum(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;

    }

    private void setViews() {

        inputNumberEditText = findViewById(R.id.input_number);
        buttonGenerate = findViewById(R.id.button_generate);
        taskResume = findViewById(R.id.task_resume);
        trueResult = findViewById(R.id.true_result);
    }

}