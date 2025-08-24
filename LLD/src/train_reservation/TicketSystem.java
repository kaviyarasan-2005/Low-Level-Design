package train_reservation;
import java.util.*;

import javax.security.auth.callback.ConfirmationCallback;

public class TicketSystem {

	 private final List<String> availableBerth = new ArrayList<>(Arrays.asList("L","M","U"));
	 
	 private final Queue<Passenger> racQueue = new LinkedList<>();
	 
	 private final Queue<Passenger> WaitingListQueue = new LinkedList<>();
	 
	 private final List<Passenger> ConfirmPassenger=new ArrayList<>();
	 
	 private int ticketCounter=0;
	 
	 public void BookTicket(String name,int age,String gender,String BerthPreference) {
		 
		 String ticketID="T"+ticketCounter++;
		 Passenger passenger;
		 
		 if(!availableBerth.isEmpty()) {
			String AllocatedBerth = allocateBerth(age, gender, BerthPreference);
			passenger = new Passenger(name,age,gender,BerthPreference,AllocatedBerth,ticketID);
			ConfirmPassenger.add(passenger);
			availableBerth.remove(AllocatedBerth);
			System.out.println("Ticket confirmed"+ passenger);
			
		 }
		 else if(racQueue.size() <1) {
			 passenger = new Passenger(name,age,gender,BerthPreference,"rac",ticketID);
			 racQueue.offer(passenger);
			 System.out.println("Ticket in RAC: "+passenger);
		 }
		 else if(WaitingListQueue.size()<1) {
			 passenger = new Passenger(name, age, gender, BerthPreference, BerthPreference, ticketID);
			 WaitingListQueue.offer(passenger);
			 System.out.println("Ticket in Waiting List"+passenger);
		 }
		 else {
			 System.out.println("No Tickets Available");
		 }
	 }
	 private String allocateBerth(int age,String gender,String Preference){
		 
		 if(age>60 || gender.equalsIgnoreCase("Female")&& availableBerth.contains("L")){
			 return "L";
		 }
		 if(availableBerth.contains(Preference)) {
			 return Preference;
		 }
		 
			 return availableBerth.get(0);
		 
	 }
	 
	 public void cancelTicket(String ticketId) {
		 Optional<Passenger> passengerOpt = ConfirmPassenger.stream().filter(p ->p.ticketId.equals(ticketId)).findFirst();
		 if(passengerOpt.isPresent()) {
			 Passenger passenger = passengerOpt.get();
			 ConfirmPassenger.remove(passenger);
			 availableBerth.add(passenger.allotedBerth);
			 if(!racQueue.isEmpty()) {
				 Passenger racPassenger = racQueue.poll();
				 String allocatedBerth = allocateBerth(racPassenger.age, racPassenger.gender, racPassenger.berthPreference);
				 racPassenger.allotedBerth=allocatedBerth;
				 ConfirmPassenger.add(racPassenger);
				 availableBerth.remove(allocatedBerth);
				 System.out.println("RAC Ticket moved to confirmed: "+racPassenger);
			 }
			 if(!WaitingListQueue.isEmpty()) {
				 Passenger waitingPassenger = WaitingListQueue.poll();
				 waitingPassenger.allotedBerth="RAC";
				 System.out.println("Waiting List ticket moved to RAC: "+ waitingPassenger);
				 racQueue.add(waitingPassenger);
			 }
			 System.out.println("Ticket Cancelled Sucessfully");
		 }
		 else {
			 System.out.println("No ticket Found Enter Correct ticket ID " + ticketId+" is Not matched");
		 }
	 }
	 public void printBookedTickets() {
		 	if(ConfirmPassenger.isEmpty()) {
		 		System.out.println("No tickets Confirmed");
		 	}
		 	else {
		 		System.out.println("Confirmed Tickets are:");
		 		for(Passenger pass:ConfirmPassenger) {
		 			System.out.println(pass);
		 		}
		 	}
	 }
	 public void printAvailableTickets() {
		 System.out.println("Available Tickets: "+availableBerth.size());
		 System.out.println("Available RAC Tickets: "+(1-racQueue.size()));
		 System.out.println("Available Waiting List Tickets: "+(1-WaitingListQueue.size()));
		 
	 }
	 public void viewRacTickets(){
		 if(racQueue.isEmpty()) {
			 System.out.println("No RAC Ticket Booked");
		 }
		 else {
			 System.out.println("RAC Tickets are :");
			 for(Passenger pass:racQueue) {
				 System.out.println(pass);
			 }
		 }
	 }
	 public void viewWaitingist() {
		 if(WaitingListQueue.isEmpty()) {
			 System.out.println("No Waiting List Ticket Booked");
		 }
		 else {
			 System.out.println("Waiting List Tickets are :");
			 for(Passenger pass:WaitingListQueue) {
				 System.out.println(pass);
			 }
		 }
	 }
	 
}
