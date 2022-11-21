package oldSimu;

import classes.Customer;
import main.java.chocolate.PreparationChocolate;
import main.java.coffee.PreparationCoffee;
import main.java.control.ControllerDevices;
import main.java.control.ControllerHR;
import main.java.payment.PreparationOrder;
import main.java.picard.PreparationPicard;
import main.java.pizza.PreparationPizza;
import main.java.ramen.StartBoilingWater;

import java.util.ArrayList;

/**
 * The type Waiting list.
 */
public final class WaitingList {

    private static WaitingList waitingListInstance = new WaitingList();
    private ArrayList<Customer> preOrder;
    private ArrayList<Customer> postOrder;
    private ArrayList<Integer> sizePre;
    private ArrayList<Integer> sizePost;

    private WaitingList() {
        preOrder = new ArrayList<>();
        postOrder = new ArrayList<>();
        sizePost = new ArrayList<>();
        sizePre = new ArrayList<>();
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static WaitingList getInstance() {
        if (waitingListInstance == null) {
            waitingListInstance = new WaitingList();
        }

        return waitingListInstance;
    }

    /**
     * Gets pre order.
     *
     * @return the pre order waiting list
     */
    public ArrayList<Customer> getPreOrder() {
        return preOrder;
    }

    /**
     * Gets post order.
     *
     * @return the post order waiting list
     */
    public ArrayList<Customer> getPostOrder() {
        return postOrder;
    }

    /**
     * Search what part of the customer's order can be prepared depending on the different free devices
     *
     * @param customer customer to search for
     */
    public void searchGlobal(Customer customer) {
        ControllerHR HRInstance = ControllerHR.getInstance();
        int time = Scheduler.getInstance().getCurrentTime() + 1;

        if (customer.getOrder().getChocolate() + customer.getOrder().getCoffee() + customer.getOrder().getRamen() + customer.getOrder().getPicard() > 0) {      //Il y a une commande à préparer

            if (HRInstance.getFreeKfetier().get("Kfetier") > 0) {           // Un kfetier est libre

                ControllerDevices devicesInstance = ControllerDevices.getInstance();
                boolean found = false;

                if (customer.getOrder().getPicard() > 0) {
                    if (devicesInstance.getFreeDevices().get("Microwave") > 0) {
                        found = true;
                        Scheduler.getInstance().addEvent(new PreparationPicard(customer, time));
                    }
                } else if (customer.getOrder().getRamen() > 0 && !found) {
                    if (devicesInstance.getFreeDevices().get("Kettle") > 0) {
                        found = true;
                        Scheduler.getInstance().addEvent(new StartBoilingWater(customer, time));
                    }
                } else if (customer.getOrder().getCoffee() > 0 && !found) {
                    if (devicesInstance.getFreeDevices().get("Cafetiere") > 0) {
                        found = true;
                        Scheduler.getInstance().addEvent(new PreparationCoffee(customer, time));
                    }
                } else if (customer.getOrder().getChocolate() > 0 && !found) {
                    if (devicesInstance.getFreeDevices().get("Cocoa") > 0) {
                        found = true;
                        Scheduler.getInstance().addEvent(new PreparationChocolate(customer, time));
                    }
                }
            } else {    //Pas de kfetier libre
                Scheduler.getInstance().addEvent(new PreparationOrder(customer, time + 49));
            }
        }
    }

    /**
     * Search if the customer ordered a pizza and if an oven is free to start the PreparationPizza
     *
     * @param customer customer to search for
     */
    public void searchPizza(Customer customer) {
        ControllerDevices devicesInstance = ControllerDevices.getInstance();
        ControllerHR HRInstance = ControllerHR.getInstance();
        if (customer.getOrder().getNbPizza() > 0) {
            if (HRInstance.getFreeKfetier().get("Cook") > 0) {           // Un kfetier est libre
                if (devicesInstance.getFreeDevices().get("Oven") > 0) {
                    Scheduler.getInstance().addEvent(new PreparationPizza(customer, Scheduler.getInstance().getCurrentTime() + 1));
                }
            }
        }
    }

    /**
     * Gets the size of the Pre order waiting list at every time
     *
     * @return the size
     */
    public ArrayList<Integer> getSizePre() {
        return sizePre;
    }

    /**
     * Gets the size of the Post order waiting list at every time.
     *
     * @return the size
     */
    public ArrayList<Integer> getSizePost() {
        return sizePost;
    }
}
