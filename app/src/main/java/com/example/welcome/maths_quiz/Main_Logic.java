package com.example.welcome.maths_quiz;

public class Main_Logic {

    public static int generate_number(){

        int max = 1000,min = 1;
        int random_num = min + (int)(Math.random() * ((max - min) + 1));
        return(random_num);
    }
    public static int check_prime(int k){

        int num_factors = 0;
        for(int i=1;i<=k/2;i++)
        {
            if(k%i==0)
                num_factors++;
        }
        if(num_factors==1){

            return(1);
        }
        else
            return(0);
    }
}
