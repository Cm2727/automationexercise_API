package test_data;

import java.util.HashMap;
import java.util.Map;

public class AutomationExerciseTestData {

    public Map<String, Object> userdate(String name, String email, String title) {

        Map<String, Object> user= new HashMap<>();
        user.put("name", name);
        user.put("email", email);
        user.put("title", title);

        return user;
    }

    public Map<String, Object> expectedDateMap(Object responseCode, Map<String, Object> user) {

        Map<String, Object> expectedDate = new HashMap<>();
        expectedDate.put("responseCode", responseCode);
        expectedDate.put("user", user);

        return expectedDate;
    }

}
