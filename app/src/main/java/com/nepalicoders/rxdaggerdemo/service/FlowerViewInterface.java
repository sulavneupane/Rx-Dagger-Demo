package com.nepalicoders.rxdaggerdemo.service;

import com.nepalicoders.rxdaggerdemo.model.FlowerResponse;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Sulav on 8/28/17.
 */

public interface FlowerViewInterface {

    void onFlowers(List<FlowerResponse> flowerResponses);

    void onError(String message);

    void onCompleted();

    Observable<List<FlowerResponse>> getFlowers();
}
