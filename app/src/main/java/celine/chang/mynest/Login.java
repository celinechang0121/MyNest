package celine.chang.mynest;

import android.content.Context;
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

public class Login extends AppCompatActivity {
    private FirebaseAuth mAuth;
    public String TAG = "Loin.class >> ";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        TextInputEditText id = findViewById(R.id.idinput);
        TextInputEditText pw = findViewById(R.id.pwinput);
        Button submit = findViewById(R.id.btn_submit);
        TextView tv = findViewById(R.id.tv_join);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Login.this, Join.class);
                startActivity(it);
                finish();
            }
        });

        mAuth = FirebaseAuth.getInstance();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lid = id.getText().toString();
                String lpw = pw.getText().toString();
                mAuth.signInWithEmailAndPassword(lid, lpw)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Intent it = new Intent(getApplicationContext(), Menu.class);
                                    assert user != null;
                                    it.putExtra("UID", user.getUid().toString());
                                    startActivity(it);

                                    //updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(Login.this, "Authentication failed. Please check your password or email!",
                                            Toast.LENGTH_SHORT).show();

                                    //updateUI(null);
                                }
                            }
                        });
            }
        });
    }

}
