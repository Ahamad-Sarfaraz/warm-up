package LLD.DesignPatterns.structural;

public class FacadeDesignPattern {
    public static void main(String[] args) {
        HotelKeeper hotelKeeper = new HotelKeeperFacade();

        System.out.println(hotelKeeper.getVegMenu());
        System.out.println(hotelKeeper.getNonVegMenu());
        System.out.println(hotelKeeper.getVegNonVegMenu());
    }
}

// Structural design pattern which helps to hide the complexities of a subs system from clients
// by introducing a facade, facade work as front gateway to the client. Client doesn't have dependency on
// subsystem, it interacts with facade only making code loosely coupled.


// Use case - Hotel Menu System
// Hotel Menu -> Menus from Different restaurant
// Hotel keeper will work as facade, client will interact with hotel keeper only for Menu
// Hotel keeper will interact with different restaurant to get menus , which hides complexity of different restaurant from client

interface Menu{
    Menu getMenu();
}

class VegMenu implements Menu{

    @Override
    public VegMenu getMenu() {
        return new VegMenu();
    }
}

class NonVegMenu implements Menu{

    @Override
    public NonVegMenu getMenu() {
        return new NonVegMenu();
    }
}

class VegNonVeg implements Menu{

    @Override
    public VegNonVeg getMenu() {
        return new VegNonVeg();
    }
}

interface HotelKeeper{
    Menu getVegMenu();
    Menu getNonVegMenu();
    Menu getVegNonVegMenu();

}

// Facade
class HotelKeeperFacade implements HotelKeeper{

    @Override
    public VegMenu getVegMenu() {
        System.out.println("Hotel Keeper is getting veg menu");
        VegMenu vegMenu = new VegMenu();
        return vegMenu.getMenu();
    }

    @Override
    public NonVegMenu getNonVegMenu() {
        System.out.println("Hotel Keeper is getting non-veg menu");
        NonVegMenu nonVegMenu = new NonVegMenu();
        return nonVegMenu.getMenu();

    }

    @Override
    public VegNonVeg getVegNonVegMenu() {
        System.out.println("Hotel Keeper is getting veg & non-veg menu");
        VegNonVeg nonVegMenu = new VegNonVeg();
        return nonVegMenu.getMenu();

    }
}



