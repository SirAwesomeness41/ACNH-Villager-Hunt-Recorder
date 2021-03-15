import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import java.util.Queue;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.*;
import java.time.Year;
public class VillagerHunt {
	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Villager desired: ");
		String villagerName = sc.nextLine();
		System.out.println("Attempt number: ");
		int attempt = sc.nextInt();
		String toFile = "The Search for " + villagerName + " Attempt #" + attempt;
		counter(villagerName, toFile, attempt);
	}
	public static void counter(String villagerName, String toFile, int attempt) throws InterruptedException, FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many tickets: ");
		int remaining = sc.nextInt();
		String prev = "";
		String next = "";
		String add = "";
		String[] sentences = new String[remaining];
		String filename = toFile + ".txt";
		int tickets = 1;
		sentences[0] = "Attempt #" + attempt + " to find " + villagerName;
		while(!next.equals(villagerName)&&!next.equals("end")) {
			prev = next;
			System.out.println("Input villager name (Type end to terminate): ");
			next = sc.next();
			if(!next.equals("end")&&!next.equals(villagerName)) {
				System.out.println();
				sentences[tickets] = "\nTicket #" + tickets + ": " + next;
				tickets++;
			}
			else if(!next.equals("end")&&next.equals(villagerName)) {
				System.out.println();
				sentences[tickets] = "\nTicket #" + tickets + ": " + next;
				sentences[tickets+1] = "\nYou found " + next + " with " + (remaining-(tickets-1)) + " tickets left.";
			}
			else if(next.equals("end")) {
				sentences[tickets] = "";
				sentences[tickets+1] = "\nYou found " + prev + " with " + (remaining-(tickets-1)) + " tickets left.";
			}
		}
		PrintWriter VillagerHunt = new PrintWriter(filename);
		VillagerHunt.print(sentences[0]);
		System.out.print(sentences[0]);
		for(int i = 1; i <= (tickets+1); i++) {
			VillagerHunt.print(sentences[i]);
			System.out.print(sentences[i]);
		}
		VillagerHunt.close();
		System.out.println("\nVillager hunt list saved to " + filename);
	}
}