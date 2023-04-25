package org.sd.rmi.methodInvocation;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author orlando
 */
public class PersonHolder {
    
    private Map<String, Person> state = new HashMap<>();
    
    public PersonHolder(){
        this.state.put("1", new Person(1L, "Orlando", "Patriarcha", "mydocument", new Date()));
        this.state.put("2", new Person(2L, "Josefina", "Silva", "23481772653", new Date()));
        this.state.put("3", new Person(3L, "El Toro", "Muchacho", "MEXDOC", new Date()));
        this.state.put("4", new Person(4L, "Tiazinha", "Silva", "32398273627", new Date()));
    }
    
    public Map<String, Person> getState(){
        return this.state;
    }
    
    public Person retrievePerson( final String key ){
        if( this.state.containsKey(key))
            return this.state.get(key);
        return null;
    }
}
