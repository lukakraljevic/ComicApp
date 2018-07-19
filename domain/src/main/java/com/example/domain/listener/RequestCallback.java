package com.example.domain.listener;

public interface RequestCallback<T> {

    void onSuccess(T value);

    void onError(Throwable error);
}
