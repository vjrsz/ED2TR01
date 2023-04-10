package Controller;

import Model.Sorter;
import Service.SorterService;

public class SorterController<Type> {
    public static <Type> Sorter create(Class<Type> type, Type[] list,  int sorterChosen, int orderByChosen){
        Sorter<Type> sorter = SorterService.getSorter(sorterChosen);

        sorter.setList(list);
        sorter.setType(type);
        sorter.setOrderBy(orderByChosen);

        return sorter;
    }
}
