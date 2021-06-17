package com.datasirpi.contacts.utils;

import java.time.Instant;
import java.util.Date;

public class AppUtils {

    public static Date getInstant() {
        return Date.from(Instant.now());
    }
}
