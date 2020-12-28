/* Activity 1 */
select * 
from exercise;

/* Activity 2 */
select * 
from client;

/* Activity 3 */
select * 
from client 
where client.City = "Metairie";

/* Activity 4 */
select * 
from client 
where client.ClientId = '818u7faf-7b4b-48a2-bf12-7a26c92de20c';

/* Activity 5 */
select count(*) as NumberOfRows 
from goal;

/* Activity 6 */
select workout.Name, workout.levelId 
from workout;

/* Activity 7 */
select workout.Name, workout.LevelId, workout.Notes 
from workout 
where workout.LevelId = 2;

/* Activity 8 */
select client.FirstName, client.LastName, client.City 
from client
where client.City = "Metairie" or client.City = "Kenner" or client.City = "Gretna";

/* Activity 9 */
select client.FirstName, client.LastName, client.BirthDate 
from client
where client.BirthDate between '1980-01-01' and '1989-12-31';

/* Activity 10 */
select client.FirstName, client.LastName, client.BirthDate 
from client
where client.BirthDate >= '1980-01-01' and client.BirthDate <= '1989-12-31';

/* Activity 11 */
select count(*) as NumberOfAddresses
from login
where login.EmailAddress like '%.gov';

/* Activity 12 */
select count(*) as NumberOfAddresses
from login
where login.EmailAddress not like '%.com';

/* Activity 13 */
select client.FirstName, client.LastName
from client
where client.BirthDate is NULL;

/* Activity 14 */
select exercisecategory.Name
from exercisecategory
where exercisecategory.ParentCategoryId is not null;

/* Activity 15 */
select workout.Name, workout.Notes
from workout
where workout.LevelId = 3
and workout.Notes like '%you%';

/* Activity 16 */
select client.FirstName, client.LastName, client.City
from client
where (client.LastName like 'L%' or client.LastName like 'M%' or client.LastName like 'N%')
and client.City = "LaPlace";

/* Activity 17 */
select *
from (
	select invoicelineitem.InvoiceId, invoicelineitem.Description, invoicelineitem.Price, invoicelineitem.Quantity, invoicelineitem.ServiceDate, invoicelineitem.Price*invoicelineitem.Quantity as line_item_total
	from invoicelineitem ) t1
where line_item_total between 15 and 25;

/* Activity 18 */
select login.EmailAddress
from client
inner join login
on client.ClientId = login.ClientId
where client.FirstName = "Estrella" and client.LastName = "Bazely"; 

/* Activity 19 */
select goal.Name
from goal
inner join workoutgoal
on goal.GoalId = workoutgoal.GoalId
inner join workout
on workout.WorkoutId = workoutgoal.WorkoutId
where workout.Name = "This Is Parkour";