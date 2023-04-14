package Test;

import Controller.CSVController;
import Controller.InvoiceController;
import Controller.SorterController;
import Model.Invoice;
import Model.Sorter;
import Service.InvoiceService;
import Utils.DateUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        List<String[]> dataInvoices = CSVController.read();
        if (dataInvoices == null) {
            return;
        }
        Invoice[] invoices = InvoiceController.create(dataInvoices);

        ArrayList<TestCaseSortInvoice> testCaseSortInvoice = createTestCaseSortInvoice();

        for(TestCaseSortInvoice tc : testCaseSortInvoice){
            int attributeChosen = tc.getAttributeChosen();
            int sorterChosen = tc.getSorterChosen();
            int orderByChosen = tc.getOrderByChosen();

            long[] res = runTestCaseSortInvoice(invoices, attributeChosen, sorterChosen, orderByChosen);

            tc.setTimeInit(res[0]);
            tc.setTimeEnd(res[1]);
        }

        saveTestCaseSortInvoice(testCaseSortInvoice);
    }

    public static ArrayList<TestCaseSortInvoice> createTestCaseSortInvoice(){
        ArrayList<TestCaseSortInvoice> testCases = new ArrayList<TestCaseSortInvoice>();
        testCases.add(new TestCaseSortInvoice(0,1,1));
        testCases.add(new TestCaseSortInvoice(0,1,2));
        testCases.add(new TestCaseSortInvoice(3,1,1));
        testCases.add(new TestCaseSortInvoice(3,1,2));
        testCases.add(new TestCaseSortInvoice(5,1,1));
        testCases.add(new TestCaseSortInvoice(5,1,2));
        testCases.add(new TestCaseSortInvoice(6,1,1));
        testCases.add(new TestCaseSortInvoice(6,1,2));

        return testCases;
    }

    public static long[] runTestCaseSortInvoice(Invoice[] invoices, int attributeChosen, int sorterChosen, int orderByChosen){
        Sorter<Invoice> sorter = SorterController.create( Invoice.class, invoices, sorterChosen, orderByChosen );

        Invoice.setPrimaryKey(attributeChosen);

        long timeInit, timeEnd;
        timeInit = System.currentTimeMillis();
        sorter.sort(InvoiceService.bif);
        timeEnd = System.currentTimeMillis();

        return new long[]{timeInit, timeEnd};
    }

    public static void saveTestCaseSortInvoice(ArrayList<TestCaseSortInvoice> testCaseSortInvoice) {
        FileWriter file = null;
        try {
            file = new FileWriter("result_" + DateUtils.getStringFormat(new Date(), "ddMMyyyyhhmm") + ".txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PrintWriter printWriter = new PrintWriter(file);

        for(TestCaseSortInvoice tc : testCaseSortInvoice) {
            printWriter.print("---" + tc.getNameSorter() +  "---\n");
            printWriter.print("+ Attribute : " + tc.getNameAttribute() +  "\n");
            printWriter.print("+ Order : " + (tc.getOrderByChosen() == 1 ? "ASC" : "DESC") +  "\n");
            printWriter.print("+ Result : \n");
            printWriter.print("\tTime Init : " + tc.getTimeInit() +  "\n");
            printWriter.print("\tTime End : " + tc.getTimeEnd() +  "\n");
            printWriter.print("\tTime Total : " + (tc.getTimeEnd() - tc.getTimeInit()) +  "ms\n");
            printWriter.print("\n\n");
        }

        printWriter.close();
    }
}
