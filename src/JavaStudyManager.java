import java.util.*;

public class JavaStudyManager {
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

            valid = Validator.apenasNumeros(idade);

            if (!valid) {
                System.out.println("Por favor digite uma idade válida.");
            }

        } while (!valid);
        int idAtual = 0;
        int ultimoId = 0;
        if (!javaStudy.isEmpty()) {
            ultimoId = javaStudy.getFirst().getId();

            for (JavaStudy aluno : javaStudy) {
                idAtual = aluno.getId();
                if (idAtual > ultimoId) {
                    ultimoId = idAtual;
                }
            }
        }
        JavaStudy js = new JavaStudy(ultimoId + 1, nome, Integer.parseInt(idade));
        javaStudy.add(js);

    }

    public void view() {

        boolean valid;
        String opcaoStr;
        int opcaoInt = 0;
        do {
            do {
                SistemUtil.limparTela();
                System.out.println("Digite uma opção: ");
                System.out.println("1 - Cadastrar novo aluno. ");
                System.out.println("2 - Editar Aluno. ");
                System.out.println("3 - Remover Aluno. ");
                System.out.println("4 - Mostrar Alunos Cadastrados. ");
                System.out.println("5 - Sair. ");

                opcaoStr = scan.nextLine();

                valid = Validator.apenasNumeros(opcaoStr);

                if (!valid) {
                    System.out.println("Por favor digite uma opção válida.");
                } else {
                    opcaoInt = Integer.parseInt(opcaoStr);
                }

            } while (!valid);

            switch (opcaoInt) {
                case 1:
                    SistemUtil.limparTela();
                    System.out.println("---Cadastrar Aluno---");
                    cadastrarAluno();
                    break;

                case 2:
                    SistemUtil.limparTela();
                    System.out.println("---Editar Aluno---");
                    editarAluno();
                    break;

                case 3:
                    SistemUtil.limparTela();
                    System.out.println("---Remover aluno---");
                    removerAluno();
                    break;

                case 4:
                    SistemUtil.limparTela();
                    System.out.println("---Alunos Cadastrados---");

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
        } while (opcaoInt != 5);

    }

    private void editarAluno() {
        boolean valid = false;
        do {
            System.out.print("Digite o id do aluno: ");
            String id = scan.nextLine();
            valid = Validator.apenasNumeros(id);
            if (valid){
                int idInt = Integer.parseInt(id);
                Optional<JavaStudy> alunoEncontradoOptional = javaStudy.stream().filter(aluno -> aluno.getId() == idInt).findFirst();
                if (alunoEncontradoOptional.isPresent()){
                    JavaStudy alunoEncontrado = alunoEncontradoOptional.get();
                    javaStudy.remove(alunoEncontrado);
                    cadastrarAluno();
                    JavaStudy aluno = javaStudy.getLast();
                    aluno.setId(alunoEncontrado.getId());
                }
            } else {
                System.out.println("Por favor Digite um id válido");
            }
        }while (!valid);

    }

    private void removerAluno(){
        boolean valid = false;
        do {
            System.out.print("Digite o id do aluno: ");
            String id = scan.nextLine();
            valid = Validator.apenasNumeros(id);
            if (valid){
                int idInt = Integer.parseInt(id);
                Optional<JavaStudy> optionalJavaStudy = javaStudy.stream().filter(aluno -> aluno.getId() == idInt).findFirst();
                if (optionalJavaStudy.isPresent()){
                    javaStudy.remove(optionalJavaStudy.get());
                }else {
                    System.out.println("Aluno não encontrado, Digite um id válido!!");
                }
            }
        }while (!valid);
    }


}
