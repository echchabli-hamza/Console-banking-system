import controllers.AllFunctions;
import controllers.Menu;
import models.Compte;
import models.Operation;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        AllFunctions al = new AllFunctions();

        new Thread(() -> {

            while (true) {
                try {
                    al.addIntrest();
                } catch (Exception ex) {
                    ex.printStackTrace(); // show error instead of killing the thread
                }

                try {
                    Thread.sleep(3000); // 3 seconds
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }).start();




        Menu m1 = new Menu(al);

        m1.index();







    }


}