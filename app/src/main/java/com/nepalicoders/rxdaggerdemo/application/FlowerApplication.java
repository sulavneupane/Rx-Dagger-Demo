package com.nepalicoders.rxdaggerdemo.application;

import android.app.Application;

import com.nepalicoders.rxdaggerdemo.dependencies.ApiComponent;
import com.nepalicoders.rxdaggerdemo.dependencies.DaggerApiComponent;
import com.nepalicoders.rxdaggerdemo.dependencies.DaggerNetworkComponent;
import com.nepalicoders.rxdaggerdemo.dependencies.NetworkComponent;
import com.nepalicoders.rxdaggerdemo.dependencies.NetworkModule;
import com.nepalicoders.rxdaggerdemo.model.Constant;

/**
 * Created by Sulav on 8/28/17.
 */

public class FlowerApplication extends Application {

    private ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        resolveDependency();
        super.onCreate();
    }

    private void resolveDependency() {
        mApiComponent = DaggerApiComponent.builder()
                .networkComponent(getNetworkComponent())
                .build();
    }

    public NetworkComponent getNetworkComponent() {
        return DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule(Constant.BASE_URL))
                .build();
    }

    public ApiComponent getApiComponent() {
        return mApiComponent;
    }

}
