import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class JavaStudyManager{
    Scanner scan = new Scanner(System.in);
    ArrayList<JavaStudy> javaStudy = new ArrayList<JavaStudy>();

    private void cadastrarAluno() {
      
        System.out.print("Digite o nome do aluno: ");
        String nome = scan.nextLine();

        int id;
        boolean valid;
        String idade;

        do {
          System.out.print("Digite a idade do aluno: ");
          idade = scan.nextLine(); 

          valid = Validator.apenasNumeros(idade) ? true : false;

          if (valid == false) {
            System.out.println("Por favor digite uma idade válida.");
          }

        } while (!valid); 
        int idAtual = 0; 
        int ultimoId = 0; 
        if (javaStudy.size() > 0) {
          ultimoId = javaStudy.get(0).getId();
          
          for (JavaStudy aluno : javaStudy) {
            idAtual = aluno.getId();
            if (idAtual > ultimoId) {
              ultimoId = idAtual;
            }
          }
        }
        JavaStudy js = new JavaStudy(ultimoId+1, nome, idade);
        javaStudy.add(js);

    }

  public void view(){

      boolean valid;
      String opcaoStr;
      int opcaoInt = 0;
  do {
    do {
      System.out.println("Digite uma opção: \n");
      System.out.println("1 - Cadastrar novo aluno. \n"); 
      System.out.println("2 - Editar Aluno. \n"); 
      System.out.println("3 - Remover Aluno. \n"); 
      System.out.println("4 - Mostrar Alunos Cadastrados. \n"); 
      System.out.println("5 - Sair. \n"); 

      opcaoStr = scan.nextLine(); 

      valid = Validator.apenasNumeros(opcaoStr) ? true : false; 
      
      if (valid == false) {
        System.out.println("Por favor digite uma opção válida.");
      }else{
        opcaoInt = Integer.parseInt(opcaoStr);
      }

    } while (!valid); 
  
    switch (opcaoInt) {
      case 1:
        System.out.println("---Cadastrar Aluno---");
        cadastrarAluno();
        break;

      case 2:
        
        break;

      case 3:
        
        break;

      case 4:
         System.out.println("---Alunos Cadastrados---\n");
         
         for (JavaStudy js : javaStudy) {
            System.out.println(js.toString());  
         }

         scan.nextLine();
        break;

      case 5:
        System.out.println("Obrigado por usar nosso sistema");
        scan.close(); 
        break;
      }
    } while(opcaoInt != 5); 

  }

  private void editarAluno(){

  }

}
