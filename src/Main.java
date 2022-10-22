/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
import java.io.IOException;
import java.util.Scanner;

public class Main {

    // hàm hiển thị menu
    public static void showMenu() {
        System.out.println("""
                               
                               +------------Menu----------+
                               |   1.Input                |
                               |   2.Output               |
                               |   3.Bubble sort          |
                               |   4.Selection sort       |
                               |   5.Insection sort       |
                               |   6.Search > value       |
                               |   7.Search = value       |
                               |   0.Exit                 |
                               +--------------------------+
                               """);
    }

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        Algorithm algorithm = new Algorithm();

        //khởi tạo mảng để lưu dữ liệu từ file
        int n = -1;
        float[] a = new float[0];

        //biến để kiểm tra dữ liệu đầu vào đã có hay chưa
        boolean case_1 = false;
        boolean case_2 = false;

        // bắt đầu vòng lặp thực hiện các chức năng
        while (true) {

            // Hien thi menu
            showMenu();

            int choice;

            do {
                System.out.print("Choice: ");
                choice = scan.nextInt();

                if (choice < 0 || choice > 7) {
                    System.out.println("Nhập sai!");
                }
            } while (choice < 0 || choice > 7);

            // điều kiện dừng vòng lặp
            if (choice == 0) {
                System.out.println("Thanks!!!");
                break;
            }

            switch (choice) {
                //nhập input và lưu vào file INPUT.TXT
                case 1 -> {
                    case_1 = true;
                    System.out.print("Input number of elements: ");

                    //Nhập 0<n<20
                    do {
                        n = scan.nextInt();
                    } while (n < 1 || n > 20);

                    float[] arr = new float[n];
                    System.out.print("Input elements: ");

                    for (int i = 0; i < n; i++) {
                        arr[i] = scan.nextFloat();
                    }
                    // ghi dữ liệu từ mảng arr vào file
                    algorithm.writeFile("INPUT.TXT", arr);
                }
                //đọc dữ liệu từ file INPUT.TXT, lưu vào mảng float a
                case 2 -> {
                    case_2 = true;

                    //kiểm tra xem đã nhập chức năng 1 hay chưa
                    if (!(algorithm.check(case_1, case_2))) {
                        break;
                    }

                    System.out.print("Read from file\nArray a: ");
                    a = new float[n];
                    algorithm.readFile("INPUT.TXT", a);
                    algorithm.display(a);
                }
                //lưu dữ liệu từ a vào b, bubble sort, lưu vào file OUTPUT1.TXT
                case 3 -> {
                    if (!(algorithm.check(case_1, case_2))) {
                        break;
                    }

                    System.out.println("Bubble sort");
                    float b[] = new float[n];
                    algorithm.copy(b, a);
                    String s = algorithm.bubbleSort(b);
                    algorithm.display(b);
                    System.out.println(s);
                    algorithm.writeFile("OUTPUT1.TXT", s);
                }
                //lưu dữ liệu từ a vào b, seclection sort, lưu vào file OUTPUT2.TXT
                case 4 -> {
                    if (!(algorithm.check(case_1, case_2))) {
                        break;
                    }

                    System.out.println("Selection sort");
                    float b[] = new float[n];
                    algorithm.copy(b, a);
                    String s = algorithm.selectionSort(b);
                    System.out.println(s);
                    algorithm.writeFile("OUTPUT2.TXT", s);
                }
                //lưu dữ liệu từ a vào b, insertion sort, lưu vào file OUTPUT3
                case 5 -> {
                    if (!(algorithm.check(case_1, case_2))) {
                        break;
                    }

                    System.out.println("Insertion sort");
                    float b[] = new float[n];
                    algorithm.copy(b, a);
                    String s = algorithm.insertionSort(b);
                    System.out.println(s);
                    algorithm.writeFile("OUTPUT3.TXT", s);
                }
                //tìm kiếm tuyến tính những giá trị lớn hơn value, lưu vào file OUTPUT4
                case 6 -> {
                    System.out.print("Linear Search\nInput Value: ");
                    float value = scan.nextFloat();
                    String s = algorithm.search(a, value);
                    algorithm.writeFile("OUTPUT4.TXT", s);
                }
                //tìm kiếm nhị phân chỉ số của value, lưu vào file INPUT5
                case 7 -> {
                    System.out.print("Binary Search\nInput value: ");
                    float value = scan.nextFloat();
                    float b[] = new float[n];
                    algorithm.copy(b, a);
                    algorithm.insertionSort(b);
                    int index = algorithm.binarySearch(b, 0, n-1, value);
                    System.out.println("Index of first element: " + index);
                    algorithm.writeFile("OUTPUT5.TXT", "Index of first element: " + index);
                }
            }
        }
    }
}
