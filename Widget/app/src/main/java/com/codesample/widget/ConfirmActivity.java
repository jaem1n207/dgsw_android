package com.codesample.widget;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.codesample.widget.databinding.ActivityConfirmBinding;

public class ConfirmActivity extends AppCompatActivity {
    private ActivityConfirmBinding binding;

    public void onButton(View v) {
        if(v.getId()==R.id.buttonOK) {
            Intent intent = new Intent();
            intent.putExtra("message", "User confirmed");
            setResult(Activity.RESULT_OK, intent);
        }
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityConfirmBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setResult(Activity.RESULT_CANCELED);

        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        String phone=intent.getStringExtra("phone");
        String userClass=intent.getStringExtra("class");
        boolean marketing=intent.getBooleanExtra("marketing", false);

        if(name!=null) binding.textViewName.setText(name);
        if(phone!=null) binding.textViewPhone.setText(phone);
        if(userClass!=null) binding.textViewClass.setText(userClass);
        Log.i("ConfirmActivity", "marketing="+marketing);
    }
}
