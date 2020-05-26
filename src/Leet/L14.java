package Leet;

public class L14 {
    public static void main(String[] args) {
        new L14().run();
    }

    private void run() {
        String str[] = {"flower","flow","flight"};
        int len = str.length;

        String prefix = str[0];

        for(int i = 1;i<len;i++) {
            System.out.println(str[i].indexOf(prefix));
            while(str[i].indexOf(prefix)!=0){
                prefix = prefix.substring(0, prefix.length()-1);
                if(prefix.length()==0) {
                    return;
                }
            }
        }
        System.out.println(prefix);

    }
}
