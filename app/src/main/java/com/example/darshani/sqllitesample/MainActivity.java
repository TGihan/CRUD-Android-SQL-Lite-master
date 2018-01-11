package com.example.darshani.sqllitesample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtinput;
    TextView txtshow;
    MyDBHandler dbHandler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtinput = (EditText) findViewById(R.id.txtinput);
        txtshow = (TextView) findViewById(R.id.txtshow);
//        dbHandler = new MyDBHandler(this);

        dbHandler = new MyDBHandler(this,null,null,1);
        txtshow.setText("");

       // printDatabase();



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });




    }

    public void addButtonClicked(View view){
        Products product = new Products(txtinput.getText().toString());
        dbHandler.addProduct(product);
        printDatabase();
    }

    public void deleteButtonClicked(View view){
        String input = txtinput.getText().toString();
        dbHandler.deleteProduct(input);
        printDatabase();
    }


    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        txtshow.setText(dbString);
        txtinput.setText("");
    }


}
