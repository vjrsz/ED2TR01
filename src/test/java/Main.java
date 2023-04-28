
import CSV.CSVReaderFile;
import CSV.CSVWriteFile;
import Segmentation.Segmentation;
import Segmentation.SegmentationService;
import Sorter.Sorter;
import Sorter.SorterService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String csvFile = "data\\customer_segmentation.csv";
        List<String[]> data = CSVReaderFile.read(csvFile); // ler csv
        Segmentation[] segmentations = SegmentationService.create(data); // cria instancias

        List<int[]> testCases = new ArrayList();
        // attributeChosen, sorterChosen, orderByChosen
        testCases.add(new int[]{1,1,1});
        testCases.add(new int[]{1,1,-1});
        testCases.add(new int[]{1,2,1});
        testCases.add(new int[]{1,2,-1});
        testCases.add(new int[]{1,3,1});
        testCases.add(new int[]{1,3,-1});
        testCases.add(new int[]{1,4,1});
        testCases.add(new int[]{1,4,-1});
        testCases.add(new int[]{1,5,1});
        testCases.add(new int[]{1,5,-1});

        for (int[] tc : testCases) {
            int attributeChosen = tc[0];
            int sorterChosen = tc[1];
            int orderByChosen = tc[2];

            Segmentation.setPrimaryKey(attributeChosen - 1);

            Sorter sorter = SorterService.getSorter(sorterChosen, SegmentationService.bif, segmentations.clone(), orderByChosen);

            System.out.println("Sorting...");

            long time = SorterService.run(sorter);

            System.out.println("Sorter Finalized " + sorter.getName( ) + "!");
            System.out.println("- Time total : " + time + "ms");
            System.out.println();

            CSVWriteFile.write( (Segmentation[]) sorter.getList(),"csvsorted\\result" + sorter.getName() + orderByChosen + ".csv");
        }
    }

}