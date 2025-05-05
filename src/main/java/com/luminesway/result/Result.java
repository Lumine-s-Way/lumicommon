package com.luminesway.result;


public record Result<T>(T value, String message, boolean success) {
    public static <T> Result<T> success(T value) {
        return new Result<>(value, null, true);
    }

    public static <T> Result<T> fail(String message) {
        return new Result<>(null, message, false);
    }

    public boolean isFailure() {
        return !success;
    }

    public T getValue() {
        if (!success) throw new IllegalStateException("No se puede obtener valor de un resultado fallido");
        return value;
    }

    public String getError() {
        if (success) throw new IllegalStateException("No se puede obtener error de un resultado exitoso");
        return message();
    }
}
