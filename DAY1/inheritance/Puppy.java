package DAY1.inheritance;

public class Puppy extends Dog {
    void weep(){
        System.out.println("Puppy weep");
    }

    public static void main(String[] args) {
        Puppy pup = new Puppy();
        pup.weep();
        pup.bark();
        pup.eat();
    }
}
