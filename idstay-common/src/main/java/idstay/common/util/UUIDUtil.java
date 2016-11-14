package idstay.common.util;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 11. 5.
 */

import java.util.UUID;

public class UUIDUtil {
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
}
