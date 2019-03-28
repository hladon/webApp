public class ItemService {
    private static ItemDAO itemDAO=new ItemDAO();
    public static void create(){

    }
    public static String read(String param){
        Item item=itemDAO.findById(Long.getLong(param));
        return item.toString();
    }
    public static void update(){

    }
    public static void delete(){

    }
}
