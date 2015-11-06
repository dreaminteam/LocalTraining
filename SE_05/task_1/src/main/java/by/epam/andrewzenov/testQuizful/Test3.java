package by.epam.andrewzenov.testQuizful;

import java.nio.file.*; 

class Test3 { 
    public static void main(String[] args) { 
        Path path1 = Paths.get("pom.xml"); 
        Path path2 = Paths.get("D:\\workspace\\LocalTraining\\SE_05\\task_1\\pom.xml"); 
        System.out.println("(path1.compareTo(path2) == 0) is: " 
                + (path1.compareTo(path2) == 0)); 
        System.out.println("path1.equals(path2) is: " + path1.equals(path2)); 
        System.out.println("path2.equals(path1.toAbsolutePath()) is " 
                + path2.equals(path1.toAbsolutePath())); 
         
        System.out.println(path1.toAbsolutePath()); 
    } 
} 
