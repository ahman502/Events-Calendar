public class EventsCalendar {
	public static void main(String[] args) {

    String[][] calendar = {
      {"volunteer", "delivery", null, null, "doctor", null, "soccer"},
      {null, "exam 1", null, "mechanic", null, null, "soccer"},
      {"volunteer", "off work", null, "birthday", null, "concert", null},
      {null, "exam 2", null, null, "doctor", null, "soccer"},
      {"visit family", null, null, null, null, null, null}
    };

//------------------------------- ROW MAJOR TRAVERSAL ------------------------------------

    for(int i = 0; i < calendar.length; i++) {
    int numberOfEventsPerWeek = 0;
    for(int j = 0; j < calendar[i].length; j++) {
        // We need conditional logic to ensure that we do not count the empty days
        String event = calendar[i][j];
        if(event!=null && !event.equals("")) {
            // If the day does not have a null value or empty string for an event, then we print it and count it
            System.out.println("Week: " + (i+1) + ", Day: " + (j+1) + ", Event: " + event);
            numberOfEventsPerWeek++;
        }
    }
    System.out.println("Total number of events for week "+ (i+1) +": " + numberOfEventsPerWeek + "\n");
}

//------------------------------- COLUMN MAJOR TRAVERSAL ------------------------------------
int numberOfEventsPerWeekday = 0;
// We will use this array of day strings for our output later on so we don't have (day: 1)
String[] days = {"Sundays", "Mondays", "Tuesdays", "Wednesdays", "Thursdays", "Fridays", "Saturdays"};

for(int i = 0; i < calendar[0].length; i++) {
    numberOfEventsPerWeekday = 0;
    for(int j = 0; j < calendar.length; j++) {
        // Don't forget to flip the iterators in the accessor since we are flipping the direction we are navigating.
        // Remember, i now controls columns and j now controls rows
        String event = calendar[j][i];
        if(event!=null && !event.equals("")) {
            // Make sure we have an event for the day before counting it
            numberOfEventsPerWeekday++;
        }
    }
    // Use the days string array from earlier to convert the day index to a real weekday string
    System.out.println("Number of events on " + days[i] + ": " + numberOfEventsPerWeekday);
}

  }
}
