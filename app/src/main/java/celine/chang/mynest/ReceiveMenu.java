package celine.chang.mynest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ReceiveMenu extends AppCompatActivity {


    ArrayList<ItemDTO> data = new ArrayList<>();
    private FirebaseAuth mAuth;
    FirebaseUser user;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receive_menu);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        ListView list = findViewById(R.id.lv);
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://mynest-dec57-default-rtdb.asia-southeast1.firebasedatabase.app/" );
        DatabaseReference myRef1 = database.getReference("Items");
        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot datasnapshot: snapshot.getChildren()){
                    ItemDTO temp = datasnapshot.getValue(ItemDTO.class);
                    data.add(temp);

                }
                Log.d("array>>", String.valueOf(data.size()));
                final ItemAdapter adp = new ItemAdapter(ReceiveMenu.this, data);
                list.setAdapter(adp);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });



    }
}
