package strings;

public class SubstringRotated {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "amazon";
		String s2 = "azonam";
	    String newS1 = s1+s1;
        int len2 = s2.length();
//        for(int i = 0;i<3;i++){
//        	System.out.println(newS1.substring(i,len2+i));
//            if(newS1.substring(i,len2+i).equals(s2)){
//            	System.out.println("abc");
//                return;
//            }
//        }
        
        for(int i = len2-2;i<len2;i--){
            if(newS1.substring(i,len2+i).equals(s2)){
                System.out.println(newS1.substring(i,len2+i));
            	return ;
            }
        }
        return;
	}

}
