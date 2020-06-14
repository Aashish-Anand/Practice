package javaConcept;

import java.util.HashMap;

class Human {
    int uid;
    String name;

    Human(int uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human is Id : "+uid + " and name is : "+name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime*result + uid;
        result = prime*result + ((name==null)?0:name.hashCode());
        return result;

    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null) {
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        Human h = (Human) obj;
        if(uid != h.uid){
            return false;
        }
        if(!name.equals(h.name)){
            return false;
        }

        return true;
    }
}
public class HashCodeAndEqual {
    public static void main(String[] args) {
        new HashCodeAndEqual().run();
    }

    private void run() {

        HashMap<Human, Integer> hash = new HashMap<>();

        Human key = new Human(134, "Aashish");
        hash.put(key, 8860);

        System.out.println(key.hashCode());
        Human newHu = new Human(134, "Aashish");

        System.out.println(newHu.hashCode());
        System.out.println(hash.get(newHu));

    }
}
