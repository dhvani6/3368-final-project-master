CREATE TABLE public.inventory
(
  inv_id serial PRIMARY KEY not null,
  inv_name varchar (20),
  inv_price integer
)