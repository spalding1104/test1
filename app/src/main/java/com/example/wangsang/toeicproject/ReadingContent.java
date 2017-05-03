package com.example.wangsang.toeicproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ReadingContent extends AppCompatActivity {

    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;
    private int position = 0;
    final String DATABASE_NAME ="dbtoeic.db";
    SQLiteDatabase db;
    Cursor cursor;
    private int mScore = 0;
    private String mAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reading_content);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // support action bar (back button)

        //Get the Views reference using the R constant
        mQuestionView = (TextView) findViewById(R.id.txvQuestion);
        mButtonChoice1= (Button) findViewById(R.id.btnChoice1);
        mButtonChoice2= (Button) findViewById(R.id.btnChoice2);
        mButtonChoice3= (Button) findViewById(R.id.btnChoice3);
        mButtonChoice4= (Button) findViewById(R.id.btnChoice4);

        db = Database.initDatabase(this, DATABASE_NAME);

        updateQuestion(); // load question and answers at the first time

        //set event on click, button 1
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mButtonChoice1.getText().toString().equals(mAnswer)){
                    Toast.makeText(ReadingContent.this,"correct",Toast.LENGTH_SHORT).show();
                    mScore++;
                    intentResult();
                } else {
                    Toast.makeText(ReadingContent.this,"wrong",Toast.LENGTH_SHORT).show();
                    intentResult();
                }
            }
        });

        //set event on click, button 2
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mButtonChoice2.getText().toString().equals(mAnswer)){
                    Toast.makeText(ReadingContent.this,"correct",Toast.LENGTH_SHORT).show();
                    mScore++;
                    intentResult();
                } else {
                    Toast.makeText(ReadingContent.this,"wrong",Toast.LENGTH_SHORT).show();
                    intentResult();
                }
            }
        });

        //set event on click, button 3
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mButtonChoice3.getText().toString().equals(mAnswer)){
                    Toast.makeText(ReadingContent.this,"correct",Toast.LENGTH_SHORT).show();
                    mScore++;
                    intentResult();
                } else {
                    Toast.makeText(ReadingContent.this,"wrong",Toast.LENGTH_SHORT).show();
                    intentResult();
                }
            }
        });

        //set event on click, button 4
        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mButtonChoice4.getText().toString().equals(mAnswer)){
                    Toast.makeText(ReadingContent.this,"correct",Toast.LENGTH_LONG).show();
                    mScore++;
                    intentResult();
                } else {
                    Toast.makeText(ReadingContent.this,mButtonChoice4.getText() + cursor.getString(5),Toast.LENGTH_LONG).show();
                    intentResult();
                }
            }
        });
    }

    public void updateQuestion(){

        //update question after each click and first load
        cursor = db.rawQuery("SELECT * FROM reading", null);
        cursor.moveToPosition(position);
        mQuestionView.setText(cursor.getString(0));
        mButtonChoice1.setText(cursor.getString(1));
        mButtonChoice2.setText(cursor.getString(2));
        mButtonChoice3.setText(cursor.getString(3));
        mButtonChoice4.setText(cursor.getString(4));
        mAnswer = cursor.getString(5).trim();
        position++;
    }

    public void intentResult(){

        //go to another class if ít's out of questions
        if(cursor.isLast()){
            Intent intent = new Intent(ReadingContent.this, Result.class);
            Bundle bundle = new Bundle();
            bundle.putInt("mykey", mScore);
            intent.putExtras(bundle);
            ReadingContent.this.finish();
            startActivity(intent);
        }else {updateQuestion();}
    }

    //back to previous event (class)
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
