package com.userinterface.ssuroom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private TextView idTv, pwTv,pwCTv,nickTv;
    private Pattern emailPattern= Patterns.EMAIL_ADDRESS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        Button btn=findViewById(R.id.signup2);
        idTv = findViewById(R.id.id2);
        pwTv = findViewById(R.id.password2);
        pwCTv=findViewById(R.id.passwordConfirm);
        nickTv=findViewById(R.id.nickname);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(idTv.length()==0||pwCTv.length()==0||pwTv.length()==0||nickTv.length()==0){
            Toast.makeText(getApplicationContext(),"값을 모두 입력해주세요.",Toast.LENGTH_SHORT).show();
            return;
        }
        if(!pwTv.getText().toString().equals(pwCTv.getText().toString())){
            Toast.makeText(getApplicationContext(),"비밀번호를 다시 확인해주세요",Toast.LENGTH_SHORT).show();
            return;
        }
        if(!emailPattern.matcher(idTv.getText().toString()).matches()){
            Toast.makeText(getApplicationContext(),"아이디는 이메일 형식으로 입력해주세요",Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.createUserWithEmailAndPassword(idTv.getText().toString(), pwTv.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();

                            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(nickTv.getText().toString())
                                    .build();

                            user.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Log.d("final_log", "신규유저 정보 DB 저장");
                                    Toast.makeText(getApplicationContext(),"회원가입에 성공하였습니다.",Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(getApplicationContext(), LoginActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            });

                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getApplicationContext(),"회원가입 실패",Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                    }
                });
    }
}