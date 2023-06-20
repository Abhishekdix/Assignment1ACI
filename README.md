# Assignment1
Question: 
Consider you are a Payment provider, and you are giving payment solutions. Find the top 3 
paying customers (based on total amount paid) label them high loyal and Find the bottom 
3 paying customer and label them low loyal. Find the intersection of high loyal and low 
loyal and print the result.

1 . Write a program to read the files from the folder. Each file must be read as a separate 
thread and data must be combined from all threads.

Code:
   
    while ((line = reader.readLine()) != null) {
                           
                            if (payDetail == null) {
                             //Creating 
                                payDetail = new Payment();
                            }
                            System.out.println(line);

                            
    The code iterates each lines from file and prints each lines from all Threads .
2 . Sort the payment details by date and display it.
   Code: 
 	        
          Collections.sort(payDetails, (a, b) ->
          ( (a.getPaymentDate()).compareTo((b.getPaymentDate()))));

          
Using Collections built sort in order of Payment Date which is stored in Object Array List.


Complete Payment Details & Details sort by Date
![image](https://github.com/Abhishekdix/Assignment1ACI/assets/81672558/5b2ee5a5-bf4d-4728-a55f-9c925d92ef4e)


3. Sort the payment details by amount and display it.
   code :


   Collections.sort(payDetails, (a, b) ->
    Double.compare(a.getPaidAmount(), b.getPaidAmount()));
   

 Using Collections built sort in order of Payment Amount which is stored in Object Array List.

4. Write a program which can combine data from all files and then perform the 
classification of customers based on amount paid into high loyal, medium loyal and low 
loyal. Find the top 3 paying customers (based on total amount paid) label them high 
loyal and Find the bottom 3 paying customer and label them low loyal. Find the 
intersection of high loyal and low loyal and print the result call them as medium loyal. 
The same customer can fall under more than one category.

code :


HashMap<String,Double> hashMap=new HashMap<>();
        
        for(Payment payDetail : payDetails) {

        	hashMap.put(payDetail.getName(),(hashMap.getOrDefault(payDetail.getName(), (double) 0)+payDetail.getPaidAmount()));
        }

      List<Map.Entry<String, Double>> sortedList = hashMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());


Using HaskMap Calculating the Total Paid Amount of Each Customer. Using the List Sort the HashMap based on their Total Amount. 

 

Payment Details sorted by Amount Paid , Highly Loyal, Low Loyal(based on Total Amount Paid) 
![image](https://github.com/Abhishekdix/Assignment1ACI/assets/81672558/3443863b-29a0-48a8-b26b-d2bfdba71cb4)

Medium Loyal , Search Customer Detail by Name
![image](https://github.com/Abhishekdix/Assignment1ACI/assets/81672558/6ad69c18-489c-47a5-b859-f852dc49d960)

