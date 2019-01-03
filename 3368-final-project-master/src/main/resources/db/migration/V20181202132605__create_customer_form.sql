CREATE TABLE public.customerss
(
    customer_id serial PRIMARY KEY not null ,
    cust_first_name varchar(30),
    cust_last_name varchar(30),
    cust_email varchar(50),
    cust_address varchar(50),
    cust_status varchar (15),
    cust_price integer,
    cust_phone_number varchar(12),
    cust_description varchar(150)

);
