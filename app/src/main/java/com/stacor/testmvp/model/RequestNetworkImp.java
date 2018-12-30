package com.stacor.testmvp.model;

import android.text.TextUtils;
import android.util.Log;

import com.stacor.testmvp.model.domain.User;

/**
 * Copyright (c) 2018, 北京视达科科技有限责任公司 All rights reserved.
 * author：chongyang.gao
 * date：2018/10/11
 * description：
 */

public class RequestNetworkImp implements RequestNetwork {
    public static final String TAG = "RequestNetworkImp";

    @Override
    public void login(String name, String password, final OnLoginListener listener) {
        try {
            Log.i(TAG, "login: 正在登录");
            Log.i(TAG, "login: name = " + name + ",password =" + password);
            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)){
                listener.onFailed(-1, "账号或密码为空");
                return;
            }
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
            listener.onFailed(500, "服务器坏了");
            return;
        }
        if ("qqq".equals(name) && "qqq".equals(password)){
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            listener.onSucceed(user);
        }else {
            listener.onFailed(-2, "账号或密码错误");
        }

    }
}
