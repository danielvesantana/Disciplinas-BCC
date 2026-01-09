import java.util.ArrayList;

public class GradeStatistics {
    public ArrayList<Integer> points;

    public GradeStatistics(){
        this.points = new ArrayList<>();
    }

    public void add(int value){
        if(value >= 0 && value <= 100){
            this.points.add(value);
        }
    }

    public String pointAverages(){
        double average;

        if(points.isEmpty()){
            average = 0.0;
        }else{
            int sum = 0;
    
            for(Integer x : points){
                sum += x;
            }
    
            average = (1.0 * sum) / this.points.size();
        }

        return "Point average (all): " + average;
    }

    public String passingGrade(){
        int sum = 0;
        int count = 0;
        double average;

        if(points.isEmpty()){
            average = 0.0;
        }else{
            for(Integer x : points){
                if(x >= 50){
                    sum += x;
                    count++;
                }
            }
    
            average = (1.0 * sum) / count;
        }

        return "Point average (passing): " + average;
    }

    public String passPercentage(){
        int count = 0;
        double percentage;

        if(points.isEmpty()){
            percentage = 0.0;
        }else{
            for(Integer x : points){
                if(x >= 50){
                    count++;
                }
            }
    
            percentage = (100.0 * count) / points.size();
        }

        return "Pass percentage: " + percentage;
    }

    public String gradeDistribution(){
        String distribution = "";
        int[] grade = new int[6];

        for(Integer point : points){
            if(point < 50){
                grade[0]++;
            }else if(point < 60){
                grade[1]++;
            }else if(point < 70){
                grade[2]++;
            }else if(point < 80){
                grade[3]++;
            }else if(point < 90){
                grade[4]++;
            }else{
                grade[5]++;
            }
        }
        distribution = printFormat(grade);

        return distribution;
    }

    public String printFormat(int[] grade){
        String distribution = "";

        for(int i = grade.length - 1; i >= 0; i--){
            distribution += (i + ": " + "*".repeat(grade[i]) + "\n");
        }

        return distribution;
    }
}
