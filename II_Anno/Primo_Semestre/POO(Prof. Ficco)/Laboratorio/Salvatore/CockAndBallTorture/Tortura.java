package CockAndBallTorture;

import java.util.Scanner;

import Entita;

public class Tortura
{
    public void checkTorture()
    {
        if(getIsAlive().equals(true) && getIsExcrutiatingPain.equals(false))
        {
            System.out.println("Subject is not in pain and now he will be tortured\n");
            setIsExcrutiatingPain(true);
        }
        else if(getIsAlive().equals(true) && getIsExcrutiatingPain.equals(true))
        {
            System.out.println("Subject is in pain and will be executed\n");
            setIsAlive(false);
        }
        else
        {
            System.out.println("Subject is dead. Resuscitating him\n");
            setIsAlive(true);
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in); //creo scanner
        String userInput;

        while(true)
        {
            System.out.println("Do you want to create a subject?, (use yes or quit (to quit))\n");
            userInput = scanner.nextLine();
            {
                if(userInput.equals("yes"))
                {
                    System.out.println("Digit cock lenght\n");
                    userInput = scanner.nextLine();
                    String cockString = userInput;
                    float cock = Float.parseFloat(cockString);
                    System.out.println("Digit ball number\n");
                    userInput = scanner.nextLine();
                    String ballString = userInput;
                    int ball = Integer.parseInt(ballString);

                    Entita entita = new Entita(cock, ball);

                    Boolean check = true;
                    while(check.equals(true))
                    {
                        System.out.println("Do you want to torture the subject? (yes, if He is dead reset))\n");
                        userInput = scanner.nextLine();
                        if(userInput.equals("yes"))
                        {
                            if(entita.getIsAlive().equals(false))
                            {
                                System.out.println("Subject is dead. Try again\n");
                            }
                            else
                            {
                                entita.setIsExcrutiatingPain(true);
                                System.out.println("Subject is in extrutiating pain\n");
                                System.out.println("Do you want to kill the subject? yes or no\n");
                                {
                                    userInput = scanner.nextLine();
                                    if(userInput.equals("yes") && entita.getIsAlive().equals(true))
                                    {
                                        System.out.println("Ended is suffering\n");
                                        entita.setIsAlive(false);
                                    }
                                    else if(userInput.equals("no") && entita.getIsAlive().equals(true))
                                    {
                                        System.out.println("Continuing the torture\n"); 
                                    }
                                }
                            }
                        }
                        else if(userInput.equals("no"))
                        {
                            System.out.println("Alright you fucking loser\n");
                        }
                        else if(userInput.equals("reset"))
                        {
                            check = false;
                        }

                    }
                }
                else if(userInput.equals("quit"))
                {
                    System.out.println("Alright exiting\n");
                    scanner.close();
                    System.exit(0);
                }
            }
        }
    }
}