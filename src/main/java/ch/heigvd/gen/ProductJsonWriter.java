package ch.heigvd.gen;

public class ProductJsonWriter implements IWriter{

    private Product product;

    ProductJsonWriter(Product product){
        this.product = product;
    }

    @Override
    public String getContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"code\": \"");
        sb.append(product.getCode());
        sb.append("\", ");
        sb.append("\"color\": \"");
        sb.append(product.getColor());
        sb.append("\", ");

        if (product.getSize() != Size.SIZE_NOT_APPLICABLE) {
            sb.append("\"size\": \"");
            sb.append(product.getSize());
            sb.append("\", ");
        }

        sb.append("\"price\": ");
        sb.append(product.getPrice());
        sb.append(", ");
        sb.append("\"currency\": \"");
        sb.append(product.getCurrency());
        sb.append("\"}");
        return sb.toString();
    }
}
