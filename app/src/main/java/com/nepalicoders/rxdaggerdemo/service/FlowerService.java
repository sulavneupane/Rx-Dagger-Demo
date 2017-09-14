package com.nepalicoders.rxdaggerdemo.service;

import com.nepalicoders.rxdaggerdemo.model.FlowerResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Sulav on 8/28/17.
 */

public interface FlowerService {

    @GET("/feeds/flowers.json")
    Observable<List<FlowerResponse>> getFlowers();

}
