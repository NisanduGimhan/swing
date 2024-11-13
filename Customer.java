class Customer {

    private String orderId;
    private String phoneNumber;
    private String size;
    private int qty;
    private double amount;
    private int status;
    private int XS;
    private int S;
    private int M;
    private int L;
    private int XL;
    private int XXL;

    Customer() {
    }

    Customer(String orderId, String phoneNumber, String size, int qty, double amount, int status) {

        this.orderId = orderId;
        this.phoneNumber = phoneNumber;
        this.size = size;
        this.qty = qty;
        this.amount = amount;
        this.status = status;
    }

    public void setorderId(String orderId) {
        this.orderId = orderId;
    }

    public void setphoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setsize(String size) {
        this.size = size;
    }

    public void setqty(int qty) {
        this.qty = qty;
    }

    public void setamount(double amount) {
        this.amount = amount;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setViewCustomerValues(String phoneNumber, int qty, double amount) {
        this.phoneNumber = phoneNumber;
        this.qty = qty;
        this.amount = amount;
    }

    public void addQtyToSize(String size, int qty) {
        switch (size.toUpperCase()) {
            case "XS":
                this.XS += qty;
                break;
            case "S":
                this.S += qty;
                break;
            case "M":
                this.M += qty;
                break;
            case "L":
                this.L += qty;
                break;
            case "XL":
                this.XL += qty;
                break;
            case "XXL":
                this.XXL += qty;
                break;
        }
    }

    public int getXS() {
        return XS;
    }

    public int getS() {
        return S;
    }

    public int getM() {
        return M;
    }

    public int getL() {
        return L;
    }

    public int getXL() {
        return XL;
    }

    public int getXXL() {
        return XXL;
    }

    public void setAllCustomerValues(String phoneNumber, int XS, int S, int M, int L, int XL, int XXL, double amount) {
        this.phoneNumber = phoneNumber;
        this.XS = XS;
        this.S = S;
        this.M = M;
        this.L = L;
        this.XL = XL;
        this.XXL = XXL;
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSize() {
        return size;
    }

    public int getQty() {
        return qty;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        switch (status) {
            case 1:
                return "Processing";

            case 2:
                return "Delivering";

            case 3:
                return "Deliverd";

            default:
                return "Unknown";
        }

    }

    public boolean equals(Customer customer) {
        return this.orderId.equalsIgnoreCase(customer.orderId);
    }
}
