package com.example.fileprocessor.utilities;

import com.example.fileprocessor.models.Student;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvUtility {


    public static List<Student> readCsv(final String fileName) throws FileNotFoundException {

        CsvToBeanBuilder<Student> beanBuilder = new CsvToBeanBuilder<>(new FileReader(fileName));
        beanBuilder.withType(Student.class);
        return beanBuilder.build().parse();
    }

    public static void writeCsv(List<Student> students) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {

        CSVWriter writer = new CSVWriter(new FileWriter("output.csv"));
        HeaderColumnNameMappingStrategy mappingStrategy =
                new HeaderColumnNameMappingStrategy();
        mappingStrategy.setType(Student.class);



        StatefulBeanToCsvBuilder<Student> builder = new StatefulBeanToCsvBuilder(writer);
        StatefulBeanToCsv beanWriter = builder
                .withMappingStrategy(mappingStrategy)
                .withSeparator(',')
                .withQuotechar('\'')
                .build();

        beanWriter.write(students);
        writer.close();
    }
}
