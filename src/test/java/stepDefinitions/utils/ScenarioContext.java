package stepDefinitions.utils;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private final ThreadLocal<Map<String, Object>> scenarioContext;

    public ScenarioContext() {
        scenarioContext = ThreadLocal.withInitial(HashMap::new);
    }

    public Object getContext(String key) {
        return scenarioContext.get().get(key);
    }

    public void setContext(String key, Object value) {
        this.scenarioContext.get().put(key, value);
    }
}
