package com.cdac.cal;

import java.util.*;
//******************************************************************************


class privacy_Exc extends Exception
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString()
    { 
           return("\n\n\t\t\t    You are not an authorized user ");
    }


}

//******************************************************************************
 
class Privacy
{

    public int password()
    {
        int flag;
        try
           {
              
              Scanner sc1=new Scanner(System.in);
              System.out.println("\n ");
              System.out.print("\t\t\t       Enter the Password : ");
              int pswd=sc1.nextInt();

              if(pswd!=007)
                   throw new privacy_Exc();

              flag=1;
            }

         catch(privacy_Exc p)
            {  
               
               System.out.println(p);  
               flag=0;
            } 
            
            return flag;  
            
    }


}




//******************************************************************************

class Myexcptn extends Exception
{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public String toString()
  {
     return(" Please Enter a Valid Number ");
  }

}

 //******************************************************************************


class Calendar extends Privacy

{

   /*
       will declare few arrays to print the dates 
       in a line simulateneously for 4 months.

   */

   public static int odd_month1[]=new int[31];
  
   public static int odd_month2[]=new int[31];
   
   public static int feb_leap[]=new int[29];
  
   public static int feb_notleap[]=new int[28];

   public static int even_month1[]=new int[30];
  
   public static int even_month2[]=new int[30];

     
   static int day_jan,day_feb ,day_mrch;          //Need dese variables for every month
   static int day_aprl,day_may ,day_june;
   static int day_july ,day_aug ,day_sep;
   static int day_oct ,day_nov ,day_dec;

  //******************************************************************************

