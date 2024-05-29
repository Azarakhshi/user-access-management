package com.amin.config;

/**
 * <p>Defaults interface.</p>
 */

@SuppressWarnings("java:S2386")
public interface Defaults {


    interface cache {

        interface redis {

            String[] server = {"redis://localhost:6379"};
            int expiration = 300;
            boolean cluster = false;
            int connectionPoolSize = 64;
            int connectionMinimumIdSize = 5000;
            int subScriptConnectionPoolSize = 5000;
            int subScriptConnectionMinimumIdSize = 5000;

        }

        interface Ehcache {

            int timeToLiveSeconds = 3600;

            long maxEntries = 3600;

        }

    }

}
