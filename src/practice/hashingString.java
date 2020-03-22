package practice;

public class hashingString {

    public static void main(String[] args) {
        String a[] = {"Customer_3412", "Customer_5463","Customer_5721", "Customer_1233120122asdsdfsdfsd33"};

        for(String str : a) {
            long hash = 0;
            for (int i = 0; i < str.length(); i++) {
                hash = hash + str.charAt(i);
            }
            System.out.println(hash);
            System.out.println(hash%3);
        }
    }
}
