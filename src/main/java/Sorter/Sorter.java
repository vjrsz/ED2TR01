package Sorter;

public abstract class Sorter<Type> implements ISorter<Type>{
    private Class<Type> type;
    protected Type[] list;
    protected int orderBy;

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
}