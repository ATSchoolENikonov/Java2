package Lesson2;

public class HW2 {
    public static void main(String args[]) {
        String arr[][] = new String[][]
                //new String [4][4];   //проверка второго исключения
                {{"1", "1", "1", "1"}, {"2", "2", "2", "2"}, {"3", "3", "3", "3"}, {"4", "4", "4", "4"},
                        {"5", "5", "5", "5"}};   //проверка первого исключения

        try {
            int total = findEx(arr);
            System.out.println(total);
        } catch (MyArraySizeException exc) {
            System.out.println("Превышен размер массива");
        } catch (MyArrayDataException exc) {
            System.out.println("Шалость не удалась!");
            System.out.println("Ошибка в элементе массива номер " + exc.i + exc.j);
        }
    }

    public static int findEx(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int a = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                try {
                    a = a + Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException exc) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return a;
    }
}
