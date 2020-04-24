package com.test.restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.test.restaurant.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private ActivityMainBinding binding;
FragmentManager fm;
FragmentTransaction tran;
Frag1 frag1;
Frag2 frag2;
Frag3 frag3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initWidgets();
        frag1 = new Frag1();
        frag2 = new Frag2();
        frag3 = new Frag3();
        setFrag(0);
    }

    private void initWidgets() {
        binding.menuBtn.setOnClickListener(this);
        binding.locBtn.setOnClickListener(this);
        binding.eventBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.menuBtn:
                setFrag(0);
                break;
            case R.id.locBtn:
                setFrag(1);
                break;
            case R.id.eventBtn:
                setFrag(2);
                break;
        }

        /*
        if (binding.menuBtn.equals(binding)) {
            setFrag(0);
        } else if (binding.locBtn.equals(binding)) {
            setFrag(1);
        } else if (binding.eventBtn.equals(binding)) {
            setFrag(2);
        }
         */
    }

    public void setFrag(int n) {
        fm = getSupportFragmentManager();
        tran = fm.beginTransaction();
        switch (n){
            case 0:
                tran.replace(R.id.main_frame, frag1);  //replace의 매개변수는 (프래그먼트를 담을 영역 id, 프래그먼트 객체) 입니다.
                tran.commit();
                break;
            case 1:
                tran.replace(R.id.main_frame, frag2);  //replace의 매개변수는 (프래그먼트를 담을 영역 id, 프래그먼트 객체) 입니다.
                tran.commit();
                break;
            case 2:
                tran.replace(R.id.main_frame, frag3);  //replace의 매개변수는 (프래그먼트를 담을 영역 id, 프래그먼트 객체) 입니다.
                tran.commit();
                break;
        }
    }
}
