class CustomerCollection {

    private Customer[] customerArray;
    private static int z = 0;
    public static int uniqueCount = 0;
    public static int uniqueCountBIC = 0;
    private Customer[] UniqeCustomer;
    public sort[] sortamount;
    public sort[] sortqty;
    public Customer[] odramount;

    public static final double XS = 600;
    public static final double S = 800;
    public static final double M = 900;
    public static final double L = 1000;
    public static final double XL = 1100;
    public static final double XXL = 1200;

    CustomerCollection() {
        customerArray = new Customer[0];
        UniqeCustomer = new Customer[0];
    }

    // -------------- GENERATE ORDER ID -----------------
    public String generateOrderId() {
        return String.format("ORD#%05d", z + 1);
    }

    // ---------PHONE NUMBER VALIDATE---------
    public Boolean phoneNumberValidate(String phonenumber) {

        if (phonenumber.length() == 10 && phonenumber.charAt(0) == '0') {
            return true;
        } else {

            return false;

        }
    }

    // ------------SIZE VALIDATE----------
    public boolean tSize(String size) {

        if (size.equals("XS") || size.equals("S") || size.equals("M") || size.equals("L") || size.equals("XL")
                || size.equals("XXL")) {
            return true;
        } else {

            return false;
        }
    }

    public boolean qantity(int qty) {
        if (qty > 0) {
            return true;
        }
        return false;

    }

    // ----------GET AMOUNT-------
    public static double amount(String size, int qty) {
        double amount = 0;
        switch (size.toUpperCase()) {
            case "XS":
                amount = XS * qty;
                break;
            case "S":
                amount = S * qty;
                break;
            case "M":
                amount = M * qty;
                break;
            case "L":
                amount = L * qty;
                break;
            case "XL":
                amount = XL * qty;
                break;
            case "XXL":
                amount = XXL * qty;
                break;
        }
        return amount;

    }

    public boolean addCustomer(Customer customer) {
        extendArrays();
        customerArray[customerArray.length - 1] = customer;
        z++;
        return true;
    }

    // --------------- EXTEND ARRAYS ---------------
    public void extendArrays() {
        Customer tempcustomerArray[] = new Customer[customerArray.length + 1];

        for (int i = 0; i < customerArray.length; i++) {
            tempcustomerArray[i] = customerArray[i];
        }

        customerArray = tempcustomerArray;

    }

    public boolean searchCustomer(String phoneNo) {
        boolean isFound = false;

        String[] tempSizeArray = { "XS", "S", "M", "L", "XL", "XXL" };
        int[] tempQtyArray = new int[6];
        double[] tempAmountArray = new double[6];

        for (int i = 0; i < customerArray.length; i++) {
            if (customerArray[i].getPhoneNumber().equals(phoneNo)) {

                isFound = true;

                if (customerArray[i].getSize().equals("XS")) {
                    tempQtyArray[0] += customerArray[i].getQty();
                    tempAmountArray[0] += customerArray[i].getAmount();
                } else if (customerArray[i].getSize().equals("S")) {
                    tempQtyArray[1] += customerArray[i].getQty();
                    tempAmountArray[1] += customerArray[i].getAmount();
                } else if (customerArray[i].getSize().equals("M")) {
                    tempQtyArray[2] += customerArray[i].getQty();
                    tempAmountArray[2] += customerArray[i].getAmount();
                } else if (customerArray[i].getSize().equals("L")) {
                    tempQtyArray[3] += customerArray[i].getQty();
                    tempAmountArray[3] += customerArray[i].getAmount();
                } else if (customerArray[i].getSize().equals("XL")) {
                    tempQtyArray[4] += customerArray[i].getQty();
                    tempAmountArray[4] += customerArray[i].getAmount();
                } else if (customerArray[i].getSize().equals("XXL")) {
                    tempQtyArray[5] += customerArray[i].getQty();
                    tempAmountArray[5] += customerArray[i].getAmount();
                } else {
                    continue;
                }

            }
        }
        if (isFound) {
            for (int i = 0; i < tempSizeArray.length; i++) {
                if (tempQtyArray[i] > 0) {
                    System.out.println("Size: " + tempSizeArray[i] + " Qty: " + tempQtyArray[i] + " Amount: "
                            + tempAmountArray[i]);
                }
            }
        }

        return isFound;
    }

    public int searchOrderId(String orderId) {

        for (int i = 0; i < customerArray.length; i++) {
            if (customerArray[i].getOrderId().equals(orderId)) {

                return i;
            }

        }
        return -1;
    }

