package com.example.botik.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.botik.R;
import com.example.botik.databinding.ActivityMainBinding;
import com.example.botik.model.CartCount;
import com.example.botik.repository.Api;
import com.example.botik.repository.Repository;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    ActivityMainBinding binding;
    NavController navController;
    AppBarConfiguration appBarConfiguration;
    BadgeDrawable badgeDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        appBarConfiguration= new AppBarConfiguration.Builder(R.navigation.navigation).build();
        NavHostFragment navHostFragment=(NavHostFragment)getSupportFragmentManager().findFragmentById(R.id.fragment);
        assert navHostFragment != null;
        navController = navHostFragment.getNavController();
        binding.bottom.setOnNavigationItemSelectedListener(this);
        Get_CountCart();
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController,appBarConfiguration);
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.Main:
                navController.navigate(R.id.fragmentMain);
                break;
            case R.id.Carts:
                String status=Repository.Shared_Read(MainActivity.this);
                if(status==null){
                    navController.navigate(R.id.fragmentLogin);
                }
                else
                {
                    navController.navigate(R.id.fragmentCart);
                }
                break;
            case R.id.user:
                String check=Repository.Shared_Read(MainActivity.this);
                if(check==null){
                    navController.navigate(R.id.fragmentLogin);
                }
                else
                {
                    navController.navigate(R.id.fragmentProfile);
                }
                break;
        }
        return false;
    }

    public void Get_CountCart(){
        String check= Repository.Shared_Read(MainActivity.this);
        if(check==null) {

        }else
        {
            badgeDrawable=binding.bottom.getOrCreateBadge(R.id.Carts);
            Repository.INSTACNCE.CustomResponse(Api.Compation.invoke().Single_Count_Cart(check), new Repository.Unit() {
                @Override
                public void invoke(Object object) {
                    CartCount CartCount = (CartCount)object;
                    badgeDrawable.setNumber(Integer.parseInt(CartCount.getCount()));
                }
            });

        }
    }
}