package Task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchCustomerDetails {
     
	public  void SearchCustomerDetail() throws FileNotFoundException {
		File file=new File("C:\\Users\\pc\\Desktop\\DetailsACIWorldWide\\CustomerDetails\\CustomerDetails.txt"); 
 
	
		BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        Payment payDetail = null;
        List<Customer> customers=new ArrayList<Customer>();
        try {
			while ((line = reader.readLine()) != null) {
			    // Create a FileDetails object
			    if (payDetail == null) {
//            	System.out.println("creating new object");
			        payDetail = new Payment();
			    }
			    
			    String[] lineData = line.split(",");
			    Customer customer=new Customer();
			    customer.setName(lineData[0]);
			    customer.setEmail(lineData[1]);
			    customer.setPhoneNo(lineData[2]);
			    customers.add(customer);
			
			
}
			
		
		this.getInfo(customers);
		
		
		} 
        
        catch (IOException e) {
			
			e.printStackTrace();
		}
	
	
	
}
	public void  getInfo(List<Customer> customers) {
		System.out.println("Enter the Name of Customer\n");
		Scanner inpScanner=new Scanner(System.in);
		String findDetails;
		findDetails=inpScanner.nextLine();
		
		System.out.println("Name"+"\t "+"Email"+"\t\t\t"+"PhoneNumber");
		for(Customer cust:customers) {
			if((cust.getName()).equals(findDetails)) {
			System.out.println(cust.getName()+"\t "+cust.getEmail()+"\t  "+cust.getPhoneNo());
		}
		}		
	}
}
