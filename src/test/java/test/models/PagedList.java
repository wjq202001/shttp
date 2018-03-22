package test.models;

import java.util.List;

/**
 * Created by Wang Juqiang on 2018/3/18.
 */
public class PagedList<T> {
    private int pageindex;
    private int pagecount;
    private int rowcount;
    private List<T> list;

    public void setPageindex(int pageindex) {
        this.pageindex = pageindex;
    }

    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
    }

    public void setRowcount(int rowcount) {
        this.rowcount = rowcount;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPageindex() {
        return pageindex;
    }

    public int getPagecount() {
        return pagecount;
    }

    public int getRowcount() {
        return rowcount;
    }

    public List<T> getList() {
        return list;
    }
}
