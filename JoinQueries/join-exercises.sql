USE PersonalTrainer;

-- Select all columns from ExerciseCategory and Exercise.
-- The tables should be joined on ExerciseCategoryId.
-- This query returns all Exercises and their associated ExerciseCategory.
-- 64 rows

select *
from ExerciseCategory
inner join Exercise
on ExerciseCategory.ExerciseCategoryId = Exercise.ExerciseCategoryId;
-- ------------------
    
-- Select ExerciseCategory.Name and Exercise.Name
-- where the ExerciseCategory does not have a ParentCategoryId (it is null).
-- Again, join the tables on their shared key (ExerciseCategoryId).
-- 9 rows

select ExerciseCategory.Name, Exercise.Name
from ExerciseCategory
inner join Exercise
on ExerciseCategory.ExerciseCategoryId = Exercise.ExerciseCategoryId
where ExerciseCategory.ParentCategoryId is NULL;
-- ------------------

-- The query above is a little confusing. At first glance, it's hard to tell
-- which Name belongs to ExerciseCategory and which belongs to Exercise.
-- Rewrite the query using an aliases. 
-- Alias ExerciseCategory.Name as 'CategoryName'.
-- Alias Exercise.Name as 'ExerciseName'.
-- 9 rows

select ExerciseCategory.Name as CategoryName, Exercise.Name as ExerciseName
from ExerciseCategory
inner join Exercise
on ExerciseCategory.ExerciseCategoryId = Exercise.ExerciseCategoryId
where ExerciseCategory.ParentCategoryId is NULL;
-- ------------------

-- Select FirstName, LastName, and BirthDate from Client
-- and EmailAddress from Login 
-- where Client.BirthDate is in the 1990s.
-- Join the tables by their key relationship. 
-- What is the primary-foreign key relationship?
-- 35 rows

select client.FirstName, client.LastName, client.BirthDate, Login.EmailAddress
from Client
inner join Login
on Client.ClientId = Login.ClientId
where Client.BirthDate between "1990-01-01" and "1999-12-31";
-- ------------------

-- Select Workout.Name, Client.FirstName, and Client.LastName
-- for Clients with LastNames starting with 'C'?
-- How are Clients and Workouts related?
-- 25 rows

select Workout.Name, Client.FirstName, Client.LastName
from client
inner join ClientWorkout on client.ClientId = ClientWorkout.ClientId
inner join Workout on Workout.WorkoutId = ClientWorkout.WorkoutId
where Client.LastName like 'C%';
-- ------------------

-- Select Names from Workouts and their Goals.
-- This is a many-to-many relationship with a bridge table.
-- Use aliases appropriately to avoid ambiguous columns in the result.

select Workout.Name as WorkoutName, Goal.Name as GoalName
from Workout
inner join WorkoutGoal on Workout.WorkoutId = WorkoutGoal.WorkoutId
inner join Goal on Goal.GoalId = WorkoutGoal.GoalId;
-- ------------------

-- Select FirstName and LastName from Client.
-- Select ClientId and EmailAddress from Login.
-- Join the tables, but make Login optional.
-- 500 rows

select Client.FirstName, Client.LastName, Login.ClientId, Login.EmailAddress
from Client
left join Login on Client.ClientId = Login.ClientId;
-- ------------------

-- Using the query above as a foundation, select Clients
-- who do _not_ have a Login.
-- 200 rows

select Client.FirstName, Client.LastName, Login.ClientId, Login.EmailAddress
from Client
left join Login on Client.ClientId = Login.ClientId
where Login.ClientId is NULL;
-- ------------------

