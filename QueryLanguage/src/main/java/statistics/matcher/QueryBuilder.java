package statistics;

import statistics.matcher.*;

public class QueryBuilder {

    private Matcher matcher;

    public QueryBuilder() {
        matcher = new All();
    }    

       

    public QueryBuilder playsIn(String fieldName) {
        this.matcher = new And(matcher, new PlaysIn(fieldName));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String fieldName) {
        this.matcher = new And(matcher, new HasAtLeast(value, fieldName));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String fieldName) {
        this.matcher = new And(matcher, new HasFewerThan(value, fieldName));
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        this.matcher = new Or(matchers);
        return this;
    } 
       
    public Matcher build() {
        Matcher ready = this.matcher;
        this.matcher = new All();
        return ready;
    }     

}