package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ImetierImpl implements Imetier {
    @Autowired
    @Qualifier("d1")
    private IDao dao; //couplage faible
    @Override
    public double calcule() {
        return dao.getData()*540/Math.cos(Math.PI*40);
    }
//injecter dans la variable dao un objet d'une clas qui implement l'interface dao
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
