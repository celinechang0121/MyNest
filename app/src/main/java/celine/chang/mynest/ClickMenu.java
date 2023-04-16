package celine.chang.mynest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
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

import org.w3c.dom.Text;

public class ClickMenu extends AppCompatActivity {

    private FirebaseAuth mAuth;
    FirebaseUser user;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.click_menu);
        String it = getIntent().getStringExtra("itemID");
        int itint = Integer.parseInt(it);

        TextView t = findViewById(R.id.title);
        TextView d = findViewById(R.id.description);
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://mynest-dec57-default-rtdb.asia-southeast1.firebasedatabase.app/" );
        DatabaseReference myRef1 = database.getReference("Items/"+itint);
        myRef1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ItemDTO item = snapshot.getValue(ItemDTO.class);
                t.setText(item.getTitle());
                d.setText(item.getDescription());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
