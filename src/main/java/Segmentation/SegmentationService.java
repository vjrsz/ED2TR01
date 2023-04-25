package Segmentation;

import java.util.Date;
import java.util.List;
import java.util.function.BiFunction;

public class SegmentationService implements BiFunction<Segmentation, Segmentation, Integer> {
    public static BiFunction<Segmentation, Segmentation, Integer> bif = new SegmentationService();

    public static Segmentation[] create(List<String[]> data) {
        //int len = data.size();
        int len = 100000;

        Segmentation[] segmentations = new Segmentation[len];

        for (int i = 0; i < len; i++) {
            String[] line = data.get(i); // [0,536365,85123A,WHITE HANGING HEART T-LIGHT HOLDER,6,12/1/2010 8:26,2.55,17850.0,United Kingdom]

            int index = Integer.parseInt(line[0]);
            String invoiceNo = line[1];
            String stockCode = line[2];
            String description = line[3];
            int quantity = Integer.parseInt(line[4]);
            String invoiceDate = line[5];
            double unitPrice = Double.parseDouble(line[6]);
            int customerID = (int) Double.parseDouble(line[7]);
            String country = line[8];

            segmentations[i] = new Segmentation(index, invoiceNo, stockCode, description, quantity, invoiceDate,
                                                    unitPrice, customerID, country);
        }

        return segmentations;
    }

    public static void show(Segmentation[] segmentations){
        for (Segmentation s : segmentations) {
            System.out.printf("%d %s %s %s %d %s %.2f %d %s", s.getIndex(), s.getInvoiceNo(), s.getStockCode(), s.getDescription(), s.getQuantity(), s.getInvoiceDate(),
                    s.getUnitPrice(), s.getCustomerID(), s.getCountry());
            System.out.println();
        }
    }

    @Override
    public Integer apply(Segmentation a, Segmentation b) {
        if (a.getPrimaryKeyValue().getClass().equals(String.class)) {
            String valueA = (String) a.getPrimaryKeyValue();
            String valueB = (String) b.getPrimaryKeyValue();

            return valueA.compareTo(valueB);
        } else if (a.getPrimaryKeyValue().getClass().equals(Integer.class)){
            int valueA = (int) a.getPrimaryKeyValue();
            int valueB = (int) b.getPrimaryKeyValue();

            if ( valueA < valueB ){ return -1;}
            else if ( valueA > valueB ){ return 1;}
        } else if (a.getPrimaryKeyValue().getClass().equals(Double.class)){
            Double valueA = (Double) a.getPrimaryKeyValue();
            Double valueB = (Double) b.getPrimaryKeyValue();

            if ( valueA < valueB ){ return -1;}
            else if ( valueA > valueB ){ return 1;}
        }

        return 0;
    }
}
