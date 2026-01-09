import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees {
    private ArrayList<Person> employees;

    public Employees(){
        this.employees = new ArrayList<>();
    }

    public void add(Person personToAdd){
        this.employees.add(personToAdd);
    }

    public void add(List<Person> peopleToAdd){
        peopleToAdd.stream()
            .forEach(people -> employees.add(people));
    }

    public void fire(Education education){
        Iterator<Person> iterator = employees.iterator();

        while(iterator.hasNext()){
            if(iterator.next().getEducation() == education){
                iterator.remove();
            }
        }
    }

    public void print(){
        Iterator<Person> iterator = employees.iterator();
        
        iterator.forEachRemaining(employee -> System.out.println(employee.toString()));
    }

    public void print(Education education){
        Iterator<Person> iterator = employees.iterator();

        while(iterator.hasNext()){
            Person person = iterator.next();

            if(person.getEducation() == education){
                System.out.println(person.toString());
            }
        }
    }
}
