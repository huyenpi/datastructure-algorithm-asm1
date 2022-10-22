/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Algorithm {

    //kiểm tra xem đã nhập và lưu dữ liệu hay chưa
    public boolean check(boolean case_1, boolean case_2) {
        if (!case_1) {
            System.out.println("Hãy chọn chức năng 1 trước");
            return false;
        } else if (!case_2) {
            System.out.println("Hãy chọn chức năng 2 trước");
        }
        return case_2;
    }
    
//copy dữ liệu từ mảng a sang mảng b
    public void copy(float[] b, float[] a) {
        System.arraycopy(a, 0, b, 0, a.length);
    }

//ghi dữ liệu từ mảng float vào file
    public void writeFile(String fileName, float arr[]) {

        FileWriter fw = null;
        try {
            fw = new FileWriter(fileName);
            for (int i = 0; i < arr.length; i++) {
                String s = Float.toString(arr[i]) + ",";
                fw.write(s);
            }
        } catch (IOException ex) {
            Logger.getLogger(Algorithm.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Algorithm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    //ghi một chuỗi dữ liệu vào file
    public void writeFile(String fileName, String line) {
        FileWriter wf = null;
        try {
            wf = new FileWriter(fileName);
            wf.write(line);
        } catch (IOException ex) {
            Logger.getLogger(Algorithm.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                wf.close();
            } catch (IOException ex) {
                Logger.getLogger(Algorithm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
// hiển thị các phần tử trong mảng

    public void display(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

//đọc file, lưu dữ liệu kiểu float vào mảng
    public void readFile(String fileName, float[] arr) {
        FileInputStream fis = null;
        Scanner scan = null;
        try {
            fis = new FileInputStream(fileName);
            scan = new Scanner(fis);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] params = line.split(",");
                for (int i = 0; i < params.length; i++) {
                    arr[i] = Float.parseFloat(params[i]);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Algorithm.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(Algorithm.class.getName()).log(Level.SEVERE, null, ex);
            }
            scan.close();
        }

    }

    // hàm sắp xếp nổi bọt
    public String bubbleSort(float arr[]) {
        boolean sort;
        String st = "";

        do {
            sort = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    sort = true;
                    float temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                st += arr[i] + " ";
            }
            st += "\n";

        } while (sort);
        return st;

    }

    //ham sap xep theo thuat toan lua chon
    public String selectionSort(float arr[]) {
        String st = "";
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    float temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            for (int k = 0; k < arr.length; k++) {
                st += arr[k] + " ";
            }
            st += "\n";
        }

        return st;

    }

    //ham sap xep theo thuat toan chen
    public String insertionSort(float arr[]) {
        String st = "";
        for (int i = 1; i < arr.length; i++) {
            float temp = arr[i];
            int j = i - 1;
            while (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;

            for (int k = 0; k < arr.length; k++) {
                st += arr[k] + " ";
            }
            st += "\n";
        }
        return st;
    }

    // ham tim kiem tuyen tinh, tim vi tri cua phan tu co gia tri lon hon value,
    public String search(float arr[], float value) {
        boolean test = false;
        String s = "Chi so la: ";
        for (int i = 0; i < arr.length; i++) {
            if (value < arr[i]) {
                test = true;
                s += i + " ";
            }
        }
        if (test == true) {
            System.out.println(s);
        } else {
            s += "Not Found";
            System.out.println("Chi so la: Not Found");
        }
        return s;
    }

    //ham tim kiem nhi phan, tim chi so cua phan tu dau tien co gia tri bang value
    public int binarySearch(float arr[], int left, int right, float value) {
        if (right >= left) {
            int mid = (right + left) / 2;
            // nếu phần tử có ở chính giữa
            if (arr[mid] == value) {
                return mid;
            }
            // Nếu phần tử nhỏ hơn giữa, thì nó chỉ có thể
            // hiện diện trong mảng con bên trái
            if (arr[mid] > value) {
                return binarySearch(arr, left, mid - 1, value);
            }
            // Ngược lại, phần tử chỉ có thể có mặt
            // trong mảng con bên phải
            return binarySearch(arr, mid + 1, right, value);

        }
        //// Nếu phầnt tử không có trong mảng
        return -1;
    }
}
