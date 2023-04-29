package Sorter;

public class SISort<Type> extends Sorter<Type>{

    private double p;

    public SISort(double p) {
        super();
        this.p = p;
    }

    @Override
    public Type[] sort (){
        int range = (int) (list.length * p);

        /* ordena as extremidades */
        Sorter ss = new SelectSort();
        ss.setBif(bif);
        ss.setOrderBy(orderBy);
        ss.setType(type);

        Sorter is = new InsertSort();
        is.setBif(bif);
        is.setOrderBy(orderBy);
        is.setType(type);

        Type[] tempLeft, tempRight, tempCenter;
        tempLeft = (Type[]) new Object[range];
        tempRight = (Type[]) new Object[range];
        tempCenter = (Type[]) new Object[list.length - range * 2];

        copyListToTemp(tempLeft, 0, range);
        copyListToTemp(tempRight, list.length - range, list.length);
        copyListToTemp(tempCenter, range, list.length - range);

        ss.setList(tempLeft);
        ss.sort();

        ss.setList(tempRight);
        ss.sort();

        is.setList(tempCenter);
        is.sort();

        if ( orderBy == 1){
            copyTempToList(tempLeft, 0, range);
            copyTempToList(tempRight, list.length - range, list.length);
            copyTempToList(tempCenter, range, list.length - range);
        }else{
            copyTempToList(tempLeft, 0, range);
            copyTempToList(tempRight, list.length - range, list.length);
            copyTempToList(tempCenter, range, list.length - range);
        }

        return list;
    }

    public Type[] copyListToTemp(Type[] temp, int p, int e){
        for (int i = p, j = 0; i < e; i++, j++) {
            temp[j] = list[i];
        }

        return temp;
    }
    public Type[] copyTempToList(Type[] temp, int p, int e){
        for (int i = p, j = 0; i < e; i++, j++) {
            list[i] = temp[j];
        }

        return temp;
    }
    @Override
    public String getName() {
        return "SISorter";
    }
}

