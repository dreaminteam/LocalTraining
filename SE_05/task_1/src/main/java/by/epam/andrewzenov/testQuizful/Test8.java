package by.epam.andrewzenov.testQuizful;

import java.io.IOException; 
import java.nio.file.*; 
 
public class Test8 { 
    public static void main(String[] args) { 
        Path pathSource = Paths.get("D:\\workspace\\LocalTraining\\SE_05\\task_1\\test.txt"); 
        Path pathDestination = Paths.get("D:\\testCopy.txt"); 
        try { 
//        	Files.move(pathSource, pathDestination,StandardCopyOption.REPLACE_EXISTING); 
//        	System.out.println("Source file moved successfully");
            Files.copy(pathSource, pathDestination,StandardCopyOption.REPLACE_EXISTING); 
            System.out.println("Source file copied successfully"); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
    } 
} 
