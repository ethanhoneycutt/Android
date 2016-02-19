package com.example.ethan.webgetanddisplay;

import android.os.Bundle;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Fetch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch);
        new FetchText().execute();
    }

    private class FetchText extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            Bundle extras = getIntent().getExtras();
            System.out.println("Starting retrieval...");
            try {
                URL url = new URL("http://www.utdallas.edu/~John.Cole/2016Spring/" + extras.getString("symbol") + ".txt");

                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                String result = readStream(in);
                urlConnection.disconnect();
                //System.out.println(result);
                return (result);

            }  catch (Exception e) {
                e.printStackTrace();
            }

            return "Something went wrong.";
        }

        @Override
        protected void onPostExecute(String result) {
            final TextView working = (TextView) findViewById(R.id.working);
            working.setText("");

            String[] lines = result.split("\n");
            ArrayList<String> listItems = new ArrayList<String>();
            ArrayAdapter<String> adapter;

            ListView table = (ListView) findViewById(R.id.table);

            for(int i = 0; i < lines.length; i++){
                listItems.add(lines[i].replace(',', ' '));
                //TextView tv = new TextView(getApplicationContext());
                //tv.setText(lines[i].replace(',', ' '))
                //table.addView(tv);
            }

            adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,listItems);
            table.setAdapter(adapter);

        }

        public String readStream(InputStream is) {
            try {
                ByteArrayOutputStream bo = new ByteArrayOutputStream();
                int i = is.read();
                while(i != -1) {
                    bo.write(i);
                    i = is.read();
                }
                return bo.toString();
            } catch (Exception e) {
                return "";
            }
        }

    }

}
