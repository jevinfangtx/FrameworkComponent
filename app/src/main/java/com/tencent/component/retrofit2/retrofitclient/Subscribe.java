package com.tencent.component.retrofit2.retrofitclient;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class Subscribe<T> implements Subscriber<T> {

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }
}
