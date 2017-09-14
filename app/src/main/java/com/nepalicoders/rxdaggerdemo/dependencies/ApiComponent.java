package com.nepalicoders.rxdaggerdemo.dependencies;

import com.nepalicoders.rxdaggerdemo.ui.MainActivity;

import dagger.Component;

/**
 * Created by Sulav on 8/28/17.
 */
@CustomScope
@Component(modules = ApiModule.class, dependencies = NetworkComponent.class)
public interface ApiComponent {

    void inject(MainActivity activity);

}
