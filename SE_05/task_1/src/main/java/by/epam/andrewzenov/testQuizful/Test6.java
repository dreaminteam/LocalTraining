package by.epam.andrewzenov.testQuizful;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Test6 { 
    public static void main(String[] args) { 
        Path path = Paths.get("D:\\workspace\\LocalTraining\\SE_05\\task_1\\pom.xml"); 
        System.out.printf("Readable: %b, Writable: %b, Executable: %b ", 
                Files.isReadable(path), Files.isWritable(path), 
                Files.isExecutable(path)); 
    } 
} 