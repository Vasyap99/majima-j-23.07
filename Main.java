
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

import java.util.Optional;

import java.util.stream.Collectors;


class AgeCounter{
    static int number=0;
    int age;
    AgeCounter(int age){
        this.age=age;
        number++;
    }
    public String toString(){return String.format("<AgeCounter: %d %d>",age,number);}
}

public class Main{
    public static void main(String[]s){
        LinkedList<Person> l=new LinkedList<>();
        l.addAll(Arrays.asList(new Person[]{
            new Person("Vasya Pupkin",35,"SPb"),
            new Person("Ivan Sergeev",12,"VN"),
            new Person("Petr Ivanov",8,"Moscow"),
            new Person("Evgenij Sidorov",19,"London"),
            new Person("Maxim Dmitriev",45,"New York"),
            new Person("Anna Voronina",34,"New York")
        }));

        System.out.println(l);

        //1.
        List<String> nl= l.stream().filter( p -> p.getAge()>18 ).map( Person::getName ).sorted().collect(Collectors.toList());
        System.out.println(nl);

        //2.1.
        System.out.println(  l.stream().filter( p -> p.getAge()>30 ).count()  );

        //2.2.
        Optional<Person> o=l.stream().max( (p1,p2) -> {if(p1.getAge()>p2.getAge()) return 1; else if(p1.getAge()<p2.getAge()) return -1; else return 0;} );
        o.ifPresentOrElse( p -> {System.out.println(p);}, ()->{System.out.println("not found!");})  ;

        //2.3.
        double v  = l.stream().filter( p -> p.getCity().equals("New York") ).map( p -> new AgeCounter(p.getAge()) ).collect(Collectors.toList()).stream() .peek( System.out::println )  .map( c -> 1.0*c.age/AgeCounter.number ) .reduce( (a,b) -> a+b ) .orElse(0.0);
        System.out.println(v);
/**/


    }
}