package com.pamsdev.moviecatalogue.data.source.remote;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static com.pamsdev.moviecatalogue.data.source.remote.StatusResponse.EMPTY;
import static com.pamsdev.moviecatalogue.data.source.remote.StatusResponse.ERROR;
import static com.pamsdev.moviecatalogue.data.source.remote.StatusResponse.SUCCESS;

public class ApiResponse<T> {
    @NonNull
    public final StatusResponse status;
    @Nullable
    public final T data;
    @Nullable
    public final String message;

    private ApiResponse(@NonNull StatusResponse status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> ApiResponse<T> success(@NonNull T data) {
        return new ApiResponse<>(SUCCESS, data, null);
    }

    public static <T> ApiResponse<T> error(String msg, @Nullable T data) {
        return new ApiResponse<>(ERROR, data, msg);
    }

    public static <T> ApiResponse<T> empty(@Nullable T data) {
        return new ApiResponse<>(EMPTY, data, null);
    }
}
