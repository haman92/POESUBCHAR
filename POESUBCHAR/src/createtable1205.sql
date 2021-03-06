drop table using_activegem;
drop table using_herald_curse_aura;
drop table using_uniqueitem;
drop table Streamer;
drop table poecharacter;
drop table labyrinthladder;

CREATE TABLE LabyrinthLadder(
	labyrinthladderdate DATE NOT NULL,
	total INT DEFAULT 0,
	ascendant INT DEFAULT 0,
	assasin INT DEFAULT 0,
	berserker INT DEFAULT 0,
	champion INT DEFAULT 0,
	chieftain INT DEFAULT 0,
	deadeye INT DEFAULT 0,
	elementalist INT DEFAULT 0,
	guardian INT DEFAULT 0,
	gladiator INT DEFAULT 0,
	hierophant INT DEFAULT 0,
	inquisitor INT DEFAULT 0,
	juggernaut INT DEFAULT 0,
	necromancer INT DEFAULT 0,
	occultist INT DEFAULT 0,
	raider INT DEFAULT 0,
	saboteur INT DEFAULT 0,
	slayer INT DEFAULT 0,
	trickster INT DEFAULT 0,

	PRIMARY KEY(labyrinthladderdate)
);

CREATE TABLE poecharacter (

	charactername VARCHAR(207),
	labyrinthladderdate DATE NOT NULL,
	characterid VARCHAR(65),
	accountname VARCHAR(207),
	ascendancy VARCHAR(40),
	twitchid VARCHAR(50),
	PRIMARY KEY(charactername, labyrinthladderdate),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)
);


CREATE TABLE Streamer(
	Streamer_twitchid VARCHAR(207),
	Streamer_name VARCHAR(207),
	PRIMARY KEY(Streamer_twitchid)
);

CREATE TABLE using_herald_curse_aura(
	charactername VARCHAR(207),
	labyrinthladderdate DATE,
	ascendancy VARCHAR(40),
	gemname VARCHAR(40),
	inventoryID VARCHAR(40),
	PRIMARY KEY(charactername,labyrinthladderdate,ascendancy,gemname,inventoryID),
	FOREIGN KEY(charactername) REFERENCES poecharacter(charactername),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)
);

CREATE TABLE using_activegem(
	charactername VARCHAR(207),
	labyrinthladderdate DATE,
	ascendancy VARCHAR(40),
	gemname VARCHAR(40),
	inventoryID VARCHAR(40),
	PRIMARY KEY(charactername,labyrinthladderdate,ascendancy,gemname,inventoryID),
	FOREIGN KEY(charactername) REFERENCES poecharacter(charactername),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)
);

CREATE TABLE using_uniqueitem(
	charactername VARCHAR(207),
	labyrinthladderdate DATE,
	ascendancy VARCHAR(40),
	uniqueitem_name VARCHAR(40),
	inventoryID VARCHAR(40),

	PRIMARY KEY(charactername,labyrinthladderdate,ascendancy,uniqueitem_name,inventoryID),
	FOREIGN KEY(charactername) REFERENCES poecharacter(charactername),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)
);
