package org.example;

import CSV.CSVReaderFile;
import CSV.CSVWriteFile;
import Segmentation.Segmentation;
import Segmentation.SegmentationService;
import Sorter.Sorter;
import Sorter.SorterService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String csvFile = "C:\\xampp\\htdocs\\ED2\\EDDOIS\\data\\customer_segmentation.csv";
        List<String[]> data = CSVReaderFile.read(csvFile); // ler csv
        Segmentation[] segmentations = SegmentationService.create(data); // cria instancias

        // menu
        int attributeChosen = MenuView.attributeChoice();
        int sorterChosen = MenuView.sorterChoice();
        int orderByChosen = MenuView.orderChoice();

        Segmentation.setPrimaryKey(attributeChosen);

        Sorter sorter = SorterService.getSorter(sorterChosen);
        sorter.setList(segmentations);
        sorter.setOrderBy(orderByChosen);

        long timeInit, timeEnd;

        timeInit = System.currentTimeMillis();
        sorter.sort(SegmentationService.bif);
        timeEnd = System.currentTimeMillis();

        System.out.println("Sorter Finalized !");
        System.out.println("- Time init : " + timeInit + "ms");
        System.out.println("- Time end : " + timeEnd + "ms");
        System.out.println("- Time total : " + (timeEnd - timeInit) + "ms");

        CSVWriteFile.write( (Segmentation[]) sorter.getList(),"csvsorted\\result.csv");
    }
}