package com.luminesway.result;


public class ActionResultResponse {
    public static <T> T get(ActionResult<T> result) {
        if (result.isFailure()) {
            return result.getError();
        }

        return result.getValue();
    }
}
