package celine.chang.mynest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ReceiveMenu extends AppCompatActivity {
    ListView list;
    ItemAdapter adp;
    ArrayList<ItemDTO> data;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receive_menu);
        list = findViewById(R.id.lv);

        adp = new ItemAdapter(getApplicationContext(), data);
        list.setAdapter(adp);





    }
}
