package Assignment.Question1;
/*
Q1)Write a program for seat reservations using multi threading and synchronization concepts learnt
        where each person who tries to reserve a seat is treated as a thread,
        There are 10 seats and each person accesses the synchronized method in Reservation class.
        give appropriate outputs depending on the availability of the seats

*/

import java.util.ArrayList;
import java.util.Scanner;

class  Reservation{
    int seats;
    Reservation(int seats){
        this.seats=seats;
    }
    synchronized void bookseat(){
        if(this.seats<=0){
            System.out.println("Remaining seats are :- "+this.seats);
            System.out.println("No Seats Available");
            System.exit(0);
        }else{
            this.seats-=1;
            System.out.println("Your Seat Booked Successfully.");
            System.out.println("Remaining seats are :- "+this.seats);
        }
    }
}
class Thread1 extends  Thread{
    Reservation r;

    Thread1(Reservation r){
        this.r=r;
    }
    public void run(){
        r.bookseat();
    }
}
public class Question1 {
    public static void main(String[] args) {
        int n;
        System.out.println("Total seats available are 10");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of persons who are trying to book tickets :-");
        n=sc.nextInt();
        Reservation r=new Reservation(10);// you can change the number of seats
        ArrayList<Thread1> th=new ArrayList<>();
           for(int i=0;i<n;i++){ // if you want you can change the number of people booking seats (here only 3 people are booking seats)
               Thread1 t=new Thread1(r);
               th.add(t);
           }
           for(Thread1 t: th){
               t.start();
           }

    }
}
