package celine.chang.mynest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PdfMenu extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_menu);


        Button math = findViewById(R.id.button2);
        Button english = findViewById(R.id.button3);
        Button science = findViewById(R.id.button4);
        Button etc = findViewById(R.id.button5);

        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("https://kyparkconnaissance.blogspot.com/2022/12/android-studio-auto-complete-code.html"));
                startActivity(it);
            }
        });


    }


}