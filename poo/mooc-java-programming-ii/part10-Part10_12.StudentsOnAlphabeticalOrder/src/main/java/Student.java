public class Student implements Comparable<Student>{

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int compareTo(Student obj){
        int comparison = this.name.compareTo(obj.getName());

        if(comparison == 0){
            return 0;
        }else if(comparison > 0){
            return 1;
        }else{
            return -1;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
