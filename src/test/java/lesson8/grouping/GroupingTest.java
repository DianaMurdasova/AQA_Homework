package lesson8.grouping;

import org.testng.annotations.Test;

public class GroupingTest {
    @Test(groups = {"regression"})
    public void f(){

    }

    @Test(groups = {"smoke", "regression"})
    public void d(){

    }

    @Test(dependsOnGroups = {"smoke"})
    public void c(){
    }

    @Test
    public void e(){
    }

    @Test(groups = {"smoke"})
    public void b(){
    }

    @Test
    public void a(){

    }
}
