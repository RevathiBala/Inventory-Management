package com.setmore.inventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class ShoppingItemDetails
{
	String itemName;
	int itemQty;
	double itemPrice;
	
	ShoppingItemDetails(String itemName,int itemQty,double itemPrice){
		this.itemName=itemName;
		this.itemQty=itemQty;
		this.itemPrice=itemPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemQty() {
		return itemQty;
	}

	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String toString(){
		return "item Name is: "+itemName+"\n"+"total qty of the particular item is: " +itemQty+"\n"+ "total amount for one single item is: "+itemPrice;
		
	}
}

class ShoppingList{
	ArrayList<ShoppingItemDetails> ar = new ArrayList<ShoppingItemDetails>();
	
	public void addItem(){
		System.out.println("Enter the name of the item");
		Scanner scanner = new Scanner(System.in);
		String itemName = scanner.nextLine();
		
		System.out.println("Enter the qty of the item");
		int itemQty = scanner.nextInt();
		
		System.out.println("Enter the amount of one item");
		double itemPrice = scanner.nextDouble();
		double itemCalc = itemQty * itemPrice;
		ShoppingItemDetails Item = new ShoppingItemDetails(itemName, itemQty,
				itemPrice);
		ar.add(Item);
		for(ShoppingItemDetails list : ar){
			System.out.println(list.getItemName()+" "+list.getItemPrice()+" "+list.getItemQty());
		}
		
	}
	public void displayItem(){
		System.out.println(ar.size()+"items");
		for(ShoppingItemDetails x :ar){
			System.out.println(x.toString());
		}
	}
	public void buyItem(){
		System.out.println("enter the item to buy");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		int len= ar.size();
		int qty = 0;
		for(int i=0; i<len; i++) {
		    if (ar.get(i).getItemName().equals(input)) {
		       System.out.println("Item found");
		       System.out.println("enter the qty");
				 qty = scanner.nextInt();
				 {
				if(ar.get(i).getItemQty() >= (qty))
				{
					System.out.println("your billing amount is:");
					double a=ar.get(i).getItemPrice()*qty;
					System.out.println(a);
					ShoppingItemDetails chosen = ar.get(i);
					 int currentStock = chosen.getItemQty();
					 chosen.setItemQty(currentStock - qty);
				}
				 else 
				 {
						System.out.println("sorry out of stock");
				 }
		     }
		    }
		    else {
		    	System.out.println("sorry, out of stock please enter other item to buy");
		    }
		    
		}
		
		
	}
	
	
}
public class Inventory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		ShoppingList sl = new ShoppingList();
		int userOptions =0;
		while (userOptions != 3) {
            
            System.out.println("----- Shopping List------");
            System.out.println("(1) Add an item to the list. ");
            System.out.println("(2) Display list and total number of items. ");
            System.out.println("(3) Exit. ");
            userOptions = input.nextInt();  

            if (userOptions == 1) {
            sl.addItem();

            }

            if (userOptions == 2) {
            sl.displayItem();
            }
        }
		int userBuy =0;
		while(userBuy!=2){
			System.out.println("------------Buy item-----------");
			System.out.println("(1) Enter an item to buy");
			System.out.println("(2) exit");
			
			userBuy = input.nextInt();
			if(userBuy == 1){
				sl.buyItem();
				
			}
		}
         
	}

}
