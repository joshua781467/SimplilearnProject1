import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SimplilearnProject1 {

    private  static void displayOptions(){
        String[] menu = new String[] {"add =1","delete=2", "search=3", "menu=4", "exit=5"};
        for (int i= 0 ; i< menu.length; i++){
            System.out.println(menu[i]);
        }
    }

    static int binarySearch(String[] arr, String x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            int res = x.compareTo(arr[m]);

            // Check if x is present at mid
            if (res == 0)
                return m;

            // If x greater, ignore left half
            if (res > 0)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        return -1;
    }
    //add files to directory if it is not already present
    private static void addFileToDirectory(String filename){
        File file = new File("/Users/joe/test/"+filename);
        boolean result = false;
        try
        {
            result = file.createNewFile();
            if(result)
            {
                System.out.println("file created "+file.getCanonicalPath());
            }
            else
            {
                System.out.println("File already exist at location: "+file.getCanonicalPath());
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
    // deletes file in directory if it is present
    private static void deleteFileFromDirectory(String filename){
        File file = new File("/Users/joe/test/"+filename);
        boolean result = false;
        try
        {
            result = file.delete();
            if(result)
            {
                System.out.println("file deleted "+file.getCanonicalPath());
            }
            else
            {
                System.out.println("File does not exist at location: "+file.getCanonicalPath());
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
 // search whether the file exits in directory if so returns the index
    private static void searchFile(String filename){
        File file = new File("/Users/joe/test");
        try
        {
            String[] files = file.list();
            Arrays.sort(files);
            int result = binarySearch(files,filename);
            if(result == -1)
                System.out.println("no file found");
            else
                System.out.println("File name "+filename +" found at index"+ result);
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }


    }

/* Program which takes input from user and performs operations */

    public static void main(String[] args) {
        System.out.println("Display options");
        displayOptions();

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter option: ");
        int option = in.nextInt();

        Scanner input = new Scanner(System.in);
        String fileName ;

        switch (option){
            case 1 : System.out.println("type file name to add");
                fileName =input.next();
                addFileToDirectory(fileName);
                break;
            case 2 :
                System.out.println("type file name you want to delete");
                fileName =input.next();
                deleteFileFromDirectory(fileName);
                break;
            case 3 :
                System.out.println("type the file name you want to search");
                fileName = input.next();
                searchFile(fileName);
                break;
            case 4 : displayOptions();
                     break;

            case 5 : System.exit(0);

            default:
                System.out.println("provide valid input");




        }

    }
}
