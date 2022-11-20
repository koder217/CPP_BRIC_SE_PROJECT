
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

CREATE TABLE Activities (
                id INTEGER NOT NULL,
                Name VARCHAR NOT NULL,
                Price DOUBLE PRECISION NOT NULL,
                CONSTRAINT activities_pk PRIMARY KEY (id)
);


CREATE TABLE HistoricalPrice (
                id INTEGER NOT NULL,
                Date DATE NOT NULL,
                Price DOUBLE PRECISION NOT NULL,
                ActivityId INTEGER NOT NULL,
                CONSTRAINT historicalprice_pk PRIMARY KEY (id)
);


CREATE TABLE DiscountScheme (
                id INTEGER NOT NULL,
                PriceDiscount DOUBLE PRECISION,
                PercentDiscount DOUBLE PRECISION,
                CustomerType VARCHAR,
                StartDate DATE,
                EndDate DATE,
                CONSTRAINT discountscheme_pk PRIMARY KEY (id)
);


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

CREATE TABLE Customers (
                id INTEGER NOT NULL,
                FirstName VARCHAR NOT NULL,
                LastName VARCHAR,
                DateOfBirth DATE,
                Phone VARCHAR,
                AddressId INTEGER NOT NULL,
                CONSTRAINT customers_pk PRIMARY KEY (id)
);


CREATE TABLE Orders (
                id INTEGER NOT NULL,
                Date DATE NOT NULL,
                Time TIME NOT NULL,
                CustomerId INTEGER NOT NULL,
                DiscountApplied DOUBLE PRECISION NOT NULL,
                TotalPrice VARCHAR NOT NULL,
                DiscountSchemeId INTEGER NOT NULL,
                CONSTRAINT orders_pk PRIMARY KEY (id)
);


CREATE TABLE LineItems (
                id INTEGER NOT NULL,
                ActivityId INTEGER NOT NULL,
                Quantity INTEGER NOT NULL,
                AppointmentId INTEGER NOT NULL,
                OrderId INTEGER NOT NULL,
                CONSTRAINT lineitems_pk PRIMARY KEY (id)
);


CREATE TABLE Students (
                id INTEGER NOT NULL,
                EnterDate DATE NOT NULL,
                Major VARCHAR NOT NULL,
                Minor VARCHAR NOT NULL,
                GradDate DATE NOT NULL,
                CONSTRAINT students_pk PRIMARY KEY (id)
);


CREATE TABLE Professors (
                id INTEGER NOT NULL,
                Department VARCHAR NOT NULL,
                Office VARCHAR NOT NULL,
                Research VARCHAR NOT NULL,
                CONSTRAINT professors_pk PRIMARY KEY (id)
);


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