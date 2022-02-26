package presentation;

import dao.IDao;
import metier.Imetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class presentation2 {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Scanner scanner=new Scanner(new File("config.txt"));
        String daocalssName=scanner.nextLine();//lire le premier line de fichier text
        Class cDao=Class.forName(daocalssName);
        IDao dao=(IDao) cDao.newInstance();
        System.out.println(dao.getData());
        String metiercalssName=scanner.nextLine();//lire le premier line de fichier text
        Class cmetier=Class.forName(metiercalssName);
        Imetier metier= (Imetier) cmetier.newInstance();
        Method method=cmetier.getMethod("setDao",IDao.class);
        method.invoke(metier,dao);
        System.out.println(metier.calcule());


    }
}
