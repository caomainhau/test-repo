import java.util.Date;

// Customer class
public class Customer {
    private String name;
    private boolean member = false;
    private String memberType;

    // Constructor
    public Customer(String name) {
        this.name = name;
    }

    // Getter and setter methods
    public String getName() {
        return name;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    // toString method
    @Override
    public String toString() {
        return "Customer [name=" + name + ", member=" + member + ", memberType=" + memberType + "]";
    }
}

// DiscountRate class
public class DiscountRate {
    // Static variables for service discounts
    private static final double serviceDiscountPremium = 0.2;
    private static final double serviceDiscountGold = 0.15;
    private static final double serviceDiscountSilver = 0.1;

    // Static variables for product discounts
    private static final double productDiscountPremium = 0.1;
    private static final double productDiscountGold = 0.1;
    private static final double productDiscountSilver = 0.1;

    // Static methods to get discount rates
    public static double getServiceDiscountRate(String type) {
        switch (type.toLowerCase()) {
            case "premium":
                return serviceDiscountPremium;
            case "gold":
                return serviceDiscountGold;
            case "silver":
                return serviceDiscountSilver;
            default:
                return 0.0;
        }
    }

    public static double getProductDiscountRate(String type) {
        switch (type.toLowerCase()) {
            case "premium":
                return productDiscountPremium;
            case "gold":
                return productDiscountGold;
            case "silver":
                return productDiscountSilver;
            default:
                return 0.0;
        }
    }
}

// Visit class
public class Visit {
    private Customer customer;
    private Date date;
    private double serviceExpense;
    private double productExpense;

    // Constructor
    public Visit(String name, Date date) {
        this.customer = new Customer(name);
        this.date = date;
    }

    // Getter and setter methods
    public String getName() {
        return customer.getName();
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    public double getTotalExpense() {
        double serviceDiscount = customer.isMember() ? DiscountRate.getServiceDiscountRate(customer.getMemberType()) : 0.0;
        double productDiscount = DiscountRate.getProductDiscountRate(customer.getMemberType());
        return (serviceExpense - serviceExpense * serviceDiscount) + (productExpense - productExpense * productDiscount);
    }
}
