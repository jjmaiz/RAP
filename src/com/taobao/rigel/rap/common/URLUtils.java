package com.taobao.rigel.rap.common;

/**
 * Created by mashengbo on 14-9-5.
 */
public class URLUtils {
    public static boolean isStaticUrl(String url) {
        if (url == null) {
            return false;
        }
        String [] extentions = new String[] {
                ".jpg", ".png", ".gif",
                ".js", ".css", ".font", ".woff"
        };
        for (String ex : extentions) {
            if (url.contains(ex)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isLogUrl(String url) {
        if (url == null) {
            return false;
        }
        String [] keys = new String[] {
                "logData.action", "getUnreadNotificationList.action"
        };
        for (String key : keys) {
            if (url.contains(key)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMockServiceUrl(String url) {
        if (url == null) {
            return false;
        }
        String [] keys = new String[] {
                "/mockjs/", "/mock/", "/mockjsdata/"
        };
        for (String key : keys) {
            if (url.contains(key)) {
                return true;
            }
        }
        return false;
    }

    public static boolean shouldLog(String url) {
        return !(isStaticUrl(url) || isLogUrl(url));
    }

    public static boolean isRelativeUrlExactlyMatch(String url1, String url2) {
        if (url1 == url2) return true;
        if (url1 == null || url2 == null) return false;
        return getRelativeUrl(url1).equals(getRelativeUrl(url2));
    }

    private static String getRelativeUrl(String url) {
        if (url == null || url.isEmpty()) {
            return "";
        }
        if (url.contains("https://")) {
            url = url.substring(url.indexOf("/", 7));
        } else if (url.contains("http://")) {
            url = url.substring(url.indexOf("/", 8));
        }
        if (url.contains("?")) {
            url = url.substring(0, url.indexOf("?"));
        }
        if (url.charAt(0) != '/') {
            url = '/' + url;

        }
        return url;
    }
}
