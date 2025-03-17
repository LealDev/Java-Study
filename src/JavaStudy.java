public class JavaStudy {

  private int id;
  private String name;
  private String idade;

  public JavaStudy(int id, String name, String idade) {
    this.id = id;
    this.name = name;
    this.idade = idade;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name; 
  }

  public String getIdade() {
    return idade;
  }

  public void setIdade(String idade) {
   this.idade = idade; 
  }

  @Override
  public String toString() {
    return " id: "+ id +"\n nome: "+ name+ "\n idade: "+ idade;
  }
}

