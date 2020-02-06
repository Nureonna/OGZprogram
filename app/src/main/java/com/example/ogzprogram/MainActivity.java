package com.example.ogzprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Calculation calculation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculation = new Calculation();
        clickButton();
    }

    public void clickButton() {
        Button button = this.findViewById(R.id.btn_calculate);
        final EditText xOP = findViewById(R.id.et_x_op);
        final EditText yOP = findViewById(R.id.et_y_op);
        final EditText xTar = findViewById(R.id.et_x_tar);
        final EditText yTar = findViewById(R.id.et_y_tar);
        final TextView angle = findViewById(R.id.tv_angle);
        final TextView distance = findViewById(R.id.tv_range);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float angleValue = calculation.calculateAngle(Float.valueOf(xOP.getText().toString()),
                        Float.valueOf(yOP.getText().toString()),
                        Float.valueOf(xTar.getText().toString()),
                        Float.valueOf(yTar.getText().toString()));

                angle.setText(String.valueOf(angleValue));

                float distValue = calculation.calculateDistance(Float.valueOf(xOP.getText().toString()),
                        Float.valueOf(yOP.getText().toString()),
                        Float.valueOf(xTar.getText().toString()),
                        Float.valueOf(yTar.getText().toString()));

                distance.setText(String.valueOf(distValue));
            }
        };
        button.setOnClickListener(listener);
    }
}
