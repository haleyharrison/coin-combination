import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import static java.lang.System.out;
import java.lang.*;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;



public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

      get("/", (request, response) -> {
              Map<String, Object> model = new HashMap<String, Object>();
              model.put("template", "templates/home.vtl");
              return new ModelAndView(model, layout);
          }, new VelocityTemplateEngine());


        get("/detector", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            model.put("template", "templates/detector.vtl");

            String userInput = request.queryParams("userInput");
            Integer inputChange = Integer.parseInt(userInput);
            HashMap<String, Integer> coinPurse = changeCalculations(inputChange);

          model.put("quarters", coinPurse.get("quarters"));
          model.put("dimes", coinPurse.get("dimes"));
          model.put("nickels", coinPurse.get("nickels"));
          model.put("pennies", coinPurse.get("pennies"));


            return new ModelAndView(model, layout);
          }, new VelocityTemplateEngine());

        //Console myConsole = System.console();
        //String stringNumber = myConsole.readLine();

  }


  public static HashMap<String, Integer> changeCalculations(Integer inputChange){

    //System.out.println("please enter the change amount you want converted!");


    Integer total = 0;
    Integer quarters = 0;
    Integer dimes = 0;
    Integer nickels = 0;
    Integer pennies = 0;

    while (inputChange >= 0)
    {

      if (inputChange >= 25)
      {
        inputChange -= 25;
        quarters++;
      }

      else if (inputChange >= 10)
      {
        inputChange -= 10;
        dimes++;
      }

      else if (inputChange >= 5)
      {
        inputChange -= 5;
        nickels++;
      }

      else
      {
        pennies = inputChange;
        inputChange = 0;
      }
    }

      HashMap<String, Integer> changeReturn = new HashMap<String, Integer>();
      changeReturn.put("quarters", quarters);
      changeReturn.put("dimes", dimes);
      changeReturn.put("nickels", nickels);
      changeReturn.put("pennies", pennies);

      //String outputChange = String.format("%d quarters ,%d dimes,%d nickels,%d pennies", quarters, dimes, nickels, pennies);


      return changeReturn;
      }
}
