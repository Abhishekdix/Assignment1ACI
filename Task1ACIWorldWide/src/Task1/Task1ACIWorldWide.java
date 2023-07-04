package Task1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.text.SimpleDateFormat;

public class Task1ACIWorldWide {

    public static void main(String[] args) throws IOException, InterruptedException {
    	
        File fileFolderPathFile = new File("C:\\Users\\pc\\Desktop\\DetailsACIWorldWide\\Task1ACIWorldWide");

        // creating a list of for each files
        List<File> files = new ArrayList<>();
        
        
        for (File file : fileFolderPathFile.listFiles()) {
            if (file.isFile()) {
                files.add(file);
            }
        }
        
        SearchCustomerDetails srCustomerDetails=new SearchCustomerDetails();
        srCustomerDetails.SearchCustomerDetail();
        
        System.out.println("The Details of all files :\n");
        System.out.println("ID"+"  "+"  Date"+"   " +"Amount"+" "+"Paid By"+" "+"Name");
        //Creating list of Payment Object
        List<Payment> payDetails = new ArrayList<>();
       
        // Creating  a list of threads.
        
        List<Thread> threads = new ArrayList<>();

        for (File file : files) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                       
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        String line;
                        Payment payDetail = null;
                        while ((line = reader.readLine()) != null) {
                           
                            if (payDetail == null) {
                             //Creating 
                                payDetail = new Payment();
                            }
                            
                            String[] lineData = line.split(",");
                            
                            //Test scenarios 
                            //All the Details are important Checking for missing details
                            if(lineData.length!=5) {
                            	//call for data collection function function
                            	continue;
                            }
                            
                            if(srCustomerDetails.verify(lineData[4])==0) {
                            	//Call for Enter Customer Details
                            	continue;
                            }

                            
                            
                            System.out.println(line);
                            //Setting Data to Objects
                            payDetail.setPaymentId(Integer.parseInt(lineData[0]));
                            payDetail.setPaymentDate(lineData[1]);
                            payDetail.setPaidAmount(Double.parseDouble(lineData[2]));
                            payDetail.setPaidBy(lineData[3]);
                            payDetail.setName(lineData[4]);
                            payDetails.add(payDetail);

                            payDetail = null;
                        }
                       
                       

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            threads.add(thread);

            
        }
        //Starting all Threads
        for (Thread thread : threads) {
            thread.start();
            Thread.sleep(200);
        }
        
        try {
     // Wait for all threads to finish.
        for (Thread thread : threads) {
            thread.join();
            }}
        catch (Exception e) {
			System.out.println(e);
		}
        
     // Check all threads are done execution.
        try {
        boolean allThreadsDone = true;
        for (Thread thread : threads) {
            allThreadsDone &= !thread.isAlive();
        }
        if (allThreadsDone) {
           
        	//To get Data Based on Date
            SortByDate sortByDate=new SortByDate();
            sortByDate.sortByDate(payDetails);
            
            
          //To get Data Based on Amount Paid
            SortByAmount sortByAmount=new SortByAmount(); 
            sortByAmount.sortByAmount(payDetails);
            
          //To get  Customer Loyal
            LoyalCustomers loyalCustomers=new LoyalCustomers() ;

            loyalCustomers.HighlyValued(payDetails);
            
          //To get information of Individual Customer
           
            srCustomerDetails.SearchCustomerDetail();
            srCustomerDetails.getInfo();
           
            
            
        }
        }
        catch (Exception e) {
			System.out.println(e);
		}
       
        
      
    }
}
