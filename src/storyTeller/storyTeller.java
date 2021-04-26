package StoryTeller;

import java.util.*;
import java.io.*;
import java.util.Random;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class storyTeller {

	public static void main(String[] args) throws IOException {
		
		//Creating linked list
		 LinkedList<String> ll
         = new LinkedList<String>();
		 
		 // Adding elements to the linked list. Delete this part and use the labels from the picture.
		 
		 ll.add("camfire");
		 ll.add("fire");
		 ll.add("camping");
		 ll.add("happiness");
		 ll.add("kids");
		 ll.add("campsite");
		 ll.add("food");
		 ll.add("goodnight");
		 ll.add("family");
		 ll.add("goodtime");
		 
		 File label =new File ("C:\\Users\\Achu\\eclipse-workspace4\\storyTeller\\label.txt");	
		BufferedWriter bw = new BufferedWriter(new FileWriter(label));	
			
		if(!label.exists()) {
				label.createNewFile();
		}
			
		Scanner myObj = new Scanner(System.in);
		
		//get the number of objects and save it to numberLabel
		//System.out.println("Enter the number of labels");
		//int numberObjects = myObj.nextInt();
			
			String line = new String();
			
			Iterator iterator=ll.iterator();
			int j;
			for (int i=1;i<=ll.size();i++) {
				
				j=i;
				
				//generate random values from 0-24
				Random rand = new Random(); //instance of random class
			    int upperbound = 25;
			    int random = rand.nextInt(upperbound); 
			    
			    int dummy = random;
						
				if (random%4==0) {
						try {
							line = Files.readAllLines(Paths.get("C:\\Users\\Achu\\eclipse-workspace4\\storyTeller\\noun.txt")).get(random);
							
						}
						catch(IOException e) {
							System.out.println(e);
						}
					}	
				
				if (random%4==1) {
					
					try {
						line = Files.readAllLines(Paths.get("C:\\Users\\Achu\\eclipse-workspace4\\storyTeller\\noun.txt")).get(random);
						
					}
					catch(IOException e) {
						System.out.println(e);
					}
				}
				if (random%4==2) {
					
					try {
						line = Files.readAllLines(Paths.get("C:\\Users\\Achu\\eclipse-workspace4\\storyTeller\\adverb.txt")).get(random);
						
					}
					catch(IOException e) {
						System.out.println(e);
					}
				}	
				else {
					try {
						line = Files.readAllLines(Paths.get("C:\\Users\\Achu\\eclipse-workspace4\\storyTeller\\adjective.txt")).get(random);
						
					}
					catch(IOException e) {
						System.out.println(e);
					}
				}
				
				bw.write(line);
				if(j%5==0)
					bw.write(".");
				bw.write(" "+iterator.next()+" ");
				random = dummy;
			}
			bw.flush();
			
			//Displaying the story.
			BufferedReader br = new BufferedReader(new FileReader(label));
			System.out.println(br.readLine());
		br.close();	
		
	}

}
