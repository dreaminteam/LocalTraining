package by.epam.andrewzenov.testQuizful;

import java.nio.file.*; 

class Test5 { 
    public static void main(String[] args) { 
        //Проверка для файла 
        Path path = Paths.get("D:\\workspace\\LocalTraining\\SE_05\\task_1\\pom.xml"); 
         
        //Проверка для дериктории 
        //Path path = Paths.get("/home/heorhi/workspace/OCPJP/src/test"); 
         
        if (Files.exists(path, LinkOption.NOFOLLOW_LINKS)) { 
            System.out.println("The file/directory " + path.getFileName() 
                    + " exists"); 
            if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) { 
                System.out.println(path.getFileName() + " is a directory"); 
            } else { 
                System.out.println(path.getFileName() + " is a file"); 
            } 
        } else { 
            System.out.println("The file/directory " + path.getFileName() + " does not exist"); 
        } 
    } 
} 
