import java.util.Scanner;
import java.util.Arrays;
public class sriSubhashHw2 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Hello world!");

        int i=0,j=0,counter=0,optioni=0;
        String optiona="",optionb="";
        do{counter=0;
            double [] array=new double [2];
            System.out.println("\n Enter few integer values into an array to test a function :");
            do{
                if(counter>=array.length)
                {
                    array=Arrays.copyOf(array,array.length+1);
                }
                array[counter]=input.nextInt();
                counter++;
                System.out.println("\nWould you like to add more (y/n) = ");
                optiona=input.next();
                System.out.println("------");
            }while(optiona.equals("y"));

            System.out.println("\n\n Below are some functions :\n1. Swap the first and last elements in the array.\n2. Shift all elements by one to the right and move the last element into the first position. \n3. Replace all even elements with 0.\n4. Replace each element except the first and last by the larger of its two neighbors.\n5. Remove the middle element if the array length is odd, or the middle two elements if the length is even\n6. Move all even elements to the front, otherwise preserving the order of the elements. \n7. Return the second-largest element in the array. \n8. Return true if the array is currently sorted in increasing order. \n9. Return true if the array contains two adjacent duplicate elements. \n10.Return true if the array contains duplicate elements (which need not be adjacent). ");
            System.out.println("\n\n The results are being displayed one by one = ");
                swapFirstAndLast(array);
                moveElementByRight(array);
                replEvenElementsWithZero(array);
                replMidByLargestOfNb(array);
                removeMiddleElement(array);
                moveEvenFront(array);
                scdLargeElemnt(array);
                checkAscOrder(array);
                checkAdjDupl(array);
                checkDupl(array);
                System.out.println("\n Would you like to continue the program  (y/n) = ");
                optionb=input.next();
        }while(optionb.equals("y"));
    }

    public static void swapFirstAndLast(double [] array1)
    { double []Array1=Arrays.copyOf(array1,array1.length);
        double temp=Array1[0];
        Array1[0]=Array1[Array1.length-1];
        Array1[Array1.length-1]=temp;
        System.out.println("\n 1. Resultant array after swapping the first and the last numbers = \n");
        for(int i=0;i<Array1.length;++i)
        {System.out.print(Array1[i]+" ");}
        System.out.println();
    }

    public static void moveElementByRight(double [] array2)
    {   double []Array2=Arrays.copyOf(array2,array2.length);
        double temp=Array2[Array2.length-1];

        for(int i=Array2.length-1;i>0;--i)
        {
            Array2[i]=Array2[i-1];

        }
        Array2[0]=temp;
        System.out.println("\n 2. Resultant array after moving all elements to the right = \n");
        for(int i=0;i<Array2.length;++i)
        {System.out.print(Array2[i]+" ");}
        System.out.println();
    }
    public static void replEvenElementsWithZero(double []array3)
    {   double []Array3=Arrays.copyOf(array3,array3.length);
        for(int i=0;i<Array3.length;++i)
        {
            if(Array3[i]%2==0)
            {
                Array3[i]=0;
            }
        }
        System.out.println("\n 3. Resultant array after replacing all even elements wth 0 = \n");
        for(int i=0;i<Array3.length;++i)
        {System.out.print(Array3[i]+" ");}
        System.out.println();
    }
    public static void replMidByLargestOfNb(double []array4){
        double []Array4=Arrays.copyOf(array4,array4.length);
        double temp1=0,temp2=0,temp3=0;
        double []arrayd= new double[Array4.length];
        arrayd[0]=Array4[0];
        arrayd[Array4.length-1]=Array4[Array4.length-1];
        for(int i=1;i<(Array4.length-1);++i)
        {
            temp1=Array4[i-1];
            temp2=Array4[i+1];
            if(temp1>temp2)
                arrayd[i]=temp1;
            else
                arrayd[i]=temp2;
        }
        System.out.println("\n 4. The array after replacing the neighbouring values = ");
        for(int i=0;i<arrayd.length;++i)
            System.out.print(arrayd[i]+" ");
        System.out.println();
    }
    public static void removeMiddleElement(double []array5)
    {   double []Array5=Arrays.copyOf(array5,array5.length);
        int middle=0,midplus1=0,count=0;
        double [] arrayd= new double [2];
        if(Array5.length%2==0)
        {
            middle=Array5.length/2;
            midplus1=middle-1;
            arrayd=Arrays.copyOf(Array5, Array5.length-2);
            for(int i=0;i<Array5.length;++i)
            {
                if((i==middle)||(i==midplus1))
                {
                    continue;
                }
                else
                {
                    arrayd[count]=Array5[i];
                    count++;
                }
            }
        }
        else
        {
            middle=(Array5.length/2);
            arrayd=Arrays.copyOf(Array5,Array5.length-1);
            for(int i=0;i<Array5.length;++i)
            {
                if(i==middle)
                {
                    continue;
                }
                else
                {
                    arrayd[count]=Array5[i];
                    count++;
                }
            }
        }
        System.out.println("\n 5. Resultant array after removing the middle element/elements = ");
        for(int i=0;i<arrayd.length;++i)
        {System.out.print(arrayd[i]+" ");}
        System.out.println();
    }

    public static void moveEvenFront(double []array6){
        double []Array6=Arrays.copyOf(array6,array6.length);
        double temp=0;
        for(int i=0;i<Array6.length;++i)
        {
            if(Array6[i]%2==0)
            {
                continue;
            }
            else{
                for(int j=i+1;j<Array6.length;++j)
                { temp=0;
                    if(Array6[j]%2==0){
                        temp=Array6[i];
                        Array6[i]=Array6[j];
                        Array6[j]=temp;
                    }
                }
            }
        }
        System.out.println("\n 6. Resultant array after moving the even elements towards right = ");
        for(int i=0;i<Array6.length;++i)
        {System.out.print(Array6[i]+" ");}
        System.out.println();
    }
    public static void scdLargeElemnt(double []array7)
    {   double []Array7=Arrays.copyOf(array7,array7.length);
        double first=0,second=0;
        int count=-1,pos=0,i;
        first=second=0;
        for(i=0;i<Array7.length;++i)
        {
            if(Array7[i]>first)
            {
                second=first;
                first=Array7[i];
            }
            else if(Array7[i]>second && Array7[i]!=first)
            {
                second=Array7[i];
            }
        }
        System.out.println("\n 7. The second largest element of the array is = "+second);
        System.out.println();
    }

    public static void checkAscOrder(double []array8)
    {   double []Array8=Arrays.copyOf(array8,array8.length);
        boolean check=true;
        for(int i=0;i<Array8.length;++i)
        {
            if(i<(Array8.length-1))
            {
                if (Array8[i]<=Array8[i+1])
                    continue;
                else
                {
                    check=false;
                    break;
                }
            }
        }
        if(check)
            System.out.println("\n 8. The elements are in ascending order. ");
        else
            System.out.println("\n 8. The elements are not in ascending order");
        System.out.println();
    }
    public static void checkAdjDupl(double []array9)
    {   double []Array9=Arrays.copyOf(array9,array9.length);
        boolean check=true;
        for(int i=0;i<(Array9.length-1);++i)
        {
            if(Array9[i]==Array9[i+1])
            {
                check=false;
                break;
            }
        }
        if(check)
            System.out.println("\n 9. There are no adjacent duplicate elements in the array.");
        else
            System.out.println("\n 9. There are adjacent duplicate elements in the array. ");
        System.out.println();
    }
    public static void checkDupl(double []array10)
    {   double []Array10=Arrays.copyOf(array10,array10.length);
        boolean check=true;
        for(int i=0;i<Array10.length;++i)
        {
            for(int j=i+1;j<Array10.length;++j)
            {
                if(Array10[i]==Array10[j])
                {check=false;
                    break;}
            }
        }
        if(check)
            System.out.println("\n 10. There are no duplicate elements in the array.");
        else
            System.out.println("\n 10. There are duplicate elements in the array.");
        System.out.println();
    }
}

