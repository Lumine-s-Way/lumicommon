package com.luminesway.result;


public record ActionResult<T>(T value, String message, boolean success, int statusCode) {
    public static <T> ActionResult<T> success(String message, T value, int statusCode) {
        return new ActionResult<>(value, message, true, statusCode);
    }

    public static <T> ActionResult<T> fail(String message, int statusCode) {
        return new ActionResult<>(null, message, false, statusCode);
    }

    public boolean isFailure() {
        return !success;
    }

    public T getValue() {
        if (!success) throw new IllegalStateException("No se puede obtener valor de un resultado fallido");
        return value;
    }

    public T getError() {
        if (success) throw new IllegalStateException("No se puede obtener error de un resultado exitoso");
        return null;
    }
}
