package com.alibaba.nacos.plugin.datasource.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 2024/12/3
 *
 * @author zhangdp
 * @since
 */
public enum TrustedPostgresqlFunctionEnum {

    NOW("NOW()", "CURRENT_TIMESTAMP");

    private static final Map<String, TrustedPostgresqlFunctionEnum> LOOKUP_MAP = new HashMap<>();

    static {
        for (TrustedPostgresqlFunctionEnum entry : TrustedPostgresqlFunctionEnum.values()) {
            LOOKUP_MAP.put(entry.functionName, entry);
        }
    }

    private final String functionName;

    private final String function;

    TrustedPostgresqlFunctionEnum(String functionName, String function) {
        this.functionName = functionName;
        this.function = function;
    }

    /**
     * Get the function name.
     *
     * @param functionName function name
     * @return function
     */
    public static String getFunctionByName(String functionName) {
        TrustedPostgresqlFunctionEnum entry = LOOKUP_MAP.get(functionName.toUpperCase());
        if (entry != null) {
            return entry.function;
        }
        throw new IllegalArgumentException(String.format("Invalid function name: %s", functionName));
    }

}
