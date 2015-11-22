package com.xformation.foodordering.control;

import com.xformation.foodordering.db.menu.Cuisine;
import com.xformation.foodordering.db.menu.Dish;
import com.xformation.foodordering.db.menu.DishType;
import com.xformation.foodordering.db.menu.MenuDAO;
import com.xformation.foodordering.db.ordering.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mikolaj on 2015-11-21.
 */
public class ControlPanel {

    protected MenuDAO menu;
    protected Waiter waiter;
    private OrderDAO orderDAO;

    private class KEY_MEANING {
        public static final int LUNCH = 0;
        public static final int DRINK = 1;
    }

    public ControlPanel() {
        menu = new MenuDAO();
        waiter = new Waiter();
        orderDAO = new OrderDAO();
    }

    public void run() {
        System.out.println("Welcome in Food Ordering System\n");
        while (keepWorking()) {
            ComplexOrder complexOrder = takeOrder();
            System.out.println("You have ordered:\n" + complexOrder.toString());
            orderDAO.addOrder(complexOrder);
        }
    }

    private boolean keepWorking() {
        return interactWithUser("What do you want to do?", "Order food", "Exit") == 0;
    }


    private ComplexOrder takeOrder() {
        ComplexOrder complexOrder = new ComplexOrder();
        do {
            Order subOrder = takeSubOrder();
            complexOrder.addOrder(subOrder);
        } while(wantSomethingElse());
        return complexOrder;
    }

    private Order takeSubOrder() {
        Cuisine choosedCuisine = chooseCuisine();
        Integer choosedMeal = chooseSortOfMeal();
        if (choosedMeal == KEY_MEANING.LUNCH) {
            return orderLunch(choosedCuisine);
        } else {
            return orderDrink(choosedCuisine);
        }
    }

    private Cuisine chooseCuisine() {
        List<Cuisine> cuisines = menu.getCuisines();
        waiter.askQuestion("Choose cuisine", cuisines);
        Integer choosedOption = handleAnswer(cuisines.size());
        return cuisines.get(choosedOption);
    }

    private Integer chooseSortOfMeal() {
        return interactWithUser("Choose sort of meal:", "Lunch", "Drink");
    }

    private Integer interactWithUser(String message, String... options){
        waiter.askQuestion(message, Arrays.asList(options));
        return handleAnswer(options.length);
    }

    private Integer handleAnswer(int optionsNb){
        Integer answer = null;
        do {
            answer = waiter.takeAnswer();
        } while (isNotProperAnswer(answer, optionsNb));
        return answer;
    }

    private boolean isNotProperAnswer(Integer answer, int optionsNb) {
        return answer < 0 || answer >= optionsNb;
    }

    private LunchOrder orderLunch(Cuisine choosedCuisine) {
        Dish mainCourse = chooseMainCourse(choosedCuisine);
        Dish dessert = chooseDessert(choosedCuisine);
        return new LunchOrder(mainCourse, dessert);
    }

    private Dish chooseMainCourse(Cuisine choosedCuisine) {
        List<Dish> courses = menu.getDishes(choosedCuisine.getName(), DishType.MAIN);
        return chooseDish("Choose a main course:", courses);
    }

    private Dish chooseDessert(Cuisine choosedCuisine) {
        List<Dish> desserts = menu.getDishes(choosedCuisine.getName(), DishType.DESSERT);
        return chooseDish("Choose a dessert:", desserts);
    }

    private Dish chooseDish(String message, List<Dish> dishes) {
        waiter.askQuestion(message, dishes);
        Integer choosedDish = handleAnswer(dishes.size());
        return dishes.get(choosedDish);
    }

    private DrinkOrder orderDrink(Cuisine choosedCuisine) {
        Dish drink = chooseDrink(choosedCuisine);
        boolean ice = askForAddition("ice");
        boolean lemon = askForAddition("lemon");
        return new DrinkOrder(drink, ice, lemon);
    }

    private Dish chooseDrink(Cuisine choosedCuisine) {
        List<Dish> drinks = menu.getDishes(choosedCuisine.getName(), DishType.DRINK);
        return chooseDish("Choose a drink:", drinks);
    }

    private boolean askForAddition(String additionName) {
        waiter.askYesNoQuestion("Do you want " + additionName);
        return handleAnswer(2) == 0;
    }

    public boolean wantSomethingElse() {
        waiter.askYesNoQuestion("Do you want something else?");
        return handleAnswer(2) == 0;
    }

    public static void main(String[] args){
        new ControlPanel().run();
        System.exit(1);
    }
}
