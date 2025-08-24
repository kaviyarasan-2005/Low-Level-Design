package train_reservation;
import java.util.*;
public class TicketBooking {
	public static void main(String[] args) {
		
		TicketSystem ticketSystem = new TicketSystem();
		Scanner scanner=new Scanner(System.in);
		while(true) {
			System.out.println("\nRailway Booking System");
			System.out.println("1. Booked Ticket");
			System.out.println("2. Cancel Ticket");
			System.out.println("3. View Confirm Ticket");
			System.out.println("4. View AvailableTicket");
			System.out.println("5. View RAC Ticket");
			System.out.println("6. View Waiting List Ticket");
			System.out.println("7. Exit");
			System.out.println("Enter Your Choice :");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice) {
			case 1:
				System.out.println("Enter name: ");
				String name = scanner.nextLine();
				System.out.println("Enter age: ");
				int age = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter Gender(Male/Female): ");
				String gender = scanner.nextLine();
				System.out.println("Enter Berth Preference(L/M/U): ");
				String berthPreference = scanner.nextLine();
				
				ticketSystem.BookTicket(name, age, gender, berthPreference);
				break; 
			case 2:
				System.out.println("Enter Ticket ID");
				String ticketId = scanner.nextLine();
				ticketSystem.cancelTicket(ticketId);
				break;
			case 3:
				ticketSystem.printBookedTickets();
				break;
			case 4:
				ticketSystem.printAvailableTickets();
				break;
			case 5:
				ticketSystem.viewRacTickets();
				break;
			case 6:
				ticketSystem.viewWaitingist();
				break;
			case 7:
				System.out.println("System Exiting.....");
				System.exit(0);
			default:
				System.out.println("Enter a Valid Number(1-7)");
			}
			
		}
	}
}
