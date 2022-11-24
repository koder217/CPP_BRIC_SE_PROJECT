
CREATE SEQUENCE appointments_id_seq;

CREATE TABLE Appointments (
                id INTEGER NOT NULL DEFAULT nextval('appointments_id_seq'),
                StartTime TIMESTAMP NOT NULL,
                EndTime TIMESTAMP NOT NULL,
                ActivityId INTEGER NOT NULL,
                CustomerId INTEGER NOT NULL,
                status VARCHAR,
                CONSTRAINT appointments_pk PRIMARY KEY (id)
);


ALTER SEQUENCE appointments_id_seq OWNED BY Appointments.id;

CREATE SEQUENCE activities_id_seq;

CREATE TABLE Activities (
                id INTEGER NOT NULL DEFAULT nextval('activities_id_seq'),
                Name VARCHAR NOT NULL,
                Price DOUBLE PRECISION NOT NULL,
                CONSTRAINT activities_pk PRIMARY KEY (id)
);


ALTER SEQUENCE activities_id_seq OWNED BY Activities.id;

CREATE SEQUENCE historicalprice_id_seq;

CREATE TABLE HistoricalPrice (
                id INTEGER NOT NULL DEFAULT nextval('historicalprice_id_seq'),
                Date DATE NOT NULL,
                Price DOUBLE PRECISION NOT NULL,
                ActivityId INTEGER NOT NULL,
                CONSTRAINT historicalprice_pk PRIMARY KEY (id)
);


ALTER SEQUENCE historicalprice_id_seq OWNED BY HistoricalPrice.id;

CREATE SEQUENCE discountscheme_id_seq;

CREATE TABLE DiscountScheme (
                id INTEGER NOT NULL DEFAULT nextval('discountscheme_id_seq'),
                PriceDiscount DOUBLE PRECISION,
                PercentDiscount DOUBLE PRECISION,
                CustomerType VARCHAR,
                StartDate DATE,
                EndDate DATE,
                CONSTRAINT discountscheme_pk PRIMARY KEY (id)
);


ALTER SEQUENCE discountscheme_id_seq OWNED BY DiscountScheme.id;

CREATE SEQUENCE addresses_id_seq;

CREATE TABLE Addresses (
                id INTEGER NOT NULL DEFAULT nextval('addresses_id_seq'),
                Street VARCHAR,
                Number VARCHAR,
                ZipCode INTEGER,
                City VARCHAR,
                State VARCHAR,
                CONSTRAINT addresses_pk PRIMARY KEY (id)
);


ALTER SEQUENCE addresses_id_seq OWNED BY Addresses.id;

CREATE SEQUENCE customers_id_seq;

CREATE TABLE Customers (
                id INTEGER NOT NULL DEFAULT nextval('customers_id_seq'),
                FirstName VARCHAR NOT NULL,
                LastName VARCHAR,
                DateOfBirth DATE,
                Phone VARCHAR,
                AddressId INTEGER NOT NULL,
                CONSTRAINT customers_pk PRIMARY KEY (id)
);


ALTER SEQUENCE customers_id_seq OWNED BY Customers.id;

CREATE SEQUENCE orders_id_seq;

CREATE TABLE Orders (
                id INTEGER NOT NULL DEFAULT nextval('orders_id_seq'),
                Date DATE NOT NULL,
                Time TIME NOT NULL,
                CustomerId INTEGER NOT NULL,
                DiscountApplied DOUBLE PRECISION NOT NULL,
                TotalPrice VARCHAR NOT NULL,
                DiscountSchemeId INTEGER NOT NULL,
                CONSTRAINT orders_pk PRIMARY KEY (id)
);


ALTER SEQUENCE orders_id_seq OWNED BY Orders.id;

CREATE SEQUENCE lineitems_id_seq;

CREATE TABLE LineItems (
                id INTEGER NOT NULL DEFAULT nextval('lineitems_id_seq'),
                ActivityId INTEGER NOT NULL,
                Quantity INTEGER NOT NULL,
                AppointmentId INTEGER NOT NULL,
                OrderId INTEGER NOT NULL,
                CONSTRAINT lineitems_pk PRIMARY KEY (id)
);


ALTER SEQUENCE lineitems_id_seq OWNED BY LineItems.id;

CREATE SEQUENCE students_id_seq;

CREATE TABLE Students (
                id INTEGER NOT NULL DEFAULT nextval('students_id_seq'),
                EnterDate DATE NOT NULL,
                Major VARCHAR NOT NULL,
                Minor VARCHAR NOT NULL,
                GradDate DATE NOT NULL,
                CONSTRAINT students_pk PRIMARY KEY (id)
);


ALTER SEQUENCE students_id_seq OWNED BY Students.id;

CREATE SEQUENCE professors_id_seq;

CREATE TABLE Professors (
                id INTEGER NOT NULL DEFAULT nextval('professors_id_seq'),
                Department VARCHAR NOT NULL,
                Office VARCHAR NOT NULL,
                Research VARCHAR NOT NULL,
                CONSTRAINT professors_pk PRIMARY KEY (id)
);


ALTER SEQUENCE professors_id_seq OWNED BY Professors.id;

ALTER TABLE LineItems ADD CONSTRAINT appointments_lineitems_fk
FOREIGN KEY (AppointmentId)
REFERENCES Appointments (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE HistoricalPrice ADD CONSTRAINT activities_historicalprice_fk
FOREIGN KEY (ActivityId)
REFERENCES Activities (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE LineItems ADD CONSTRAINT activities_lineitems_fk
FOREIGN KEY (ActivityId)
REFERENCES Activities (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Orders ADD CONSTRAINT discountscheme_orders_fk
FOREIGN KEY (DiscountSchemeId)
REFERENCES DiscountScheme (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Customers ADD CONSTRAINT addresses_customers_fk
FOREIGN KEY (AddressId)
REFERENCES Addresses (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Orders ADD CONSTRAINT customers_orders_fk
FOREIGN KEY (CustomerId)
REFERENCES Customers (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Students ADD CONSTRAINT customers_students_fk
FOREIGN KEY (id)
REFERENCES Customers (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Professors ADD CONSTRAINT customers_professors_fk
FOREIGN KEY (id)
REFERENCES Customers (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE LineItems ADD CONSTRAINT orders_lineitems_fk
FOREIGN KEY (OrderId)
REFERENCES Orders (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;