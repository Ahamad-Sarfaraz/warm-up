package LLD.DesignPatterns.creational;

public class FactoryDesignPattern {
    public static void main(String[] args) {
        Notifications nf = Factory.getInstance("Push");
        nf.notifyUser();
    }
}

class Factory {
    public static Notifications getInstance(String className) {
        return switch (className) {
            case "SMS" -> new SMSNotifications();
            case "Email" -> new EmailNotifications();
            case "Push" -> new PushNotifications();
            default -> throw new RuntimeException("Invalid Notification Type");
        };
    }
}



interface Notifications{
    void notifyUser();
}

class SMSNotifications implements Notifications {
    @Override
    public void notifyUser() {
        System.out.println("SMS Notification");

    }
}

class EmailNotifications implements Notifications {
    @Override
    public void notifyUser() {
        System.out.println("Email Notification");

    }
}

class PushNotifications implements Notifications {
    @Override
    public void notifyUser() {
        System.out.println("Push Notification");

    }
}
