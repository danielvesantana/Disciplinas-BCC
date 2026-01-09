public class Book {
    private String name;
    private int age;

    public Book(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }
    
    public int getAge(){
        return age;
    }
    
    public int compareTo(Book book){
        if(this.age == book.getAge()){
            return this.name.compareTo(book.getName());
        }else if(this.age > book.getAge()){
            return 1;
        }else{
            return -1;
        }
    }
}
