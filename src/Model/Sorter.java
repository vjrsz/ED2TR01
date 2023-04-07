package Model;

public abstract class Sorter<Type> {
    private Class<Type> type;
    private Type[] list;
    private int orderBy;

    public Sorter(Class<Type> type, Type[] list, int orderBy) {
        this.type = type;
        this.list = list;
        this.orderBy = orderBy;
    }

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
