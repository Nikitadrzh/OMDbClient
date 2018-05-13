package ru.nikitadrzh.domain.interactor.type;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface UseCaseWithParameters<P, R> {
    Observable<R> execute(P parameter);
}
