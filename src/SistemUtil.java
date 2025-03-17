public class SistemUtil {
    public static void limparTela(){
        try {
            String sistema = System.getProperty("os.name").toLowerCase();
            if (sistema.contains("win")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }else{
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
