package com.codesample.widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;


import com.codesample.widget.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initWidgets();
    }

    private void initWidgets() {
        binding.editTextName.addTextChangedListener(this);
        binding.editTextPhone.addTextChangedListener(this);
        binding.radioButtonAdult.setOnClickListener(this);
        binding.radioButtonStudent.setOnClickListener(this);;
        binding.checkBoxTerms.setOnCheckedChangeListener(this);
        binding.buttonApply.setOnClickListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Log.i("Main", "before="+s + " start="+start+", count="+count+", after="+after);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.i("Main", "on="+s + " start="+start+", before="+before+", count="+count);
    }

    @Override
    public void afterTextChanged(Editable s) {
        Log.i("Main", "after=" + s.toString());
        updateProgress();
    }

    @Override
    public void onClick(View v) {
        updateProgress();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        updateProgress();
    }

    public void updateProgress() {
        int progress=0;

        if(binding.editTextName.getText().length()>0) progress+=25;
        if(binding.editTextPhone.getText().length()>0) progress+=25;
        if(binding.radioButtonAdult.isChecked() || binding.radioButtonStudent.isChecked()) progress+=25;
        if(binding.checkBoxTerms.isChecked()) progress+=25;

        binding.progressBar.setProgress(progress);
        if(progress==100) binding.buttonApply.setVisibility(View.VISIBLE);
        else binding.buttonApply.setVisibility(View.INVISIBLE);
    }


}
