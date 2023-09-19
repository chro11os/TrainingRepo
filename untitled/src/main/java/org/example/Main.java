package org.example;
import java.util.Scanner;
import org.example.name;


public  class Main
{
    public static void main(String[] args)
    {
        name sdk = new name();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Your Name: ");
        sdk.Name = scanner.nextLine();

        System.out.print("Enter Your ID Number: ");
        sdk.id = scanner.nextInt();

        System.out.print("Enter The Password: ");
        sdk.pass = scanner.nextInt();

        if (sdk.pass == 6292)
        {
            System.out.println("Enter Proof logs you wanna open: ");
            sdk.choice = scanner.nextInt();
        } else
        {
            System.out.println("Sorry Incorrect pass :<< ");
        }

        scanner.close();

        switch (sdk.choice)
        {
            case 1:
                System.out.println("View Logs ");
                    name.Data_1();
                break;
            case 2:
                System.out.println("View Internal Logs ");

                break;
            case 3:
                System.out.println("Exit ");
                break;
        }

    }
}