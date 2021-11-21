package com.liguo.flutterboost.test_flutter_boost;

import android.content.Intent;
import android.util.Log;

import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostDelegate;
import com.idlefish.flutterboost.FlutterBoostRouteOptions;

public class MyFlutterBoostDelegate implements FlutterBoostDelegate {
    public final static String TAG = "MyFlutterBoostDelegate";

    @Override
    public void pushNativeRoute(FlutterBoostRouteOptions options) {
        Log.e(TAG,"===========>pushNativeRoute");
        Intent intent = new Intent(FlutterBoost.instance().currentActivity(), TestFlutterBoostActivity.class);
        FlutterBoost.instance().currentActivity().startActivityForResult(intent, options.requestCode());
    }

    @Override
    public void pushFlutterRoute(FlutterBoostRouteOptions options) {
        Log.e(TAG,"===========>pushFlutterRoute");
        /*Class<? extends FlutterBoostActivity> activityClass = options.opaque() ? FlutterBoostActivity.class : TransparencyPageActivity.class;
        Intent intent = new FlutterBoostActivity.CachedEngineIntentBuilder(activityClass)
                .destroyEngineWithActivity(false)
                .uniqueId(options.uniqueId())
                .url(options.pageName())
                .urlParams(options.arguments())
                .build(FlutterBoost.instance().currentActivity());
        FlutterBoost.instance().currentActivity().startActivity(intent);*/
    }

}
