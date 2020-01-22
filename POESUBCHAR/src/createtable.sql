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

	charactername VARCHAR(40),
	labyrinthladderdate DATE NOT NULL,
	characterid VARCHAR(40),
	accountname VARCHAR(40),
	ascendancy VARCHAR(40),
	twitchid VARCHAR(40),
	PRIMARY KEY(charactername, labyrinthladderdate),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)
);

CREATE TABLE Streamer(
	Streamer_twitchid VARCHAR(40),
	Streamer_name VARCHAR(40),
	PRIMARY KEY(Streamer_twitchid)
);

CREATE TABLE using_herald_curse_aura(
	charactername VARCHAR(40),
	labyrinthladderdate DATE,
	ascendancy VARCHAR(40),
	gemname VARCHAR(40),

	PRIMARY KEY(charactername,labyrinthladderdate,ascendancy,gemname),
	FOREIGN KEY(charactername) REFERENCES poecharacter(charactername),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)
);

CREATE TABLE using_activegem(
	charactername VARCHAR(40),
	labyrinthladderdate DATE,
	ascendancy VARCHAR(40),
	gemname VARCHAR(40),

	PRIMARY KEY(charactername,labyrinthladderdate,ascendancy,gemname),
	FOREIGN KEY(charactername) REFERENCES poecharacter(charactername),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)
);

CREATE TABLE using_uniqueitem(
	charactername VARCHAR(40),
	labyrinthladderdate DATE,
	ascendancy VARCHAR(40),
	uniqueitem_name VARCHAR(40),

	PRIMARY KEY(charactername,labyrinthladderdate,ascendancy,uniqueitem_name),
	FOREIGN KEY(charactername) REFERENCES poecharacter(charactername),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)
);

CREATE TABLE ascendancy_activegem_count(

	labyrinthladderdate DATE NOT NULL,
	ascendancy VARCHAR(40),
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,ascendancy,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);

CREATE TABLE ascendancy_herald_curse_aura_count(

	labyrinthladderdate DATE NOT NULL,
	ascendancy VARCHAR(40),
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,ascendancy,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);

CREATE TABLE ascendancy_uniqueitem_count(

	labyrinthladderdate DATE NOT NULL,
	ascendancy VARCHAR(40),
	uniqueitemname VARCHAR(40),
	uniqueitemcount int,
	PRIMARY KEY(labyrinthladderdate,ascendancy,uniqueitemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);



CREATE TABLE ascendancy_activegem_count_asc(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);

CREATE TABLE ascendancy_activegem_count_ass(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);

CREATE TABLE ascendancy_activegem_count_ber(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);

CREATE TABLE ascendancy_activegem_count_cha(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);

CREATE TABLE ascendancy_activegem_count_chi(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);

CREATE TABLE ascendancy_activegem_count_dea(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);

CREATE TABLE ascendancy_activegem_count_ele(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);

CREATE TABLE ascendancy_activegem_count_gla(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);

CREATE TABLE ascendancy_activegem_count_gua(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);

CREATE TABLE ascendancy_activegem_count_hie(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);

CREATE TABLE ascendancy_activegem_count_inq(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);

CREATE TABLE ascendancy_activegem_count_jug(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);

CREATE TABLE ascendancy_activegem_count_nec(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);

CREATE TABLE ascendancy_activegem_count_occ(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);

CREATE TABLE ascendancy_activegem_count_pat(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);

CREATE TABLE ascendancy_activegem_count_rai(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);

CREATE TABLE ascendancy_activegem_count_sab(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);

CREATE TABLE ascendancy_activegem_count_sla(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);

CREATE TABLE ascendancy_activegem_count_tri(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);




CREATE TABLE ascendancy_herald_curse_aura_count_asc(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);
CREATE TABLE ascendancy_herald_curse_aura_count_ass(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);
CREATE TABLE ascendancy_herald_curse_aura_count_ber(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);
CREATE TABLE ascendancy_herald_curse_aura_count_cha(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);
CREATE TABLE ascendancy_herald_curse_aura_count_chi(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);
CREATE TABLE ascendancy_herald_curse_aura_count_dea(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);
CREATE TABLE ascendancy_herald_curse_aura_count_ele(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);
CREATE TABLE ascendancy_herald_curse_aura_count_gla(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);
CREATE TABLE ascendancy_herald_curse_aura_count_gua(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);
CREATE TABLE ascendancy_herald_curse_aura_count_hie(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);
CREATE TABLE ascendancy_herald_curse_aura_count_inq(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);
CREATE TABLE ascendancy_herald_curse_aura_count_jug(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);
CREATE TABLE ascendancy_herald_curse_aura_count_nec(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);
CREATE TABLE ascendancy_herald_curse_aura_count_occ(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);
CREATE TABLE ascendancy_herald_curse_aura_count_pat(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);
CREATE TABLE ascendancy_herald_curse_aura_count_rai(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);
CREATE TABLE ascendancy_herald_curse_aura_count_sab(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);
CREATE TABLE ascendancy_herald_curse_aura_count_sla(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);
CREATE TABLE ascendancy_herald_curse_aura_count_tri(
	labyrinthladderdate DATE NOT NULL,
	gemname VARCHAR(40),
	gemcount int,
	PRIMARY KEY(labyrinthladderdate,gemname),
	FOREIGN KEY(labyrinthladderdate) REFERENCES LabyrinthLadder(labyrinthladderdate)

);