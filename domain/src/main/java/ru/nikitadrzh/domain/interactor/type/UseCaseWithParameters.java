package ru.nikitadrzh.domain.interactor.type;

import io.reactivex.Observable;

public interface UseCaseWithParameters<P, R> {
    Observable<R> execute(P parameter);
}
