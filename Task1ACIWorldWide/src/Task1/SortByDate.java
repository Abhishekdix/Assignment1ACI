package Task1;

import java.util.Collections;
import java.util.List;


public class SortByDate {
	public void sortByDate (List<Payment> payDetails) {
		
		
	   
	        System.out.println("\nDetails in sorted order based on date");
	        System.out.println("ID"+"  "+"  Date"+"\t" +"Amount"+"  "+"Paid By"+"  "+"Name");
	        
	        // Sort the payment details by date using Collections
	        Collections.sort(payDetails, (a, b) ->( (a.getPaymentDate()).compareTo((b.getPaymentDate()))));
	        
	        
	        for (Payment payDetail : payDetails) {
	        	
	        	System.out.println(payDetail.getPaymentId()+" , "+payDetail.getPaymentDate()+" , "+payDetail.getPaidAmount()+" , "+payDetail.getPaidBy()+" , "+payDetail.getName());

	}

}
	}
