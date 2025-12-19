import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class QuizApplication
{
    String questions,answers;

    void read(Path filePath)
    {
        if (!Files.exists(filePath))
            {
                System.out.println("File does not exist.");
                return;
            }
        try (BufferedReader br = Files.newBufferedReader(filePath, StandardCharsets.UTF_8))
        {                       
            String line;
            System.out.println("Reading file....: \n" + filePath);

            while ((line = br.readLine()) != null)
            {
               System.out.println(line);
            }
        }
        catch (IOException e)
        {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String args[])
    {
        QuizApplication qa = new QuizApplication();
        Scanner sc = new Scanner(System.in);

        int x, num,e,s,m,ca,ss;
        String name, id;
        String[] subjectFiles = {
                "English.csv",
                "Science.csv",
                "Maths.csv",
                "Computer Application.csv",
                "Social Science.csv"
            };
        System.out.println("1. Teacher");
        System.out.println("2. Student");
        x = sc.nextInt();
        sc.nextLine();  

        switch (x)
        {
            case 1:
                System.out.println("1. Add Quiz");
                break;

            case 2:
                System.out.println("Enter your name:");
                name = sc.nextLine();
                System.out.println("Enter your ID:");
                id = sc.nextLine();                
                System.out.println("1. English");
                System.out.println("2. Science");
                System.out.println("3. Maths");
                System.out.println("4. Computer Application");
                System.out.println("5. Social Science");
                System.out.println("Enter your choice:");
                num = sc.nextInt();
                sc.nextLine(); 
                switch(num)
                {
                    case 1:
                        
                        
                         
                        
                }
                Path filePath = Paths.get(subjectFiles[num-1]);
                qa.read(filePath);  
               
                 String[] questions = {};                    
                 String[] answers = {"4", "delhi"};
                 String[] userAnswers = new String[questions.length];
                 int correctCount = 0;

                 
                 System.out.println("===== Welcome to the Quiz! =====");

                 for (int i = 0; i < questions.length; i++)
                 {
                     System.out.println(questions[i]);
                     System.out.print("Your answer: ");
                     userAnswers[i] = sc.nextLine().trim().toLowerCase();

                     if (userAnswers[i].equals(answers[i]))
                         correctCount++;
                 }

                
                 System.out.println("\n================ QUIZ RESULTS ================");

                 for (int i = 0; i < questions.length; i++)
                 {
                     System.out.println(questions[i]);
                     System.out.println("Your answer: " + userAnswers[i]);
                     System.out.println("Correct answer: " + answers[i]);
                     System.out.println();
                 }

                 double percentage = (correctCount / (double) questions.length) * 100;
                 System.out.printf("You got %d out of %d correct. (%.2f%%)\n",
                     correctCount, questions.length, percentage);

                break;

            default:
                System.out.println("Invalid choice.");
        }

        sc.close();
    }
}
