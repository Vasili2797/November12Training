-- 1. Get 10 cities in descending alphabetical order. This Works
select * from sakila.city
order by city desc limit 10;

-- 2. Get all films with "airplane" in the title. This works
select * from sakila.film
where title LIKE "%airplane%";

-- 3. Get the highest payment amount. This works
select max(amount) from sakila.payment;

-- 4. Get the number of records in the customer table for store id #1. This works
Select count(*) from sakila.customer where store_id = '1';

-- 5. Get all payment records for customer with email address "NANCY.THOMAS@sakilacustomer.org" this works
select * from sakila.customer where email="NANCY.THOMAS@sakilacustomer.org";

-- 6. Use a View to get the film info for actor Bob Fawcett. this works
create view film_view AS 

select sakila.actor.first_name, sakila.actor.last_name, sakila.film.* from sakila.actor INNER JOIN sakila.film_actor
 on sakila.actor.actor_id = sakila.film_actor.actor_id INNER JOIN sakila.film
 on film.film_id=film_actor.film_id WHERE first_name="Bob" and last_name="Fawcett";

select * from film_view;

-- 7. Use a Stored Procedure to get the 4 inventory ids for the film "Alien Center" at Store #2. 
-- film_id=15, store_id =2, film_count=1
USE sakila;
Select film_id from sakila.film where title="Alien Center";

CALL `sakila`.`film_in_stock`((Select film_id from sakila.film where title="Alien Center"), 2, @_count);
select @_count;
select * from sakila.store;
select * from sakila.staff;
-- 8. Insert a new store. Ensure that you use TRANSACTION. (This one is possible but it's tough! Pay attention to constraints and the order that you are inserting data.)
-- use sakila;
Start Transaction;
Select store_id, manager_staff_id, address_id from sakila.store;

-- update sakila.store as SKST;
insert into sakila.staff(staff_id, first_name, last_name, address_id, picture,
 email, store_id, active, username, password, last_update)values('3', 'Bob', 'Builder', '5', NULL,
 'Bob.Builder@sakilastaff.com', 2, '1', 'Bob', 'newPassword', STR_TO_DATE('10-17-2021 15:40:10', '%m-%d-%Y %H:%i:%s'));
insert into sakila.store(store_id, manager_staff_id, address_id)values(3, 3, 3);
update staff set store_id=3 where staff_id=3;
-- commit;
rollback;

-- 9. Update the timestamp to the current date/time for the new store you entered in the previous question. 
-- last_update STR_TO_DATE("10-17-2021 15:40:10", "%m-%d-%Y %H:%i:%s"));
update store set last_update = now() where store_id=3;

-- 10. Delete the new store.
update staff set store_id=2 where staff_id=3;
DELETE from store where store_id=3;
select * from sakila.store;

-- 11. Using one SQL statement, get how many films are there in each rating category. This works
select rating, count(*) from sakila.film group by rating order by rating; 

-- 12. Get (in order) the first and last names of the 3 customers who have spent the most, along with how much they have paid overall.
select customer.first_name, customer.last_name, SUM(amount) as Total_Amount
FROM customer inner join payment on customer.customer_id=payment.customer_id group by customer.customer_id
order by Total_Amount desc limit 3;

-- 13. Get all movies rented by the customer who spent the most. (Hint: This will either require nested queries, or more than two joins. one approach is much shorter than the other.)
select most_paying_customers.*, film.* from (select customer.first_name, customer.last_name, customer.customer_id, SUM(amount) as Total_Amount
FROM customer inner join payment on customer.customer_id=payment.customer_id group by customer.customer_id
order by Total_Amount desc limit 3) as most_paying_customers join rental on rental.customer_id=most_paying_customers.customer_id
join inventory on inventory.inventory_id=rental.inventory_id join film on film.film_id = inventory.film_id;

-- 14. Get the first and last names of all customers who spent more than $150, along with how much they spent.
select customer.first_name, customer.last_name, SUM(amount) as Total_Amount
FROM customer inner join payment on customer.customer_id=payment.customer_id group by customer.customer_id  having SUM(amount)>150
order by Total_Amount desc;