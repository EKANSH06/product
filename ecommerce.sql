-- Create the database
CREATE DATABASE ecommerce_platform;
USE ecommerce_platform;

-- Create the User table
CREATE TABLE User (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role ENUM('customer', 'admin') DEFAULT 'customer',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create the Product table
CREATE TABLE Product (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL CHECK (price >= 0),
    stock INT NOT NULL CHECK (stock >= 0),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create the Order table
CREATE TABLE Order (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('pending', 'shipped', 'delivered', 'cancelled') DEFAULT 'pending',
    total DECIMAL(10, 2) NOT NULL CHECK (total >= 0),
    FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE
);

-- Create the OrderItem table
CREATE TABLE OrderItem (
    order_item_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL CHECK (quantity > 0),
    price DECIMAL(10, 2) NOT NULL CHECK (price >= 0),
    FOREIGN KEY (order_id) REFERENCES Order(order_id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES Product(product_id)
);

-- Sample data insertion

-- Insert data into User table
INSERT INTO User (username, email, password, role)
VALUES 
('john_doe', 'john@example.com', 'hashedpassword123', 'customer'),
('jane_admin', 'jane@example.com', 'hashedpassword456', 'admin');

-- Insert data into Product table
INSERT INTO Product (product_name, description, price, stock)
VALUES 
('Laptop', 'High-performance laptop', 1200.00, 10),
('Smartphone', 'Latest model smartphone', 800.00, 25),
('Headphones', 'Noise-cancelling headphones', 150.00, 50);

-- Insert data into Order table
INSERT INTO Order (user_id, status, total)
VALUES 
(1, 'pending', 1950.00), 
(1, 'shipped', 150.00);

-- Insert data into OrderItem table
INSERT INTO OrderItem (order_id, product_id, quantity, price)
VALUES 
(1, 1, 1, 1200.00), -- 1 Laptop
(1, 2, 1, 800.00),  -- 1 Smartphone
(2, 3, 1, 150.00);  -- 1 Headphones for a different order
