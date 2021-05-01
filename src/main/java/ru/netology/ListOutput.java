package ru.netology;

import java.util.List;

//I- принцип сегрегации (разделения) интерфейса
public interface ListOutput<T> {
    public default String listOutput(List<T> list) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            sb.append((i + 1) + "." + list.get(i) + "\n");
        }
        return sb.toString();
    }

}
