package com.cognyte.infrastarter;

import org.springframework.beans.factory.annotation.Autowired;

// Avoid @Component when creating starters, We do not want to effect foreign scanning process
public class CognyteLogger {

    @Autowired
    private InfraProperties infraProperties;

//    private boolean info;

    public void info(String str) {
        if(infraProperties.isInfo()) {
            System.out.println("Cognyte Info: " + str);
        }
    }
    public void debug(String str) {
        if(infraProperties.isDebug()) {
            System.out.println("Cognyte Debug: " + str);
        }
    }
}
