package com.example.myapplication01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.MessageFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView text_name, text_age, text_personality, text_live, text_hobby;
    private Button button_insert;
    private EditText edittext_name;
    private CardView card_info, card_reset;
    private RelativeLayout relative_input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assigning id to variable....
        text_name = findViewById(R.id.text_name);
        text_age = findViewById(R.id.text_age);
        text_personality = findViewById(R.id.text_personality);
        text_live = findViewById(R.id.text_live);
        text_hobby = findViewById(R.id.text_hobby);

        button_insert = findViewById(R.id.button_insert);

        edittext_name = findViewById(R.id.edittext_name);

        card_info = findViewById(R.id.card_info);

        card_reset = findViewById(R.id.card_reset);

        relative_input = findViewById(R.id.relative_input);

        setVisibilityToGone();
        button_insert.setOnClickListener(this);
        card_reset.setOnClickListener(this);

    }


    private void setVisibilityToGone() {
        text_name.setVisibility(View.GONE);
        text_age.setVisibility(View.GONE);
        text_personality.setVisibility(View.GONE);
        text_live.setVisibility(View.GONE);
        text_hobby.setVisibility(View.GONE);
        card_info.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View view) {
        if ( view == button_insert){
            if(edittext_name.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(), "field can not be empty", Toast.LENGTH_SHORT).show();
                return;
            }

            card_info.setVisibility(view.VISIBLE);
            if (text_name.getVisibility() == View.GONE){
                edittext_name.setHint("Enter your age");
                text_name.setText(MessageFormat.format("My Name Is {0}", edittext_name.getText().toString()));
                edittext_name.setText("");
                text_name.setVisibility(view.VISIBLE);
                edittext_name.setInputType(InputType.TYPE_CLASS_NUMBER);
                return;
            }
            if (text_age.getVisibility() == View.GONE){
                edittext_name.setHint("Enter your personality");
                text_age.setText(MessageFormat.format("I am {0} years old", edittext_name.getText().toString()));
                edittext_name.setText("");
                text_age.setVisibility(view.VISIBLE);
                edittext_name.setInputType(InputType.TYPE_CLASS_TEXT);
                return;
            }
            if (text_personality.getVisibility() == View.GONE){
                edittext_name.setHint("Enter your live");
                text_personality.setText(MessageFormat.format("I am very {0}", edittext_name.getText().toString()));
                edittext_name.setText("");
                text_personality.setVisibility(view.VISIBLE);
                edittext_name.setInputType(InputType.TYPE_CLASS_TEXT);
                return;
            }
            if (text_live.getVisibility() == View.GONE){
                edittext_name.setHint("Enter your hobby");
                text_live.setText(MessageFormat.format("I live in {0}", edittext_name.getText().toString()));
                edittext_name.setText("");
                text_live.setVisibility(view.VISIBLE);
                edittext_name.setInputType(InputType.TYPE_CLASS_TEXT);
                return;
            }
            if (text_hobby.getVisibility() == View.GONE){
                text_hobby.setText(MessageFormat.format("I love {0}", edittext_name.getText().toString()));
                edittext_name.setText("");
                text_hobby.setVisibility(view.VISIBLE);
                edittext_name.setInputType(InputType.TYPE_CLASS_TEXT);
                relative_input.setVisibility(View.GONE);
                card_reset.setVisibility(View.VISIBLE);
                relative_input.setVisibility(View.VISIBLE);
            }
        }
        if (view == card_reset){
            setVisibilityToGone();
            edittext_name.setHint("Enter  your name...");
            edittext_name.setInputType(InputType.TYPE_CLASS_TEXT);
            card_reset.setVisibility(View.GONE);
        }
    }
}