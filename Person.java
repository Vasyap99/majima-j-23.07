public class Person {
    private String name;
    private int age;
    private String city;

    // Конструкторы, геттеры и сеттеры
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getCity(){
        return city;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setCity(String city){
        this.city=city;
    }

    public Person(){}

    public Person(String name,int age,String city){
        this.name=name;
        this.age=age;
        this.city=city;
    }

    public String toString(){
        return String.format("<Person: %s %d %s>", getName(),getAge(),getCity());
    }
}