package View;

import Model.Invoice;

public class InvoiceView{
    public static void created(int size){
        IView.divider();

        System.out.println("Invoices created from CSV !");
        System.out.println("- Length : " + size);
    }

    public static void running(String name){
        IView.divider();

        System.out.println("Running " + name + " !");
    }

    public static void show(Invoice[] invoices){
        IView.divider();
        for (Invoice invoice : invoices){
            System.out.println(invoice.getPrimaryKeyValue());
        }
    }
}
