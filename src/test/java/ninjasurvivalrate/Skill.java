package ninjasurvivalrate;

import java.util.HashMap;
import java.util.Map;

public class Skill {

    private String name;
    
    private static final Map<String, String> samurai;
    private static final Map<String, String> chuck;

    static {
        samurai = new HashMap<String, String>();
        samurai.put("katana", "high");
        samurai.put("karate-kick", "low");

        chuck = new HashMap<String, String>();
        chuck.put("katana", "extreme");
        chuck.put("karate-kick", "extreme");
        chuck.put("roundhouse-kick", "extreme");

    }

    public Skill(String skill) {
        skill = name;
    }

    public String getName() {
        return name;
    }

    public boolean availableTo(String opponent) {
        Map<String, String> map;
        if ("Chuck Norris".equals(opponent)){
          map = chuck;  
        } else {
            map = samurai;
        }
        return map.containsKey(getName());
    }

    public String getDanger(String opponent) {
        Map<String, String> map;
        if ("Chuck Norris".equals(opponent)){
          map = chuck;  
        } else {
            map = samurai;
        }
        return map.get(getName());
    }
}
