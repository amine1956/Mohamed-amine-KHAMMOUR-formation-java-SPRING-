package presentation;

import metier.Imetier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class PresSpringXml {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("configure.xml");
        // Imetier metier=(Imetier) ctx.getBean("metier");
        Imetier metier=ctx.getBean(Imetier.class);
        System.out.println(metier.calcule());

    }
}
