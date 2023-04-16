package celine.chang.mynest;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Contactus_Menu extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactus_menu);
        Button btn1 = findViewById(R.id.button_call);
        Button btn2 = findViewById(R.id.button_call2);


        btn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String number = "12312313";
            //call intent
            Intent it = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
            startActivity(it);
            }
        });




    }
}




