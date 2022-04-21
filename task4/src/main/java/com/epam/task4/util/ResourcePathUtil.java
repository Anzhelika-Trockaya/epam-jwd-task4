package com.epam.task4.util;

import com.epam.task4.exception.TextParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;

public class ResourcePathUtil {
    private static final Logger LOGGER = LogManager.getLogger();

    public static String getResourcePath(String resourceName) throws TextParseException {
        final int pathStartPosition = 6;
        ClassLoader loader = ResourcePathUtil.class.getClassLoader();
        URL resource = loader.getResource(resourceName);
        if (resource == null) {
            LOGGER.error("Resource " + resourceName + " is not found");
            throw new TextParseException("Resource " + resourceName + " is not found");
        }
        return resource.toString().substring(pathStartPosition);
    }
}
