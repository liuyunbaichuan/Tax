package org.example.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private List<T> data;

    public static Result success() {
        return new Result(200, "success", null);
    }
    public static<T> Result<T> success(List<T> data) {
        return new Result(200, "success", data);
    }
    public static Result error(String message) {
        return new Result(500, message, null);
    }
    public static Result success(String message) {
        return new Result(200, message, null);
    }

}
