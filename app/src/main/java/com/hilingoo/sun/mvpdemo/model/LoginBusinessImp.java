package com.hilingoo.sun.mvpdemo.model;

import com.hilingoo.sun.mvpdemo.presenter.LoginPresenter;

/**
 * Author: Diligent.S
 * Time: 2016/9/20 13:45.
 */
public class LoginBusinessImp implements LoginModelInterface {
    @Override
    public void login(final String userName, final String password, final LoginPresenter.CallBack callBack) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //进行耗时操作，进行网络请求
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //模拟验证。用户名密码相同，我们定为校验失败，否则校验成功
                if (!userName.equals(password)) {
                    LoginInfo info = new LoginInfo(userName, password);
                    callBack.onSuccess(info);
                } else {
                    callBack.onFail(new Exception("用户名或密码错误"));
                }
            }
        }).start();
    }
}
