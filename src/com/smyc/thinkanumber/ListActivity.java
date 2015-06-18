package com.smyc.thinkanumber;

import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListActivity extends Activity {

	public static String theName;
	
	//creates and array with 200 names
	String [] FullArray = {"Barack Obama", "Osama Bin Laden", "J.K.Rowling", "Usain Bolt", "Lance Armstrong", "Stephen Hawking ", "Linus Torvalds", 
			"Jimmy Wales", "Steve Jobs", "Hilary Clinton", "Shakira", "Jimmy Carter", "George Clooney", "Paul Krugman", "Kate Middleton", "Lionel Messi" ,
			 "Cristiano Ronaldo", "Beyonce", "Lady Gaga", "Vladimir Putin", "Roman Abramovich", "David Cameron", "Will Smith", "Larry Page", "Angelina Jolie",
			 "Sergey Brin", "Michael Bloomberg", "Mark Zuckerberg", "Elon Musk", "Jon Stewart", "Scarlett Johansson", "Stephen Colbert", "Kim Jong Un",
			 "Bashar Assad", "E.L. James", "Rihanna", "Novak Djokovic", "Warren Buffett", "Xi Jinping", "Leonardo DiCaprio", "Christian Bale", "Johnny Depp",
			 "Will Smith", "Denzel Washington", "Daniel Craig", "Christoph Waltz", "David Tennant", "Liam Neeson", "Brad Pitt", "Helena Bonham Carter",
			 "Natalie Portman", "Meryl Streep", "Renée Zellweger", "Sandra Bullock", "Nicole Kidman", "Hilary Swank", "Emma Stone", "Cate Blanchett", 
			 "Jennifer Lawrence", "Gwyneth Paltrow", "Scarlett Johansson", "Kate Hudson", "Mila Kunis", "Anne Hathaway", "Amanda Seyfried", "Julia Roberts",
			 "Milla Jovovich",  "Noomi Rapace", "Octavia Spencer", "Dakota Fanning", "Andrew Lincoln", "Chandler Riggs", "Steven Yeun", "Norman Reedus",
			 "Lauren Cohan", "Emily Kinney", "Scott Wilson", "Peter Dinklage", "Lena Headey", "Emilia Clarke", "Kit Harington", "Paul Wesley", "Ian Somerhalde",
			 "Nina Dobrev", "Candice Accola", "Steven R. McQueen", "Michael Trevino", "Chris Wood", "Joseph Morgan", "Daniel Gillies", "Phoebe Tonkin", 
			 "Charles Michael Davis", "Leah Pipes", "Danielle Campbell", "Claire Holt", "Daniella Pineda", "Jennifer Aniston", "Courteney Cox", "Lisa Kudrow",
			 "Matt LeBlanc", "Matthew Perry", "David Schwimmer", "Elliott Gould", "Paget Brewster", "Josh Radnor", "Jason Segel", "Cobie Smulders", 
			 "Neil Patrick Harris", "Alyson Hannigan", "Lyndsy Fonseca", "David Henrie", "Jennifer Morrison", "Virginia Williams", "Roger Bart", "Rubens Barrichello",
			 "Michael Schumacher", "Jenson Button", "Riccardo Patrese", "Jarno Trulli", "David Coulthard", "Fernando Alonso", "Kimi Räikkönen", "Felipe Massa", 
			 "Max Verstappen", "Alain Prost", "Ayrton Senna", "Sebastian Vettel", "Lewis Hamilton", "Nigel Mansell", "Jackie Stewart", "Jim Clark", "Niki Lauda", 
			 "Jackie Stewart", "Jacques Villeneuve", "Robert Kubica", "James Allison", "Bernie Ecclestone",  "Claire Williams", "sir Frank Williams", 
			 "Tiametmarduk", "SkyDoesMinecraft", "TheFineBros", "RayWilliamJohnson", "BlueXephos", "TobyGames", "DisneyCollectorBR", "Smosh", "PewDiePie", 
			 "Derek Banas", "Chuck Peddle", "Jack Tramiel", "Bil Gates", "Steve Wozniak", "Jay Miner", "Richard Stallman", "Martha Lane Fox", "Dennis Ritchie", 
			 "Jonathan Schaeffer", "Michael Widenius", "Carl Sassenrath", "Jason Fried", "Rasmus Lerdorf", "Bjarne Stroustrup", "Larry Wall", "Guido van Rossum", 
			 "Bram Cohen", "Brendan Eich", "Donald Knuth", "Douglas Crockford", "James Gosling", "Ben Goodger", "Sergey Brin", "Tim Berners-Lee", 
			 "William Shakespeare", "Nelson Mandela", "Adolf Hitler", "Albert Einstein", "Christopher Columbus", "Galileo Galilei", "Isaac Newton", 
			 "Aristotle", "Arcimedes", "Nikola Tesla", "Leonardo Da Vinci", "Matthew Bellamy", "Christopher Wolstenholme", "Dominic Howard", "Elvis Presley",
			 "John Lennon", "James Bay", "Alexander Desplat", "Eminem", "50 cent", "Madonna", "Katy Perry", "Miley Cyrus", "Andres Iniesta", "Zlatan Ibrahimovic",
			 "Wayne Rooney", "Iker Casillas"
			 
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		setTitle("Think A Number");
		
		new AlertDialog.Builder(this)
	    .setTitle("Here is the magic")
	    .setMessage("Find the name that match to your number and keep it in your mind. Refresh the names if you want!")
	    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) { 
	            
	        }
	     })
	    .setIcon(android.R.drawable.ic_dialog_alert)
	    .show();

		
		
		
		Button refresh = (Button) findViewById(R.id.refresh);
		refresh.setOnClickListener(refressPressed);
		
		Button next = (Button) findViewById(R.id.button1);
		next.setOnClickListener(nextPressed);
		
		setUpList(); //calls the method that create the FinalArray, adapter and Views
		
	  
		
	}
	
	 private View.OnClickListener refressPressed = new View.OnClickListener() {
		    public void onClick(View v) {
		    	setUpList();
		    }
		  };
		  
	private View.OnClickListener nextPressed = new View.OnClickListener() {
			    public void onClick(View v) {
			    	Intent intent = new Intent (ListActivity.this, ResultActivity.class);
			    	startActivity(intent);
			    	overridePendingTransition(R.animator.animation1, R.animator.animation2);
			    	
			    	
			    }
			  };
	
	private String[] createFinalArray(String[] full) {
		String[] tempArray = new String[99];
		for (int i=0; i<99; i++) {
			tempArray[i]=full[randInt(0,199)]; //fill the FinalArray with random 99 random numbers from FullArray
		}
		return tempArray;
	}
	
	private void setUpList() { //setup the list
		
		    String[] FinalArray = new String[99]; //the array with the elements on the list

			FinalArray=createFinalArray(FullArray); //setup the final array with random elements
			
			int forModNine = randInt(0,199);
			theName=FullArray[forModNine];
			
			for (int i=1; i<99; i++) {
				if (i%9==0) FinalArray[i-1]=FullArray[forModNine]; //this is the magic!!
			}
			
			for (int i=0; i<99; i++) { //put numbers in front of names
				String current = Integer.toString(i+1);
				current+=". ";
				FinalArray[i]=current+FinalArray[i];
			}
			
			
			ListAdapter theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, FinalArray);
			ListView theListView = (ListView) findViewById(R.id.theListView);
			theListView.setAdapter(theAdapter);
	}
  	
    private  int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			new AlertDialog.Builder(this)
		    .setTitle("So much fame!")
		    .setMessage("Scientists, drivers, football players, singers, terrorists, politicians etc are there. ")
		    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            
		        }
		     })
		    .setIcon(android.R.drawable.ic_dialog_alert)
		    .show();
			
			
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