   void print_month(int day,int year)
   {

       /*
          Now we have the day on which this year is starting .that is which 
          day is jan1st.Aim in this function to print d numbers in order.
          s going from 1 to 3 as we r printing months in order of 4
  
       */


         for(int i=0;i<31;i++)                 // Initializing arrays
         {
              odd_month1[i]=i+1;
         }

         for(int i=0;i<29;i++)      
         {
              feb_leap[i]=i+1;
         }
         for(int i=0;i<28;i++)      
         {
              feb_notleap[i]=i+1;
         }
         for(int i=0;i<31;i++)      
         {
              odd_month2[i]=i+1;
         }
         for(int i=0;i<30;i++)      
         {
              even_month1[i]=i+1;
         }
         for(int i=0;i<30;i++)      
         {
              even_month2[i]=i+1;
         }
         
         

         for(int s=1;s<=4;s++)      //loop for displaying month name 
         {
  
              System.out.print("\n");
              if(s==1)
              {
                   System.out.println("\t    JANUARY \t\t    FEBRUARY \t\t     MARCH");
                   System.out.println("\t-S--M--T--W--T--F--S \t-S--M--T--W--T--F--S \t-S--M--T--W--T--F--S");
              }
              else
              if(s==2)
              {
                   System.out.println("\t     APRIL \t\t      MAY \t\t      JUNE"); 
                   System.out.println("\t-S--M--T--W--T--F--S \t-S--M--T--W--T--F--S \t-S--M--T--W--T--F--S");


              }
              else
              if(s==3)
              {
                   System.out.println("\t      JULY \t\t     AUGUST \t\t   SEPTEMBER"); 
                   System.out.println("\t-S--M--T--W--T--F--S \t-S--M--T--W--T--F--S \t-S--M--T--W--T--F--S");


              }
              else
              {
                   System.out.println("\t    OCTOBER \t\t    NOVEMBER \t\t     DECEMBER"); 
                   System.out.println("\t-S--M--T--W--T--F--S \t-S--M--T--W--T--F--S \t-S--M--T--W--T--F--S");

              }

              
              int leaptst; 

              day_jan=day;                      // initialize day of january
              

              int odd1_end=0,feb_end=0 ,odd2_end=0,even1_end=0 ,even2_end=0 ;   //to know whether all array elements r print till respective month end ie 31 ?30 ?28?29

              int jvacc=0 ,jstart=0;               //start for preventing loop to print vaccant place at beging again ie wen k1 =1 ,2 ...
              int fvacc=0 ,fstart=0;
              int mvacc=0 ,mstart=0;
              
              int apvacc=0 ,apstart=0;              
              int myvacc=0 ,mystart=0;
              int jnvacc=0 ,jnstart=0;
 
              int jyvacc=0 ,jystart=0;              
              int auvacc=0 ,austart=0;
              int sbvacc=0 ,sbstart=0;

              int ocvacc=0 ,ocstart=0;              
              int nvvacc=0 ,nvstart=0;
              int dbstart=0;


              for(int i=1;i<=6;i++)                            // 6 indicates the number of rows >>>>Need to consider 6*7=42 as reference.
              {                                                // 42 days should b printed for each month

                   if(s==1)                                    //  s=1 got second munth as feb
                   { 
                        System.out.print("\t");
       
                        for(int k1=0;k1<7;k1++)                // printing first 7 days of jan
                        { 
                             if(day_jan!=k1 && jstart==0 )
                             {
                            
                                  System.out.print("   ");
                                  jvacc++;
                             }   
                             else
                             {
                               
                                  jstart=1;
                                  if(odd1_end<31)
                                  {
                                      if(odd_month1[odd1_end]<10)
                                            System.out.print("0"+odd_month1[odd1_end]+" ");
                                      else
                                            System.out.print(odd_month1[odd1_end]+" ");
                                      odd1_end++;
 
                                  }
                                  else
                                  {
                                      System.out.print("   ");


                                  }


                             }

                         }// January
                         
                         day_feb=(31+jvacc)%7;                        

                         System.out.print("   ");   //Space between months

                         if(year%4==0)             //printing first 7 days of feb
                           leaptst=0;
                         else
                           leaptst=year%4;

                    
                         for(int k2=0;k2<7;k2++)   
                         {  
                              if(day_feb!=k2 && fstart==0 )
                              {         
                                    System.out.print("   ");
                                    fvacc++;
                              } 
                              else
                              {
                               
                                   fstart=1;
                                   if(feb_end<29 && leaptst==0)
                                   {
                                       if(feb_leap[feb_end]<10)
                                            System.out.print("0"+feb_leap[feb_end]+" ");
                                       else 
                                            System.out.print(feb_leap[feb_end]+" ");
                                       feb_end++;
 
                                    }
                                    else
                                    if(feb_end<28 && leaptst!=0)
                                    {
                                       if(feb_leap[feb_end]<10)
                                            System.out.print("0"+feb_notleap[feb_end]+" ");
                                       else 
                                            System.out.print(feb_notleap[feb_end]+" ");
                                       feb_end++;

                                    }
                                    else
                                    {
                                        System.out.print("   ");

                                    }



                              }


                          }    // end of feb

                          System.out.print("   ");       //Space between months

                          if(leaptst==0)
                             day_mrch=(29+fvacc)%7;
                          else
                             day_mrch=(28+fvacc)%7;
   
                           
                          for(int k3=0;k3<7;k3++)   
                          { 
                                
                             if(day_mrch!=k3 && mstart==0 )
                             {
                                  System.out.print("   ");
                                  mvacc++;
                             }   
                             else
                             {
                               
                                  mstart=1;
                                  if(odd2_end<31)
                                  {
                                      if(odd_month2[odd2_end]<10)
                                            System.out.print("0"+odd_month2[odd2_end]+" ");
                                      else
                                            System.out.print(odd_month2[odd2_end]+" ");
                                      odd2_end++;
 
                                  }
                                  else
                                  {
                                      System.out.print("   ");


                                  }


                             } 


                          
                           }// end of march

                          System.out.print("\n");

                          day_aprl =(31+mvacc)%7;

                   } // end of if s==1 

                   else
                   if(s==2)               
                   {     
                       
                         System.out.print("\t");
                               
                         for(int k1=0;k1<7;k1++)                // printing first 7 days of april
                         {
                               if(day_aprl!=k1 && apstart==0)
                               {
                                  System.out.print("   ");
                                  apvacc++;
                               }   
                               else
                               {
                               
                                  apstart=1;
                                  if(even1_end<30)
                                  {
                                      if(even_month1[even1_end]<10)
                                            System.out.print("0"+even_month1[even1_end]+" ");
                                      else
                                            System.out.print(even_month1[even1_end]+" ");
                                      even1_end++;
 
                                  }
                                  else
                                  {
                                      System.out.print("   ");


                                  }


                               }

                               

                          } // end of april

                          day_may =(30+apvacc)%7;

                          System.out.print("   ");   //Space between months

                          for(int k2=0;k2<7;k2++)   
                          {  
                              if(day_may!=k2 && mystart==0 )
                              {
                                    System.out.print("   ");
                                    myvacc++;
                              } 
                              else
                              {
                               
                                   mystart=1;
                                   if(odd1_end<31)
                                  {
                                      if(odd_month1[odd1_end]<10)
                                            System.out.print("0"+odd_month1[odd1_end]+" ");
                                      else
                                            System.out.print(odd_month1[odd1_end]+" ");
                                      odd1_end++;
 
                                  }
                                  else
                                  {
                                      System.out.print("   ");


                                  }



                              }


                           }    // end of may

                           day_june =(31+myvacc)%7;

                           System.out.print("   ");             //Space between months

                           for(int k3=0;k3<7;k3++)                // printing first 7 days of april
                           {
                               if(day_june!=k3 && jnstart==0)
                               {
                                  System.out.print("   ");
                                  jnvacc++;
                               }   
                               else
                               {
                               
                                  jnstart=1;
                                  if(even2_end<30)
                                  {
                                      if(even_month2[even2_end]<10)
                                            System.out.print("0"+even_month2[even2_end]+" ");
                                      else
                                            System.out.print(even_month2[even2_end]+" ");
                                      even2_end++;
 
                                  }
                                  else
                                  {
                                      System.out.print("   ");


                                  }


                               }

                               

                           } // end of june

                           System.out.print("\n");

                           day_july =(30+jnvacc)%7;

                   }//end else s=2

                   else
                   if(s==3)
                   {
                      
                        System.out.print("\t");
                               
                        for(int k1=0;k1<7;k1++)                // printing first 7 days of april
                        { 
                              if(day_july!=k1 && jystart==0 )
                              {
                                    System.out.print("   ");
                                    jyvacc++;
                              } 
                              else
                              {
                               
                                   jystart=1;
                                   if(odd1_end<31)
                                   {
                                      if(odd_month1[odd1_end]<10)
                                            System.out.print("0"+odd_month1[odd1_end]+" ");
                                      else
                                            System.out.print(odd_month1[odd1_end]+" ");
                                      odd1_end++;
 
                                   }
                                   else
                                   {
                                      System.out.print("   ");


                                   }



                              }  
 
                         } // end of july

                         System.out.print("   ");             //Space between months
  
                         day_aug =(31+jyvacc)%7;

                         for(int k2=0;k2<7;k2++)   
                          { 
                                
                             if(day_aug!=k2 && austart==0 )
                             {
                                  System.out.print("   ");
                                  auvacc++;
                             }   
                             else
                             {
                               
                                  austart=1;
                                  if(odd2_end<31)
                                  {
                                      if(odd_month2[odd2_end]<10)
                                            System.out.print("0"+odd_month2[odd2_end]+" ");
                                      else
                                            System.out.print(odd_month2[odd2_end]+" ");
                                      odd2_end++;
 
                                  }
                                  else
                                  {
                                      System.out.print("   ");


                                  }


                             } 


                          
                           }// end of august


                           System.out.print("   ");             //Space between months

                           day_sep =(31+auvacc)%7;

                           for(int k3=0;k3<7;k3++)                // printing first 7 days of april
                           {
                               if(day_sep!=k3 && sbstart==0)
                               {
                                  System.out.print("   ");
                                  sbvacc++;
                                                                
                               }   
                               else
                               {
                               
                                  sbstart=1;
                                  if(even2_end<30)
                                  {
                                      if(even_month2[even2_end]<10)
                                            System.out.print("0"+even_month2[even2_end]+" ");
                                      else
                                            System.out.print(even_month2[even2_end]+" ");
                                      even2_end++;
 
                                  }
                                  else
                                  {
                                      System.out.print("   ");


                                  }


                               }

                               

                           } // end of september
                           
                           System.out.print("\n");
                          
                           day_oct =(30+sbvacc)%7;

                   } // end of s=3

                   else
                   {

                        System.out.print("\t");
                               
                        for(int k1=0;k1<7;k1++)                // printing first 7 days 
                        { 
                              if(day_oct!=k1 && ocstart==0 )
                              {
                                    System.out.print("   ");
                                    ocvacc++;
                              } 
                              else
                              {
                               
                                   ocstart=1;
                                   if(odd1_end<31)
                                   {
                                      if(odd_month1[odd1_end]<10)
                                            System.out.print("0"+odd_month1[odd1_end]+" ");
                                      else
                                            System.out.print(odd_month1[odd1_end]+" ");
                                      odd1_end++;
 
                                   }
                                   else
                                   {
                                      System.out.print("   ");


                                   }



                              }  
 
                         } // end of October

                         System.out.print("   ");             //Space between months

                         day_nov =(31+ocvacc)%7;
                        
                         for(int k2=0;k2<7;k2++)                // printing first 7 days of april
                         {
                              if(day_nov!=k2 && nvstart==0)
                              {
                                  System.out.print("   ");
                                  nvvacc++;
                              }   
                              else
                              {
                               
                                  nvstart=1;
                                  if(even1_end<30)
                                  {
                                      if(even_month1[even1_end]<10)
                                            System.out.print("0"+even_month1[even1_end]+" ");
                                      else
                                            System.out.print(even_month1[even1_end]+" ");
                                      even1_end++;
 
                                  }
                                  else
                                  {
                                      System.out.print("   ");


                                  }


                               }
                               

                           } // end of november
 
                           System.out.print("   ");             //Space between months

                           day_dec =(31+nvvacc)%7;

                           for(int k3=0;k3<7;k3++)   
                           { 
                                
                              if(day_dec!=k3 && dbstart==0 )
                              {
                                  System.out.print("   ");
                                  
                              }   
                              else
                              {
                               
                                  dbstart=1;
                                  if(odd2_end<31)
                                  {
                                      if(odd_month2[odd2_end]<10)
                                            System.out.print("0"+odd_month2[odd2_end]+" ");
                                      else
                                            System.out.print(odd_month2[odd2_end]+" ");
                                      odd2_end++;
 
                                  }
                                  else
                                  {
                                      System.out.print("   ");


                                  }


                              } 


                          
                           }// end of december

                          System.out.print("\n");

                   }

              }  // end of i 1-6            


         } // end of s =1 -4


   }// end of print_month


