package by.epam.andrewzenov.testQuizful;

import java.io.IOException; 
import java.nio.file.*; 
 
class Test7 { 
    public static void main(String[] args) { 
        Path path = Paths.get("D:\\workspace\\LocalTraining\\SE_05\\task_1\\pom.xml"); 
        try { 
            Object object = Files.getAttribute(path, "creationTime"); 
            System.out.println("Creation time: " + object); 
             
            //Здесь указан третий параметр 
            object = Files.getAttribute(path, "lastModifiedTime", 
                    LinkOption.NOFOLLOW_LINKS); 
            System.out.println("Last modified time: " + object); 
 
            object = Files.getAttribute(path, "size"); 
            System.out.println("Size: " + object); 
 
            object = Files.getAttribute(path, "isDirectory"); 
            System.out.println("isDirectory: " + object); 

        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
    } 
} 