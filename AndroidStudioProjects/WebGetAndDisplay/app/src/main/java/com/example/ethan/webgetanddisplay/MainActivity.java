package com.example.ethan.webgetanddisplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText ET = (EditText) findViewById(R.id.input);
        Button B1 = (Button) findViewById(R.id.button);
        final TextView response = (TextView) findViewById(R.id.response);

        B1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(ET.getText().toString().equals("INTC")){
                    Intent newActivity = new Intent(MainActivity.this, Fetch.class);
                    newActivity.putExtra("symbol", ET.getText().toString());
                    startActivity(newActivity);
                }
                else if(ET.getText().toString().equals("MSFT")){
                    Intent newActivity = new Intent(MainActivity.this, Fetch.class);
                    newActivity.putExtra("symbol", ET.getText().toString());
                    startActivity(newActivity);
                }
                else{
                    response.setText("Not a valid symbol.");
                }
            } });
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
