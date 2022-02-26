package presentation;

import metier.Imetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//import org.spring
public class Presentation_Anotation
{
    public static void main(String[] args) {
        ApplicationContext ctx=new AnnotationConfigApplicationContext("extention","metier","dao");//ajouter les pakedges qu'il faut scaner
        Imetier metier=ctx.getBean(Imetier.class);
        System.out.println(metier.calcule());
    }}
