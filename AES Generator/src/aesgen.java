import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;


public class aesgen {

    public static void main(String args[]) {

    	
        String s = null;

        try {
        	
        	
        	System.out.println("Number of arguments:" + args.length + " arguments.");
        	System.out.println ("Argument List:");
        	for(int i=0; i<args.length; ++i) {
        	    System.out.println(args[i]);
        	}

    		

    		int keylen = args [2].length();
    		String cipher = "-aes-" + Integer.toString(keylen * 4) + "-" + args [4];
        	
        
    		String opensslcmd = String.format("openssl enc %s %s -K %s -v -nosalt -in %s -out %s", cipher, args[0], args[2], args[6], args[8]);

            Process p = Runtime.getRuntime().exec(opensslcmd);
            
            BufferedReader stdInput = new BufferedReader(new 
                 InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new 
                 InputStreamReader(p.getErrorStream()));

            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
            
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
            
            System.exit(0);
        }
        catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);
        }
    }
}