package pageHelper;


public class Main
{
	public static void main(String[] args) {
	    
	    System.out.println(A.s);
		A.test();
	}
	

}

 class A{
    public static String s = "tushar";
    
    public static void test(){
        System.out.println(A.s);
    }
}