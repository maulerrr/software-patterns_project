package task1.services.DB.data.interfaces;

import java.util.List;

public interface EntityRepo<Entity> {
    Entity get(int id);
    List<Entity> getAll();
    boolean create(Entity entity);
    boolean delete(int id);
}
