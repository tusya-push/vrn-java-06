package ru.dataart.academy.java;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Optional;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Calculator {

    /**
     * @param zipFilePath -  path to zip archive with text files
     * @param character   - character to find
     * @return - how many times character is in files
     */

    public static Integer getNumberOfChar(String zipFilePath, char character) throws IOException {
        int res = 0;
        ZipFile zipFile = new ZipFile(zipFilePath);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = entries.nextElement();
            InputStream inputStream = zipFile.getInputStream(zipEntry);
            // to get content as string
            String content = IOUtils.toString(inputStream, Charset.defaultCharset());
            // to find count
            int matches = StringUtils.countMatches(content, Character.toString(character));
            res += matches;
            inputStream.close();
        }
        zipFile.close();
        return res;
    }

    /**
     * @param zipFilePath - path to zip archive with text files
     * @return - max length
     */

    public static Integer getMaxWordLength(String zipFilePath) throws IOException {
        int res = 0;
        ZipFile zipFile = new ZipFile(zipFilePath);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = entries.nextElement();
            InputStream inputStream = zipFile.getInputStream(zipEntry);
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();
                Optional<Integer> optional = Arrays.stream(nextLine.split(" ")).map(String::length).max(Integer::compare);
                if (optional.isPresent()) {
                    res = Math.max(res, optional.get());
                }
            }
            scanner.close();
            inputStream.close();
        }
        zipFile.close();
        return res;
    }

}
