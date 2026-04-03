package org;
import java.util.*;

public class Path {
    private List<String> nodes;

    public Path(List<String> nodes){
        this.nodes = nodes;
    }

    public List<String> getNodes(){
        return nodes;
    }

    public String toString(){
        return String.join(" -> ", nodes);
    }
}
