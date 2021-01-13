package ru.sapteh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
         //create directory in console
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter name directory: ");
        String dirName = reader.readLine();

        System.out.println("Enter name File: ");
        String fileName = reader.readLine();


        System.out.println("Enter Key: ");
        String key = reader.readLine();

        Path sourcePath = Paths.get("C:/java_42");
        Path dir = Paths.get(sourcePath.resolve(dirName).toString());
        if (!Files.exists(dir)){
            Files.createDirectory(dir);
            System.out.printf("Directory %s created\n", dir.getFileName());
        }else
            System.out.printf("Directory %s exists\n", dir.getFileName());

        // create file in console


        Path sourcePath1 = Paths.get("C:/java_42/dir");
        Path file = Paths.get(sourcePath1.resolve(fileName).toString());
        if (!Files.exists(file)){
            Files.createFile(file);
            System.out.printf("File %s created\n", file.getFileName());
        }else
            System.out.printf("File %s exists\n", file.getFileName());

         //Расчет кол-ва файлов, папок и размеры файлов
        MyVisitClass myVisitClass = new MyVisitClass();
        myVisitClass.setStrKey(key);

        Files.walkFileTree(sourcePath,myVisitClass);

        System.out.println(myVisitClass.getCountFile());
        System.out.println(myVisitClass.getCountDirectory());
        System.out.printf("%f KB ",myVisitClass.getSizeDirectory()/1024F);
        System.out.println(myVisitClass.getSearchFile());

    }
}
