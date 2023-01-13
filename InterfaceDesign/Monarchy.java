package InterfaceDesign;

import java.util.ArrayList;
import java.util.HashMap;

public class Monarchy {
    public static void main(String[] args) {
        Tree obj = new Tree("Aditya");
        obj.birth("Riya", "Aditya");
        obj.birth("Lea", "Riya");
        obj.death("Riya");
        System.out.println(obj.gos());
    }
}

class Tree {
    Person king;
    HashMap<String, Person> map;

    Tree(String k) {
        king = new Person(k);
        map = new HashMap<>();
        map.put(king.name, king);
    }

    public void birth(String child, String parent) {
        Person par = map.get(parent);
        Person chi = new Person(child);
        par.children.add(chi);
        map.put(child, chi);
    }

    public String death(String dead) {
        Person dying = map.get(dead);
        if (dying.isAlive == false) {
            return "Person already dead";
        } else {
            dying.isAlive = false;
            return dying.name;
        }
    }

    public ArrayList<String> gos() {
        ArrayList<String> res = new ArrayList<>();
        dfs(res, king);
        return res;
    }

    public void dfs(ArrayList<String> res, Person curNode) {
        if (curNode.isAlive == true) {
            res.add(curNode.name);
        }
        ArrayList<Person> c = curNode.children;
        for (int i = 0; i < c.size(); i++) {
            dfs(res, c.get(i));
        }
        return;
    }
}

class Person {
    String name;
    boolean isAlive;
    ArrayList<Person> children;

    Person(String name) {
        this.name = name;
        isAlive = true;
        children = new ArrayList<>();
    }
}
