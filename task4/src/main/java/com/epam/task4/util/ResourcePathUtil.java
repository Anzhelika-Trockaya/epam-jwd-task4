package com.epam.task4.util;

import com.epam.task4.exception.TextParseException;

import java.net.URL;

public class ResourcePathUtil {
    public static String getResourcePath(String resourceName) throws TextParseException {
        final int pathStartPosition = 6;
        ClassLoader loader = ResourcePathUtil.class.getClassLoader();
        URL resource = loader.getResource(resourceName);
        if (resource == null) {//todo ??? log
            throw new TextParseException("Resource " + resourceName + " is not found");
        }
        return resource.toString().substring(pathStartPosition);
    }
}
