package com.acme.catchup.platform.platform.shared.application.result;

import com.sun.net.httpserver.Authenticator;

public sealed interface Result<T, E> permits Result.Success, Result.Failure {

    static <T, E> Result<T, E> success(T value) {
        return new Success<>(value);
    }

    static <T, E> Result<T, E> failure(E error) {
        return new Failure<>(error);
    }

    default boolean isSuccess() {
        return this instanceof Success;
    }

    default boolean isFailure() {
        return this instanceof Failure;
    }

    default Optional<E> failure() {
        if (this instanceof Failure<T, E> failure) {
            E error =
            return Optional.of(failure.error());
        }
        return Optional.empty();
    }
    record Success<T, E>(T value) implements Result<T, E> { }
    record Failure<T, E>(E error) implements Result<T, E> { }

}
