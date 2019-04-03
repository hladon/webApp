
import java.util.Date;

public class ItemService {
    private static ItemDAO itemDAO=new ItemDAO();
    public static void create(String name,String description){
        Item item=new Item();
        item.setDateCreated(new Date());
        item.setName(name);
        item.setDescription(description);
        item.setLastUpdatedDate(new Date());
        itemDAO.save(item);
    }
    public static String read(String param){
        int id=Integer.parseInt(param);
        Item item=itemDAO.findById(id);
        return item.toString();
    }
    public static void update(String id,String name,String description){
        Item item=itemDAO.findById(Integer.parseInt(id));
        item.setName(name);
        item.setDescription(description);
        item.setLastUpdatedDate(new Date());
        itemDAO.update(item);

    }
    public static void delete(String id){
        itemDAO.deleteById(Integer.parseInt(id));
    }
}
