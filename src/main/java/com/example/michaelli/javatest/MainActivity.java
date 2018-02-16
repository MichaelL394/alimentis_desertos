package com.example.michaelli.javatest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int cawfe = 0;
    public static final String EXTRA_MESSAGE = "com.example.michaelli.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void next(View view) {
        Intent intent = new Intent(this, GridActivity.class);
        EditText editText = (EditText) findViewById(R.id.fillIn);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    //go to grid view
    public void doit2(View view) {
        Intent intent = new Intent(this, GridActivity.class);
        startActivity(intent);
    }

    public void submitOrder(View view) {
        display(cawfe);
        price(cawfe * 5);

    }

    void clear(View view) {

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    public void plus(View view) {
        cawfe++;
        display(cawfe);
        price(cawfe * 5);
    }

    public void minus(View view) {
        cawfe--;
        display(cawfe);
        price(cawfe * 5);
    }

    private void display(int number) {
        TextView doit = (TextView) findViewById(R.id.doit);
        doit.setText(String.format("cawfes %d", number));
    }

    private void price(int number) {
        TextView yes = (TextView) findViewById(R.id.yes);
        yes.setText(String.format("$%d", number));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
