package Assignment.Question2;
/*
Q2)Write a program for money withdraw and deposit using interprocess communication
for a Person with 1000 rupees in his account
execute with 2 threads  withdraw 1500 and deposit 1000 using wait() and notify()
*/
class Person{
    int amnt=1000;

    public int getAmnt() {
        return amnt;
    }

    synchronized void withdraw(int amnt){
        System.out.println("Withdrawing....");
        if(this.amnt<amnt){
            System.out.println("Less Balance");
            try{
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        this.amnt=this.amnt-amnt;
        System.out.println("Withdraw Completed, Amount in the account is :- "+this.amnt);
    }
    synchronized void deposit(int amnt){
        System.out.println("Depositing....");
        this.amnt+=amnt;
        notify();
        System.out.println("Deposit Completed, Amount in the account is :- "+this.amnt );
    }
}
public class Question2 {
    public static void main(String[] args) {
        Person p = new Person();
        new Thread() {
            @Override
            public void run() {
                p.withdraw(1500);
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                p.deposit(1000);
            }
        }.start();

    }
}
