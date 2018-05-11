/**
Name: Nicholas Boesel
Date: 2/8/2016
Course/Section: IT 206.001
Assignment: Programming Assignment 2

What is being made here is the data definition class for campaigns to be run through the charities.
Each Campaign will have a name, a total funded, a goal amount, and whether the campaign is active or not.
It features a ready-made specific constructor for hardcoding and a default for user-entered variables.
There are getter and setter methods for every value in the Campaign and one special method to help add donations to the total.*/

public class Campaign
{
   private String name;
   private boolean forProfit;
   private double amountTotal;
   private double campaignGoal=10000;
   private boolean active=true;
   
   //specific constructor
   public Campaign(String tempName,boolean tempForProfit,double tempGoal)
   {
      this.name=tempName;
      this.forProfit=tempForProfit;
      this.amountTotal=0.0;
      this.active=true;
      this.campaignGoal=tempGoal;
   }
   //default constructor
   public Campaign()
   {}
   //changes the goal amount in this object
   public void setGoal(double myGoal)
   {
   	   this.campaignGoal=myGoal;
   }
   //retrieves the current goal amount
   public double getGoal()
   {return this.campaignGoal;}
   //sets whether the charity is for profit or not
   public void setForProfit(boolean myForProfit)
   {
      this.forProfit=myForProfit;
   }
   //checks whether the charity is for profit or not
   public boolean getForProfit()
   {return this.forProfit;}
   //adds donated money to the total donations
   public void addTotal(double donation)
   {
         this.amountTotal+=donation;
   }
   //retrieves the amount of money already donated
   public double getTotal()
   {return this.amountTotal;}
   //sets whether the campaign is active or not
   public void setActive(boolean myActive)
   {
      this.active=myActive;
   }
   //finds out whether the campaign is active or not
   public boolean getActive()
   {return this.active;}
   
   public void setName(String myName)
   {this.name=myName;}
   public String getName()
   {return this.name;}
}