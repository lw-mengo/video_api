package com.mengo.api.video.utils;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class CommonResult {
    private static final String STATUS = "status";
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private static final String FAIL = "fail";

    public static String success() {
        Map<String, String> map = new HashMap<>();
        map.put(STATUS, SUCCESS);
        String result = new Gson().toJson(map);
        return result;
    }

    public static String error() {
        Map<String, String> map = new HashMap<>();
        map.put(STATUS, ERROR);
        String result = new Gson().toJson(map);
        return result;
    }

    public static String fail() {
        Map<String, String> map = new HashMap<>();
        map.put(STATUS, FAIL);
        String result = new Gson().toJson(map);
        return result;
    }
}
