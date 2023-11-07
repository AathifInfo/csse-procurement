package com.csse.order.common;

public class StatusCode {

    public static final int OK = 200;
    public static final int CREATED = 201;
    public static final int ACCEPTED = 202;
    public static final int NO_CONTENT = 204;
    public static final int RESET_CONTENT = 205;
    public static final int BAD_REQUEST = 400;
    public static final int UNAUTHORIZED = 401;
    public static final int NOT_FOUND = 404;
    public static final int METHOD_NOT_ALLOWED = 405;
    public static final int NOT_ACCEPTABLE = 406;
    public static final int REQUEST_TIMEOUT = 408;
    public static final int CONFLICT = 409;
    public static final int PAYLOAD_TOO_LARGE = 413;
    public static final int URL_TOO_LONG = 414;
    public static final int UNSUPPORTED_MEDIA_TYPE = 415;
    public static final int RANGE_NOT_SATISFIABLE = 416;
    public static final int EXPECTATION_FAILED = 417;
    public static final int TOO_MANY_REQUEST = 429;
    public static final int INTERNAL_SERVER_ERROR = 500;
    public static final int NOT_IMPLEMENTED = 501;
    public static final int BAD_GATEWAY = 502;

    private StatusCode() {
        throw new IllegalStateException("Utility class");
    }

}
