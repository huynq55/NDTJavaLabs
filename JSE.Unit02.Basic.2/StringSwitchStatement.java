import java.util.Calendar;
import java.util.Locale;

public class StringSwitchStatement {
	
	public static String getTypeOfDay(Calendar calendar) {
		String type = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("vi"));
		switch(type) {
			case "Th 2":
				return "Hom nay la thu may, chac chan la thu high";
			case "Th 3":
				return "Ngay de code";
			case "Th 4":
				return "Giua tuan";
			case "Th 5":
				return "Sap het tuan roi!";
			case "Th 6":
				return "Ngay lam viec cuoi cung :D";
			case "Th 7":
				return "Thu bay mau chay ve tr*m";
			case "CN":
				return "Troi nhe dan len cao hon toi tua nhu canh trym";
		}
		return "Unknown";
		
		
	}
	
	public static void main(String[] args) {
		
		Calendar calendar = Calendar.getInstance();
		System.out.println("Today is " + StringSwitchStatement.getTypeOfDay(calendar));
		
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
		System.out.println("Tomorrow is " + StringSwitchStatement.getTypeOfDay(calendar));
		
	}
	
	
	


}