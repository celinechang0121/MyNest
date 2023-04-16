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


        Button finance = findViewById(R.id.button2);
        Button jobs = findViewById(R.id.button3);
        Button women = findViewById(R.id.button4);
        Button housing = findViewById(R.id.button5);

        finance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //internet intent
                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youth.seoul.go.kr/site/main/content/youth_allowance_justice"));
                startActivity(it);
            }
        });

        jobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //internet intent
                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youthcenter.go.kr/entrProg/entrProgList.do"));
                startActivity(it);
            }
        });

        women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //internet intent
                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.lh.or.kr/contents/cont.do?sCode=user&mId=234&mPid=231"));
                startActivity(it);
            }
        });

        housing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //internet intent
                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("https://central.childcare.go.kr/ccef/main.jsp"));
                startActivity(it);
            }
        });

    }


}