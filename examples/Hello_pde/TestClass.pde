import javax.persistence.Id;
import javax.persistence.Column;

class TestClass {
  @Id
  @Column(name = "ID")
  private int id;

  @Column(name = "Name")
  private String name;
}
