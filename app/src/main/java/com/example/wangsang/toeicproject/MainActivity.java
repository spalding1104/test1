package com.example.wangsang.toeicproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnRe;
    private Button btnLis;
    private Button btnVol;
    private Button btnGr;
    //DatabaseOpenHelper myDb;
    final String DATABASE_NAME ="dbtoeic.db";
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRe = (Button) findViewById(R.id.btnReading);
        btnLis = (Button) findViewById(R.id.btnListening);
        btnVol = (Button) findViewById(R.id.btnVolcabulary);
        btnGr = (Button) findViewById(R.id.btnGrammar);

        //myDb = new DatabaseOpenHelper(this);
        database = Database.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM reading", null);
        cursor.moveToNext();
        Toast.makeText(this,cursor.getString(0), Toast.LENGTH_LONG).show();

        btnRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ReadingTest.class));
            }
        });

        btnLis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListeningTest.class));
            }
        });
    }
}


