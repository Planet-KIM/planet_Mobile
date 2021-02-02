package com.example.walkplanetcat_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.walkplanetcat_mobile.FRAGMENTS.sub_Activity_Fragment1;
import com.example.walkplanetcat_mobile.FRAGMENTS.sub_Activity_Fragment2;
import com.example.walkplanetcat_mobile.FRAGMENTS.sub_Activity_Fragment3;
import com.example.walkplanetcat_mobile.FRAGMENTS.sub_Activity_Fragment4;
import com.example.walkplanetcat_mobile.FRAGMENTS.sub_Activity_Fragment5;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavigationView = findViewById(R.id.nav_bottom_view);
        mBottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        BottomNavigate(item.getItemId());
                        return true;
                    }
                }
        );
        mBottomNavigationView.setSelectedItemId(R.id.bottom1);
    }

    private void BottomNavigate(int itemId) {
        String tag = String.valueOf(itemId);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment currentFragment = fragmentManager.getPrimaryNavigationFragment();

        if(currentFragment != null){
            fragmentTransaction.hide(currentFragment);
        }

        Fragment fragment = fragmentManager.findFragmentByTag(tag);

        if(fragment == null){
            if (itemId == R.id.bottom1){
                fragment= new sub_Activity_Fragment1();
            }
            else if(itemId == R.id.bottom2){
                fragment = new sub_Activity_Fragment2();
            }
            else if(itemId == R.id.bottom3){
                fragment= new sub_Activity_Fragment3();
            }
            else if(itemId == R.id.bottom4){
                fragment= new sub_Activity_Fragment4();
            }
            else if(itemId == R.id.bottom5){
                fragment= new sub_Activity_Fragment5();
            }

            fragmentTransaction.add(R.id.content_layout, fragment, tag);
        }
        else{
            fragmentTransaction.show(fragment);
        }
        // 이 부분을 명시해주어야 글자가 겹치지 않고 표시됩니다.
        fragmentTransaction.setPrimaryNavigationFragment(fragment);
        fragmentTransaction.setReorderingAllowed(true);
        fragmentTransaction.commitNow();
    }

    public void access_Login_Page(View view) {
        Toast.makeText(getApplicationContext(), "Access Login Page", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), sub_Activity_Login.class);
        startActivity(intent);
    }
}