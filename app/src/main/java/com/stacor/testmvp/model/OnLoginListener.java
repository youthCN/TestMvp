package com.stacor.testmvp.model;

/**
 * Copyright (c) 2018, 北京视达科科技有限责任公司 All rights reserved.
 * author：chongyang.gao
 * date：2018/10/11
 * description：
 */

public interface OnLoginListener<T> {
    void onSucceed(T t);

    void onFailed(int code, String msg);
}
