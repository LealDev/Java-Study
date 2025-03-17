public class JavaStudy {

  private int id;
  private String name;
  private int idade;

  public JavaStudy(int id, String name, int idade) {
    this.id = id;
    this.name = name;
    this.idade = idade;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name; 
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
   this.idade = idade; 
  }

  @Override
  public String toString() {
    return " id: "+ id +"\n nome: "+ name+ "\n idade: "+ idade;
  }
}

