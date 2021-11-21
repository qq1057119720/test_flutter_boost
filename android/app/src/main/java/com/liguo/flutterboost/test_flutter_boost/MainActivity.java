package com.liguo.flutterboost.test_flutter_boost;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostRouteOptions;
import com.idlefish.flutterboost.containers.FlutterActivityLaunchConfigs;
import com.idlefish.flutterboost.containers.FlutterBoostActivity;

import java.util.HashMap;

import io.flutter.embedding.engine.FlutterEngine;

public class MainActivity extends FlutterBoostActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//API>21,设置状态栏颜色透明
            getWindow().setStatusBarColor(0);
        }
        FlutterBoostRouteOptions options = new FlutterBoostRouteOptions.Builder()
                .pageName("splash")
                .arguments(new HashMap<>())
                .requestCode(1111)
                .build();
        FlutterBoost.instance().open(options);
        finish();

    }
//    @Override
//    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
//        super.configureFlutterEngine(flutterEngine);
//    }

}
