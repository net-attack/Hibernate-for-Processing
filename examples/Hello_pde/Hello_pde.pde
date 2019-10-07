import hibernate.libary.*;
import java.util.*;

void setup(){
  List<Class> classes = new ArrayList<Class>();
  classes.add(TestClass.class);
  
 Hibernate  f = new Hibernate(this, "test.accdb", classes);
 println(f.sayHello());
 println(f.version());
}
