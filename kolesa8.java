import java.util.LinkedList;
import java.util.List;


public class Client {

    public static void main(String[] args) {
        List<Cat> cats = new LinkedList<>();
        cats.add(new MaineCoonCat());
        cats.add(new MunchkinCat());
        cats.add(new PiggyBankCat());
        cats.add(new ToyCat());

        for (Cat cat : cats) {
            cat.display();
            cat.purr();
            cat.meow();
            cat.jump();
            System.out.println();
        }
    }
}

abstract class  Cat {
    
    abstract void display();//as all types of cat has its own implementation it is abstract method with no return

    public void purr() {
        System.out.println("This cat can purr, mrrrrr...");
    }

    public void meow() {
        System.out.println("Does this cat meow? - Meow!");
    }

    public void jump() {
        System.out.println("How does this cat jump? - Jumps high");
    }
} 


class MaineCoonCat extends Cat {

    @Override
    public void display() {
        //its own display implementation 

        System.out.println("Maine coon cat is displayed, it is very big");
    }
    
    @Override
    public void purr() {
       
        System.out.println("This cat can purr, mrrrrr..."");
    }
    
    @Override
    public void meow() {
       

        System.out.println("Does this cat meow? - Meow!");
    }
    
    @Override
    public void jump() {
       

        System.out.println("How does this cat jump? - Jumps high");
    }
}


class MunchkinCat extends Cat {

    @Override
    public void display() {
        //its own display implementation

        System.out.println("Munchkin cat is displayed, he has small paws");
    }
    
     @Override
    public void purr() {
       
        System.out.println("This cat can purr, mrrrrr..."");
    }
    
    @Override
    public void meow() {
       

        System.out.println("Does this cat meow? - Meow!");
    }

    @Override
    public void jump() {
        //its own jump implementation

        System.out.println("How does this cat jump? - Jumps high");
    }
}


class PiggyBankCat extends Cat {

    @Override
    public void display() {
        //its own display implementation

        System.out.println("Piggy bank cat is displayed, it can keep money");
    }

    @Override
    public void purr() {
      
        System.out.println("This cat does not purr!");
    }

    @Override
    public void meow() {

        System.out.println("This cat does not mew!");
    }

    @Override
    public void jump() {
       

        System.out.println("This cat does not jump!");
    }
}


class ToyCat extends Cat {

    public void display() {
        //its own display implementation

        System.out.println("Toy cat is displayed, it is soft");
    }
    
  

    @Override
    public void purr() {
       

        System.out.println("This cat does not purr!");
    }

    @Override
    public void meow() {
        
        System.out.println("Meow!");
    }


    @Override
    public void jump() {
      
        System.out.println("This cat does not jump!");
    }
}
