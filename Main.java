import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

class Ticket{
    private String name;
    private int age;
    private String boardingPoint;
    private String deboardingPoint;
    private String date;
    private String trainName;
    private int pnr;
    
    Ticket(){
        
    }
    
    Ticket(String name,int age,String boardingPoint,String deboardingPoint,String date,String trainName,int pnr){
        this.name = name ;
        this.age = age ;
        this.boardingPoint = boardingPoint ;
        this.deboardingPoint = deboardingPoint ;
        this.date=date;
        this.trainName = trainName ;
        this.pnr = pnr ;
        
    }
    
    public int getPnr(){
        return pnr;
    }
    
     public String getname(){
        return name;
    }
    
     public int getage(){
        return age;
    }
    
     public String getboardingPoint(){
        return boardingPoint;
    }
    
     public String getdeboardingPoint(){
        return deboardingPoint;
    }
    
    public String getdate(){
        return date;
    }
    
    public String gettrainName(){
        return trainName;
    }
    
    
}

public class Main {
    
    static Map<String, String> map = new HashMap<>();
     
    public static String LoginDeatils(String username){
    if (map.containsKey(username)) {
            System.out.print("Password: ");
            String password = input.nextLine();
            if (password.equals(map.get(username))) {
                return "1";
            } else {
                return "0";
            }
        } else {
            return "10";
        }
}

    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Ticket> bookedTickets = new ArrayList<>();

    public static void main(String[] args) {
        
        map.put("shiva","ABC123XYZ");
        map.put("venky","hibye");
        map.put("ram","1209");
        map.put("jhon","2021");
        System.out.println("----------ONLINE RESERVATION SYSTEM--------------");
        System.out.println("LOGIN DEATILS");
        System.out.print("UserName :");
        String UserName = input.nextLine();
        String result = LoginDeatils(UserName);
        if(result=="1"){
            System.out.println("Login Successfull!!");
            
        int choice;

        do{
            System.out.println("\n1. Book a ticket");
            System.out.println("2. Cancel a ticket");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    bookTicket();
                    break;
                case 2:
                    cancelTicket();
                    break;
                case 3:
                    System.out.println("Thank you for using our train booking system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option (1, 2, or 3)");
            }
        }while (choice != 3);
        input.close();
        
        }else if(result == "0"){
            System.out.println("Invalid password.");
        }else{
            System.out.println("User not found");
        }
        
        
    }

    private static void bookTicket() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = input.nextLine();

        System.out.println("Enter your age: ");
        int age = input.nextInt();
        
        
        System.out.println("Enter boarding point: ");
        String boardingPoint = in.nextLine();
        
        input.nextLine();
        System.out.println("Enter deboarding point: ");
        String deboardingPoint = input.nextLine();
       
        System.out.println("Enter the date(dd/mm/yy) : ");
        String date =input.nextLine();
        
        System.out.println("Choose your train:\n1. Godavari Exp\n2. Garibrath Exp\n3. Visakha Exp\n4. Vande Bharat EXP\n5. Konark Exp\nEnter your choice: ");
        int trainChoice = input.nextInt();
        
        

        String trainName = "";
        switch (trainChoice) {
            case 1:
                trainName = "Godavari Exp";
                break;
            case 2:
                trainName = "Garibrath Exp";
                break;
            case 3:
                trainName = "Visakha Exp";
                break;
            case 4:
                trainName = "Vande Bharat EXP";
                break;
            case 5:
                trainName = "Konark Exp";
                break;
            default:
                System.out.println("Invalid train choice. Please enter a valid option (1, 2, 3, 4, or 5)");
                return;
        }

        int pnr = generatePNR();

        Ticket ticket = new Ticket(name, age, boardingPoint, deboardingPoint, date, trainName, pnr);
        bookedTickets.add(ticket);

        System.out.println("\nYour ticket is booked ");
        System.out.println("----"+boardingPoint+" TO "+deboardingPoint+"----");
        System.out.println("Date: "+date);
        System.out.println("Passenger Name: "+name);
        System.out.println("Passenger Age: "+age);
        System.out.println("Train Name: " +trainName);
        System.out.println("PNR NO: " +pnr);
    }

    private static void cancelTicket() {
        System.out.print("Enter PNR number: ");
        int pnr = input.nextInt();
        input.nextLine();
        
        Ticket ticket = findTicketByPNR(pnr);
        
        if (ticket != null) {
            
            System.out.println("Your Ticket ");
            System.out.println("----"+ticket.getboardingPoint()+" TO "+ticket.getdeboardingPoint()+"----");
            System.out.println("Date: "+ticket.getdate());
            System.out.println("Passenger Name: "+ticket.getname());
            System.out.println("Passenger Age: "+ticket.getage());
            System.out.println("Train Name: " +ticket.gettrainName());
            System.out.println("PNR NO: " +ticket.getPnr());
            
            System.out.println("Do You Want To Cancel Or Not");
            System.out.println("Enter \"YES\" for cancelling & \"N0\" for not cancelling. ");
            String value = input.nextLine();
            if(value.equals("YES")){
            bookedTickets.remove(ticket);
            System.out.println("\nTicket with PNR number " + pnr + " has been canceled.");
            }else{
                System.out.println("Your Ticket Is Not canceled");
            }
        } else {
            System.out.println("\nInvalid PNR number.");
        }
    }

    private static Ticket findTicketByPNR(int pnr) {
        for (Ticket ticket : bookedTickets) {
            if (ticket.getPnr() == pnr) {
                return ticket;
            }
        }
        return null;
    }

    private static int generatePNR() {
        int pnr = (int) (Math.random() * 1000000);
        while (findTicketByPNR(pnr) != null) {
            pnr = (int) (Math.random() * 1000000);
        }
        return pnr;
    }
}
