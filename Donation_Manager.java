/**
Name: Nicholas Boesel
Date: 2/8/2016
Course/Section: IT 206.001
Assignment: Programming Assignment 2

We have code in this class to help manage the campaigns and give them the inputs needed to gain donations and end.
You are asked the name of your campaign, whether it's for profit or not, how much you want to raise, and whether you want to
continue donating after entering your donation. The input methods also contain checks to keep the user from entering wrong information or crashing the program.
We set the fee for for-profit charities and then go through our hardcoded campaign in order to test the checks. then we move on to the user-input
campaign where you are asked for all of the inputs and we loop to repeat the actions of donating asking to continue and finally checking to
see if your funding goals were met and whether your custom campaign or the hardcoded campaign generated more money.
This will output two text boxes, one stating whether you exceeded your donation amount, met it exactly, or didn't meet it.
The other one shows which made more and how much the winning campaign made in dollars.
*/

import javax.swing.JOptionPane;
public class Donation_Manager
{
   public static void main(String[]args)
   {
      double fee=initFee();
      //Set hardcoded placeholder Campaign
      Campaign iTScholarship=new Campaign("IT Scholarship Fund",false,15000);
      sendDonation(iTScholarship,fee,2000);
      sendDonation(iTScholarship,fee,3600);
      sendDonation(iTScholarship,fee,1255);
      iTScholarship.setActive(false);
      campaignOver(iTScholarship);
      //End hardcoded campaign and begin user input campaign
      Campaign myCampaign=new Campaign();
      pickName(myCampaign);
      pickForProfit(myCampaign);
      pickAmount(myCampaign);
      //Ask the user to donate until they do not want to any more
      myCampaign.setActive(true);
      do{
         double donation=makeDonation();
         sendDonation(myCampaign,fee,donation);
         wantoToContinue(myCampaign);
         myCampaign.getActive();
        }
      while(myCampaign.getActive()==true);
      campaignOver(myCampaign);
      compare(iTScholarship,myCampaign);

   }
   //Gathers the amount of money someone would wish to donate
   public static double makeDonation()
   {
      double donation;
      try{
            do
            {
               donation=Double.parseDouble(JOptionPane.showInputDialog("How much would you like to donate?"));
               if(donation<=0)
                  {JOptionPane.showMessageDialog(null,"Invalid amount");}
            }
            while(donation<=0); 
         }
      catch(NumberFormatException e)
         {
          donation=0;
          JOptionPane.showMessageDialog(null,"Invalid entry, zero added to campaign");
         } 
      return donation;
   }
   //adds the donation amount to the campaign total
   public static void sendDonation(Campaign cause,double forProfitFee,double donation)
   {
      if(cause.getForProfit()==true)
      {cause.addTotal(donation-(donation*forProfitFee));}
      else
      {cause.addTotal(donation);}
   }
   //asks the user if they want to keep donating
   public static void wantoToContinue(Campaign cause)
   {
      boolean continuation;
      int option=JOptionPane.showConfirmDialog(null, "Would you like to continue donating?","",JOptionPane.YES_NO_OPTION);
      if(option==0)
      {cause.setActive(true);}
      else
      {cause.setActive(false);}
   }
   //Asks the user if their charity is for profit or not
   public static void pickForProfit(Campaign cause)
   {
      int option=JOptionPane.showConfirmDialog(null, "Is this a for-profit charity?","",JOptionPane.YES_NO_OPTION);
      if(option==0)
      {cause.setForProfit(true);}
      else
      {cause.setForProfit(false);}
   }
   //asks the user to name their campaign
   public static String pickName(Campaign cause)
   {
      String name;
      do{;
         name=JOptionPane.showInputDialog("What is your campaign called?");
         if(name.equals(""))
         {JOptionPane.showMessageDialog(null,"Invalid Name");}
         }
      while(name.equals(""));
      cause.setName(name);
      return name;
   }
   //asks the user to set their campaign goal
   public static double pickAmount(Campaign cause)
   {
      double goal;
      try{
         do{;
            goal=Double.parseDouble(JOptionPane.showInputDialog("What is your campaign's goal?"));
            if(goal<=0||goal>25000)
            {JOptionPane.showMessageDialog(null,"Invalid Amount");}
            }
         while(goal<=0||goal>25000);
         }
      catch(NumberFormatException e)
      {
         goal=10000;
         JOptionPane.showMessageDialog(null,"Invalid entry, campaign goal set to $10000 default");
      }
      cause.setGoal(goal);
      return goal;
   }
   //initializes fee rate for for profit charities
   public static double initFee()
   {double fee=0.05; 
   return fee;}
   //measures if a campaign has gotten it's goal amount or not
   public static void campaignOver(Campaign cause)
   {
      if(cause.getTotal()>cause.getGoal())
         {JOptionPane.showMessageDialog(null,"Goal exceeded!\n"+String.format("%.2f",cause.getTotal())+"/"+String.format("%.2f",cause.getGoal()));}
      else if(cause.getTotal()<cause.getGoal())
         {JOptionPane.showMessageDialog(null,"Goal not met!\n"+String.format("%.2f",cause.getTotal())+"/"+String.format("%.2f",cause.getGoal()));}
      else if(cause.getTotal()==cause.getGoal())
         {JOptionPane.showMessageDialog(null,"Goal met!\n"+String.format("%.2f",cause.getTotal())+"/"+String.format("%.2f",cause.getGoal()));}
   }
   //compares the sample charity versus the one that was user-input
   public static void compare(Campaign cause1, Campaign cause2)
   {
      if(cause1.getTotal()>cause2.getTotal())
         {JOptionPane.showMessageDialog(null,cause1.getName()+" made more money\n$"+String.format("%.2f",cause1.getTotal()));}
      if(cause1.getTotal()<cause2.getTotal())
         {JOptionPane.showMessageDialog(null,cause2.getName()+" made more money\n$"+String.format("%.2f",cause2.getTotal()));}
      if(cause1.getTotal()==cause2.getTotal())
         {JOptionPane.showMessageDialog(null,"Both campaigns made the same\n$"+String.format("%.2f",cause1.getTotal()));}
   }
}