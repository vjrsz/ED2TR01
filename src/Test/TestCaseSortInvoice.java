package Test;

import Model.Invoice;
import Service.SorterService;

import java.lang.reflect.Field;

public class TestCaseSortInvoice {
    private int attributeChosen;
    private int sorterChosen;
    private int orderByChosen;
    private long timeInit;
    private long timeEnd;

    public TestCaseSortInvoice(int attributeChosen, int sorterChosen, int orderByChosen) {
        this.attributeChosen = attributeChosen;
        this.sorterChosen = sorterChosen;
        this.orderByChosen = orderByChosen;
    }

    public String getNameSorter(){
        return SorterService.getSorter(sorterChosen).getName();
    }

    public String getNameAttribute(){
        Field field = Invoice.class.getDeclaredFields()[attributeChosen];
        return field.getName();
    }

    public int getAttributeChosen() {
        return attributeChosen;
    }

    public void setAttributeChosen(int attributeChosen) {
        this.attributeChosen = attributeChosen;
    }

    public int getSorterChosen() {
        return sorterChosen;
    }

    public void setSorterChosen(int sorterChosen) {
        this.sorterChosen = sorterChosen;
    }

    public int getOrderByChosen() {
        return orderByChosen;
    }

    public void setOrderByChosen(int orderByChosen) {
        this.orderByChosen = orderByChosen;
    }

    public long getTimeInit() {
        return timeInit;
    }

    public void setTimeInit(long timeInit) {
        this.timeInit = timeInit;
    }

    public long getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(long timeEnd) {
        this.timeEnd = timeEnd;
    }
}
