package com.example.bangash.internshiptask1_customlistview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView lvItems = (ListView) findViewById(R.id.lvItems);
        int imgs[] = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4};
        String names[] = {"Hamad", "Fazal Nabi", "Ilyas", "Sajad"};
        customArrayAdapter customArrayAdapter = new customArrayAdapter(this, names, imgs);
        lvItems.setAdapter(customArrayAdapter);
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedName= (String) lvItems.getItemAtPosition(position);
                String img[]={"image_1","image_2","image_3","image_4"};
                String imgId=img[position];
                sendingIntents(selectedName,imgId);

            }
        });
    }

    private void sendingIntents(String selectedName, String imgId) {
        Intent itemsIntent=new Intent(MainActivity.this,DetailsActivity.class);
        itemsIntent.putExtra("Names",selectedName);
        itemsIntent.putExtra("Images",imgId);
        startActivityForResult(itemsIntent,0);
    }


    class customArrayAdapter extends ArrayAdapter {
        Context context;
        String names[];
        int imgs[];

        public customArrayAdapter(Context context, String names[], int imgs[]) {
            super(context, R.layout.custom_listview_layout, names);
            this.context = context;
            this.names = names;
            this.imgs = imgs;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.custom_listview_layout, null);
            ImageView ivListviewImage = (ImageView) view.findViewById(R.id.ivListviewImage);
            ivListviewImage.setImageResource(imgs[position]);
            TextView tvListItems = (TextView) view.findViewById(R.id.tvListviewItems);
            tvListItems.setText(names[position]);
            return view;
        }
    }

}
