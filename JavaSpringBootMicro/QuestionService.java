import java.util.Scanner;

public class QuestionService {
    Question[] listQuestions = new Question[5];
    String selections[] = new String[5];
    

    public QuestionService() {
        listQuestions[0] = new Question(1,"Qus1","1opt1","1opt2","1opt4","1opt5","ans1");
        listQuestions[1] = new Question(2,"Qus2","2opt1","2opt2","2opt4","2opt5","ans2");
        listQuestions[2] = new Question(3,"Qus3","3opt1","3opt2","3opt4","3opt5","ans3");
        listQuestions[3] = new Question(4,"Qus4","4opt1","4opt2","4opt4","4opt5","ans4");
        listQuestions[4] = new Question(5,"Qus5","5opt1","5opt2","5opt4","5opt5","ans5");
    }



    public void displayQuestion(){
        int i=0;
        for(Question qus:listQuestions){
            System.out.println(qus.getId());
            System.out.println(qus.getQuestion());
            System.out.println(qus.getOpt1());
            System.out.println(qus.getOpt2());
            System.out.println(qus.getOpt3());
            System.out.println(qus.getOpt4());
            Scanner sc = new Scanner(System.in);
            selections[i] = sc.nextLine();
            i++;
        }        
    }

    public void printScore(){
        int score = 0;
        for(int i=0; i<listQuestions.length; i++){
            String actualAnswer = listQuestions[i].getAns();
            String userAnswer = selections[i];
            if (actualAnswer.equals(userAnswer)) {
                score++;
            }
        }
        System.out.println("Your Score : ans"+score);
    }
}
