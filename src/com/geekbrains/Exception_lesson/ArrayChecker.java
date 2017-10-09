package com.geekbrains.Exception_lesson;

public class ArrayChecker {
    private String[][] strings;

    public void setStrings(String[][] strings) {
        try {
            checkSizeArray(strings);
            this.strings = strings;
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }
        catch (NullPointerException ne){
            System.out.println("В параметр массива передан null!");
            ne.printStackTrace();
        }
    }

    private void checkSizeArray(String[][] strings) throws MyArraySizeException {
        if (strings.length != 4 || strings[0].length !=4){
            throw new MyArraySizeException("Размер массива не соответствует 4х4");
        }
    }

    public void summ(){
        if (strings == null){
            System.out.println("У класса не инициализирован массив строк, суммировать нечего");
            return;
        }

        try {
            summArray();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    private void summArray() throws MyArrayDataException {
        int result = 0;
        for (int x = 0;x<strings.length;x++) {
            String[] str = strings[x];
            for (int y = 0;y<str.length;y++) {
                try {
                    result+=Integer.parseInt(str[y]);
                }
                catch (NumberFormatException e){
                    throw new MyArrayDataException("Массив содержит не только числа, суммирование не возможно. Ошибка в ячейке: " + x + ":" + y);
                }
            }
        }
        System.out.println("Сумма элементов массива: " + result);
    }
}
