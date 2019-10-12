package com.PracticeMedian.app;

public class Main {
    public static void main(String[] args) {
        //Declarations
        int vector[] = {10,1,5,6,7,9,5,3,3};
        int mode = 0;
        double mean = 0;
        int median = 0;

        //Process mean
        for (byte count = 0; count < vector.length; count++){
            mean = mean + vector[count];
        }
        mean /= vector.length;

        //Process median
        median = Median(vector);

        //Process mode
        mode = Mode(vector);

        //output results
        System.out.println(String.format("Mode: %d Mean: %.2f Median: %d", mode,mean, median));
    }
    //Mode process
    public static int Mode(int vector[]){
        //Declarations
        byte repitCount = 0;
        byte repitMax = 0;
        int mode = 0;

        //Process count repeated numbers
        for (byte i = 0;i < vector.length; i++){
            for(byte j = 0; j < vector.length; j++){
                //repeated number
                if(vector[i] == vector[j]) {
                    repitCount++;
                }
            }
            //Repeated number counter size validator
            if(repitCount > repitMax){
                mode = vector[i];
                repitMax = repitCount;
            }
            repitCount = 0;
        }
        return mode;
    }
    //Median process
    public static int Median(int vector[]){
        //Process
        int vectorOrder[] = BurbbleSort(vector);
        //Get the median position
        int pos = vector.length / 2;
        //
        if(pos % 2 == 0){
            return (vectorOrder[pos-1] + vectorOrder[pos])/2;
        }
        else{
            return vectorOrder[pos];
        }
    }

    //Shorting Burbble
    public static int[] BurbbleSort(int[] vector){
        //Declarations
        int aux = 0;

        //Sort ascending
        for(int i = 0; i < vector.length; i++){
            for(int j = 0; j< i; j++){
                if(vector[i] < vector[j]){
                    aux = vector[j];
                    vector[j] = vector[i];
                    vector[i] = aux;
                }
            }
        }
        return vector;
    }
}
