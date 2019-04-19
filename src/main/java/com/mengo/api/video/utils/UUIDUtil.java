package com.mengo.api.video.utils;

import java.util.UUID;

public class UUIDUtil {

    public static String getBid() {
        String[] bids = UUID.randomUUID()
                .toString()
                .split("-");
        String bid = bids[0];
        return bid;
    }
}
