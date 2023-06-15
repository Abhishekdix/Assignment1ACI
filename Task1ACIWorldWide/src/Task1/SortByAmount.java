package Task1;

import java.util.Collections;
import java.util.List;

public class SortByAmount {

	public void sortByAmount(List<Payment> payDetails) {

        System.out.println("\n");
        System.out.println("Details in sorted based on Amount paid");
        System.out.println("ID"+"  "+"  Date"+"\t" +"Amount"+"  "+"Paid By"+"  "+"Name");

        // Sort the payment details by amount
        Collections.sort(payDetails, (a, b) -> Double.compare(a.getPaidAmount(), b.getPaidAmount()));
        
        for (Payment payDetail : payDetails) {
        	System.out.println(payDetail.getPaymentId()+" , "+payDetail.getPaymentDate()+" , "+payDetail.getPaidAmount()+" , "+payDetail.getPaidBy()+" , "+payDetail.getName());
        }
        System.out.println("\n");

	}
	
}
