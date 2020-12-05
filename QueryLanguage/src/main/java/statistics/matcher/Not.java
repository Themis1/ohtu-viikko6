package statistics.matcher;

import java.lang.reflect.Method;
import statistics.Player;

public class Not implements Matcher {
    
    // private int value;
    private Matcher matcher;

    public Not(Matcher matcher) {
        this.matcher=matcher;
    }

    @Override
    public boolean matches(Player p) {
        if (matcher.matches(p)) {
            return false;
        } else {
            return true;
        }
        
    }    
    
}
