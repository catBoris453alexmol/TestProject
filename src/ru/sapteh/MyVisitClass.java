package ru.sapteh;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyVisitClass extends SimpleFileVisitor<Path> {
    private int countFile;
    private int countDirectory;
    private long sizeDirectory;
    private String strKey;
    private Set<String> searchFile = new HashSet<>();

    public int getCountDirectory() {
        return countDirectory;
    }

    public int getCountFile() {
        return countFile;
    }

    public long getSizeDirectory() {
        return sizeDirectory;
    }

    public void setStrKey(String strKey) {
        this.strKey = strKey;
    }

    public Set<String> getSearchFile(){
        return searchFile;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        countDirectory++;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        countFile++;
        sizeDirectory += attrs.size();
        List<String> lines = Files.readAllLines(file);
        for (String str : lines){
            if (str.contains(strKey)){
                searchFile.add(file.toAbsolutePath().toString());
            }
        }


        return FileVisitResult.CONTINUE;
    }
}
