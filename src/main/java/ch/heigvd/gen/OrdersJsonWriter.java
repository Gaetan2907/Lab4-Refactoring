package ch.heigvd.gen;

import java.util.List;

public class OrdersJsonWriter implements IWriter{

    private List<Order> orders;

    public OrdersJsonWriter(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String getContent() {
        StringBuffer sb = new StringBuffer("{\"orders\": [");

        for (int i = 0; i < orders.size(); i++) {
            sb.append(new OrderJsonWriter(orders.get(i)).getContent());
            sb.append(", ");
        }

        if (orders.size() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        return sb.append("]}").toString();
    }
}