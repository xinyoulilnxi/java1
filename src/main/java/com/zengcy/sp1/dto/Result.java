package com.zengcy.sp1.dto;

import java.io.Serializable;
import com.zengcy.sp1.enums.ResponseStatusEnum;
import lombok.Builder;
import lombok.Data;

/**
 * @author zengcy 2023-05-24
 */
@Data
@Builder
public class Result<T> {
    /**
     * response timestamp.
     */
    private long timestamp;

    /**
     * response code, 200 -> OK.
     */
    private String status;

    /**
     * response message.
     */
    private String message;

    /**
     * response data.
     */
    private T data;

    /**
     * response success result wrapper.
     *
     * @param <T> type of data class
     * @return response result
     */
    public static <T> Result<T> success() {
        return success(null);
    }

    /**
     * response success result wrapper.
     *
     * @param data response data
     * @param <T>  type of data class
     * @return response result
     */
    public static <T> Result<T> success(T data) {
        return Result.<T>builder().data(data)
                .message(ResponseStatusEnum.SUCCESS.getDescription())
                .status(ResponseStatusEnum.SUCCESS.getResponseCode())
                .timestamp(System.currentTimeMillis())
                .build();
    }

    /**
     * response error result wrapper.
     *
     * @param message error message
     * @param <T>     type of data class
     * @return response result
     */
    public static <T extends Serializable> Result<T> fail(String message) {
        return fail(null, message);
    }

    /**
     * response error result wrapper.
     *
     * @param data    response data
     * @param message error message
     * @param <T>     type of data class
     * @return response result
     */
    public static <T> Result<T> fail(T data, String message) {
        return Result.<T>builder().data(data)
                .message(message)
                .status(ResponseStatusEnum.FAIL.getResponseCode())
                .timestamp(System.currentTimeMillis())
                .build();
    }


}
