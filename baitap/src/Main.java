import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);  // tạo bến scanner
    static int[] arr1 = {12, 23, 4, 65, 45};
    static int[] arr2 = {32, 33, 42, 6, 5};
    static int[] arr3 = {21, 20, 78, 61, 44};

    public static void main(String[] args) {
        //Viết một chương trình Java nhận một chuỗi từ người dùng và tách các từ trong chuỗi đó. Sau đó, in ra từng từ trên một dòng.

        Scanner scanner = new Scanner(System.in);
//        System.out.println("nhập chuỗi bạn mún:");
//        String str = scanner.nextLine();
//        String[] tokens = str.split(" ");
//        for (String token : tokens) {
//            System.out.println("các từ trong chuỗi là" + token);
//        }

        //Viết một chương trình Java để kiểm tra xem một chuỗi có phải là một địa chỉ email hợp lệ hay không, sử dụng regex.
        // Một địa chỉ email hợp lệ có thể có dạng "username@OrganizationName. area symbol". Vd: rikeiacademy@rikkeisoft.com


        //viết 1 chương trình java console,
        //cho sẵn 3 danh danh sách số nguyên;
        //hiển thị 1 menu với các lựa chọn sau:
        //1 hiển thị 3 mảng số nguyên
        //2.hiển thị mảng đc gộp từ 2 mảng số nguyên, lựa chọn được mảng để gộp
        //3. hiển thị mảng được gộp 3 mảng số ngyên
        //4. chọn 1 mảng số nguyên để in ra
        //4.1 thêm 1 phần tử vào cuối
        //4.2 thêm 1 phần tử vào đầu
        //4.3 xóa 1 phần tử ở vị trí đc chọn
        //5. dừng chương trình

        //chương trình được lặp lại cho đến khi chọn 5.


        while (true) {
//        while (chaice != 5 ) { //cách 2 để thoát vòng lặp
            System.out.println("1 hiển thị 3 mảng số nguyên");
            System.out.println("2.hiển thị mảng đc gộp từ 2 mảng số nguyên, lựa chọn được mảng để gộp");
            System.out.println("3. hiển thị mảng được gộp 3 mảng số ngyên");
            System.out.println("4. chọn 1 mảng số nguyên để in ra");
            System.out.println("5. dừng chương trình");
            Scanner sc = new Scanner(System.in);
            int chaice = sc.nextInt();
            switch (chaice) {
                case 1:
                    showArr(arr1, "mảng 1 là:");
                    showArr(arr2, "mảng 2 là:");
                    showArr(arr3, "mảng 3 là:");
                    break;
                case 2:
                    int[] arr = gopmang();
                    System.out.println("mảng sau khi gộp là: " + Arrays.toString(arr));
                    break;
                case 3:
                    System.out.println(gop3mang().length);
                    System.out.println("mảng sau khi gộp là: " + Arrays.toString(gop3mang()));
                    break;
                case 4:
                    hienmang4();
                    break;
                case 5:
                    System.exit(0);// tăt vòng lặp
            }
        }


    }

    private static int[] hienmang4(){
        System.out.println("Điền số mảng bàng muốn xem từ 1-3");
        int choice = scanner.nextInt();
        int[] mang =laymang(choice);
        System.out.println("mảng bạn đã chọn là:" + Arrays.toString(mang));


        System.out.println("thêm số muốn thêm vào cuối");
        int number = scanner.nextInt();
        int[] mangmoi = new int[mang.length +1];
        for (int i = 0; i < mang.length;i++){
            mangmoi[i] = mang[i];
        }
        mangmoi[mang.length+1] = number;
        System.out.println("số Bạn muốn thêm vào cuối mảng là:"+ mangmoi);

        return mang ;
    }
    private static int[] themcuoi() {
        System.out.println("thêm số muốn thêm vào cuối");
        int number = scanner.nextInt();
        int[] mangdachon = hienmang4();
       int[] mangmoi = new int[mangdachon.length +1];
        for (int i = 0; i < mangdachon.length;i++){
            mangmoi[i] = mangdachon[i];
        }
        return mangdachon;
    }
    private static int[] gopmang() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập mảng thứ nhất bạn muốn gộp");
        int choice = scanner.nextInt();
        int[] mang1 = laymang(choice);
        System.out.println("nhập mảng thứ hai bạn muốn gộp");
        int[] mang2 = laymang(choice);

        int[] newArr = new int[mang1.length + mang2.length];
        for (int i = 0; i < newArr.length; i++) {
            if (i < mang1.length) {
                newArr[i] = mang1[i];
            } else {
                newArr[i] = mang2[i - mang1.length];
            }
        }
        return newArr;
    }

    private static void showArr(int[] arr, String tenmang) {
        System.out.println(tenmang + Arrays.toString(arr));
    }


    private static int[] laymang(int somang) {
        switch (somang) {
            case 1:
                return arr1;
            case 2:
                return arr2;
            case 3:
                return arr3;
        }
        return null;
    }

    private static int[] gop3mang() {
        int[] arr1 = laymang(1);
        int[] arr2 = laymang(2);
        int[] arr3 = laymang(3);
        int[] gop = new int[arr1.length + arr2.length + arr3.length ];

        for (int i = 0; i < gop.length; i++) {
            if (i < arr1.length) {
                gop[i] = arr1[i];
            } else if (i < arr1.length + arr2.length) {
                gop[i] = arr2[i - arr1.length];
            } else {
                gop[i] = arr3[i -(arr1.length + arr2.length)];
            }
        }

        return gop;

    }

}