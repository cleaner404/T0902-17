package com.example.cleaner208.t0902_17;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //文件名
    private final static String SharedPreferencesFileName="config";

    //键
    private final static String Key_UserName="UserName";//用户名
    private final static String Key_Code="Code";//用户名


    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获得SharedPreferences实例
        preferences=getSharedPreferences(SharedPreferencesFileName, MODE_PRIVATE);
        editor=preferences.edit();

        Button btnWrite=(Button)findViewById(R.id.btn_w);
        Button btnRead=(Button)findViewById(R.id.btn_r);
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //写入键值对
                editor.putString(Key_UserName, "李大钊");
                editor.putString(Key_Code,"2014000001");
                //提交修改
                editor.apply();
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUserName = preferences.getString(Key_UserName, null);
                String strCode = preferences.getString(Key_Code, null);
                if (strUserName != null&&strCode!=null)
                    Toast.makeText(MainActivity.this, "用户名:" + strUserName+"密码:"+strCode, Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "无数据", Toast.LENGTH_LONG).show();
            }
        });
    }
}
