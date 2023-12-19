package Task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SearchCustomerDetails {
	List<Customer> customers=new ArrayList<Customer>();
	HashMap<String,Integer> custName=new HashMap<>();
	
	public  void SearchCustomerDetail() throws FileNotFoundException {
		File file=new File("C:\\Users\\pc\\Desktop\\DetailsACIWorldWide\\CustomerDetails\\CustomerDetails.txt"); 
 
	
		BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        Payment payDetail = null;
        
        try {
			while ((line = reader.readLine()) != null) {
			    // Create a FileDetails object
			   
			    
			    String[] lineData = line.split(",");
			    custName.put(lineData[0],1);
			    
			    Customer customer=new Customer();
			    customer.setEmployeeName(lineData[0]);
			    customer.setEmployeeEmail(lineData[1]);
			    customer.setEmployeePhoneNo(lineData[2]);
			    customers.add(customer);
			
			
}
		

		
		
		} 
        
        catch (IOException e) {
			
			e.printStackTrace();
		}
	
	
	
}
	public void getInfo() {
		System.out.println("Enter the Name of Customer\n");
		Scanner inpScanner=new Scanner(System.in);
		String findDetails;
		findDetails=inpScanner.nextLine();
		
		
		for(Customer cust:customers) {
			if((cust.getEmployeeName()).equals(findDetails)) {
				System.out.println("Name"+"\t "+"Email"+"\t\t\t"+"PhoneNumber");
			System.out.println(cust.getEmployeeName()+"\t "+cust.getEmployeeEmail()+"\t  "+cust.getEmployeePhoneNo());
			return ;
	
		}
		}
		System.out.println("Customer Not Registered");
	}
	
	public int verify(String custmerName) {
		return custName.getOrDefault(custmerName, 0);
	}
	
	
}
