package by.epam.andrewzenov.testQuizful;

import java.io.IOException; 
import java.nio.file.*; 
import java.nio.file.attribute.BasicFileAttributes; 
 
class MyFileVisitor implements FileVisitor { 
	


	@Override
	public FileVisitResult postVisitDirectory(Object arg0, IOException arg1) throws IOException {
//		 System.out.println("postVisitDirectory:" + (Path)arg0); 
	        return FileVisitResult.CONTINUE; 
	}

	@Override
	public FileVisitResult preVisitDirectory(Object arg0, BasicFileAttributes arg1) throws IOException {
	    System.out.println("Directory name:" + (Path)arg0); 
        return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Object arg0, BasicFileAttributes arg1) throws IOException {
	    System.out.println("File name:" + ((Path)arg0).getFileName()); 
        return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Object arg0, IOException arg1) throws IOException {
//	    System.out.println("Directory name:" + (Path)arg0); 
        return FileVisitResult.CONTINUE;
	} 

} 
 
public class Test11 { 
    public static void main(String[] args) { 
 
        Path pathSource = Paths.get("d:\\Документы\\Java\\"); 
        try { 
            Files.walkFileTree(pathSource, new MyFileVisitor()); 
            System.out.println("<<<");
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
    } 
}