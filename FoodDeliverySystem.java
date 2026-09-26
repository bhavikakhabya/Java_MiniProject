import javax.swing.*;
import java.awt.*;
import java.util.*;

class Food {
    int id;
    String name;
    double price;

    Food(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class Order {
    String customer;
    Food food;
    int quantity;

    Order(String customer, Food food, int quantity) {
        this.customer = customer;
        this.food = food;
        this.quantity = quantity;
    }

    double total() {
        return food.price * quantity;
    }
}

public class FoodDeliverySystem {

    static Food[] foods = {
            new Food(101, "Pizza", 250),
            new Food(102, "Burger", 150),
            new Food(103, "Biryani", 220),
            new Food(104, "Dosa", 100),
            new Food(105, "Pasta", 180)
    };

    static LinkedList<Order> orders = new LinkedList<>();
    static HashMap<Integer, Food> foodMap = new HashMap<>();
    static TreeMap<Integer, Food> sortedFood = new TreeMap<>();

    static JTextField nameField;
    static JTextField idField;
    static JTextField quantityField;
    static JTextArea output;

    public static void main(String[] args) {

        for (Food food : foods) {
            foodMap.put(food.id, food);
            sortedFood.put(food.id, food);
        }

        createGUI();
    }

    static void createGUI() {

        JFrame frame = new JFrame("Food Delivery Management System");

        frame.setSize(900, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());


        JPanel header = new JPanel();

        // Lavender colour
        header.setBackground(new Color(220, 200, 240));

        header.setPreferredSize(
                new Dimension(900, 80));

        JLabel title = new JLabel(
                "FOOD DELIVERY SYSTEM");

        // BLACK TEXT
        title.setForeground(Color.BLACK);

        title.setFont(
                new Font("Arial", Font.BOLD, 28));

        header.add(title);

        frame.add(header, BorderLayout.NORTH);


        JPanel leftPanel = new JPanel();

        leftPanel.setBackground(
                new Color(250, 245, 252));

        leftPanel.setPreferredSize(
                new Dimension(300, 500));

        leftPanel.setLayout(
                new GridLayout(9, 1, 10, 10));

        JLabel customerLabel = new JLabel("  Customer Name");

        customerLabel.setForeground(Color.BLACK);

        customerLabel.setFont(
                new Font("Arial", Font.BOLD, 14));

        nameField = new JTextField();

        JLabel idLabel = new JLabel("  Food ID");

        idLabel.setForeground(Color.BLACK);

        idLabel.setFont(
                new Font("Arial", Font.BOLD, 14));

        idField = new JTextField();

        JLabel quantityLabel = new JLabel("  Quantity");

        quantityLabel.setForeground(Color.BLACK);

        quantityLabel.setFont(
                new Font("Arial", Font.BOLD, 14));

        quantityField = new JTextField();

        leftPanel.add(customerLabel);
        leftPanel.add(nameField);

        leftPanel.add(idLabel);
        leftPanel.add(idField);

        leftPanel.add(quantityLabel);
        leftPanel.add(quantityField);

        JButton placeButton = new JButton("🛒 Place Order");

        JButton searchButton = new JButton("🔍 Search Food");

        JButton modifyButton = new JButton("✏ Modify Order");

        placeButton.setForeground(Color.BLACK);
        searchButton.setForeground(Color.BLACK);
        modifyButton.setForeground(Color.BLACK);

        placeButton.setBackground(
                new Color(230, 210, 245));

        searchButton.setBackground(
                new Color(210, 195, 235));

        modifyButton.setBackground(
                new Color(200, 220, 240));

        leftPanel.add(placeButton);
        leftPanel.add(searchButton);
        leftPanel.add(modifyButton);

        frame.add(
                leftPanel,
                BorderLayout.WEST);

        JPanel centerPanel = new JPanel(new BorderLayout());

        JLabel outputTitle = new JLabel(
                "   Food & Order Details");

        // BLACK TEXT
        outputTitle.setForeground(Color.BLACK);

        outputTitle.setFont(
                new Font("Arial", Font.BOLD, 20));

        output = new JTextArea();

        output.setFont(
                new Font("Arial", Font.PLAIN, 16));

        output.setForeground(Color.BLACK);

        output.setBackground(
                new Color(255, 252, 255));

        output.setEditable(false);

        JScrollPane scroll = new JScrollPane(output);

        centerPanel.add(
                outputTitle,
                BorderLayout.NORTH);

        centerPanel.add(
                scroll,
                BorderLayout.CENTER);

        frame.add(
                centerPanel,
                BorderLayout.CENTER);


        JPanel bottomPanel = new JPanel();

        bottomPanel.setBackground(
                new Color(235, 220, 245));

        JButton showFoodButton = new JButton("🍕 Show Food");

        JButton showOrdersButton = new JButton("📋 Show Orders");

        JButton billButton = new JButton("🧾 Generate Bill");

        JButton cancelButton = new JButton("❌ Cancel Order");

        showFoodButton.setForeground(Color.BLACK);
        showOrdersButton.setForeground(Color.BLACK);
        billButton.setForeground(Color.BLACK);
        cancelButton.setForeground(Color.BLACK);

        showFoodButton.setBackground(
                new Color(255, 225, 200));

        showOrdersButton.setBackground(
                new Color(200, 225, 240));

        billButton.setBackground(
                new Color(200, 235, 205));

        cancelButton.setBackground(
                new Color(245, 200, 210));

        bottomPanel.add(showFoodButton);
        bottomPanel.add(showOrdersButton);
        bottomPanel.add(billButton);
        bottomPanel.add(cancelButton);

        frame.add(
                bottomPanel,
                BorderLayout.SOUTH);


        placeButton.addActionListener(
                e -> placeOrder());

        searchButton.addActionListener(
                e -> searchFood());

        modifyButton.addActionListener(
                e -> modifyOrder());

        showFoodButton.addActionListener(
                e -> showFood());

        showOrdersButton.addActionListener(
                e -> showOrders());

        billButton.addActionListener(
                e -> generateBill());

        cancelButton.addActionListener(
                e -> cancelOrder());

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }


    static void showFood() {

        output.setText(
                "AVAILABLE FOOD\n\n");

        for (Food food : sortedFood.values()) {

            output.append(
                    "ID: " + food.id +
                            "     " +
                            food.name +
                            "     ₹" +
                            food.price +
                            "\n\n");
        }
    }

    static void searchFood() {

        try {

            int id = Integer.parseInt(
                    idField.getText());

            Food food = foodMap.get(id);

            if (food != null) {

                output.setText(
                        "FOOD FOUND\n\n" +
                                "Food ID: " + food.id +
                                "\nFood Name: " + food.name +
                                "\nPrice: ₹" + food.price);

            } else {

                output.setText(
                        "Food not found.");
            }

        } catch (Exception e) {

            output.setText(
                    "Please enter a valid Food ID.");
        }
    }

    static void placeOrder() {

        try {

            String customer = nameField.getText();

            int id = Integer.parseInt(
                    idField.getText());

            int quantity = Integer.parseInt(
                    quantityField.getText());

            if (customer.isEmpty()) {

                output.setText(
                        "Please enter customer name.");

                return;
            }

            Food food = foodMap.get(id);

            if (food == null) {

                output.setText(
                        "Food not found.");

                return;
            }

            Order order = new Order(
                    customer,
                    food,
                    quantity);

            orders.add(order);

            output.setText(
                    "ORDER PLACED!\n\n" +
                            "Customer: " + customer +
                            "\nFood: " + food.name +
                            "\nQuantity: " + quantity +
                            "\nTotal: ₹" + order.total());

        } catch (Exception e) {

            output.setText(
                    "Please enter valid details.");
        }
    }

    static void showOrders() {

        output.setText(
                "CUSTOMER ORDERS\n\n");

        if (orders.isEmpty()) {

            output.append(
                    "No orders available.");

            return;
        }

        for (int i = 0; i < orders.size(); i++) {

            Order order = orders.get(i);

            output.append(
                    (i + 1) +
                            ". " +
                            order.customer +
                            " → " +
                            order.food.name +
                            " x " +
                            order.quantity +
                            " = ₹" +
                            order.total() +
                            "\n\n");
        }
    }

    static void modifyOrder() {

        if (orders.isEmpty()) {

            output.setText(
                    "No order to modify.");

            return;
        }

        try {

            int quantity = Integer.parseInt(
                    quantityField.getText());

            Order order = orders.getLast();

            order.quantity = quantity;

            output.setText(
                    "ORDER MODIFIED!\n\n" +
                            "Food: " +
                            order.food.name +
                            "\nNew Quantity: " +
                            quantity +
                            "\nNew Total: ₹" +
                            order.total());

        } catch (Exception e) {

            output.setText(
                    "Enter a valid quantity.");
        }
    }

    static void cancelOrder() {

        if (orders.isEmpty()) {

            output.setText(
                    "No order to cancel.");

            return;
        }

        Order order = orders.removeLast();

        output.setText(
                "ORDER CANCELLED!\n\n" +
                        order.food.name +
                        " order has been cancelled.");
    }

    static void generateBill() {

        if (orders.isEmpty()) {

            output.setText(
                    "No orders available.");

            return;
        }

        double total = 0;

        output.setText(
                "FINAL BILL\n\n");

        for (Order order : orders) {

            output.append(
                    order.food.name +
                            " x " +
                            order.quantity +
                            " = ₹" +
                            order.total() +
                            "\n");

            total = total +
                    order.total();
        }

        output.append(
                "\n-------------------------\n" +
                        "TOTAL BILL = ₹" +
                        total);
    }
}