package LLD.DesignPatterns.behavioral;

public class StateDesignPattern {
    public static void main(String[] args) {

        VendingMachineStateContext context = new VendingMachineStateContext(new ReadyState());
        context.request();

        context.changeState(new InsertCoinState(10));
        context.changeState(new SelectProductState());
        context.changeState(new DispenseState());
        context.changeState(new ReturnCoinState());

        context.request();
    }
}

// behavioral design patten
// if an  objects behavior changes based on its internal state, then we can use state design pattern
// this pattern simplifies the if-else and switch case block for different behavior based on state
// easy to extend the new behavior for new state

// Component -
//  1. Context Class  - Holds the context of state and delegate the behavior based on context change
//  2. State - abstract class to define the base state
//  3. StateConcrete - different implementation of different state

// Use case - Vending Machine (behaves differently based on its state change) simpler


class VendingMachineStateContext{

    private VendingMachineState vendingMachineState;

    public VendingMachineStateContext(VendingMachineState vendingMachineState){
        this.vendingMachineState = vendingMachineState;
    }

    public void changeState(VendingMachineState newState){
        this.vendingMachineState = newState;
    }

    public void request(){
        this.vendingMachineState.handelState();
    }

}


// State class
interface VendingMachineState{

    void handelState();
}

// Concrete class of state
class ReadyState implements VendingMachineState {
    @Override
    public void handelState() {
        System.out.println("Machine is in ready state, please insert the coin");
    }
}

class InsertCoinState implements VendingMachineState {

    private final Integer insertedAmount;

    InsertCoinState(Integer insertAmount){
        this.insertedAmount = insertAmount;
    }

    @Override
    public void handelState() {
        System.out.println(STR."Coin of \{this.insertedAmount} inserted, move to product selection state");
    }
}

class SelectProductState implements VendingMachineState{
    @Override
    public void handelState() {
        System.out.println("Product selected");
    }
}


class DispenseState implements VendingMachineState{
    @Override
    public void handelState() {
        System.out.println("Dispensing the selected product");
    }
}

class ReturnCoinState implements VendingMachineState{
    @Override
    public void handelState() {
        // if machine has the inserted coin then only return the coins
        System.out.println("Will return the coin, if machine was in insert coin state previously");
    }
}




