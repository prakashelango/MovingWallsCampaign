package com.base.movingwalls.common.core;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.concurrent.CompletableFuture.completedFuture;
import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * A monad Reactive sequential execution of functions
 * <p>
 */
public class React<T> {

    private final CompletableFuture<T> completableFuture;

    private React(final CompletableFuture<T> completableFuture) {
        this.completableFuture = completableFuture;
    }

    public static <T> React<T> of(final T t) {
        return of(completedFuture(t));
    }

    public static <T> React<T> of(final React<T> t) {
        return of(t.get());
    }

    public static <T> React<T> of(final Supplier<T> t) {
        return new React<>(supplyAsync(t));
    }

    public static <T> React<T> of(final CompletableFuture<T> t) {
        return new React<>(t);
    }

    public static <T> React<T> of(final Promise<T> t) {
        return of(t.getFuture());
    }

    public <U> React<U> then(final Do<T, U> doNext) {
        return then(doNext.get());
    }

    public <U> React<U> then(final Function<T, U> function) {
        return thenCF(t -> supplyAsync(() -> function.apply(t)));
    }

    public React<T> thenV(final Consumer<T> function) {
        return then(t -> {
            function.accept(t);
            return t;
        });
    }

    public React<Void> thenVoid(final Consumer<T> function) {
        return then(t -> {
            function.accept(t);
            return null;
        });
    }

    public <U> React<U> thenCF(final Function<T, CompletableFuture<U>> function) {
        return new React<>(completableFuture.thenCompose(t -> function.apply(t)));
    }

    public <U> React<U> thenR(final Function<T, React<U>> function) {
        return thenCF(t -> function.apply(t).get());
    }

    public <U> React<U> thenP(final Function<T, Promise<U>> function) {
        return thenCF(t -> function.apply(t).getFuture());
    }


    public CompletableFuture<T> get() {
        return completableFuture;
    }

    public Promise<T> getPromise() {
        return Promise.of(completableFuture);
    }

}