-- Does the Client, Romeo Seaward, have a Login?
-- Decide using a single query.
-- nope :(

select Client.FirstName, Client.LastName, Login.ClientId, Login.EmailAddress
from Client
left join Login on Client.ClientId = Login.ClientId
where Client.FirstName = "Romeo" and Client.LastName = "Seaward";
-- ------------------

-- Select ExerciseCategory.Name and its parent ExerciseCategory's Name.
-- This requires a self-join.
-- 12 rows

select parent.Name as ParentName, child.Name as ChildName
from  ExerciseCategory parent
inner join ExerciseCategory child on parent.ExerciseCategoryId = child.ParentCategoryId;
-- ------------------
    
-- Rewrite the query above so that every ExerciseCategory.Name is
-- included, even if it doesn't have a parent.
-- 16 rows

select parent.Name as ParentName, child.Name as ChildName
from  ExerciseCategory parent
right join ExerciseCategory child on parent.ExerciseCategoryId = child.ParentCategoryId;
-- ------------------
    
-- Are there Clients who are not signed up for a Workout?
-- 50 rows

select client.FirstName, client.LastName
from client
left join ClientWorkout on ClientWorkout.ClientId = client.ClientId
where ClientWorkout.ClientId is null;
-- ------------------

-- Which Beginner-Level Workouts satisfy at least one of Shell Creane's Goals?
-- Goals are associated to Clients through ClientGoal.
-- Goals are associated to Workouts through WorkoutGoal.
-- 6 rows, 4 unique rows

select Workout.Name, Level.Name
from Client
inner join ClientGoal on Client.ClientId = ClientGoal.ClientId
inner join Goal on Goal.GoalId = ClientGoal.GoalId
inner join WorkoutGoal on Goal.GoalId = WorkoutGoal.GoalId
inner join Workout on WorkoutGoal.WorkoutId = Workout.WorkoutId
inner join Level on Level.LevelId = Workout.LevelId
where Client.FirstName = "Shell" and Client.LastName = "Creane"
and level.name = "Beginner";
-- ------------------

-- Select all Workouts. 
-- Join to the Goal, 'Core Strength', but make it optional.
-- You may have to look up the GoalId before writing the main query.
-- If you filter on Goal.Name in a WHERE clause, Workouts will be excluded.
-- Why?
-- 26 Workouts, 3 Goals

select workout.Name as WorkoutName, goal.goalid as GoalID, goal.name as GoalName
from workout
left join workoutgoal on workout.workoutid = workoutgoal.workoutid
left join goal on workoutgoal.goalid = goal.goalid
group by workout.name;
-- ------------------

-- The relationship between Workouts and Exercises is... complicated.
-- Workout links to WorkoutDay (one day in a Workout routine)
-- which links to WorkoutDayExerciseInstance 
-- (Exercises can be repeated in a day so a bridge table is required) 
-- which links to ExerciseInstance 
-- (Exercises can be done with different weights, repetions,
-- laps, etc...) 
-- which finally links to Exercise.
-- Select Workout.Name and Exercise.Name for related Workouts and Exercises.

Select Workout.Name as WorkoutName, Exercise.Name as ExerciceName
from workout
inner join WorkoutDay on WorkoutDay.WorkoutId = workout.WorkoutId
inner join WorkoutDayExerciseInstance on WorkoutDay.WorkoutDayId = WorkoutDayExerciseInstance.WorkoutDayId
inner join ExerciseInstance on ExerciseInstance.ExerciseInstanceId = WorkoutDayExerciseInstance.ExerciseInstanceId
inner join Exercise on Exercise.ExerciseId = ExerciseInstance.ExerciseId;
-- ------------------
   
-- An ExerciseInstance is configured with ExerciseInstanceUnitValue.
-- It contains a Value and UnitId that links to Unit.
-- Example Unit/Value combos include 10 laps, 15 minutes, 200 pounds.
-- Select Exercise.Name, ExerciseInstanceUnitValue.Value, and Unit.Name
-- for the 'Plank' exercise. 
-- How many Planks are configured, which Units apply, and what 
-- are the configured Values?
-- 4 rows, 1 Unit, and 4 distinct Values

Select Exercise.Name, ExerciseInstanceUnitValue.Value, Unit.Name UnitName
from unit
inner join ExerciseInstanceUnitValue on ExerciseInstanceUnitValue.UnitId = Unit.UnitId
inner join ExerciseInstance on ExerciseInstance.ExerciseInstanceId = ExerciseInstanceUnitValue.ExerciseInstanceId
inner join Exercise on Exercise.ExerciseId = ExerciseInstance.ExerciseId
where Exercise.Name = "Plank";
-- ------------------