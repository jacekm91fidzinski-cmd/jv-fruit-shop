package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import service.FileWriter;

public class FileWriterImpl implements FileWriter {

    @Override
    public void write(String content, String filePath) {
        try {
            Files.write(Path.of(filePath), content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write file: " + filePath, e);
        }
    }
}
