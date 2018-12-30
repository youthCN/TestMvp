package com.stacor.testmvp.view;

/**
 * Copyright (c) 2018, 北京视达科科技有限责任公司 All rights reserved.
 * author：chongyang.gao
 * date：2018/10/11
 * description：
 */

public interface LoginView {

    String getName();
    String getPassword();
    void showLoading();
    void dismissLoading();
    void clearAll();
    void showSucceedToast(String tips);
    void showFailedToast(String tips);
}
