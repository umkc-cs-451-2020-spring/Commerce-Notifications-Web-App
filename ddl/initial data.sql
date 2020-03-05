USE CS_451;

CREATE TABLE User(
	UserID INT NOT NULL,
    Password VARCHAR(30) NOT NULL,
    PRIMARY KEY(UserID)
);

CREATE TABLE Transaction(
	TransactionID INT NOT NULL AUTO_INCREMENT,
    AccountNumber INT NOT NULL,
    Description VARCHAR(50) NOT NULL,
    Amount FLOAT NOT NULL,
    State VARCHAR(2) NOT NULL,
    Date DATE NOT NULL,
    TransactionType VARCHAR(2) NOT NULL,
    PRIMARY KEY(TransactionID)
);

CREATE TABLE Account(
	AccountNumber INT NOT NULL AUTO_INCREMENT,
	UserID INT NOT NULL,
    AccountType VARCHAR(1),
    Balance FLOAT NOT NULL,
    PRIMARY KEY(AccountNumber)
);

INSERT INTO Account ( UserID, AccountType, Balance ) VALUES ( 1, "C", 5000.00 );
INSERT INTO Account ( UserID, AccountType, Balance ) VALUES ( 2, "C", 5340.28 );
INSERT INTO Account ( UserID, AccountType, Balance ) VALUES ( 2, "S", 0.00 );

#Inserts for User 1 Checking
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Starbucks', 2.00, 'MO', '2019-11-03', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Payroll', 800.00, 'MO', '2019-11-03', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Chipotle', 8.00, 'MO', '2019-11-03', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'ATM', 10.00, 'MO', '2019-11-04', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Hoolihans', 32.00, 'MO', '2019-11-05', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'KCPL', 100.00, 'MO', '2019-11-05', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Google Fiber', 190.00, 'MO', '2019-11-09', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Netflix', 9.99, 'MO', '2019-11-11', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Rent', 350.00, 'MO', '2019-11-11', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Starbucks', 2.00, 'MO', '2019-11-15', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Payroll', 750.00, 'MO', '2019-11-22', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Commerce Bank Credit Card payment', 620.00, 'MO', '2019-11-25', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'McFaddens', 150.00, 'MO', '2019-11-28', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Price Chopper', 100.00, 'MO', '2019-11-28', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Check from friend', 50.00, 'MO', '2019-11-29', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Payroll', 800.00, 'MO', '2019-12-01', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Hyvee', 9.00, 'MO', '2019-12-01', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'McFaddens', 14.00, 'MO', '2019-12-01', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Target', 32.00, 'MO', '2019-12-01', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'KCPL', 100.00, 'MO', '2019-12-01', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Payroll', 750.00, 'MO', '2019-12-02', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Google Fiber', 190.00, 'MO', '2019-12-03', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Netflix', 9.99, 'MO', '2019-12-03', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Rent', 350.00, 'MO', '2019-12-03', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Neos', 6.50, 'MO', '2019-12-03', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Commerce Bank Credit Card payment', 230.00, 'MO', '2019-12-05', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Best Buy', 100.00, 'MO', '2019-12-06', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Pottery Barn', 300.00, 'MO', '2019-12-07', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'The Loft', 23.00, 'MO', '2019-12-07', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Dave and Busters', 45.00, 'MO', '2019-12-07', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Bowling', 35.00, 'MO', '2019-12-08', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Payroll', 800.00, 'MO', '2019-12-15', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'McFaddens', 210.00, 'MO', '2019-12-20', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Taco Bell', 18.00, 'MO', '2019-12-25', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'QuikTrip', 45.00, 'MO', '2019-12-31', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'KCPL', 130.00, 'MO', '2020-01-01', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Google Fiber', 185.00, 'MO', '2020-01-01', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Netflix', 7.99, 'MO', '2020-01-02', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Price Chopper', 56.00, 'MO', '2020-01-05', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Price Chopper', 43.00, 'MO', '2020-01-06', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Target', 98.00, 'MO', '2020-01-10', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Jose Peppers', 13.00, 'MO', '2020-01-10', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Starbucks', 9.00, 'MO', '2020-01-12', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Rent', 350.00, 'MO', '2020-01-13', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Redbox', 3.50, 'MO', '2020-01-14', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Bank of America Credit Card payment', 301.00, 'MO', '2020-01-15', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Payroll', 730.00, 'MO', '2020-01-16', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Target', 232.68, 'MO', '2020-01-16', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Best Buy', 18.50, 'MO', '2020-01-16', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Nationwide', 120.00, 'MO', '2020-01-16', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'KC Police - Speeding Ticket', 50.00, 'MO', '2020-01-17', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Uber', 50.00, 'MO', '2020-01-18', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Mannys', 9.20, 'MO', '2020-01-18', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Toys R Us', 24.75, 'MO', '2020-01-19', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Scooters', 3.50, 'MO', '2020-01-19', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'QuikTrip', 36.00, 'MO', '2020-01-20', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Price Chopper', 32.00, 'MO', '2020-01-20', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Home Depot', 48.12, 'MO', '2020-01-20', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Burger King', 4.20, 'MO', '2020-01-21', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Jiffy Lube', 45.00, 'MO', '2020-01-22', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Doctor visit', 25.00, 'MO', '2020-01-23', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'CVS', 36.00, 'MO', '2020-01-23', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Price Chopper', 29.00, 'MO', '2020-01-23', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Transfer to Savings', 200.00, 'MO', '2020-01-23', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Christmas Check from Grandma', 150.00, 'MO', '2020-01-24', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Student loans', 250.00, 'MO', '2020-01-25', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Ford Service', 75.00, 'MO', '2020-01-25', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Hallmark', 36.00, 'MO', '2020-01-26', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'CVS', 22.00, 'MO', '2020-01-27', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Payroll', 810.00, 'MO', '2020-01-28', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Pottery Barn', 180.00, 'MO', '2020-01-29', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Cheesecake Factory', 46.00, 'MO', '2020-01-30', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (1, 'Starbucks', 8.00, 'MO', '2020-01-30', 'DR' );

