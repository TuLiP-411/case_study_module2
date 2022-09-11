package storage.product;

import model.product.contents.Product;

import java.util.List;

public class ReadWriteText implements IReadWriteData {
    private ReadWriteText() {
    }

    //instance static thuoc lop
    private static ReadWriteText readWriteText;

    public static ReadWriteText getInstance() {
        if (readWriteText == null) readWriteText = new ReadWriteText();
        return readWriteText;
    }

    @Override
    public List<Product> readData() {
        return null;
    }

    @Override
    public void writeData(List<Product> materials) {

    }
}
