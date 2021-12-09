package com.github.wnebyte.jargs.util;

public class Objects {

    public static boolean isNull(Object... objects) {
        if (objects == null) {
            return true;
        }
        for (Object o : objects) {
            if (o == null) {
                return true;
            }
        }
        return false;
    }
}