#Inserts for User 2 Checking
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Verizon', 200.00, 'MO', '2016-11-02', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Panda Express', 18.24, 'MO', '2016-11-02', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'CVS', 64.03, 'MO', '2016-11-02', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Maurices', 122.08, 'MO', '2016-11-02', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'QuikTrip', 26.11, 'MO', '2016-11-02', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'QuikTrip', 24.69, 'MO', '2016-11-04', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'KFC', 14.47, 'MO', '2016-11-07', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Car wash', 9.00, 'MO', '2016-11-07', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Dollar General', 38.08, 'MO', '2016-11-07', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Price Chopper', 75.00, 'MO', '2016-11-07', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Bank of America Credit Card Payment', 85.25, 'MO', '2016-11-08', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Doctor', 125.00, 'MO', '2016-11-09', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'QuikTrip', 35.80, 'MO', '2016-11-09', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Red Robin', 24.40, 'MO', '2016-11-09', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Doctor', 45.00, 'MO', '2016-11-14', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Starbucks', 10.65, 'MO', '2016-11-14', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Payroll', 2000.00, 'MO', '2016-11-15', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'AT&T', 139.72, 'MO', '2016-11-15', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Transfer to Savings', 200.00, 'MO', '2016-11-16', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Transfer to another bank', 200.00, 'MO', '2016-11-16', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Best Buy', 25.00, 'MO', '2016-11-16', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Target', 25.00, 'MO', '2016-11-16', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Walmart', 25.00, 'MO', '2016-11-16', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Amazon', 25.00, 'MO', '2016-11-16', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'KCPL', 100.00, 'MO', '2016-11-16', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Bristol', 23.55, 'MO', '2016-11-17', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'CVS', 80.00, 'MO', '2016-11-18', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Rent', 300.00, 'MO', '2016-11-18', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Airline ticket', 125.00, 'MO', '2016-11-18', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Maurices', 97.69, 'MO', '2016-11-18', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Price Chopper', 41.04, 'MO', '2016-11-21', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Home Depot', 86.00, 'MO', '2016-11-21', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Bristol', 63.55, 'MO', '2016-11-21', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Nebraska Furniture Mart', 494.08, 'MO', '2016-11-21', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'State Farm', 328.43, 'MO', '2016-11-21', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Walmart', 164.21, 'MO', '2016-11-22', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Doctor', 100.00, 'MO', '2016-11-23', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Walmart', 32.23, 'MO', '2016-11-23', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'ATM', 30.00, 'MO', '2016-11-25', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'QuikTrip', 21.52, 'MO', '2016-11-25', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Price Chopper', 72.21, 'MO', '2016-11-28', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Hobby Lobby', 88.25, 'MO', '2016-11-28', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Walmart', 42.51, 'MO', '2016-11-28', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Transfer to Savings', 100.00, 'MO', '2016-11-29', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Check to sister', 100.00, 'MO', '2016-11-29', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Brew Top', 36.00, 'MO', '2016-11-29', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Payroll', 2000.00, 'MO', '2016-11-30', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Transfer to Savings', 300.00, 'MO', '2016-11-30', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Verizon', 157.99, 'MO', '2016-11-30', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'AT&T', 100.00, 'MO', '2016-11-30', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'KCPL', 100.00, 'MO', '2016-11-30', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Starbucks', 4.00, 'MO', '2016-11-30', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Walmart', 80.68, 'MO', '2016-12-01', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Check from grandma', 600.00, 'MO', '2016-12-02', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Transfer to Savings', 100.00, 'MO', '2016-12-02', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Petsmart', 138.30, 'MO', '2016-12-02', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'ATM', 40.00, 'MO', '2016-12-02', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Luckys', 110.00, 'MO', '2016-12-05', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Dennys  ', 24.53, 'MO', '2016-12-05', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'ATM', 150.00, 'MO', '2016-12-06', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'QuikTrip', 19.27, 'MO', '2016-12-07', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Starbucks', 13.90, 'MO', '2016-12-09', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Sears', 55.45, 'MO', '2016-12-09', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Transfer to Savings', 50.00, 'MO', '2016-12-12', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Jiffy Lube', 20.78, 'MO', '2016-12-12', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'OCharleys', 57.65, 'MO', '2016-12-12', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Famous Footwear', 145.73, 'MO', '2016-12-12', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Target', 86.67, 'MO', '2016-12-12', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Pizza Hut ', 48.00, 'MO', '2016-12-12', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Walmart', 191.86, 'MO', '2016-12-12', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'QuikTrip', 22.78, 'MO', '2016-12-13', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Payday', 2000.00, 'MO', '2016-12-15', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Bonus', 1500.00, 'MO', '2016-12-15', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Transfer to Savings', 300.00, 'MO', '2016-12-16', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Best Buy', 25.00, 'MO', '2016-12-16', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Target', 25.00, 'MO', '2016-12-16', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Walmart', 25.00, 'MO', '2016-12-16', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'CVS', 25.00, 'MO', '2016-12-16', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'ATM', 200.00, 'MO', '2016-12-16', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Amazon', 150.00, 'MO', '2016-12-16', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Verizon', 142.87, 'MO', '2016-12-16', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Toys R Us', 133.35, 'MO', '2016-12-16', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Maurices', 100.00, 'MO', '2016-12-16', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Panera Bread', 13.98, 'MO', '2016-12-19', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Buffalo Wild Wings', 57.00, 'MO', '2016-12-19', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Walmart', 205.47, 'MO', '2016-12-19', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Walmart', 156.27, 'MO', '2016-12-19', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Joy Wok', 10.84, 'MO', '2016-12-20', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Taxes', 125.06, 'MO', '2016-12-21', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Doctor', 30.00, 'MO', '2016-12-21', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'State Farm', 328.43, 'MO', '2016-12-21', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Rent', 350.00, 'MO', '2016-12-23', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'KCPL', 159.00, 'MO', '2016-12-23', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, '7 Eleven', 24.52, 'MO', '2016-12-27', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Hyvee', 27.77, 'MO', '2016-12-27', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Price Chopper', 128.56, 'MO', '2016-12-29', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'ATM', 150.00, 'MO', '2016-12-29', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Payday', 2000.00, 'MO', '2016-12-30', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Red box', 2.95, 'MO', '2016-12-30', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Walmart', 41.18, 'MO', '2016-12-30', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Walmart', 109.35, 'MO', '2016-12-30', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'BoA Credit Card payment', 217.00, 'MO', '2016-12-30', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Transfer to Savings', 100.00, 'MO', '2016-12-30', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Maurices', 5.95, 'MO', '2016-12-30', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'ATM', 40.00, 'MO', '2017-01-03', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Dave and Busters', 70.00, 'MO', '2017-01-03', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Pizza Ranch', 47.06, 'MO', '2017-01-03', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Walmart', 163.10, 'MO', '2017-01-03', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Olive Garden', 22.01, 'MO', '2017-01-04', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'QuikTrip', 34.86, 'MO', '2017-01-04', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Check to sister', 150.00, 'MO', '2017-01-05', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Doctor', 10.00, 'MO', '2017-01-05', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'MOD Pizza', 10.00, 'MO', '2017-01-05', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Best Buy', 10.00, 'MO', '2017-01-05', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Target', 10.00, 'MO', '2017-01-05', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'OReillys', 23.52, 'MO', '2017-01-09', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Walmart', 118.25, 'MO', '2017-01-09', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'QuikTrip', 25.00, 'MO', '2017-01-12', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Walmart', 45.74, 'MO', '2017-01-12', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Payroll', 2000.00, 'MO', '2017-01-13', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Transfer to Savings', 50.00, 'MO', '2017-01-13', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Verizon', 136.89, 'MO', '2017-01-13', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Transfer to Savings', 100.00, 'MO', '2017-01-17', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Bravos', 25.00, 'MO', '2017-01-17', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Starbucks gift card', 25.00, 'MO', '2017-01-17', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'ATM', 25.00, 'MO', '2017-01-17', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Check to brother', 25.00, 'MO', '2017-01-17', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Laser Rock', 24.22, 'MO', '2017-01-17', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Walmart', 102.87, 'MO', '2017-01-17', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Tanners', 57.32, 'MO', '2017-01-17', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Price Chopper', 36.00, 'MO', '2017-01-17', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Bristol', 54.00, 'MO', '2017-01-18', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'State Farm', 328.43, 'MO', '2017-01-19', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Payment to friend', 5.00, 'MO', '2017-01-19', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'QuikTrip', 26.49, 'MO', '2017-01-20', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'KFC', 5.00, 'MO', '2017-01-23', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Doctor', 55.00, 'MO', '2017-01-23', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Best Buy', 172.25, 'MO', '2017-01-23', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Pizza Hut ', 52.00, 'MO', '2017-01-23', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Red Lobster', 60.38, 'MO', '2017-01-23', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'QuikTrip', 58.55, 'MO', '2017-01-23', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Walmart', 72.52, 'MO', '2017-01-25', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Home Depot', 64.00, 'MO', '2017-01-26', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Payday', 2000.00, 'MO', '2017-01-27', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Transfer to Savings', 150.00, 'MO', '2017-01-27', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Check from mom', 200.00, 'MO', '2017-01-27', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Cash deposit', 75.00, 'MO', '2017-01-27', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'QuikTrip', 29.10, 'MO', '2017-01-27', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Transfer to Savings', 100.00, 'MO', '2017-01-27', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (2, 'Nebraska Furniture Mart', 150.00, 'MO', '2017-01-27', 'DR' );

