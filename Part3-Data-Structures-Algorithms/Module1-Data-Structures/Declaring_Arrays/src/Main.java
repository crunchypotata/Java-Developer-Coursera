public class Main {
    public static void main(String[] args) {
        int [] daysInMonth = new int [12];
        String [] monthNames = new String []
                {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        for (int i = 0; i < 12; i++) {
            if (i == 1) {
                daysInMonth[i] = 28;
            } else if (i == 3 || i == 5 || i == 8 || i == 10) {
                daysInMonth[i] = 30;
            } else {
                daysInMonth[i] = 31;
            }
        }

        for (int i = 0; i < monthNames.length; i++) {
            System.out.println(monthNames[i] + ": " + daysInMonth[i] + " days");
        }
    }
}
