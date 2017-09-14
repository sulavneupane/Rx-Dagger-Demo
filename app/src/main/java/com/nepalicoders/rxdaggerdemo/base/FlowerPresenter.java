package com.nepalicoders.rxdaggerdemo.base;

import com.nepalicoders.rxdaggerdemo.model.FlowerResponse;
import com.nepalicoders.rxdaggerdemo.service.FlowerViewInterface;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Sulav on 8/28/17.
 */

public class FlowerPresenter extends BasePresenter implements Observer<List<FlowerResponse>> {

    FlowerViewInterface mViewInterface;

    public FlowerPresenter(FlowerViewInterface viewInterface) {
        mViewInterface = viewInterface;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull List<FlowerResponse> flowerResponses) {
        mViewInterface.onFlowers(flowerResponses);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        mViewInterface.onError(e.getMessage());
    }

    @Override
    public void onComplete() {
        mViewInterface.onCompleted();
    }

    public void fetchFlowers() {
        disposeAll();
        subscribe(mViewInterface.getFlowers(), FlowerPresenter.this);
    }
}
