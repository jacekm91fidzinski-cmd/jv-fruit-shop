package service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.FileReader;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> read(String filePath) {
        if (filePath == null) {
            throw new IllegalArgumentException("File path cannot be null");
        }

        List<String> lines = new ArrayList<>();
        try (BufferedReader reader =
                     new BufferedReader(new java.io.FileReader(filePath))) {

            String header = reader.readLine();
            if (header == null) {
                return lines;
            }

            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file: " + filePath, e);
        }
        return lines;
    }
}
