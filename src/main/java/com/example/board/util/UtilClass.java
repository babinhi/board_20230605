package com.example.board.util;

import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UtilClass {
    public static String dateFormat(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        } else {
            return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
    }
}