    public void viewCustomerReport() {

        UniqeCustomer = new Customer[customerArray.length];
        uniqueCount = 0;

        for (int i = 0; i < customerArray.length; i++) {
            boolean exists = false;

            for (int j = 0; j < uniqueCount; j++) {
                if (UniqeCustomer[j].getPhoneNumber().equals(customerArray[i].getPhoneNumber())) {

                    int totalQty = UniqeCustomer[j].getQty() + customerArray[i].getQty();
                    double totalAmount = UniqeCustomer[j].getAmount() + customerArray[i].getAmount();

                    UniqeCustomer[j].setViewCustomerValues(customerArray[i].getPhoneNumber(), totalQty, totalAmount);
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                UniqeCustomer[uniqueCount] = new Customer();
                UniqeCustomer[uniqueCount].setViewCustomerValues(customerArray[i].getPhoneNumber(),
                        customerArray[i].getQty(), customerArray[i].getAmount());
                uniqueCount++;
            }
        }
    }

    public void bestInCustomer() {

        UniqeCustomer = new Customer[customerArray.length];
        uniqueCountBIC = 0;

        for (int i = 0; i < customerArray.length; i++) {
            boolean exists = false;

            for (int j = 0; j < uniqueCountBIC; j++) {
                if (UniqeCustomer[j].getPhoneNumber().equals(customerArray[i].getPhoneNumber())) {

                    int totalQty = UniqeCustomer[j].getQty() + customerArray[i].getQty();
                    double totalAmount = UniqeCustomer[j].getAmount() + customerArray[i].getAmount();

                    UniqeCustomer[j].setViewCustomerValues(customerArray[i].getPhoneNumber(), totalQty, totalAmount);
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                UniqeCustomer[uniqueCountBIC] = new Customer();
                UniqeCustomer[uniqueCountBIC].setViewCustomerValues(customerArray[i].getPhoneNumber(),
                        customerArray[i].getQty(), customerArray[i].getAmount());
                uniqueCountBIC++;
            }
        }

    }

    public void allInCustomer() {
        UniqeCustomer = new Customer[customerArray.length];
        uniqueCountBIC = 0;

        for (int i = 0; i < customerArray.length; i++) {
            int Mcount = 0;
            int XScount = 0;
            int Scount = 0;
            int Lcount = 0;
            int XLcount = 0;
            int XXLcount = 0;
            double totalAmount = customerArray[i].getAmount();

            switch (customerArray[i].getSize()) {
                case "M":
                    Mcount = customerArray[i].getQty();
                    break;
                case "XS":
                    XScount = customerArray[i].getQty();
                    break;
                case "S":
                    Scount = customerArray[i].getQty();
                    break;
                case "L":
                    Lcount = customerArray[i].getQty();
                    break;
                case "XL":
                    XLcount = customerArray[i].getQty();
                    break;
                case "XXL":
                    XXLcount = customerArray[i].getQty();
                    break;
            }

            boolean exists = false;

            for (int j = 0; j < uniqueCountBIC; j++) {
                if (UniqeCustomer[j].getPhoneNumber().equals(customerArray[i].getPhoneNumber())) {

                    XScount += UniqeCustomer[j].getXS();
                    Scount += UniqeCustomer[j].getS();
                    Mcount += UniqeCustomer[j].getM();
                    Lcount += UniqeCustomer[j].getL();
                    XLcount += UniqeCustomer[j].getXL();
                    XXLcount += UniqeCustomer[j].getXXL();
                    totalAmount += UniqeCustomer[j].getAmount();

                    UniqeCustomer[j].setAllCustomerValues(customerArray[i].getPhoneNumber(), XScount, Scount, Mcount,
                            Lcount, XLcount, XXLcount, totalAmount);
                    exists = true;
                    break;
                }
            }

            if (!exists) {

                UniqeCustomer[uniqueCountBIC] = new Customer();
                UniqeCustomer[uniqueCountBIC].setAllCustomerValues(customerArray[i].getPhoneNumber(), XScount, Scount,
                        Mcount, Lcount, XLcount, XXLcount, totalAmount);
                uniqueCountBIC++;
            }
        }

    }

    public void categorizedByQty() {
        sortqty = new sort[6];
        boolean[] processed = new boolean[customerArray.length];

        int Mqty = 0;
        int XSqty = 0;
        int Sqty = 0;
        int Lqty = 0;
        int XLqty = 0;
        int XXLqty = 0;

        double Mtotal = 0;
        double XStotal = 0;
        double Stotal = 0;
        double Ltotal = 0;
        double XLtotal = 0;
        double XXLtotal = 0;

        for (int i = 0; i < customerArray.length; i++) {

            if (customerArray[i].getSize().equals("M")) {
                Mqty += customerArray[i].getQty();

            } else if (customerArray[i].getSize().equals("XL")) {
                XLqty += customerArray[i].getQty();

            } else if (customerArray[i].getSize().equals("XS")) {
                XSqty += customerArray[i].getQty();

            } else if (customerArray[i].getSize().equals("S")) {
                Sqty += customerArray[i].getQty();

            } else if (customerArray[i].getSize().equals("XXL")) {
                XXLqty += customerArray[i].getQty();

            } else if (customerArray[i].getSize().equals("L")) {
                Lqty += customerArray[i].getQty();

            }

        }
        Mtotal = Mqty * 900;
        XLtotal = XLqty * 1100;
        XStotal = XSqty * 600;
        Stotal = Sqty * 900;
        Ltotal = Lqty * 1000;
        XXLtotal = XXLqty * 1200;

        sortqty[0] = new sort();
        sortqty[0].setByqty("XS", XSqty, XStotal);
        sortqty[1] = new sort();
        sortqty[1].setByqty("S", Sqty, Stotal);
        sortqty[2] = new sort();
        sortqty[2].setByqty("M", Mqty, Mtotal);
        sortqty[3] = new sort();
        sortqty[3].setByqty("L", Lqty, Ltotal);
        sortqty[4] = new sort();
        sortqty[4].setByqty("XL", XLqty, XLtotal);
        sortqty[5] = new sort();
        sortqty[5].setByqty("XXL", XXLqty, XXLtotal);

        for (int i = 5; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                if (sortqty[j].getqty() < sortqty[j + 1].getqty()) {
                    sort temp = sortqty[j];
                    sortqty[j] = sortqty[j + 1];
                    sortqty[j + 1] = temp;
                }
            }
        }

    }

    public void odramount() {

        odramount = new Customer[customerArray.length];

        for (int i = 0; i < customerArray.length; i++) {

            odramount[i] = customerArray[i];
        }

        for (int i = customerArray.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (odramount[j].getAmount() < odramount[j + 1].getAmount()) {
                    Customer temp = odramount[j];
                    odramount[j] = odramount[j + 1];
                    odramount[j + 1] = temp;
                }
            }
        }
    }

