package celine.chang.mynest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Join extends AppCompatActivity {
    private FirebaseAuth mAuth;
    public String TAG = "Join.class >> ";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);

        TextInputEditText id = findViewById(R.id.idinput);
        TextInputEditText name = findViewById(R.id.nameinput);
        TextInputEditText pw = findViewById(R.id.pwinput);
        Button submit = findViewById(R.id.btn_submit);

        mAuth = FirebaseAuth.getInstance();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.createUserWithEmailAndPassword(id.getText().toString(), pw.getText().toString())
                        .addOnCompleteListener(Join.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    assert user != null;
                                    updateUI(user, name.getText().toString());
                                    Intent it = new Intent(getApplicationContext(), Menu.class);
                                    assert user != null;
                                    it.putExtra("UID", user.getUid().toString());
                                    it.putExtra("Name", name.getText().toString());
                                    startActivity(it);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(Join.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    //updateUI(null);
                                }
                            }
                        });
            }
        });

    }

    public void updateUI(FirebaseUser user, String name){
        UserDTO userDTO = new UserDTO(name, user.getUid());
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://mynest-dec57-default-rtdb.asia-southeast1.firebasedatabase.app/" );
        DatabaseReference myRef = database.getReference();
        myRef.child("Users").child(user.getUid()).setValue(userDTO);
        Log.d(TAG, myRef.toString());
    }


}