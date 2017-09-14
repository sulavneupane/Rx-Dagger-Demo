package com.nepalicoders.rxdaggerdemo.dependencies;

import com.nepalicoders.rxdaggerdemo.service.FlowerService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Sulav on 8/28/17.
 */
@Module
public class ApiModule {

    @Provides
    @CustomScope
    FlowerService provideFlowerService(Retrofit retrofit) {
        return retrofit.create(FlowerService.class);
    }

}
