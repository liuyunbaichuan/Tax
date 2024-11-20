package org.example.utils;

public class ThreadLocalUtil {

    private static final ThreadLocal threadLocal = new ThreadLocal<>();

    public static<T> T get() {
        return (T) threadLocal.get();
    }
    public static void set(Object value) {
        threadLocal.set(value);
    }

    //清楚ThreadLocal里面的信息  防止内存泄露
    public static void remove() {
        threadLocal.remove();
    }
}
