drop database if exists MovieCatalogue;

create database MovieCatalogue;

use MovieCatalogue;

/*
    Genre
        GenreID - Primary key, Identity
        GenreName - Required, Extended character set, Length: 30
*/     
create table Genre(
	GenreID int primary key auto_increment,
    GenreName varchar(30) not null
);

/*
    Director
        DirectorID - Primary key, Identity
        FirstName - Required, Extended character set, Length: 30
        LastName - Required, Extended character set, Length: 30
        BirthDate - Not required
*/
create table Director(
	DirectorID int primary key auto_increment,
    FirstName varchar(30) not null,
    LastName varchar(30) not null,
    BirthDate date null
);

/*
    Rating
        RatingID - Primary key, Identity
        RatingName - Required, Standard character set, Length: 5
*/
create table Rating(
	RatingID int primary key auto_increment,
    RatingName char(5) not null
);

/*
    Actor
        ActorID - Primary key, Identity
        FirstName - Required, Extended character set, Length: 30
        LastName - Required, Extended character set, Length: 30
        BirthDate - Not required
*/
create table Actor(
	ActorID int primary key auto_increment,
    FirstName varchar(30) not null,
    LastName varchar(30) not null,
    BirthDate date null
);

/*
    Movie
        MovieID - Primary key, Identity
        GenreID - Foreign key, Genre table, Required
        DirectorID - Foreign key, Director table, Not required
        RatingID - Foreign key, Rating table, Not required
        Title - Required, Extended character set, Length: 128
        ReleaseDate - Not required
*/
create table Movie(
	MovieID int primary key auto_increment,
    GenreID int not null,
    DirectorID int null,
    RatingID int null,
    Title varchar(128) not null,
    ReleaseDate date null,
    foreign key fk_Movie_GenreID (GenreID)
		references Genre(GenreID),
	foreign key fk_Movie_DirectorID (DirectorID)
		references Director(DirectorID),
	foreign key fk_Movie_RatingID (RatingID)
		references Rating(RatingID)
);

/*
    CastMembers
        CastMemberID - Primary key, Identity
        ActorID - Foreign key, Actor table, Required
        MovieID - Foreign key, Movie table, Required
        Role - Required, Extended character set, Length: 50
*/
create table CastMembers(
	CastMemberID int primary key auto_increment,
    ActorID int not null,
    MovieID int null,
    Role varchar(50) not null,
	foreign key fk_CastMembers_ActorID (ActorID)
		references Actor(ActorID),
	foreign key fk_CastMembers_MovieID (MovieID)
		references Movie(MovieID)
);