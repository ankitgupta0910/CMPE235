package com.example.ankit.finalproject1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private ArrayList<String> fileList = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        final ListView listView = (ListView)findViewById(R.id.listview);
//      File root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File root = Environment.getExternalStorageDirectory();

            File listFile[] = root.listFiles();
            if (listFile != null && listFile.length > 0) {
                for (int i = 0; i < listFile.length; i++) {
                    if (listFile[i].getName().endsWith(".mp4"))
                    {
                        fileList.add(listFile[i].getName());
                    }
                    }
                }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, fileList);

        // Assign adapter to ListView
            listView.setAdapter(adapter);

        // ListView Item Click Listener
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

//            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        // ListView Clicked item index
            int itemPosition = position;

        // ListView Clicked item value
            String itemValue = (String) listView.getItemAtPosition(position);
            System.out.println("ItemValue" + itemValue);
            Intent intent = new Intent(MainActivity.this, VideoActivity.class);
            intent.putExtra("Name",itemValue);
            startActivity(intent);
            }  });
    }
}
