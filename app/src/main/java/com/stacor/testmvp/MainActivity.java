package com.stacor.testmvp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.stacor.testmvp.presenter.LoginPresenter;
import com.stacor.testmvp.presenter.LoginPresenterImp;
import com.stacor.testmvp.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView{


    private EditText nameTv;
    private EditText passwordTv;
    private Button loginBt;
    private Button clearBt;
    private ProgressDialog progressDialog;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameTv = (EditText) findViewById(R.id.tv_name);
        passwordTv = (EditText) findViewById(R.id.tv_password);
        loginBt = (Button) findViewById(R.id.bt_login);
        clearBt = (Button) findViewById(R.id.bt_clear);
        progressDialog = new ProgressDialog(this);
        loginPresenter = new LoginPresenterImp(this);

        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.login();
            }
        });

        clearBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAll();
            }
        });


    }

    @Override
    public String getName() {
        return nameTv.getText().toString();
    }

    @Override
    public String getPassword() {
        return passwordTv.getText().toString();
    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void dismissLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void clearAll() {
        nameTv.setText("");
        passwordTv.setText("");
    }

    @Override
    public void showSucceedToast(String tips) {
        Toast.makeText(this,tips,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedToast(String tips) {
        Toast.makeText(this,tips,Toast.LENGTH_SHORT).show();
    }
}
