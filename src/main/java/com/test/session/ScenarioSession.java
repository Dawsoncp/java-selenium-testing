package com.test.session;


import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;


@Component
public class ScenarioSession {

    private Map<String, Object> sessionData = new HashMap<String, Object>();

    public void putData(String key, Object value) {
        sessionData.put(key, value);
    }

    public Object getData(String key) {
        return sessionData.get(key);
    }

    public void clearSessionData(){
        sessionData.clear();
    }
}
