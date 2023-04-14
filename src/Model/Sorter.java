package Model;

import java.util.function.BiFunction;

public abstract class Sorter <Type> {
    private Class<Type> type;
    protected Type[] list;
    protected int orderBy;

    public abstract String getName();

    public Sorter() {}

    public Class<Type> getType() {
        return type;
    }

    public void setType(Class<Type> type) {
        this.type = type;
    }

    public Type[] getList() {
        return list;
    }

    public void setList(Type[] list) {
        this.list = list;
    }

    public int getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(int orderBy) {
        this.orderBy = orderBy;
    }

    public abstract void sort(BiFunction<Type, Type, Integer> bif);
}
