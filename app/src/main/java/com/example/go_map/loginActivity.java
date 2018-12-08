package com.example.go_map;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    private EditText account;
    private EditText passageword;
    private Button button;
    private CheckBox checkBox;
    private SharedPreferences preferences=null;
    private SharedPreferences.Editor editor=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        preferences= PreferenceManager.getDefaultSharedPreferences(this);
        account=(EditText)findViewById(R.id.account);
        passageword=(EditText)findViewById(R.id.passage);
        button=(Button)findViewById(R.id.login);
        checkBox=(CheckBox)findViewById(R.id.remenber_password);
        boolean remember=preferences.getBoolean("remember",false);
        if(remember)
        {
            account.setText(preferences.getString("account","null"));
            passageword.setText(preferences.getString("password","null"));
            checkBox.setChecked(true);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Account=account.getText().toString();
                String Passageword=passageword.getText().toString();
                if(Account.equals("123")&&Passageword.equals("1111"))
                {
                    editor=preferences.edit();
                    if(checkBox.isChecked())//记住密码被选中
                    {
                        editor.putString("account","123");
                        editor.putString("password","1111");
                        editor.putBoolean("remember",true);
                    }
                    else
                    {
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent=new Intent(loginActivity.this,MainUIActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(loginActivity.this,"账号或密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
