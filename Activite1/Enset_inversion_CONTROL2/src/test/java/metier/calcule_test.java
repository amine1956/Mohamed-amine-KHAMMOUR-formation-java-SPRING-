package metier;

import org.junit.Assert;
import org.junit.Test;
public class calcule_test {
    private metier.calcule calcule;
    @Test
    public void somme_test(){
        calcule=new calcule();
        double a=5,b=14;
        double expected=19;
        double res= calcule.somme(a,b);
        Assert.assertTrue(res==expected);
    }
}