   //******************************************************************************

  void program()
  {

      try
      {
            


            Scanner sc=new Scanner(System.in);
            System.out.println("\n ");
            System.out.print("\t\t\t\t Enter the year : ");
            int year=sc.nextInt();
               
            System.out.println("\n ");
            if(year<=0)
                throw new Myexcptn();
     

   /*
     We r considering 2012 as reference point.So jan1st 2012 is SUNDAY as per
     calendar.next year jan1st 2013 has jan1st as TUESDAY.here 2 days increased 
     as 1 increase for d year and 1(leap) for d leap year 2012.(feb got 29 days).
     next year 2014 has jan1st on WEDNESDAY,den 2015 THURSDAY. 

     leap_incr is used to find dat number of 1s in case of leap year.
     for ex:
             year=2016
     den leap_incr=(2016/4)-(2012/4)   = 1(for 2012)
          if year=2017
     den leap_incr=(2017/4)-(2012/4)+ 1(for 2016)= 2(for both 2012 and 2016)   
 
   */

             int day,leap_incr=0,day_back;                //   day goes from 0-6 for sun-mon

             if(year==2012)                               //   Taking 2012 as reference point
             {
                 day=0;                                  //   Jan1st 2006 is Sunday
 
             }
             else
             if(year>2012)
             {
                   if(year%4==0)
                         leap_incr=(year/4)-(2012/4);
                   else
                         leap_incr=(year/4)-(2012/4)+1;
  
                   day=(leap_incr+year-2006)%7;             // day calculating 
              }
              else
              {
                   if(year%4==0)
                         leap_incr=(2012/4)-(year/4)+1;    // here first increment as we r subtracting
                   else
                         leap_incr=(2012/4)-(year/4);      // from 7 later. c day=(7-day2)%7;
   
                   day_back=(2006-year+leap_incr)%7;
                   day=(7-day_back)%7;                     // day calculating 
              }
 
              print_month(day,year);                      // calling month() function

     }
     
     catch(Myexcptn e)
     { 
              System.out.println(e);

     }     


  } // end of program() function

 //******************************************************************************
 public static void main(String args[])
 {
       int valid;
       
       Privacy obj=new Privacy();
       valid=obj.password();
      
       if(valid==1)
       {
              Calendar C=new Calendar();
              C.program();
       }

 }



}// end of class Calendar







