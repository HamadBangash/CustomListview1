package com.example.bangash.internshiptask1_customlistview;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        gettingIntents();
    }

    private void gettingIntents() {
        String Names = getIntent().getExtras().getString("Names");
        String imgs = getIntent().getExtras().getString("Images");
        final TextView tvName = (TextView) findViewById(R.id.tvName);
        TextView tvQ_value = (TextView) findViewById(R.id.tvQ_value);
        TextView tvE_value = (TextView) findViewById(R.id.tvE_value);
        final TextView tvC_value = (TextView) findViewById(R.id.tvC_value);
        TextView tvDesegnation = (TextView) findViewById(R.id.tvDeseg);
        int res=getResources().getIdentifier(imgs,"drawable",getPackageName());
        ImageView ivAvatar= (ImageView) findViewById(R.id.ivAvatar);
        ImageView ivCall= (ImageView) findViewById(R.id.ivCall);
        ImageView ivMsg= (ImageView) findViewById(R.id.ivMsg);
        ivCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+tvC_value.getText()));
                startActivity(intent);
            }
        });
        ivMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setType("vnd.android-dir/mms-sms");
                sendIntent.putExtra("address", tvC_value.getText());
                sendIntent.putExtra("sms_body","Hi how are you"+tvName.getText());
                startActivity(sendIntent);
            }
        });
        ivAvatar.setImageResource(res);
        tvName.setText(Names);
        if (Names.equals("Hamad")) {
            tvQ_value.setText("BSE(Hons)");
            tvE_value.setText("Android Developer");
            tvC_value.setText("03455984877");
            tvDesegnation.setText("Internee");

        } else if (Names.equals("Fazal Nabi")) {
            tvQ_value.setText("BSE(Hons)");
            tvE_value.setText("Android Developer");
            tvC_value.setText("03329393666");
            tvDesegnation.setText("Internee");

        } else if (Names.equals("Ilyas")) {
            tvQ_value.setText("BSE(Hons)");
            tvE_value.setText("Android Developer");
            tvC_value.setText("03138877654");
            tvDesegnation.setText("Internee");

        } else if (Names.equals("Sajad")) {
            tvQ_value.setText("BSCS(Hons)");
            tvE_value.setText("Android Developer");
            tvC_value.setText("03338877698");
            tvDesegnation.setText("Internee");

        }

    }
}
