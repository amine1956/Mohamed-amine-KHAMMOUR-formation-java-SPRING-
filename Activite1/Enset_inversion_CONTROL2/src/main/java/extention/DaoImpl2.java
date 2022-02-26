package extention;
import dao.IDao;
import org.springframework.stereotype.Component;

@Component("d")

public class DaoImpl2 implements IDao {
    //version capteur
    @Override
    public double getData() {
        System.out.println("version capture");
        return 4000;
    }
}
