package ch.heigvd.gen;

public class OrderJsonWriter implements IWriter {

    private Order order;

    public OrderJsonWriter(Order order){
        this.order = order;
    }

    @Override
    public String getContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"id\": ");
        sb.append(order.getOrderId());
        sb.append(", ");
        sb.append("\"products\": [");
        for (int j = 0; j < order.getProductsCount(); j++) {
            sb.append(new ProductJsonWriter(order.getProduct(j)).getContent());
            sb.append(", ");
        }

        if (order.getProductsCount() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        sb.append("]}");
        return sb.toString();
    }
}
