package com.aidan.QuizGenerator.utils;

import com.aidan.QuizGenerator.config.ReactiveMongoConfig;
import com.aidan.QuizGenerator.model.Question;
import com.aidan.QuizGenerator.model.TextQuestion;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import java.io.FileInputStream;
import java.io.IOException;

public class DatabasePopulator {

    private final ReactiveMongoTemplate reactiveMongoTemplate;

    public DatabasePopulator() throws IOException {
        // As this is a one time use case, this is very hardcoded...
        reactiveMongoTemplate = new ReactiveMongoConfig().reactiveMongoTemplate();

        FileInputStream fs = new FileInputStream("/Users/aidanmcphelim/Documents/programming/QuizGenerator/server/src/main/resources/questionSources/Trivia-Printable.xlsx");
        Workbook workbook = new XSSFWorkbook(fs);
        Sheet sheet = workbook.getSheet("Millionaire - Easy Q");

        for (int i = 1; i < sheet.getLastRowNum(); i++) {
            Question q1 = new TextQuestion(
                    null,
                    sheet.getRow(i).getCell(0).getStringCellValue(),
                    sheet.getRow(i).getCell(1).getStringCellValue()
            );

            System.out.println(sheet.getRow(i).getCell(0).getStringCellValue());
            System.out.println(sheet.getRow(i).getCell(1).getStringCellValue());
            System.out.println();

            Question q2 = new TextQuestion(
                    null,
                    sheet.getRow(i).getCell(3).getStringCellValue(),
                    sheet.getRow(i).getCell(4).getStringCellValue()
            );

            Question q3 = new TextQuestion(
                    null,
                    sheet.getRow(i).getCell(6).getStringCellValue(),
                    sheet.getRow(i).getCell(7).getStringCellValue()
            );

            reactiveMongoTemplate.insert(q1, "questions").subscribe();
            reactiveMongoTemplate.insert(q2, "questions").subscribe();
            reactiveMongoTemplate.insert(q3, "questions").subscribe();
        }
    }

    public static void main(String[] args) {
        try {
            new DatabasePopulator();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
