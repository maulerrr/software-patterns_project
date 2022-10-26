package task1.services.DB.data.interfaces;

import task1.services.DB.models.Product;

import java.util.List;

public interface IProductRepo extends EntityRepo<Product>{
    List<Product> getAllByRestik(int restik_id);
}
