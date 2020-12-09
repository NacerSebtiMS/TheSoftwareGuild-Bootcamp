/* 
	INSERT QUERIES 
*/

-- Actor table
insert into actor (ActorID, FirstName, LastName, BirthDate) values
	(1, 'Bill', 'Murray', '1950-09-21'),
	(2, 'Dan', 'Aykroyd', '1952-07-01'),
	(3, 'John','Candy','1950-10-31'),
	(4, 'Steve', 'Martin', NULL),
	(5, 'Sylvester', 'Stallone', NULL);
    
-- Director table
insert into director (DirectorID, FirstName, LastName, BirthDate) values
	(1, 'Ivan', 'Reitman', '1946-10-27'),
	(2, 'Ted', 'Kotcheff', NULL);
    
-- Rating table
insert into rating (RatingID, RatingName) values
	(1,'G'),
    (2,'PG'),
    (3,'PG-13'),
    (4,'R');

-- Genre table
insert into genre (GenreID, GenreName) values
	(1,'Action'),
    (2,'Comedy'),
    (3,'Drama'),
    (4,'Horror');
    
-- Movie table
insert into movie (MovieID, GenreID, DirectorID, RatingID, Title, ReleaseDate) values
	(1, 1, 2, 4, 'Rambo: First Blood', '1982-10-22'),
    (2, 2, NULL, 4, 'Planes, Trains & Automobiles', '1987-11-25'),
    (3, 2, 1, 4, 'Ghostbusters', NULL),
    (4, 2, NULL, 4, 'The Great Outdoors', '1988-06-17');
    
-- CastMember table
insert into castmembers (CastMemberID, ActorID, MovieID, Role) values
	(1, 5, 1, 'John Rambo'),
    (2, 4, 2, 'Neil Page'),
    (3, 3, 2, 'Del Griffith'),
    (4, 1, 3, 'Dr. Peter Venkman'),
    (5, 2, 3, 'Dr. Raymond Stanz'),
    (6, 2, 4, 'Roman Craig'),
    (7, 3, 4, 'Chet Ripley');
    
/*
	UPDATE QUERIES
*/

-- Change the title of Ghostbusters to Ghostbusters (1984) and the release date to 6/8/1984
update movie set
	Title = 'Ghostbusters (1984)',
    ReleaseDate='1984-06-08'
where MovieID = 3;

-- Change the Action genre to Action/Adventure.
update genre set
	GenreName = 'Action/Adventure'
where GenreID = 1;

/*
	DELETE QUERIES
*/

-- Delete the movie Rambo: First Blood.
delete from castmembers
where MovieID = 1;

delete from movie
where MovieID = 1;

/*
	ALTERING TABLES
*/

-- Alter the Actor table to add a column DateOfDeath. Set John Candy's record to be 3/4/1994.
alter table actor
add DateOfDeath date null;

select actor.ActorID 
from actor 
where actor.FirstName = 'John' and actor.LastName = 'Candy';

update actor set
	DateOfDeath = '1994-03-04'
where ActorID = 3;