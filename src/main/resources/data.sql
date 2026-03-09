INSERT INTO USERS (user_name, user_email, user_password, user_role, is_active)
VALUES 
('John', 'john@example.com', 'pass123', 'CUSTOMER', true),
('Alice', 'alice@example.com', 'pass123', 'CUSTOMER', true),
('Bob', 'bob@example.com', 'pass123', 'CUSTOMER', true),
('Admin', 'admin@example.com', 'admin123', 'ADMIN', true),
('David', 'david@example.com', 'pass123', 'CUSTOMER', true);

INSERT INTO PRODUCT (product_name, product_description, product_price, stock_quentity, is_active)
VALUES
('Laptop', 'Gaming Laptop', 800.0, 10, true),
('Mouse', 'Wireless Mouse', 20.0, 100, true),
('Keyboard', 'Mechanical Keyboard', 40.0, 50, true),
('Monitor', '24 Inch Monitor', 150.0, 30, true),
('Headphones', 'Noise Cancelling', 60.0, 60, true),
('Tablet', 'Android Tablet', 300.0, 20, true),
('Phone', 'Smart Phone', 500.0, 40, true),
('Charger', 'Fast Charger', 25.0, 200, true),
('Camera', 'DSLR Camera', 450.0, 15, true),
('Speaker', 'Bluetooth Speaker', 70.0, 70, true),
('SSD', '1TB SSD', 120.0, 25, true),
('RAM', '16GB RAM', 80.0, 80, true),
('GPU', 'Graphics Card', 600.0, 12, true),
('CPU', 'Processor', 400.0, 18, true),
('Printer', 'Laser Printer', 200.0, 22, true),
('Router', 'WiFi Router', 90.0, 33, true),
('SmartWatch', 'Fitness Watch', 150.0, 45, true),
('PowerBank', '10000mAh PowerBank', 35.0, 90, true),
('Microphone', 'Studio Mic', 110.0, 55, true),
('Webcam', 'HD Webcam', 85.0, 65, true);

INSERT INTO INVENTORY_EVENT (order_id, event_type, quantity, product_id)
VALUES
(1, 'STOCK_ADDED', 10, 1),
(2, 'STOCK_ADDED', 20, 2),
(3, 'STOCK_ADDED', 15, 3),
(4, 'STOCK_ADDED', 30, 4),
(5, 'STOCK_ADDED', 12, 5),
(6, 'STOCK_ADDED', 18, 6),
(7, 'STOCK_ADDED', 22, 7),
(8, 'STOCK_ADDED', 40, 8),
(9, 'STOCK_ADDED', 14, 9),
(10, 'STOCK_ADDED', 35, 10),
(11, 'STOCK_ADDED', 16, 11),
(12, 'STOCK_ADDED', 28, 12),
(13, 'STOCK_ADDED', 11, 13),
(14, 'STOCK_ADDED', 19, 14),
(15, 'STOCK_ADDED', 23, 15),
(16, 'STOCK_ADDED', 17, 16),
(17, 'STOCK_ADDED', 26, 17),
(18, 'STOCK_ADDED', 32, 18),
(19, 'STOCK_ADDED', 21, 19),
(20, 'STOCK_ADDED', 29, 20);