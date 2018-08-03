package com.example.domain.usecase;

import io.reactivex.Single;

public interface UseCase<T> {

    Single<T> execute();

}
