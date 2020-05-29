package com.plug.wv;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.JavascriptInterface;

import com.just.library.AgentWeb;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 李明明
 * Date is 2019/5/7
 **/
public class JsCallAndroidInterface {
    private final FullScreenDialog fullScreenDialog;
    private AgentWeb agent;
    private Context context;
    FullScreenDialog.OnWVCb cb;


    public JsCallAndroidInterface(FullScreenDialog dialog,AgentWeb agent, Context context, FullScreenDialog.OnWVCb cb) {
        this.agent = agent;
        this.context = context;
        fullScreenDialog = dialog;
        this.cb = cb;
    }

    @JavascriptInterface
    public void BackToAndroid(String data) {
        Log.e(FullScreenDialog.TAG, "BackToAndroid" + data);
        cb.onJsCall(data);
    }

}