package com.example.domain.usecase;

import com.example.domain.listener.RequestCallback;

public interface UseCaseWithParam<P, T> {

    void execute(P param, RequestCallback<T> callback);
}
