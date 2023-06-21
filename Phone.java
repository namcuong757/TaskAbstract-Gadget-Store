package CoreJava6;

import java.util.Scanner;

public class Phone extends Store{

	private String[] model;
	private int[] year;
	private final int price[] = {1100,1000,900,1200};
	
	Phone() {
		super();
		model = new String[]{"Iphone Max", "Iphone Pro", "Reg Iphone", "Samsung Fold"};
		year = new int[] {2019,2020,2021,2022,2023};
	}

	@Override
	public String sale(Store a) 
	{
		String bill = "";
		int model_choice = -1;
		int year_choice = -1;
		int qty = 0;
		int price0 = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("-Choose your model-");
		
		for(int i = 0; i < 4; i++)
		{
			int counter0 = i+1;
			System.out.println(counter0 + ". " +model[i]);
		}
		System.out.print("model: ");
		model_choice = scanner.nextInt();
		System.out.println("-Choose your year-");
		for(int i = 0; i < 4; i++)
		{
			int counter0 = i+1;
			System.out.println(counter0 + ". " +year[i]);
		}
		System.out.print("year: ");
		year_choice = scanner.nextInt();
		System.out.print("Quantity: ");
		qty = scanner.nextInt();
		//counter++;
		a.update(a);
		price0 = price[model_choice-1] + (( year[year_choice-1] - 2019) * 100);
		a.total_bill += price0;
		bill += "\n" + a.counter+ ".\t" + model[model_choice-1] + "\t\t" + year[year_choice-1] + "\t" + qty + "\t" + price0 + "\t" + price0 * qty;
		
		return bill;
	}

}
