package train_reservation;

 class Passenger {
	
	 int age;
	 String name;
	 String  gender;
	 String berthPreference;
	 String allotedBerth;
	 String ticketId;
	
	public Passenger (String name,int age,String gender,String berthPreference,String allotedBerth,String ticketId) {
		this.name= name;
		this.age=age;
		this.gender=gender;
		this.berthPreference=berthPreference;
		this.allotedBerth = allotedBerth; 
		this.ticketId=ticketId;
	}
//	public String getBookingID() {
//		return bookingID;
//	}
//	public int getSeatsBooked() {
//		return seatsBooked;
//	}
////	@Override
//	 public String toString() {
//		 return "Passenger{booking ID = '}"+bookingID + "', name = '"+ name+"', age '" + age+"', seatsBooked"+seatsBooked+"'";
//	 }
	@Override
	public String toString() {
		return "Ticket ID: "+ticketId+", Name: "+name+ ", Age: "+age+", Gender "+gender+",Berth "+allotedBerth;
	}
}
 