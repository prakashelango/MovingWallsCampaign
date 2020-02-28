package com.base.movingwalls.common.core;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface TwoTrack<T> {

    static <T> TwoTrack<T> of(final T val) {
        return new SuccessTrack<>(val);
    }

    static <T> TwoTrack<T> ofNullable(final T val) {
        return Optional.ofNullable(val)
                .map(TwoTrack::of)
                .orElseGet(
                        () -> TwoTrack.of(new ErrorCodeAndParam(ErrorCode.NOT_FOUND)));
    }

    static <T> TwoTrack<T> ofNullable(final T val, final Predicate<T> filter) {
        return Optional.ofNullable(val)
                .filter(filter)
                .map(TwoTrack::of)
                .orElseGet(
                        () -> TwoTrack.of(new ErrorCodeAndParam(ErrorCode.NOT_FOUND)));
    }

    static <T> TwoTrack<T> of(final ErrorCodeAndParam error) {
        return new FailureTrack<>(error);
    }

    T get();

    ErrorCodeAndParam getErrorCode();

    boolean isSuccess();

    <R> TwoTrack<R> map(Function<T, R> function);

    <R> TwoTrack<R> flatMap(final Function<T, TwoTrack<R>> function);

    default <R> Function<TwoTrack<T>, TwoTrack<R>> asTwoTrack(final Function<T, R> function) {
        return t -> t.map(function);
    }


    void onSuccess(Consumer<T> success);

    void onFailure(Consumer<ErrorCodeAndParam> failure);

    default T get(final Function<ErrorCodeAndParam, T> errorConverter) {
        return Optional.ofNullable(get()).orElseGet(() -> errorConverter.apply(getErrorCode()));
    }

    class SuccessTrack<T> implements TwoTrack<T> {

        private final T val;

        private SuccessTrack(final T val) {
            this.val = val;
        }

        @Override
        public T get() {
            return val;
        }

        @Override
        public ErrorCodeAndParam getErrorCode() {
            return null;
        }

        @Override
        public boolean isSuccess() {
            return true;
        }

        @Override
        public <R> TwoTrack<R> map(final Function<T, R> function) {
            return TwoTrack.of(function.apply(get()));
        }

        @Override
        public <R> TwoTrack<R> flatMap(final Function<T, TwoTrack<R>> function) {
            return function.apply(val);
        }

        @Override
        public void onSuccess(final Consumer<T> success) {
            success.accept(val);
        }

        @Override
        public void onFailure(final Consumer<ErrorCodeAndParam> success) {

        }


    }

    class FailureTrack<T> implements TwoTrack<T> {

        private final ErrorCodeAndParam errorCode;

        private FailureTrack(final ErrorCodeAndParam errorCode) {
            this.errorCode = errorCode;
        }

        @Override
        public T get() {
            return null;
        }

        @Override
        public ErrorCodeAndParam getErrorCode() {
            return errorCode;
        }

        @Override
        public boolean isSuccess() {
            return false;
        }

        @Override
        public <R> TwoTrack<R> map(final Function<T, R> function) {
            return TwoTrack.of(errorCode);
        }

        @Override
        public <R> TwoTrack<R> flatMap(final Function<T, TwoTrack<R>> function) {
            return TwoTrack.of(errorCode);
        }

        @Override
        public void onSuccess(final Consumer<T> success) {

        }

        @Override
        public void onFailure(final Consumer<ErrorCodeAndParam> failure) {
            failure.accept(errorCode);
        }
    }


}
