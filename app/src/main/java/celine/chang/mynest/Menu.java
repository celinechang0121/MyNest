package celine.chang.mynest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

public class Menu extends AppCompatActivity {

    private FirebaseAuth mAuth;
    FirebaseUser user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        TextView tv = findViewById(R.id.button12);
        tv.setText(user.getUid());
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://mynest-dec57-default-rtdb.asia-southeast1.firebasedatabase.app/" );
        DatabaseReference myRef = database.getReference("Users/"+user.getUid());
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
            UserDTO usr = snapshot.getValue(UserDTO.class);
                assert usr != null;
                String name = usr.getName();
                Log.d("NAME", name);
                tv.setText("welcome, "+ name+"!");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        //define
        String a = "hello";

        Button btn1 = findViewById(R.id.button2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Menu.this, DonateMenu.class);
                startActivity(it);
            }
        });

        Button btn2 = findViewById(R.id.button3);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent( Menu.this, ReceiveMenu.class);
                startActivity(it);
            }
        });

        Button btnmap = findViewById(R.id.button5);
        btnmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent( Menu.this, FakeMap.class);
                startActivity(it);
            }
        });

        Button btnpdf = findViewById(R.id.button4);
        btnpdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent( Menu.this, PdfMenu.class);
                startActivity(it);
            }
        });

        Button btncall = findViewById(R.id.button6);
        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent( Menu.this, Contactus_Menu.class);
                startActivity(it);
            }
        });



    }
}

