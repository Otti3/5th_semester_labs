import java.util.Scanner;

public class Lab_1 {
    //Для переданной в качестве параметра последовательности из N целых чисел написать утилиту c функционалом:
    //1) Для данной последовательности, выводит значение «равны» если все элементы последовательности
    // равны и «не равны», в противном случае.



    public static void main(String[] args){
        task1();
        task2();
        task3();
    }

    public static void task1(){
        System.out.println("Task 1");
        System.out.println(isArrElementsAreEqual(new int [] {1, 1, 2} ));
    }

    public static void task2(){
        Scanner input = new Scanner(System.in);
        System.out.println("Task 2");
        System.out.println("Enter array length: ");
        int size = input.nextInt();
        double array[] = new double[size];
        System.out.println("Insert array elements:");
        for (int i = 0; i < size; i++) {
            array[i] = input.nextDouble();
        }
        printArray((subArray(array, 0, 2 )));
    }

    public static void task3(){
        System.out.println("Task 3");
        Scanner in = new Scanner(System.in);
        System.out.print("Input string: ");
        String string = in.nextLine();
        System.out.println(shiftRight(string, -1));

    }

    public static void printArray(double[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }


    public static String isArrElementsAreEqual(int [] inputArr){
        String notEqual = "не равны";
        String equal = "равны";
        for (int i=0; i < inputArr.length - 1; i++){
            if (inputArr[i] != inputArr[i + 1]){
                return notEqual;
            }
        }
        return equal;
    }

    public static double[] subArray(double[] array, int startIndex, int endIndex){
        if (startIndex < 0 || startIndex >= array.length){
            System.out.println("Левая граница broken");
            return new double[0];
        }
        if (endIndex < startIndex){
            System.out.println("Правая граница broken");
            return new double[0];
        }
        if (endIndex >= array.length){
            endIndex = array.length;
        }
        double [] resultArr = new double[endIndex - startIndex];
        int count = 0;
        for (int i = startIndex; i < endIndex; i++){
            resultArr[count] = array[i];
            count++;
        }
        return resultArr;
    }

    public static String shiftRight(String srt, int shift){
        if (srt == null){
            return null;
        }
        int resultShift = shift % srt.length();
        if (resultShift < 0){
            resultShift = resultShift + srt.length();
        }

        for (int i = 0; i < resultShift; i++){
            String temp = "";
            temp += srt.charAt(srt.length() - 1);
            for (int j = 0; j < srt.length() - 1; j++){
                temp += srt.charAt(j);
            }
            srt = temp;

        }
        return srt;
    }

}
