package Controller;

import Model.Sorter;
import Service.SorterService;

public class SorterController<Type> {
    public static <Type> Sorter create(Class<Type> type, Type[] list,  int sorterChoice, int orderByChoice){
        Sorter<Type> sorter = SorterService.getSorter(sorterChoice);

        sorter.setList(list);
        sorter.setType(type);
        sorter.setOrderBy(orderByChoice);

        return sorter;
    }
}
