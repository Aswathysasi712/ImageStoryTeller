package storyTeller;

import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.net.*;

import java.util.Locale;
import javax.*;
import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

public class storyTeller {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Scanner myObj = new Scanner(System.in);

		File inputfile = new File("C:\\Users\\Achu\\StoryTeller\\input.txt");
		File outputfile = new File("C:\\Users\\Achu\\StoryTeller\\output.txt");
		
		BufferedReader br = new BufferedReader(new FileReader(inputfile));
		BufferedWriter bw = new BufferedWriter(new FileWriter(outputfile));
		
		if(!inputfile.exists()) {
			inputfile.createNewFile();
		}
		
		if(!outputfile.exists()) {
			outputfile.createNewFile();
		}
		
		System.out.println("Enter the number of labels\n");
		int numberLabel = myObj.nextInt();
		
		
		System.out.println("Enter the labels");
		for(int i=0;i<numberLabel;i++) {
		String label = myObj.nextLine();
		bw.write(label);
		bw.newLine();
		}
		
		bw.close();
		br.close();
		
		 try {
	            // Set property as Kevin Dictionary
	            System.setProperty(
	                "freetts.voices",
	                "com.sun.speech.freetts.en.us"
	                    + ".cmu_us_kal.KevinVoiceDirectory");
	  
	            // Register Engine
	            Central.registerEngineCentral(
	                "com.sun.speech.freetts"
	                + ".jsapi.FreeTTSEngineCentral");
	  
	            // Create a Synthesizer
	            Synthesizer synthesizer
	                = Central.createSynthesizer(
	                    new SynthesizerModeDesc(Locale.US));
	  
	            // Allocate synthesizer
	            synthesizer.allocate();
	  
	            // Resume Synthesizer
	            synthesizer.resume();
	  
	            // Speaks the given text
	            // until the queue is empty.
	            synthesizer.speakPlainText(
	                "GeeksforGeeks", null);
	            synthesizer.waitEngineState(
	                Synthesizer.QUEUE_EMPTY);
	  
	            // Deallocate the Synthesizer.
	            synthesizer.deallocate();
	        }
	  
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
