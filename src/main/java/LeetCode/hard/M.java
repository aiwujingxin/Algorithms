package LeetCode.hard;

import java.util.HashSet;


/**
 * @author jingxinwu
 * @date 2022-03-16 15:04
 */
public class M {

    public static void main(String[] args) {
        HashSet<Person> set = new HashSet<>();
        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1002, "BB");
        set.add(p1);
        set.add(p2);
        System.out.println(set);

        for (Person p : set) {
            System.out.println(p.name + p.hashCode());
        }

        p1.setName("CC");
        set.remove(p1);
        System.out.println(set);

        for (Person p : set) {
            System.out.println(p.name + p.hashCode());
        }

        set.add(new Person(1001, "CC"));
        System.out.println(set);


        for (Person p : set) {
            System.out.println(p.name + p.hashCode());
        }

        set.add(new Person(1001, "AA"));
        System.out.println(set);
    }

    static class Person {

        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Person)) {
                return false;
            }

            Person person = (Person) o;

            if (id != person.id) {
                return false;
            }
            return name != null ? name.equals(person.name) : person.name == null;

        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

}
