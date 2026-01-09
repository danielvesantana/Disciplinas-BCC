public class Person {
    private String name;
    private Education edu;

    public Person(String name, Education edu){
        this.name = name;
        this.edu = edu;
    }

    public Education getEducation(){
        return edu;
    }

    @Override
    public String toString(){
        return name + ", " + edu;
    }
}
