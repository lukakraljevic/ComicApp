package com.example.domain.usecase;

import io.reactivex.Single;

public interface UseCaseWithParam<Param, T> {

    Single<T> execute(Param param);
}
