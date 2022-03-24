import java.util.Arrays;
import java.time.LocalDate;

public class ex3{

    ///////Exercicio1//////
    public int a(int arr[]){
        int min=arr[0];
        int pos=0;
        while(pos<arr.length){
            if (arr[pos]<min){
                min=arr[pos];
            }
            pos+=1;
        }
        return min;
    }

    public int[] b(int arr[],int index1, int index2){
        int tempArr[]=new int[index2-index1];
        int pos=0;
        while(index1<index2){
            tempArr[pos]=arr[index1];
            pos+=1;
            index1+=1;
        }
        return tempArr;
    }

    public int[] c(int arr1[],int arr2[]){
        int finArr[]=new int[arr1.length];
        int pos=0;
        int posI=0;
        while(pos<arr1.length){
            if(Arrays.binarySearch(arr2, arr1[pos])>=0 && Arrays.binarySearch(finArr,arr1[pos])<0){
                finArr[posI]=arr1[pos];
                posI+=1;
            }
            pos+=1;
        }
        return finArr;
    }
    ///////Exercicio 2/////

}