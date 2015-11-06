package by.epam.andrewzenov.testQuizful;


 
import java.nio.file.Path;
import java.nio.file.Paths; 
 
public class Test1 { 
	
    public static void main(String[] args) { 
         
        // C������� ������� Path ����� ����� ������������ ������ get() ������ Paths 
        //Path testFilePath = Paths.get("/home/heorhi/testfile.txt"); 
         
        //������ ������ �������� ������� Path ���� ��� ������� � Windows 
        Path testFilePath = Paths.get("D:\\install\\HDDscan\\FAQ.txt"); 
 
        //����� ��������� � ����� 
        System.out.println("Printing file information: "); 
        System.out.println("\t file name: " + testFilePath.getFileName()); 
        System.out.println("\t root of the path: " + testFilePath.getRoot()); 
        System.out.println("\t parent of the target: " 
                + testFilePath.getParent()); 
 
        //����� ��������� ���� 
        System.out.println("Printing elements of the path: "); 
        for (Path element : testFilePath) { 
            System.out.println("\t path element: " + element); 
        } 
    } 
} 