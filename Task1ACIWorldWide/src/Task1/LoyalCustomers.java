package Task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LoyalCustomers {
	
	
public void HighlyValued(List<Payment> payDetails) {
		
	
	//Creating hashmap to Get TotalAmount of Each Customer.
HashMap<String,Double> hashMap=new HashMap<>();
        
        for(Payment payDetail : payDetails) {

        	hashMap.put(payDetail.getName(),(hashMap.getOrDefault(payDetail.getName(), (double) 0)+payDetail.getPaidAmount()));
        }
        
         System.out.println("Loyality of Customers");
         System.out.println("Name"+"\t "+"TotalAmount");
         
         
         
         
         
List<Map.Entry<String, Double>> sortedList = hashMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        
        
for (Map.Entry<String, Double> entry : sortedList) {
         	
         	
             System.out.println(entry.getKey()+"\t "+entry.getValue());
            
         }
        System.out.println("\n");

        
        
        Map<String, Payment> map = new HashMap<>();
        
        for (Payment payDetail : payDetails) {
                	
                	map.put(payDetail.getName(), payDetail);
                }
        
           

        Collections.reverse(sortedList);
        int count=0;
       
        System.out.println("Highly Loyal");
        
        //Creating List of highlyLoyalList
        List<String> highLoyalList=new ArrayList<String>();
        
      //Printing High Loyal Customers with Their Total Amount
        System.out.println("Name"+"\t "+"TotalAmount");
        for (Map.Entry<String, Double> entry : sortedList) {
        	if(count==3) {
        		break;
        	}
        	count=count+1;
            System.out.println(entry.getKey()+"\t "+entry.getValue());
            highLoyalList.add(entry.getKey());
        }
        
  

	//Call Function of low Loyal Customer
	this.LowLoyalCustomer(sortedList,payDetails,highLoyalList);
	
		
		
		
	}
public void LowLoyalCustomer(List<Map.Entry<String, Double>> sortedList,List<Payment> payDetails,List<String> highLoyalList){
		
         int count=0;
         Collections.reverse(sortedList);
        
         System.out.println("\nLow Loyal");
         
      // creating a List LowLoyal Customer       
         List<String> lowLoyalList=new ArrayList<String>();
         
         System.out.println("Name"+"\t "+"TotalAmount");
         
       //Printing Low Loyal Customers with Their Total Amount
         for (Map.Entry<String, Double> entry : sortedList) {
         	if(count==3) {
         		break;
         	}
         	count=count+1;
             System.out.println(entry.getKey()+"\t "+entry.getValue());
             lowLoyalList.add(entry.getKey());
         }
         
         //Calling Function for mediumLoyal Customer

     this.mediumLoyal(lowLoyalList, highLoyalList,sortedList);
		
	}

public void mediumLoyal(List<String> lowLoyalList,List<String> highLoyalList,List<Map.Entry<String, Double>> sortedList) {
	
	//Creating List of mediumList Customer
	List<String> mediumLoyalList=new ArrayList<String>();
	
	for(String lowloyal:lowLoyalList) {
		if(highLoyalList.contains(lowloyal)) {
			mediumLoyalList.add(lowloyal);
		}
	}
	
	//Printing Medium Loyal Customers with Their Total Amount
	System.out.println("\nMedium Loyal");
	System.out.println("Name"+"\t "+"TotalAmount");
	for (Map.Entry<String, Double> entry : sortedList) {
     	if(mediumLoyalList.contains(entry.getKey())) {
         System.out.println(entry.getKey()+"\t "+entry.getValue());
     	}
     }
     
	
}
}

