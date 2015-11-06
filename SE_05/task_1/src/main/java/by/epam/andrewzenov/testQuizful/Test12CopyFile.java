package by.epam.andrewzenov.testQuizful;

import java.io.IOException; 
import java.nio.file.*; 
import java.nio.file.attribute.*; 
 
class MyFileCopyVisitor extends SimpleFileVisitor { 
    private Path source, destination; 
 
    public MyFileCopyVisitor(Path s, Path d) { 
        source = s; 
        destination = d; 
    } 
 
    public FileVisitResult visitFile(Path path, 
            BasicFileAttributes fileAttributes) { 
        Path newd = destination.resolve(source.relativize(path)); 
        try { 
            Files.copy(path, newd, StandardCopyOption.REPLACE_EXISTING); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
        return FileVisitResult.CONTINUE; 
    } 
 
    public FileVisitResult preVisitDirectory(Path path, 
            BasicFileAttributes fileAttributes) { 
        Path newd = destination.resolve(source.relativize(path)); 
        try { 
            Files.copy(path, newd, StandardCopyOption.REPLACE_EXISTING); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
        return FileVisitResult.CONTINUE; 
    } 
} 
 
public class Test12CopyFile { 
    public static void main(String[] args) { 
        Path pathSource = Paths.get("Вставьте сюда путь к желательно непустой директории для копирования"); 
        Path pathDestination = Paths.get("Вставьте сюда путь к новому положению директории"); 
        try { 
            Files.walkFileTree(pathSource, new MyFileCopyVisitor(pathSource,    pathDestination)); 
            System.out.println("Files copied successfully!"); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
    } 
}