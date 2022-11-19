
CREATE SEQUENCE brcm.appointments_id_seq;

CREATE TABLE brcm.Appointments (
                id INTEGER NOT NULL DEFAULT nextval('brcm.appointments_id_seq'),
                StartTime TIMESTAMP NOT NULL,
                EndTime TIMESTAMP NOT NULL,
                ActivityId INTEGER NOT NULL,
                CustomerId INTEGER NOT NULL,
                CONSTRAINT appointments_pk PRIMARY KEY (id)
);


ALTER SEQUENCE brcm.appointments_id_seq OWNED BY brcm.Appointments.id;

CREATE TABLE brcm.Activities (
                id INTEGER NOT NULL,
                Name VARCHAR NOT NULL,
                Price DOUBLE PRECISION NOT NULL,
                CONSTRAINT activities_pk PRIMARY KEY (id)
);


CREATE TABLE brcm.HistoricalPrice (
                id INTEGER NOT NULL,
                Date DATE NOT NULL,
                Price DOUBLE PRECISION NOT NULL,
                ActivityId INTEGER NOT NULL,
                CONSTRAINT historicalprice_pk PRIMARY KEY (id)
);


CREATE TABLE brcm.DiscountScheme (
                id INTEGER NOT NULL,
                PriceDiscount DOUBLE PRECISION NOT NULL,
                PercentDiscount DOUBLE PRECISION NOT NULL,
                CustomerType VARCHAR NOT NULL,
                StartDate DATE NOT NULL,
                EndDate DATE NOT NULL,
                CONSTRAINT discountscheme_pk PRIMARY KEY (id)
);


CREATE SEQUENCE brcm.addresses_id_seq;

CREATE TABLE brcm.Addresses (
                id INTEGER NOT NULL DEFAULT nextval('brcm.addresses_id_seq'),
                Street VARCHAR NOT NULL,
                Number VARCHAR NOT NULL,
                ZipCode INTEGER NOT NULL,
                City VARCHAR NOT NULL,
                State VARCHAR NOT NULL,
                CONSTRAINT addresses_pk PRIMARY KEY (id)
);


ALTER SEQUENCE brcm.addresses_id_seq OWNED BY brcm.Addresses.id;

CREATE TABLE brcm.Customers (
                id INTEGER NOT NULL,
                FirstName VARCHAR NOT NULL,
                LastName VARCHAR NOT NULL,
                DateOfBirth DATE NOT NULL,
                Phone VARCHAR NOT NULL,
                AddressId INTEGER NOT NULL,
                CONSTRAINT customers_pk PRIMARY KEY (id)
);


CREATE TABLE brcm.Orders (
                id INTEGER NOT NULL,
                Date DATE NOT NULL,
                Time TIME NOT NULL,
                CustomerId INTEGER NOT NULL,
                DiscountApplied DOUBLE PRECISION NOT NULL,
                TotalPrice VARCHAR NOT NULL,
                DiscountSchemeId INTEGER NOT NULL,
                CONSTRAINT orders_pk PRIMARY KEY (id)
);


CREATE TABLE brcm.LineItems (
                id INTEGER NOT NULL,
                ActivityId INTEGER NOT NULL,
                Quantity INTEGER NOT NULL,
                AppointmentId INTEGER NOT NULL,
                OrderId INTEGER NOT NULL,
                CONSTRAINT lineitems_pk PRIMARY KEY (id)
);


CREATE TABLE brcm.Students (
                id INTEGER NOT NULL,
                EnterDate DATE NOT NULL,
                Major VARCHAR NOT NULL,
                Minor VARCHAR NOT NULL,
                GradDate DATE NOT NULL,
                CONSTRAINT students_pk PRIMARY KEY (id)
);


CREATE TABLE brcm.Professors (
                id INTEGER NOT NULL,
                Department VARCHAR NOT NULL,
                Office VARCHAR NOT NULL,
                Research VARCHAR NOT NULL,
                CONSTRAINT professors_pk PRIMARY KEY (id)
);


ALTER TABLE brcm.LineItems ADD CONSTRAINT appointments_lineitems_fk
FOREIGN KEY (AppointmentId)
REFERENCES brcm.Appointments (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE brcm.HistoricalPrice ADD CONSTRAINT activities_historicalprice_fk
FOREIGN KEY (ActivityId)
REFERENCES brcm.Activities (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE brcm.LineItems ADD CONSTRAINT activities_lineitems_fk
FOREIGN KEY (ActivityId)
REFERENCES brcm.Activities (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE brcm.Orders ADD CONSTRAINT discountscheme_orders_fk
FOREIGN KEY (DiscountSchemeId)
REFERENCES brcm.DiscountScheme (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE brcm.Customers ADD CONSTRAINT addresses_customers_fk
FOREIGN KEY (AddressId)
REFERENCES brcm.Addresses (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE brcm.Orders ADD CONSTRAINT customers_orders_fk
FOREIGN KEY (CustomerId)
REFERENCES brcm.Customers (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE brcm.Students ADD CONSTRAINT customers_students_fk
FOREIGN KEY (id)
REFERENCES brcm.Customers (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE brcm.Professors ADD CONSTRAINT customers_professors_fk
FOREIGN KEY (id)
REFERENCES brcm.Customers (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE brcm.LineItems ADD CONSTRAINT orders_lineitems_fk
FOREIGN KEY (OrderId)
REFERENCES brcm.Orders (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;