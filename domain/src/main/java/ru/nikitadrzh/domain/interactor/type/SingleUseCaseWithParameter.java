package ru.nikitadrzh.domain.interactor.type;

import java.io.IOException;

import io.reactivex.Single;

public interface SingleUseCaseWithParameter<P, R> {
    Single<R> execute(P parameter) throws IOException;
}
