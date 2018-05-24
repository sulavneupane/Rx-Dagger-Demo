package com.nepalicoders.rxdaggerdemo.base;

import com.nepalicoders.rxdaggerdemo.model.FlowerResponse;

import org.reactivestreams.Subscriber;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Sulav on 8/28/17.
 */

public abstract class BasePresenter<T> extends DisposableObserver<T> implements Presenter {

    private CompositeDisposable mCompositeDisposable;

    @Override
    public void onCreate() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {
        configureDisposable();
    }

    private CompositeDisposable configureDisposable() {
        if (mCompositeDisposable == null || mCompositeDisposable.isDisposed()) {
            mCompositeDisposable = new CompositeDisposable();
        }
        return mCompositeDisposable;
    }

    @Override
    public void onDestroy() {
        disposeAll();
    }

    void disposeAll() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
            mCompositeDisposable.clear();
        }
    }

    <T> void subscribe(Observable<T> observable, Observer<T> observer) {
        DisposableObserver<T> disposableObserver = (DisposableObserver<T>) observer;

        Disposable disposable = observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.computation())
                .subscribeWith(disposableObserver);

        mCompositeDisposable.add(disposable);
    }

}
