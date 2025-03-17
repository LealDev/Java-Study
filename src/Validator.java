public class Validator{


  public static boolean name(int idade) {
    return idade >=0 && idade <= 200;    
  }

  public static boolean apenasNumeros(String str) {
    return str != null && str.matches("\\d+");
  }

} 
