package com.brianway.learning.java.base.loadProperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 本地加载配置文件
 */
public class FilterManager {

    private static Logger logger = LoggerFactory.getLogger(FilterManager.class);

    private static final ConcurrentHashMap<String, String> aliasMap = new ConcurrentHashMap<String, String>(16, 0.75f, 1);

    static {
        try {
            Properties filterProperties = loadFilterConfig();
            for (Map.Entry<Object, Object> entry : filterProperties.entrySet()) {
                String key = (String) entry.getKey();
                if (key.startsWith("druid.filters.")) {
                    String name = key.substring("druid.filters.".length());
                    aliasMap.put(name, (String) entry.getValue());
                }
            }
        } catch (Throwable e) {
            logger.error("load filter config error", e);
        }
    }


    public static final String getFilter(String alias) {
        if (alias == null) {
            return null;
        }

        String filter = aliasMap.get(alias);

        if (filter == null && alias.length() < 128) {
            filter = alias;
        }

        return filter;
    }


    public static Properties loadFilterConfig() throws IOException {
        Properties filterProperties = new Properties();
        loadFilterConfig(filterProperties, Thread.currentThread().getContextClassLoader());
        return filterProperties;

    }

    private static void loadFilterConfig(Properties filterProperties, ClassLoader classLoader) throws IOException {
        if (classLoader == null) {
            return;
        }
        for (Enumeration<URL> e = classLoader.getResources("druid-filter.properties"); e.hasMoreElements(); ) {
            URL url = e.nextElement();
            Properties property = new Properties();
            InputStream is = null;
            try {
                is = url.openStream();
                property.load(is);
            } finally {
                close(is);
            }

            filterProperties.putAll(property);
        }
    }

    public static void close(Closeable x) {
        if (x == null) {
            return;
        }
        try {
            x.close();
        } catch (Exception e) {
            logger.debug("close error", e);
        }
    }


}
