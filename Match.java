package com.example.Java101.boksOyunu;
import java.util.Random;
import java.sql.SQLOutput;

public class Match {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;


    Match(Fighter f1, Fighter f2, int minWeight, int maxWeight){
        this.f1=f1;
        this.f2=f2;
        this.maxWeight=maxWeight;
        this.minWeight=minWeight;
    }
    public void run(){
        determineFirstAttacker();

        if(isCheck()){
            while(this.f1.health > 0 && this.f2.health > 0) {
                System.out.println("=====YENİ ROUND=====");
                this.f2.health=this.f1.hit(this.f2);
                if(isWin()){
                    break;
                }
                //System.out.println(this.f2.health);
                this.f1.health=this.f2.hit(this.f1);
                if(isWin()){
                    break;
                }
                //System.out.println(this.f1.health);
                System.out.println(this.f1.name+" Sağlık: "+this.f1.health);
                System.out.println(this.f2.name+" Sağlık: "+this.f2.health);

            }
        }else{
            System.out.println("Sporcuların sikletleri uymuyor.");
        }
    }
    private void determineFirstAttacker() {
        Random random = new Random();
        int randomNumber = random.nextInt(100); // 0-99 arasında rastgele bir sayı alınır

        // %50 olasılıkla ilk dövüşçü belirlenir
        if (randomNumber < 50) {
            System.out.println("İlk dövüşçü: " + f1.name);
        } else {
            System.out.println("İlk dövüşçü: " + f2.name);
            // Eğer ikinci dövüşçü ilk saldıran ise, f1 ve f2 yer değiştirecek
            Fighter temp = f1;
            f1 = f2;
            f2 = temp;
        }
    }
    boolean isCheck(){
        return (this.f1.weight>=minWeight && this.f1.weight<=maxWeight) && (this.f2.weight>=minWeight && this.f2.weight<=maxWeight);
    }
    boolean isWin() {
        if (this.f1.health == 0) {
            System.out.println(this.f2.name + " kazandı.");
            return true;
        }
        if(this.f2.health==0){
            System.out.println(this.f1.name+ " kazandı.");
            return true;
        }
        return false;
    }


}
