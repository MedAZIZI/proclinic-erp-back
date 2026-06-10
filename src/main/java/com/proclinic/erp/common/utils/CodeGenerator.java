package com.proclinic.erp.common.utils;

import java.time.LocalDate;
import java.util.UUID;

public class CodeGenerator {

    public static String generate(String prefix) {
        return prefix + "-" +
                LocalDate.now().getYear() + "-" +
                UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
