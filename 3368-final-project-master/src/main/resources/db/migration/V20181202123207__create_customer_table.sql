CREATE TABLE public.customer
(
    customer_id serial PRIMARY KEY not null ,
    cust_first_name varchar(30),
    cust_last_name varchar(30),
    cust_email varchar(50),
    cust_address varchar(50),
    cust_phone_number varchar(12)
);