    public void sortByamount() {
        sortamount = new sort[6];
        boolean[] processed = new boolean[customerArray.length];

        int Mqty = 0;
        int XSqty = 0;
        int Sqty = 0;
        int Lqty = 0;
        int XLqty = 0;
        int XXLqty = 0;

        double Mtotal = 0;
        double XStotal = 0;
        double Stotal = 0;
        double Ltotal = 0;
        double XLtotal = 0;
        double XXLtotal = 0;

        for (int i = 0; i < customerArray.length; i++) {

            if (customerArray[i].getSize().equals("M")) {
                Mqty += customerArray[i].getQty();

            } else if (customerArray[i].getSize().equals("XL")) {
                XLqty += customerArray[i].getQty();

            } else if (customerArray[i].getSize().equals("XS")) {
                XSqty += customerArray[i].getQty();

            } else if (customerArray[i].getSize().equals("S")) {
                Sqty += customerArray[i].getQty();

            } else if (customerArray[i].getSize().equals("XXL")) {
                XXLqty += customerArray[i].getQty();

            } else if (customerArray[i].getSize().equals("L")) {
                Lqty += customerArray[i].getQty();

            }

        }
        Mtotal = Mqty * 900;
        XLtotal = XLqty * 1100;
        XStotal = XSqty * 600;
        Stotal = Sqty * 900;
        Ltotal = Lqty * 1000;
        XXLtotal = XXLqty * 1200;

        sortamount[0] = new sort();
        sortamount[0].setByqty("XS", XSqty, XStotal);
        sortamount[1] = new sort();
        sortamount[1].setByqty("S", Sqty, Stotal);
        sortamount[2] = new sort();
        sortamount[2].setByqty("M", Mqty, Mtotal);
        sortamount[3] = new sort();
        sortamount[3].setByqty("L", Lqty, Ltotal);
        sortamount[4] = new sort();
        sortamount[4].setByqty("XL", XLqty, XLtotal);
        sortamount[5] = new sort();
        sortamount[5].setByqty("XXL", XXLqty, XXLtotal);
        for (int i = 5; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                if (sortamount[j].getamount() < sortamount[j + 1].getamount()) {
                    sort temp = sortamount[j];
                    sortamount[j] = sortamount[j + 1];
                    sortamount[j + 1] = temp;
                }
            }
        }
    }

    public boolean sortarray(int deleteindex) {
        Customer[] tempCusArray = new Customer[customerArray.length - 1];

        for (int i = 0, j = 0; i < customerArray.length; i++) {
            if (i != deleteindex) {
                tempCusArray[j] = customerArray[i];
                j++;
            }
        }

        customerArray = tempCusArray;
        return true;
    }

    // real object(use for deletation proccess)
    public Customer[] getCustomerArray() {
        return customerArray;
    }

    // unique object
    public Customer[] getUniqeCustomer() {
        Customer[] tempArray = new Customer[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            tempArray[i] = UniqeCustomer[i];
        }
        return tempArray;
    }

    // object
    public Customer[] getCustomerObjects() {
        Customer[] tempCustomerArray = new Customer[customerArray.length];
        for (int i = 0; i < customerArray.length; i++) {
            tempCustomerArray[i] = customerArray[i];
        }
        return tempCustomerArray;
    }

}

class sort {
    private int qty;
    private String size;
    private double amount;

    public void setByqty(String size, int qty, double amount) {

        this.size = size;
        this.qty = qty;
        this.amount = amount;
    }

    public String getSize() {
        return size;
    }

    public int getqty() {
        return qty;
    }

    public double getamount() {
        return amount;
    }

}
