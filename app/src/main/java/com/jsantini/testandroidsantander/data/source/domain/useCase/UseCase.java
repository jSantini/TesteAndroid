package com.jsantini.testandroidsantander.data.source.domain.useCase;

import retrofit2.Response;

/**
 * Created by jsantini on 21/04/18.
 */

public class UseCase {

    public interface UseCaseCallback<R> {
        void onSuccess(Response response);
        void onError();
        void onGenericError();
        void onConnectionError();
    }
}
