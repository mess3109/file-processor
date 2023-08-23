package com.example.fileprocessor;

import com.example.fileprocessor.models.Student;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.util.List;

import static com.example.fileprocessor.utilities.CsvUtility.readCsv;
import static com.example.fileprocessor.utilities.CsvUtility.writeCsv;
import static com.example.fileprocessor.utilities.JsonUtility.getFromJsonFile;
import static com.example.fileprocessor.utilities.JsonUtility.writeJson;

public class Application {

    public static void main(String[] args) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        final Student student = getFromJsonFile("student.json", Student.class);
        System.out.println(student);

        writeJson(student);

        final List<Student> students = readCsv("students.csv");
        System.out.println(students);

        Student ex = new Student("James", 18);
        writeCsv(List.of(ex));

    }
}