package com.liguo.flutterboost.test_flutter_boost;

import android.content.Intent;

import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostDelegate;
import com.idlefish.flutterboost.FlutterBoostRouteOptions;
import com.idlefish.flutterboost.FlutterBoostSetupOptions;
import com.idlefish.flutterboost.containers.FlutterBoostActivity;

import java.util.ArrayList;

import io.flutter.app.FlutterApplication;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;

public class MyApplication extends FlutterApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        FlutterBoost.instance().setup(this, new FlutterBoostDelegate() {
            @Override
            public void pushNativeRoute(FlutterBoostRouteOptions options) {
                //这里根据options.pageName来判断你想跳转哪个页面，这里简单给一个
                Intent intent = new Intent(FlutterBoost.instance().currentActivity(), TestFlutterBoostActivity.class);
                FlutterBoost.instance().currentActivity().startActivityForResult(intent, options.requestCode());
            }

            @Override
            public void pushFlutterRoute(FlutterBoostRouteOptions options) {
                Intent intent = new FlutterBoostActivity.CachedEngineIntentBuilder(FlutterBoostActivity.class)
                        .backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.transparent)
                        .destroyEngineWithActivity(false)
                        .uniqueId(options.uniqueId())
                        .url(options.pageName())
                        .urlParams(options.arguments())
                        .build(FlutterBoost.instance().currentActivity());
                FlutterBoost.instance().currentActivity().startActivity(intent);
            }
        }, engine -> {
        });
    }
}

