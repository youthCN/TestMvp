package com.stacor.testmvp.presenter;

import com.stacor.testmvp.model.OnLoginListener;
import com.stacor.testmvp.model.RequestNetwork;
import com.stacor.testmvp.model.RequestNetworkImp;
import com.stacor.testmvp.model.domain.User;
import com.stacor.testmvp.view.LoginView;

/**
 * Copyright (c) 2018, 北京视达科科技有限责任公司 All rights reserved.
 * author：chongyang.gao
 * date：2018/10/11
 * description：
 */

public class LoginPresenterImp implements LoginPresenter {

    private LoginView loginView;//presenter层持有view的引用
    private RequestNetwork requestNetwork;//presenter层持有Model的应用

    public LoginPresenterImp(LoginView loginView){
        this.loginView = loginView;
        requestNetwork = new RequestNetworkImp();
    }

    @Override
    public void login() {
        loginView.showLoading();
        requestNetwork.login(loginView.getName(), loginView.getPassword(), new OnLoginListener<User>() {
            @Override
            public void onSucceed(User user) {
                loginView.showSucceedToast("欢迎回来："+user.getName());
                loginView.dismissLoading();
            }

            @Override
            public void onFailed(int code, String msg) {
                loginView.showSucceedToast("登录失败："+msg+",code="+code);
                loginView.dismissLoading();
            }
        });
    }

}
