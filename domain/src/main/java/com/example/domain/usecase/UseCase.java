package com.example.domain.usecase;

import com.example.domain.listener.RequestCallback;

public interface UseCase<T> {

    void execute(RequestCallback<T> callback);

}
