package by.epam.andrewzenov.testQuizful;

import java.io.IOException; 
import java.nio.file.*; 
 
class Test2 { 
    public static void main(String[] args) throws IOException { 
        //Path testFilePath = Paths.get("./Test"); 
         
        //������ ������ ���� ��� ������� � Windows 
        Path testFilePath = Paths.get(".\\pom.xml"); 
         
        System.out.println("The file name is: " + testFilePath.getFileName()); 
        System.out.println("It's URI is: " + testFilePath.toUri()); 
        System.out.println("It's absolute path is: " 
                + testFilePath.toAbsolutePath()); 
        System.out.println("It's normalized path is: " 
                + testFilePath.normalize()); 
 
        //��������� ������� ������� ������ �� ���������������� �������������� ���� 
        Path testPathNormalized = Paths 
                .get(testFilePath.normalize().toString()); 
        System.out.println("It's normalized absolute path is: " 
                + testPathNormalized.toAbsolutePath()); 
        System.out.println("It's normalized real path is: " 
                + testFilePath.toRealPath(LinkOption.NOFOLLOW_LINKS)); 
    } 
} 