#Inserts for User 2 Savings
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (3, 'Cash Deposit', 25.00, 'MO', '2016-11-01', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (3, 'Transfer from savings', 200.00, 'MO', '2016-11-16', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (3, 'Cash Deposit', 25.00, 'MO', '2016-11-16', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (3, 'Transfer from savings', 100.00, 'MO', '2016-11-29', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (3, 'Transfer from savings', 300.00, 'MO', '2016-11-30', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (3, 'Interest', 0.02, 'MO', '2016-11-30', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (3, 'Transfer from savings', 100.00, 'MO', '2016-12-02', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (3, 'Transfer from savings', 50.00, 'MO', '2016-12-12', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (3, 'Transfer from savings', 300.00, 'MO', '2016-12-16', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (3, 'Transfer from savings', 100.00, 'MO', '2016-12-30', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (3, 'Interest', 0.02, 'MO', '2016-12-30', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (3, 'OReillys', -379.00, 'MO', '2016-12-31', 'DR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (3, 'Check deposit', 10.00, 'MO', '2017-01-05', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (3, 'Transfer from savings', 50.00, 'MO', '2017-01-13', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (3, 'Transfer from savings', 100.00, 'MO', '2017-01-17', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (3, 'Transfer from savings', 150.00, 'MO', '2017-01-27', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (3, 'Interest', 0.02, 'MO', '2017-01-27', 'CR' );
INSERT INTO Transaction( AccountNumber, Description, Amount, State, Date, TransactionType ) VALUES (3, 'Transfer from savings', 100.00, 'MO', '2017-01-27', 'CR' );
