package presentation;

import extention.DaoImpl2;
import metier.ImetierImpl;

public class presentation {
    public static void main(String[] args) {
        DaoImpl2 dao= new DaoImpl2();
        ImetierImpl metier=new ImetierImpl();
        metier.setDao(dao);
        System.out.println(metier.calcule());
    }
}
